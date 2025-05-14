package in.advJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SelectAllBook {

private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "Prakash@23";
	
	private static final String SELECT_SQL = "SELECT BOOK_IB, BOOK_NAME, BOOK_PRICE FROM BOOKS";

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		//Statement stmt = con.createStatement();
		
		Statement stmt = con.createStatement
		(ResultSet.TYPE_SCROLL_INSENSITIVE, 
		 ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		System.out.println("Column Count : " + metaData.getColumnCount());

		for(int i = 1; i<=metaData.getColumnCount(); i++) {
			String columnName = metaData.getColumnName(i);
			System.out.println();
		}
		
//		rs.absolute(2);
//
//		rs.updateDouble(3, 8500.00);
//		
//		rs.updateRow();

		
		//rs.updateRow();
		
		//rs.deleteRow(2);
		
		//rs.previous();
		
		//rs.last();
		
//		System.out.println(rs.getInt(1));
//		System.out.println(rs.getString(2));
//		System.out.println(rs.getDouble(3));
		
//		rs.previous();
		
//		System.out.println("Query Execution Completed... Data available in ResultSet");
		
//		while(rs.next()) {
////			System.in.read();
////			System.in.read();
////			rs.refreshRow();
//			System.out.println(rs.getInt(1) + "----" + rs.getString(2) + "-----" + rs.getDouble(3));
//		}
		
		con.close();
		
	}
	
}
