package in.prakashit;

import java.sql.Connection;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	public static void main(String[] args) throws Exception {
		
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);
		
		config.setMaximumPoolSize(20);
		config.setMinimumIdle(5);
		
		HikariDataSource datasource = new HikariDataSource(config);
		
		Connection con1 = datasource.getConnection();
		
		String sql = "INSERT INTO BOOKS VALUES (203, 'OP', 7500.00)";
		
		Statement stmt = con1.createStatement();
		
		stmt.executeUpdate(sql);
		
		System.out.println("Record Inserted....");
		
		con1.close();
		
	}
	
}