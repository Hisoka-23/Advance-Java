package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmpWithAddr {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String EMP_SELECT = "SELECT * FROM EMP e, EMP_ADDRESS a WHERE e.emp_id = a.emp_id and e.emp_id = ?";
	
	public static void main(String[] args)throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(EMP_SELECT);
		
		pstmt.setInt(1, 102);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString(2)+" ");
			System.out.print(rs.getDouble(3)+" ");
			System.out.print(rs.getString(4)+" ");
			System.out.print(rs.getString(5)+" ");
			System.out.print(rs.getString(6)+" ");
		}
		
		con.close();
		
	}
	
}
