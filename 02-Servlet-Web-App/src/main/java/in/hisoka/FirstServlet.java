package in.hisoka;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		PrintWriter writer = resp.getWriter();
		
		String s = null;
		s.length();
		
		writer.append("<h1>Welcome to web Development</h1>");
		
	}
	
}
