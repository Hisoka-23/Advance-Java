package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpAddrInsert {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String EMP_INSERT = "INSERT INTO EMP VALUES(?, ?, ?)";
	
	private static final String EMP_ADDR_INSERT = "INSERT INTO EMP_ADDRESS VALUES(?, ?, ?, ?)";
	
	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		//By default conn - autoCommit mode is true;
		
		con.setAutoCommit(false);
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
			pstmt.setInt(1, 102);
			pstmt.setString(2, "Steve");
			pstmt.setDouble(3, 2000.00);
			
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(EMP_ADDR_INSERT);
			pstmt.setString(1, "Pune");
			pstmt.setString(2, "MH");
			pstmt.setString(3, "India");
			pstmt.setInt(4, 102);
			
			pstmt.executeUpdate();
			
			con.commit();
			
			System.out.println("Records Inserted...");
			
		}catch(Exception e){
			
			System.out.println("Transcation Rolled Back....");
			con.rollback();
			
		}
		
		con.close();
		
	}
	
}
