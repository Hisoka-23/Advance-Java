package in.prakash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.prakash.dto.EmpDTO;
import in.prakash.util.ConnectionFactory;

public class EmpDAO {

	private static final String INSERT = "insert into EMP_DTLS(EMP_NAME, EMP_EMAIL, EMP_GENDER, EMP_DEPT, EMP_EXP) values(?,?,?,?,?)";
	
	public boolean saveEmp(EmpDTO empDto) {
		
		int count = 0;
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, empDto.getEmpName());
			pstmt.setString(2, empDto.getEmpEmail());
			pstmt.setString(3, empDto.getEmpGender());
			pstmt.setString(4, empDto.getEmpDept());
			pstmt.setInt(5, empDto.getEmpExp());
			
			count = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count > 0;
	}
	
	public List<EmpDTO> getEmps(EmpDTO empDto){
		
		StringBuilder sql = new StringBuilder("select * from emp_dtls where 1=1");
		
		List<EmpDTO> emps = new ArrayList<EmpDTO>();
		
		try {
			
			if(empDto.getEmpDept() != null && !empDto.getEmpDept().equals("")) {
				sql.append(" and emp_dept = ?");
			}
			
			if(empDto.getEmpGender() != null && !empDto.getEmpGender().equals("")) {
				sql.append(" and emp_gender = ?");
			}
			
			if(empDto.getEmpExp() != null ) {
				sql.append(" and emp_exp = ?");
			}
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			
			if(empDto.getEmpDept() != null && !empDto.getEmpDept().equals("")) {
				pstmt.setString(index, empDto.getEmpDept());
				index ++;
			}
			
			if(empDto.getEmpGender() != null && !empDto.getEmpGender().equals("")) {
				pstmt.setString(index, empDto.getEmpGender());
				index ++;
			}
			
			if(empDto.getEmpExp() != null) {
				pstmt.setInt(index, empDto.getEmpExp());
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				
				dto.setEmpId(rs.getInt("EMP_ID"));
				dto.setEmpName(rs.getString("EMP_NAME"));
				dto.setEmpDept(rs.getString("EMP_DEPT"));
				dto.setEmpExp(rs.getInt("EMP_EXP"));
				dto.setEmpGender(rs.getString("EMP_GENDER"));
				
				emps.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return emps;
	}
	
}
