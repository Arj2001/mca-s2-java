import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.awt.event.ActionEvent;
;
public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordField;
	static Connection con = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //System
		String username = "system";
		String password = "arjun";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
		}catch(Exception e) {
			System.out.println("JDBC Connection failed");
//			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(96, 46, 72, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(176, 50, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(293, 19, 1, 1);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel_1 = new JLabel("Register Page");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(163, 19, 109, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(96, 79, 72, 25);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 79, 96, 19);
		contentPane.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(96, 107, 72, 25);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 108, 96, 19);
		contentPane.add(textField_2);
		
		JLabel lblName_1_1 = new JLabel("Password");
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName_1_1.setBounds(96, 133, 72, 25);
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Date of birth");
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName_1_1_1.setBounds(96, 166, 72, 25);
		contentPane.add(lblName_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(176, 170, 96, 19);
		contentPane.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 137, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertUser(textField.getText(), textField_1.getText(),
						textField_2.getText(), new String(passwordField.getPassword()), textField_4.getText());
			}
		});
		btnNewButton.setBounds(187, 213, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	void insertUser(String username, String name, String email, String password, String dob) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
			stmt  =  con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setString(5, dob);;
			int row =  stmt.executeUpdate();
			if(row > 0) {
				JOptionPane.showMessageDialog(null,"Registration successful" );
				System.out.println("Registration successful");
			}else {
				System.out.println("Registration failed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	Date getDateFromString(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = (Date) sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
}
