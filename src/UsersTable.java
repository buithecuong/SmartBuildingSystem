import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersTable {

	public static int insertRecord ( String username, String password, String firstName,
								String lastName, String email, Connection conn )
	{
		int result = 0;
		PreparedStatement stmt = null;
		
		try {
			
			stmt = conn.prepareStatement("insert into users (username, password,firstname,"
					+ "lastname, email)values (?,?,?,?,?)");
			stmt.setString(1,username );
			stmt.setString(2,password );
			stmt.setString(3,firstName );
			stmt.setString(4,lastName );
			stmt.setString(5,email );
			
			result = stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result ;
		
	}
}
