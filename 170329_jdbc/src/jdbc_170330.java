import java.sql.*;
import java.util.*;;

public class jdbc_170330 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:33066/testDB?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		jdbcClass jc = new jdbcClass(stmt);
		jc.a();
		
		stmt.close();
		con.close();
	}
}
