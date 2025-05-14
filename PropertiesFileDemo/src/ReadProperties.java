import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args)throws Exception {
		
		File f = new File("db.properties");
		FileInputStream fis = new FileInputStream(f);
		
		Properties p = new Properties();
		p.load(fis);//load all the properties from properties file
		
		System.out.println(p);
		
		String uname = p.getProperty("db.username");
		String pwd = p.getProperty("db.password");
		String driver = p.getProperty("driver");
		
		System.out.println("UserName"+uname);
		System.out.println("PassWord"+pwd);
		System.out.println("Driver"+driver);
		
		fis.close();
		
	}
	
} 