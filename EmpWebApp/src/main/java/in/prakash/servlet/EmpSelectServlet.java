package in.prakash.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.prakash.dao.EmpDAO;
import in.prakash.dto.EmpDTO;

@WebServlet("/select")
public class EmpSelectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//captue form data
		String gender = req.getParameter("gender");
		String dept = req.getParameter("dept");
		String exp = req.getParameter("exp");
				
		//representing form data in object form
		EmpDTO dto = new EmpDTO();
		dto.setEmpGender(gender);
		dto.setEmpDept(dept);
		if(!exp.equals("")) {
			dto.setEmpExp(Integer.parseInt(exp));
		}
		
		//call dao method
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> emps = dao.getEmps(dto);
		req.setAttribute("emps", emps);
		
		req.getRequestDispatcher("/emps.jsp").forward(req, resp);
		
	}
	
}
