import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class ITTicketSys extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection conn = JDBCCon.connect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITTicketSys frame = new ITTicketSys();
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
	public ITTicketSys() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Register");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Help");
		menuBar.add(mntmNewMenuItem_2);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register reg = new Register();
				reg.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(109, 25, 73, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username: ");
		lblNewLabel_1.setBounds(32, 68, 77, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(110, 65, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("password:");
		lblNewLabel_1_1.setBounds(32, 96, 77, 13);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 93, 97, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				if(username.equals("admin") && password.equals("admin")) {
					dispose();
					new AdminPage().setVisible(true);
				}else {
				    try {
				        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
				        PreparedStatement pst = conn.prepareStatement(query);
				        pst.setString(1, username);
				        pst.setString(2, password);
				        ResultSet rs = pst.executeQuery();
				        
				        if (rs.next()) {
				            JOptionPane.showMessageDialog(contentPane, "Login successful.");
				            // Proceed to the next screen or functionality
				            dispose();
				            new UserPage(rs.getString("id")).setVisible(true);
				        } else {
				            JOptionPane.showMessageDialog(contentPane, "Invalid username or password.");
				        }
				        
				        rs.close();
				        pst.close();
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				}

			}
		});
		btnNewButton.setBounds(109, 139, 85, 21);
		contentPane.add(btnNewButton);
		ImageIcon imageIcon = new ImageIcon("E:\\Downloads\\GYWooZnWsAAbkp5.png");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(135, 152, java.awt.Image.SCALE_SMOOTH));
		JLabel imageLabel = new JLabel(imageIcon);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);

		// Optionally, revalidate and repaint the panel to ensure the image is displayed
		imagePanel.revalidate();
		imagePanel.repaint();
		imagePanel.setBounds(264, 25, 135, 152);
		contentPane.add(imagePanel);
		
	}
}
