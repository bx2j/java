/*
 * Basic Training2 - 테이블 생성, 1000명 데이터 넣기, 페이지당 30명 출력
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 * 	2017.06.04 -> 처음, 마지막 학생 번호 추가, 한명 삭제되도 정상 출력 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class db_bt2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement(); // stmt객체 생성
		//stmt.execute("delete from stu_info");
		/*stmt.execute("create table stu_info( " // 테이블 명 stu_info
				+ "stu_id int not null primary key, " // 학생번호 주키
				+ "stu_name varchar(50), " // 학생 이름
				+ "kor int, " // 국어 점수
				+ "eng int, " // 영어 점수
				+ "mat int) " // 수학 점수				
				+ "default charset=utf8;"); // 기본 charset utf8 설정 */		
		/*for(int i =1 ;i<1001;i++){ // 1000명의 학생 생성 및 국,영,수 점수 생성 후 stu_info 테이블에 삽입
			int kor = (int) (Math.random()*100); // 국어 점수
			int eng = (int) (Math.random()*100); // 영어 점수
			int mat = (int) (Math.random()*100); // 수학 점수
			stmt.execute("insert into stu_info values(" + i +  ",'STU" + i + "'," + kor + "," + eng + "," + mat + ")");
			// stu_info테이블에 번호,이름,국,영,수 점수 삽입
		}*/		
	
		
		Calendar cal = Calendar.getInstance(); // Calendar 클래스는 현재 시간을 가져옴
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 4자리 년도-월-일 시:분 형식으로 현재 시간의 출력 포맷 지정
		ResultSet rest = null; // select query 저장할 resultset (전체 학생수, 국,영수,이름,합계,평균,id 받는 쿼리)
		ResultSet rest1 = null; // select query 저장할 resultset1 (페이지당,누적 성적 계산)
		Statement stmt1 = con.createStatement(); // stmt객체 생성
		int acnt = 0,cnt = 0; // 전체 인원수 , 현재 페이지 인원수
		int p = 1,sc = 0; // 페이지 수,  한페이지당 몇명 출력됬는지 확인
		int first=0,last=0; // 처음,마지막 학생 번호 저장
		rest = stmt.executeQuery("select count(*) from stu_info"); // 전체 학생수 확인
		rest.next(); // 전체 학생 수 쿼리문 받아오기
		int total = rest.getInt(1); // 전체 학생 수 저장
		rest = stmt.executeQuery("select kor,eng,mat,stu_name,(kor+eng+mat),(kor+eng+mat)/3,stu_id from stu_info");
		System.out.printf("%20s\n","성적집계표"); // 첫 장 헤더 출력
		System.out.printf("*********************************************\n");
		System.out.printf("%s %d %12s %s\n","PAGE : ",p,"날짜 : ",sdf.format(cal.getTime()));
		System.out.printf("---------------------------------------------\n");
		System.out.printf("%5s %4s %4s %4s %4s %4s\n","학생이름","국어","영어","수학","합계","평균");
		System.out.printf("*********************************************\n");
		while(rest.next()){						
			acnt++; // 전체 학생 수 증가
			cnt++; // 현재 페이지 인원수 증가
			System.out.printf("[%7s]   %4s   %4s   %4s   %4s   %4s\n",rest.getString(4),rest.getInt(1),rest.getInt(2),rest.getInt(3),rest.getInt(5),rest.getInt(6));			
			if(sc == 0) // 처음이면 첫번째 학생id 저장
				first = rest.getInt(7);
			sc++; // 페이지당 몇명인지 확인
			if(sc == 30 || total == acnt) // 학생의 수가 마지막 30번째거나 , 전체 학생수랑 증가된 학생수 값이 같으면(마지막 페이지)
				last = rest.getInt(7);			
			// 학생 이름, 국,영,수 점수 출력
			if ( (acnt % 30) == 0){
				p++; // 페이지 수 증가
				rest1 = stmt1.executeQuery("select " 
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then kor end),"
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then eng end),"
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then mat end),"
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then kor end)/" + cnt + ","
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then eng end)/" + cnt + ","
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then mat end)/" + cnt + ","
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat) end),"
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat) end)/" + cnt + ","
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end),"
						+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end)/" + cnt + " "
						+ "from stu_info");
				// 범위 내의 학생 id 조건에 맞으면 현재 페이지의 국,영,수 필드의 합계와 평균을 구한다
				rest1.next();
				System.out.printf("*********************************************\n");
				System.out.printf("%-7s %6s %6s %6s %6s %6s\n","합계",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
				System.out.printf("%-7s %6s %6s %6s %6s %6s\n","평균",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
				System.out.printf("*********************************************\n");
				rest1 = stmt1.executeQuery("select "
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then kor end),"
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then eng end),"
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then mat end),"
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then kor end)/" + acnt + ","
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then eng end)/" + acnt + ","
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then mat end)/" + acnt + ", "
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat) end),"
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat) end)/" + acnt + ","
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end),"
						+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end)/" + acnt + " "
						+ " from stu_info");
				// 범위 내의 학생 id 조건에 맞으면 누적된 국,영,수 필드의 합계와 평균을 구한다
				rest1.next();
				System.out.printf("%-4s %7s %6s %6s %6s %6s\n","누적합계",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
				System.out.printf("%-4s %7s %6s %6s %6s %6s\n","누적평균",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
				System.out.printf("*********************************************\n");
				System.out.printf("*********************************************\n");
				// 나머지 헤더 출력
				System.out.printf("%20s\n","성적집계표"); 
				System.out.printf("*********************************************\n");
				System.out.printf("%s %d %12s %s\n","PAGE : ",p,"날짜 : ",sdf.format(cal.getTime()));				
				System.out.printf("---------------------------------------------\n");
				System.out.printf("%5s %4s %4s %4s %4s %4s\n","학생이름","국어","영어","수학","합계","평균");
				System.out.printf("*********************************************\n");				
				cnt=0; // 현재 페이지 인원수 초기화
				sc=0; // 한 페이지당 몇명 출력됬는지 확인하는 변수 초기화
			}	
		}
		rest1 = stmt1.executeQuery("select "
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then kor end),"
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then eng end),"
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then mat end),"
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then kor end)/" + cnt + ","
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then eng end)/" + cnt + ","
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then mat end)/" + cnt + ","
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat) end),"
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat) end)/" + cnt + ", "
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end),"
				+ "sum(case when stu_id >= " + (first) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end)/" + cnt + " "				
				+ "from stu_info");
		// 범위 내의 학생 id 조건에 맞으면 현재 페이지에서 남은 페이지의 국,영,수 필드의 합계와 평균을 구한다
		rest1.next();
		System.out.printf("*********************************************\n");
		System.out.printf("%-7s %6s %6s %6s %6s %6s\n","합계",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
		System.out.printf("%-7s %6s %6s %6s %6s %6s\n","평균",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
		System.out.printf("*********************************************\n");
		rest1 = stmt1.executeQuery("select "
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then kor end),"
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then eng end),"
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then mat end),"
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then kor end)/" + acnt + ","
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then eng end)/" + acnt + ","
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then mat end)/" + acnt + ","
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat) end),"
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat) end)/" + acnt + ", "
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end),"
				+ "sum(case when stu_id >= " + (1) + " and stu_id <= " + (last) + " then (kor+eng+mat)/3 end)/" + acnt + " "
				+ "from stu_info");
		// 범위 내의 학생 id 조건에 맞으면 누적된 국,영,수 필드의 합계와 평균을 구한다
		rest1.next();
		System.out.printf("%-4s %7s %6s %6s %6s %6s\n","누적합계",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
		System.out.printf("%-4s %7s %6s %6s %6s %6s\n","누적평균",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
		System.out.printf("*********************************************\n");
		
		rest1.close();
		rest.close();
		stmt.close();
		stmt1.close();
		con.close();
		}
}
