import java.sql.*;
public class CreateTableEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "mca";
		String password = "mca";
//		String query = "CREATE TABLE EMPLOYEE1( ID NUMBER(5) PRIMARY KEY,"
//				+ " NAME VARCHAR2(50), DEPARTMENT VARCHAR2(30), AGE NUMBER(2), SALARY NUMBER(6))";
//		String query = "delete employee1 where id = 1";
		String query = "insert into employee1 values(1, 'Ais', 'Lib', 27, 54000)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
//			stmt.execute(query);
			stmt.executeUpdate(query);
			System.out.println("Query successful");
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
