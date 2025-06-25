package in.prakash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.prakash.dto.UserDTO;
import in.prakash.util.ConnectionFactory;

public class UserDAO {

	private static final String INSERT_SQL = "insert into user_dtls(user_name, user_email, user_phno) values (?,?,?)";
	
	private static final String SELECT_SQL = "SELECT * FROM USER_DTLS";
	
	public boolean saveUser(UserDTO userDto) {
		
		boolean isSaved = false;
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
			
			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getUserEmail());
			pstmt.setInt(3, userDto.getUserPhno());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				isSaved = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSaved;
	}
	
	public List<UserDTO> getUser(){
		
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_SQL);
			
			while(rs.next()) {
				UserDTO user = new UserDTO();
				
				user.setUserId(rs.getInt("USER_ID"));
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("USER_EMAIL"));
				user.setUserPhno(rs.getInt("user_Phno"));
				
				//adding each user obj to collection
				users.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
		
	}
	
}
