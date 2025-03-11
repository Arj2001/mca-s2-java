import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection conn = JDBCCon.connect();
	private String userId;
	private String username;
	private String password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage("bc1799a2-33f8-4f91-abaa-e7d549d8c70b");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void reloadPage() {
	    this.dispose();
	    UserPage newPage = new UserPage(this.userId);
	    newPage.setVisible(true);
	}
	public void getUser() {
		// Fetch user details from database
		 String query = "SELECT * FROM users WHERE id = ?";
		 
	        try {
	            PreparedStatement pst = conn.prepareStatement(query);
	            pst.setString(1, userId);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                username = rs.getString("username");
//	                password = rs.getString("password");
	            }
	            
	            rs.close();
	            pst.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	}
	/**
	 * Create the frame.
	 */
	public UserPage(String userId) {
		this.userId = userId;
		getUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ITTicketSys login = new ITTicketSys();
				login.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Help");
		menuBar.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 426, 231);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Create ticket", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New ticket");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 10, 79, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter details");
		lblNewLabel_1.setBounds(67, 47, 102, 13);
		panel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(179, 41, 158, 47);
		panel.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Select device");
		lblNewLabel_2.setBounds(67, 101, 113, 13);
		panel.add(lblNewLabel_2);
		
		JComboBox<Device> comboBox = new JComboBox();
		comboBox.setBounds(179, 97, 71, 21);
		String deviceQuery = "SELECT id, name FROM devices WHERE user_id = ?";
        PreparedStatement pst2;
		try {
			pst2 = conn.prepareStatement(deviceQuery);
			pst2.setString(1, userId);
			
			ResultSet rs = pst2.executeQuery();
			System.out.println(userId);
			while(rs.next()) {
				
				comboBox.addItem( new Device(rs.getString("id"), rs.getString("name")));
			}
			System.out.println("Devices fetched successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String details = textArea.getText();
				Device device = (Device) comboBox.getSelectedItem();
				String deviceId = device.getId();
				String query = "INSERT INTO tickets (id, details, dev_id,user_id) VALUES (?, ?, ?,?)";
				try {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, JDBCCon.generateUniqueKey());
					pst.setString(2, details);
					pst.setString(3, deviceId);
					pst.setString(4, userId);
					pst.executeUpdate();
					System.out.println("Ticket created successfully");
					JOptionPane.showMessageDialog(contentPane, "Ticket created successfully");
					reloadPage();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(165, 140, 85, 21);
		panel.add(btnSubmit);
		
		
		DefaultTableModel model = new DefaultTableModel();
//		model.addColumn("Ticket ID");
		model.addColumn("Details");
		model.addColumn("Device ID");
		model.addColumn("Status");
//		model.;
		JTable table=new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("View Ticets", null, scrollPane, null);

		String ticketQuery = "SELECT t.details AS details, status, d.name AS device_name FROM tickets t JOIN devices d ON t.dev_id = d.id WHERE t.user_id = ?";
		try {
		    PreparedStatement pst3 = conn.prepareStatement(ticketQuery);
		    pst3.setString(1, userId);
		    ResultSet rs2 = pst3.executeQuery();
		    
		    while (rs2.next()) {
		        model.addRow(new Object[]{
		            rs2.getString("details"),
		            rs2.getString("device_name"),
		            rs2.getString("status")
		        });
		    }
		    rs2.close();
		    pst3.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
}
