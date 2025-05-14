package in.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException {
		
		PrintWriter pw = res.getWriter();
		pw.append("<h1>Welcome to Servlets</h1>");
		
	}
	
}