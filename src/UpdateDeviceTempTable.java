import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDeviceTempTable {

	public static int updateDeviceTempRecord ( String device_id, String temp, Connection conn )
	{
		int result = 0;
		PreparedStatement stmt = null;
		System.out.println(device_id);
		System.out.println(temp);
		try {
			
			stmt = conn.prepareStatement("update device_temp set temp=? where device_id=?");
			stmt.setString(1,temp );
			stmt.setString(2,device_id );
			System.out.println();
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
	
	
	public static int AddDeviceTempRecord ( String device_id, String temp, Connection conn )
	{
		int result = 0;
		PreparedStatement stmt = null;
		System.out.println(device_id);
		System.out.println(temp);
		try {
			
			stmt = conn.prepareStatement("insert into device_temp (device_id, temp"
					+ ")values (?,?)");
			stmt.setString(1,device_id );
			stmt.setString(2,temp );
			System.out.println();
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
