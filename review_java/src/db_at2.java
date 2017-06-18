/*
 * 주가데이터 테이블 stock 에서 삼성전자, 특정일자 불러오는 쿼리 작성
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 * 	17.06.02 shrn_iscd->stnd_iscd 수정
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class db_at2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 3자리 콤마찍기 위한 DecimalFormat
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false", "root", "1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = conn.createStatement(); // statement 객체 생성

		// 삼성전자(A005930)만 불러오는 쿼리문		
		ResultSet rest = stmt.executeQuery(
				"select stnd_iscd,bsop_date,shrn_iscd,stck_prpr from stock where shrn_iscd = 'A005930';");

		
		// 특정일자(20150112)만 불러오는 쿼리문
		/*ResultSet rest = stmt.executeQuery(
				"select stnd_iscd,bsop_date,shrn_iscd,stck_prpr from stock where bsop_date = '20150112';");*/
		   
		int cnt = 0; // 총 개수 세는 변수
		   long st = System.currentTimeMillis(); // 시작 시간
		   while(rest.next()){
			   System.out.printf("*****************************************\n");
			   System.out.printf("%s : %s\n","표준 종목 코드",rest.getString(1));
			   System.out.printf("%s : %s\n","주식 영업 일자",rest.getString(2));
			   System.out.printf("%s : %s\n","유가증권 단축 종목 코드",rest.getString(3));
			   System.out.printf("%s : %s\n","주식 종가",df.format(rest.getInt(4)));
			   cnt++;
		   }
		   System.out.printf("총 개수 [%d]\n",cnt);
		   long et = System.currentTimeMillis(); // 종료 시간
		   System.out.printf("경과시간 : [%d]ms\n",et-st); // 경과 시간 측정
		   
	}
}


