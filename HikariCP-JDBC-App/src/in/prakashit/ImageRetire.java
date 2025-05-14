package in.prakashit;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageRetire {

	public static void main(String[] args)throws Exception {
		
		Connection con = ConnectionFactory1.getDBConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON");
		
		if(rs.next()) {
			System.out.println(rs.getInt(1));
			byte stream[] = rs.getBytes(2);
			
			FileOutputStream fos = new FileOutputStream("Path of image\\image name.jpg");
			fos.write(stream);
			fos.close();
		}
		
		con.close();
		
	}
	
}