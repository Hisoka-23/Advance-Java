package in.bookapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet{

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		//capture from form
		String bookId = req.getParameter("bookId");
		String bookName = req.getParameter("bookName");
		String bookPrice = req.getParameter("bookPrice");
		
		System.out.println(bookId);
		System.out.println(bookName);
		System.out.println(bookPrice);
		
		PrintWriter pw = resp.getWriter();
		pw.append("Form Submitted");
		
		//insert into db table
		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
			
			String sql = "insert into BOOKS Values(?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(bookId));
			pstmt.setString(2, bookName);
			pstmt.setDouble(3, Double.parseDouble(bookPrice));
			
			int count = pstmt.executeUpdate();
			
			System.out.println("Rows Effected :: "+count);
			
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
