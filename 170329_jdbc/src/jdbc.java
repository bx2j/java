import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:33066/testDB?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		for(int i=1;i<90000;i++){	
			double kor = (Math.random() * 100);
			double eng = (Math.random() * 100);
			double mat = (Math.random() * 100);
			stmt.execute("insert into extable values "
					+ "('crystal" + i +"', "+ i +"," + kor +","+ eng +"," + mat +")");
		}
		
		ResultSet rest = stmt.executeQuery("select * from extable");
		while(rest.next()){
			System.out.println(rest.getString(1) + "\t" + rest.getString(3) +"\t" + rest.getString(4) + 
					"\t" + rest.getString(5) + "\t" + rest.getString(6) + "\t" + rest.getString(7));
		}
				
		stmt.close();
		con.close();
	}
}
