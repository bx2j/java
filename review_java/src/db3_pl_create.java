/*
 * Basic Training1 - 테이블 생성
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db3_pl_create {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		stmt.execute("create table parking( " // 테이블 명 parking
				+ "pl_index int not null primary key, " // 임시 부여 번호 주키
				+ "pl_admin varchar(50), " // 주차장 관리 번호
				+ "pl_name varchar(50), " // 주차장 명
				+ "pl_div varchar(50), " // 주차장 구분
				+ "pl_type varchar(50), " // 주차장 유형
				+ "pl_jibun varchar(100), " // 소재지지번주소
				+ "pl_doro varchar(100), " // 소재지도로명
				+ "pl_size varchar(20), " // 주차구획수
				+ "pl_grade varchar(10), " // 급지구분
				+ "pl_day varchar(50), " // 운영요일
				+ "pl_lat double, " // 위도
				+ "pl_lng double )" // 경도
				+ "default charset=utf8;");
		stmt.close();
		con.close();
	}
}

