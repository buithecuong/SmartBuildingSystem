import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getDbConnection(String dbName) throws SQLException, ClassNotFoundException
	{
		Connection conn = null;
		if(dbName.equalsIgnoreCase("mysql"))
		{	
				Class.forName("com.mysql.jdbc.Driver");  
				conn=DriverManager.getConnection(  
				"jdbc:mysql://35.183.144.230:3306/smartbuilding","admin","Asdf$1234");  
				return conn;
		}
		else
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			conn=DriverManager.getConnection(  
			"jdbc:oracle:thin:@192.168.2.80:1521:xe","system","Asdf$1234");  
			return conn;
		}
	
		
		
	}
}
