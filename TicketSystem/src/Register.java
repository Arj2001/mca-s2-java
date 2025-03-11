import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class Register extends JFrame {

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
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Login");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Register");
		menuBar.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.setEnabled(false);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Help");
		menuBar.add(mntmNewMenuItem_2);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ITTicketSys login = new ITTicketSys();
				login.setVisible(true);
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(196, 20, 169, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username: ");
		lblNewLabel_1.setBounds(191, 57, 77, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(269, 54, 96, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("password:");
		lblNewLabel_1_1.setBounds(191, 85, 77, 13);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(268, 82, 97, 19);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(268, 128, 85, 21);
		contentPane.add(btnRegister);
		
		ImageIcon imageIcon = new ImageIcon("E:\\Downloads\\JKmH3qSP_ybzNE3zWkc4--transformed.jpeg");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(158, 182, java.awt.Image.SCALE_SMOOTH));
		JLabel imageLabel = new JLabel(imageIcon);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
//		imagePanel.revalidate();
//		imagePanel.repaint();
		imagePanel.setBounds(10, 20, 158, 182);
		contentPane.add(imagePanel);
		 btnRegister.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String username = textField.getText();
	                String password = new String(passwordField.getPassword());
	                try {
	                    String query = "INSERT INTO users (id, username, password) VALUES (?, ?,?)";
	                    PreparedStatement pst = conn.prepareStatement(query);
	                    pst.setString(1, JDBCCon.generateUniqueKey() );
	                    pst.setString(2, username);
	                    pst.setString(3, password);
	                    pst.executeUpdate();
	                    pst.close();
	                    JOptionPane.showMessageDialog(contentPane, "User registered successfully");
	         
	                    System.out.println("User registered successfully.");
	                    dispose();
	    				ITTicketSys login = new ITTicketSys();
	    				login.setVisible(true);
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	}
}
