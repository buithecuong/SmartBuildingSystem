import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		Connection 	conn = DbConnection.getDbConnection("oracle");
		UsersTable.insertRecord("buithecuong", "1_Abc_123", "The Cuong", "Bui", "buithecuong@gmail.com", conn);
	}

}
