package in.prakash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
		PrintWriter pw = resp.getWriter();
		pw.append("This is second servlet response...");
		
	}
	
}
