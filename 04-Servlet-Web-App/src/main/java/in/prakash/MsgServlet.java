package in.prakash;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/msgServlet")
public class MsgServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException{
		
		String name = req.getParameter("name");
		
		PrintWriter writer = resp.getWriter();
		
		writer.append(name+", Good Evening...!!");
		
	}
	
}
