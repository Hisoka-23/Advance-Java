package in.prakash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
		
		PrintWriter pw = resp.getWriter();
		pw.append("This is first servlet response...");
		
		RequestDispatcher rd = req.getRequestDispatcher("/second");
//		rd.forward(req, resp);
		rd.include(req, resp);
		
	}
	
}
