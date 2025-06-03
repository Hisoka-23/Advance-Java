package in.prakash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		ServletConfig config = getServletConfig();
		String msg = config.getInitParameter("msg2");
		
		ServletContext content = req.getServletContext();
		String website = content.getInitParameter("website");
		
		PrintWriter writer = resp.getWriter();
		writer.append(msg+"--"+website);
		
	}
	
}
