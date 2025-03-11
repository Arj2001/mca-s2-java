import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection conn = JDBCCon.connect();
	private JTextField deviceName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ITTicketSys login = new ITTicketSys();
				login.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Help");
		menuBar.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 416, 221);
		contentPane.add(tabbedPane);
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("id");
		model1.addColumn("Username");
		model1.addColumn("Details");
		model1.addColumn("Device Name");
		model1.addColumn("Status");
		JTable table1=new JTable(model1);
		table1.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table1);
		tabbedPane.addTab("Tickets", null, scrollPane, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Device", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter device name");
		lblNewLabel.setBounds(43, 30, 112, 13);
		panel.add(lblNewLabel);
		
		deviceName = new JTextField();
		deviceName.setBounds(179, 27, 125, 19);
		panel.add(deviceName);
		deviceName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Select User");
		lblNewLabel_1.setBounds(43, 72, 112, 13);
		panel.add(lblNewLabel_1);
		
		JComboBox<Device> userDropDwn = new JComboBox<Device>();
		userDropDwn.setBounds(179, 68, 67, 21);
		panel.add(userDropDwn);
		String deviceQuery = "SELECT id, username FROM users";
        PreparedStatement pst2;
		try {
			pst2 = conn.prepareStatement(deviceQuery);
			ResultSet rs = pst2.executeQuery();
			while(rs.next()) {
				
				userDropDwn.addItem( new Device(rs.getString("id"), rs.getString("username")));
			}
			System.out.println("Devices fetched successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deviceNameStr = deviceName.getText();
				Device dev = (Device) userDropDwn.getSelectedItem();
				String userStr = dev.getId();
				String insertQuery = "INSERT INTO devices (id, name, user_id) VALUES (?, ?, ?)";
				try {
					PreparedStatement pst = conn.prepareStatement(insertQuery);
					pst.setString(1, JDBCCon.generateUniqueKey());
					pst.setString(2, deviceNameStr);
					pst.setString(3, userStr);
					pst.executeUpdate();
					pst.close();
					deviceName.setText("");
					JOptionPane.showMessageDialog(null, "Device added successfully");
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(179, 111, 85, 21);
		panel.add(btnNewButton);
		String ticketQuery = "SELECT t.id, username, details, d.name AS dev_name, status FROM tickets t JOIN users u ON t.user_id = u.id JOIN devices d ON t.dev_id = d.id";
		try {
		    PreparedStatement pst3 = conn.prepareStatement(ticketQuery);
		    ResultSet rs2 = pst3.executeQuery();

		    while (rs2.next()) {
		        model1.addRow(new Object[]{
		        	rs2.getString("id"),
		            rs2.getString("username"),
		            rs2.getString("details"),
		            rs2.getString("dev_name"),
		            rs2.getString("status")
		        });
		    }
		    rs2.close();
		    pst3.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		table1.removeColumn(table1.getColumnModel().getColumn(0));
		
		table1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table1.rowAtPoint(e.getPoint());
//				int col = table1.columnAtPoint(e.getPoint());
				if (row >= 0) {
					String ticketId = (String) model1.getValueAt(row, 0);
					String status = (String) model1.getValueAt(row, 4);
					if (status.equals("pending")) {
						int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to mark this ticket as resolved?", "Warning", JOptionPane.YES_NO_OPTION);
						if (dialogResult == JOptionPane.YES_OPTION) {
							String updateQuery = "UPDATE tickets SET status = 'resolved' WHERE id = ?";
							try {
								PreparedStatement pst = conn.prepareStatement(updateQuery);
								pst.setString(1, ticketId);
								pst.executeUpdate();
								pst.close();
								model1.setRowCount(0);
								ResultSet rs = conn.prepareStatement(ticketQuery).executeQuery();
								while (rs.next()) {
									model1.addRow(new Object[]{
										rs.getString("id"),
										rs.getString("username"),
										rs.getString("details"),
										rs.getString("dev_name"),
										rs.getString("status")
									});
								}
								rs.close();
							} catch (SQLException ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
		});
	}
}
