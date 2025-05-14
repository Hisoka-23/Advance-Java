package in.prakashServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class MessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		PrintWriter writer = resp.getWriter();
		writer.append("<h1>Welcome Servlet</h1>");
	}
	
}
