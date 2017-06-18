/*
 * examtable - 테이블 조회
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

public class db2_select {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		ResultSet rest = stmt.executeQuery("select * from examtable;"); // select 문 전송
		
		System.out.printf("  이름   학번   국어 영어 수학\n");
		while(rest.next()){
			System.out.printf("%4s  %6d  %3d  %3d  %3d\n",rest.getString(1) , 
					rest.getInt(2) , rest.getLong(3) , rest.getInt(4) , rest.getInt(5));
			// examtable 테이블의 레코드를 조회하여 순서대로 출력
		}
		
		rest.close();
		stmt.close();
		con.close();	
	}
}

