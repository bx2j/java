/*
 * examtable - 테이블 레코드 삽입
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db2_insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		stmt.execute("insert into examtable values ('1번',209901,95,40,85);"); // examtable에 1번,209901,95,40,85 삽입
		stmt.execute("insert into examtable values ('2번',209902,75,60,75);"); // examtable에 2번,209902,75,60,75 삽입
		stmt.execute("insert into examtable values ('3번',209903,55,14,65);"); // examtable에 3번,209903,55,14,65 삽입
		stmt.execute("insert into examtable values ('4번',209904,85,10,35);"); // examtable에 4번,209904,85,10,35 삽입
		stmt.execute("insert into examtable values ('5번',209905,65,12,25);"); // examtable에 5번,209905,65,12,25 삽입
		stmt.execute("insert into examtable values ('6번',209906,75,10,85);"); // examtable에 6번,209906,75,10,85 삽입
		
		stmt.close();
		con.close();
	}
}

