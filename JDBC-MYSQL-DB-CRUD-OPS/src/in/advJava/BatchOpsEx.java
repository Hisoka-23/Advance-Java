package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchOpsEx {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	public static void main(String[] args)throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		Statement stmt = con.createStatement();
		
		stmt.addBatch("INSERT INTO BOOKS VALUES(109, 'AI', 2800.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(110, 'ML', 4800.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(111, 'DS', 9800.00)");
		
		int count[] = stmt.executeBatch();
		
//		for(int i: count) {
//			System.out.println(i);
//		}
		
		System.out.println("Records Effected ::" + count.length);
		
		con.close();
		
		System.out.println("Execution completed....");
		
	}
	
}
