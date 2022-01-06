import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static String USER = "gpshqobtqpqlne";
    private static String PASSWORD = "66346f36dbd47a5aadaded42e02637792bc85123b87cbaeca609af48b5a8d700";
    private static String DBUrl = "jdbc:postgresql://ec2-54-171-25-232.eu-west-1.compute.amazonaws.com:5432/d3lvpbc9i53ofu?sslmode=require";
    private static String DBDriver = "org.postgresql.Driver";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(DBUrl,USER,PASSWORD);
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
