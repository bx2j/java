import java.sql.*;
import java.util.*;;

public class jdbc_170330 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		ResultSet rest = stmt.executeQuery("select * from examtable");
		/*jdbcClass jc = new jdbcClass(stmt);
		jc.a();
		
		stmt.close();
		con.close();*/
		while(rest.next()){
			System.out.println(rest.getString(1) + "\t" + rest.getString(2) +"\t" + rest.getString(3) + 
					"\t" + rest.getString(4) + "\t" + rest.getString(5) );
		}
				
		stmt.close();
		con.close();
	}
}
