import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.ResultSet;

public class DBDao {

    private String SQL = "";
    private int username = 0;
    private int password = 0;


    public boolean Login(User user){
        username = user.username;
        password = user.password;
        SQL = "select * from xx where username = ? and password = ?";//select matched user
        PreparedStatement pstmt = null;//used to execute sql statement with parameters
        Connection connection = null;
        User dbuser = new User();

        try{
            connection = DBConn.getConnection();//connect to the database
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            pstmt.setInt(1,username);//replace the ? in sql by username and password
            pstmt.setInt(2,password);
            Statement s = connection.createStatement();
            ResultSet rset = s.executeQuery(SQL);
            if(rset.next()){

                dbuser.getUsername(rset.getString("username"));
                dbuser.getPassword(rset.getString("password"));
            }
            s.close();

        }
        catch(Exception e) {
        }

        //check if there is a matched user and  return the result
        if(dbuser.username!=0&&dbuser.password!=0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean Register(User user){
        return true;
    }
}
