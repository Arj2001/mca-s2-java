import java.sql.*;
public class ViewEmployeeTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "mca";
		String password = "mca";
		String query = "SELECT * FROM EMPLOYEE1";
//		String query = "insert into employee values(3, 'Mani', 'Library', 27, 67000)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			stmt.execute(query);
			ResultSet resultSet = stmt.getResultSet();
//			if(resultSet.next())System.out.println("No values in the table");
			while(resultSet.next()) {
				System.out.println("ID: "+resultSet.getInt(1)+ " | Name: "+resultSet.getString(2)
				+ " | Department: "+ resultSet.getString(3)+ " | Age: " + resultSet.getInt(4)+
				" | Salary: " + resultSet.getLong(5));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
