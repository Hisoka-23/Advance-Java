package in.prakash.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;
	
	public static Connection getConnection() {
		
	Connection con = null;
		
	try {
			
		if(ds == null) {
				
			FileInputStream fis = new FileInputStream(new File("D:\\Work space\\Development\\23-JFSD-Workspace\\01-ADV-JAVA\\UserWebApp\\db.properties"));
			Properties p = new Properties();
			p.load(fis);
				
			HikariConfig config = new HikariConfig();
			config.setUsername(p.getProperty("db.uname"));
			config.setPassword(p.getProperty("db.password"));
			config.setJdbcUrl(p.getProperty("db.url"));
			config.setDriverClassName(p.getProperty("db.driver"));
				
			ds = new HikariDataSource(config);
			 
		}
		
			con = ds.getConnection();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return con;
		
	}
	
}
