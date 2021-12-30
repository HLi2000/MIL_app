import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static String DBUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String DBDriver = "org.postgresql.Driver";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBUrl);
        } catch (Exception e) {
            System.out.println("connection error");
        }
        return connection;
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}
