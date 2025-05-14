package in.prakashit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImageBlob {

	public static void main(String[] args)throws Exception {
		
		File f = new File("D:\\My space\\me\\Prakash.jpg");
		
		FileInputStream fis = new FileInputStream(f);
		
		Connection con = ConnectionFactory1.getDBConnection();
		
		String sql = "INSERT INTO PERSON VALUES(?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 101);
		pstmt.setBlob(2, fis);
		
		int count = pstmt.executeUpdate();
		
		System.out.println("Row Inserted :: "+count);
		
		pstmt.close();
		con.close();
		
	}
	
}