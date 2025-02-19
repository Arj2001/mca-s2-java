import java.sql.*;
public class JDBCConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //System
		String username = "mca";
		String password = "mca";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection successful");
			conn.close();
		}catch(Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}

}
