/*
 * examtable - 테이블 생성
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

public class db2_createtable {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		stmt.execute("create table examtable(name varchar(20)," // 이름은 varchar형
				+ "studentid int not null primary key, kor int,eng int,mat int) "
				// studentid 필드는 not null 이며 pk로 설정, 국,영,수 점수는 int형 필드
				+ "default charset=utf8;"); // 기본 charset 는 utf8
		stmt.close();
		con.close();
	}
}


