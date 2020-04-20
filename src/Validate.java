
import java.sql.*;

public class Validate {
    public static boolean checkUser(String email,String pass) 
    {
        boolean st =false;
        try {

            //creating connection with the database
            Connection 	conn = DbConnection.getDbConnection("mysql");
            PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}