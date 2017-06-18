import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Calc_bonus_by_stmt_1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException,Exception {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",Locale.KOREA);
		Date date = new Date();
		String time1 = sdf.format(date); // bonus_large 테이블의 yyyymm 컬럼에 값을 저장하기 위해 날짜 받아오는 time1 변수
		Connection conn = null;
		// 특정 데이터 원본과 연결된 커넥션을 나타내고 특정한 SQL문장을 정의하고 실행시킬 수 있는 statement객체를 생성할 때도 사용
		// 메타데이터에 관한 정보를 데이터 원본에 질의하는데 사용
		String url ="jdbc:oracle:thin:@192.168.149.128:1521:orasparta"; // hostname(ip), port, sid
		String id = "scott"; // 오라클 dbms 에 접속하기 위한 id
		String passwd = "tiger"; // 오라클 dbms 에 접속하기 위한 id 의 passwd
		Class.forName("oracle.jdbc.driver.OracleDriver"); // upload driver for memory
		// 특정 클래스를 로딩하면 자동으로 객체가 생성,DriverManager에 등록
		// 드라이버 클래스를 찾지 못할 경우 ClassNotFoundException 예외 발생
		System.out.println("driver load success");
		conn = DriverManager.getConnection(url,id,passwd);
		// DriverManager 객체는 데이터 원본에 JDBC드라이버를 통하여 커넥션을 만드는 역할
		// Class.forName() 메소드를 통해 생성된다. 
		conn.setAutoCommit(false); // autocommit 방지
		System.out.println("db connect success");		
		Statement stmt = conn.createStatement();
		// connection 객체에 의해 구현되는 메소드 집합을 정의한다. statement 인터페이스를 구현한 객체
		// executeQuery() 메소드를 호출하여 SQL 질의 실행 가능.
		//String str = "select * from emp_large"; // emp_large 테이블의 정보를 조회하는 쿼리 str변수에 저장
		//String str = "select * from emp_large where rownum<=100000";
		ResultSet rest = stmt.executeQuery("select * from emp_x_large"); // emp_x_large test table
		// select 문을 사용한 질의의 경우 성공시 결과물로 ResultSet 반환.
		// SQL질의에 의해 생성된 테이블 보유
		long startTime = System.currentTimeMillis(); // 시작시간 측정
		while(rest.next()){
			Statement stmt1 = conn.createStatement();
			int bonus = 0;			
			/*System.out.println(rest.getString(1) + "\t" + rest.getString(2) + "\t" + rest.getString(3) + "\t" + rest.getString(4) + "\t"
				+ rest.getString(5) + "\t" + rest.getString(6) + "\t" + rest.getString(7) + "\t" + rest.getString(8));*/
			if(rest.getString(3).equals("PRESIDENT")) // 사장이면 보너스 없음
				continue;
			switch(rest.getInt(8)){
			case 10: // 10번 부서
				bonus = (int) ((rest.getInt(6)*0.3)); // 급여의 30%
				break;
			case 20: // 20번 부서
				bonus = (int) ((rest.getInt(6)*0.1)); // 급여의 10%
				break;
			case 30: // 30번 부서
				bonus = (int) ((rest.getInt(6)*0.05)); // 급여의 5%
				break;
			case 40: // 40번 부서
				bonus = (int) ((rest.getInt(6)*0.2)); // 급여의 20%
				break;
			}
			/*String sql = "insert into bonus_large values('" + 
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")";*/
			// 성능 저하의 원인??
			stmt1.executeUpdate("insert into bonus_x_large values('" + // bonus_x_large test table
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")");
			conn.commit(); // 한 줄 마다 commit
			stmt1.close();
		}
		long endTime = System.currentTimeMillis(); // 종료시간 측정
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec"); // 종료시간 - 시작시간 ms(밀리초) 표시를 초로 변환해 출력
		stmt.close();		
		conn.close();		
	}	
}



