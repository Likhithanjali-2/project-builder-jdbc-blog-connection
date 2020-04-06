package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public Connection getConnection() throws Exception {
		Properties prop = loadPropertiesFile();
		Class.forName((String) prop.get("driver"));// can also use getProperety method to access
		Connection con = DriverManager.getConnection((String) prop.get("url"),(String) prop.get("username"),(String) prop.get("password"));
		return con;
	}
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}
