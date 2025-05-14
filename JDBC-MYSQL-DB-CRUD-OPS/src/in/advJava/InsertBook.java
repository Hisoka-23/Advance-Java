package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertBook {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String INSERT_SQL = "INSERT INTO BOOKS VALUES(111, 'Prakash',999999)";
	
	public static void main(String[] args) throws Exception {
		
		//Step-1 : Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		//Step-2 : Get DB Connection
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		//System.out.println(con);
		
		//Step-3 : Create Statement
		Statement Stmt = con.createStatement();
		
		//Step-4 : Execute Query
		int rowsEffected = Stmt.executeUpdate(INSERT_SQL);
		
		//Step-5 : Process Result
		System.out.println("Record Inserted Count :: "+ rowsEffected);
		
		//Step-6 : Close Connection
		con.close();
	}
	
}
