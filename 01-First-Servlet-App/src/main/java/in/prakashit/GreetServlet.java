package in.prakashit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter pw = response.getWriter();
		pw.append("<h1>Good Evening....</h1>");
		
	}
	
}
