package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class EmpHike1 {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String SELECT_SQL = "SELECT * FROM EMPLOYEE";
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter emp hike");
		double hike = s.nextDouble();
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		//Statement stmt = con.createStatement();
		
		String UPDATE_SAL_SQL = "UPDATE EMPLOYEE SET EMP_SALARY=EMP_SALARY + (EMP_SALARY * ?) / 100";
		
		PreparedStatement pstmt = con.prepareStatement(UPDATE_SAL_SQL);
		
		pstmt.setDouble(1, hike);
		
		System.out.println("Update completed");
		con.close();
		
	}
}
