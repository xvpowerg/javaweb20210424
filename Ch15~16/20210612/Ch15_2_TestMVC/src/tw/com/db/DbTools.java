package tw.com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbTools {
	private static String url;
	private static String user;
	private static String password;
	private static String dbType;
	
	public static  Connection getConnection() throws SQLException {
		Connection conn =   DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	public static  void  setURL(String url) {
		DbTools.url = url;
	}
	public static  void  setUser(String user) {
		DbTools.user = user;
	}
	public static  void  setPassword(String password) {
		DbTools.password = password;
	}
	public static  void  setDbType(String dbType) {
		DbTools.dbType = dbType;
	}
}
