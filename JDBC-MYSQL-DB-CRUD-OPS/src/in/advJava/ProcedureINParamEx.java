package in.advJava;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcedureINParamEx {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String PROCEDURE = "call getBookById(?)";
	
	public static void main(String[] args)throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book Id :: ");
		int bookId = s.nextInt();
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		CallableStatement cstmt = con.prepareCall(PROCEDURE);
		cstmt.setInt(1, bookId);
		
		ResultSet rs = cstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getDouble(3));
		}
		
		con.close();
		
	}
	
}