/*
 * jdbc 기본 프로그램
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		ResultSet rest = stmt.executeQuery("show databases"); // show databases 쿼리 전송
		
		while(rest.next()){
			System.out.println("값 : "+rest.getString(1)); // 받아온 내용 출력
			
		}
		rest.close();
		stmt.close();
		con.close();
	}
}

