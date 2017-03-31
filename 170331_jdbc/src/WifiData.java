import java.io.*;
import java.sql.*;

public class WifiData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		int cnt=0;
		String data = null;
				
		// DB Loading
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:33066/ex2?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		Statement stmt = con.createStatement();
		
		/*LoadFile lf = new LoadFile(stmt);
		lf.FileCall();*/
		
		LoadClass ls = new LoadClass(stmt);
		ls.call();
		
		stmt.close();
	}
}
