package in.prakash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.prakash.dao.EmpDAO;
import in.prakash.dto.EmpDTO;

@WebServlet("/insert")
public class EmpInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//captue form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dept = req.getParameter("dept");
		String exp = req.getParameter("exp");
		
		//representing form data in object form
		EmpDTO dto = new EmpDTO();
		dto.setEmpName(name);
		dto.setEmpEmail(email);
		dto.setEmpGender(gender);
		dto.setEmpDept(dept);
		dto.setEmpExp(Integer.parseInt(exp));
		
		//saving form data using dao method
		EmpDAO dao = new EmpDAO();
		boolean isSaved = dao.saveEmp(dto);
		
		String msg = null;
		
		if(isSaved) {
			msg = "Save successfully";
		}else {
			msg = "Failed to Save";
		}
		
		//send msg to jsp page
		req.setAttribute("msg", msg);
		
		//redirect request to same jsp page
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
