import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class JDBCCon{

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "arjun";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to establish connection.");
            e.printStackTrace();
        }
        return connection;
    }
    public static String generateUniqueKey() {
        return UUID.randomUUID().toString();
    }
}
