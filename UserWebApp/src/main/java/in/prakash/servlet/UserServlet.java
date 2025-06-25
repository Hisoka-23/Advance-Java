package in.prakash.servlet;

import java.io.IOException;
import java.util.List;

import in.prakash.dao.UserDAO;
import in.prakash.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDao = new UserDAO();
		List<UserDTO> users = userDao.getUser();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/viewUsers.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// capture the form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		
		//Set form data userDto object for transfer
		UserDTO user = new UserDTO();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserPhno(Integer.parseInt(phno));
		
		//call dao method
		UserDAO dao = new UserDAO(); 
		boolean isSaved = dao.saveUser(user);
		
		String msg = null;
		
		if(isSaved) {
			msg = "user Saved";
		}else {
			msg="User Not Saved";
		}
		
		//Setting msg to display on index page
		req.setAttribute("msg", msg);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}
