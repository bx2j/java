import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Calc_bonus_by_stmt_8 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",Locale.KOREA);
		Date date = new Date();
		String yyyymm = sdf.format(date);
		Connection conn = null;	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver load success");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.149.128:1521:orasparta","scott","tiger");
		conn.setAutoCommit(false); // autocommit 방지
		System.out.println("db connect success");	
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement currentStack = stacks[ 0 ]; // 현재 class 출력
		System.out.println( "current class : " + currentStack.getClassName() );
		long startTime = System.currentTimeMillis();
		CallableStatement cs = conn.prepareCall(
				"declare" + // 변수 선언
					" cursor cur is (select empno,job,deptno,sal,"+ // Explicit cursor 정의
						"case deptno "+ // 부서별 보너스 계산
							"when 10 then trunc(sal * 0.3) "+ // 10번 부서 급여의 30% 지급
							"when 20 then trunc(sal * 0.1) "+ // 20번 부서 급여의 10% 지급
							"when 30 then trunc(sal * 0.05) "+ // 30번 부서 급여의 5% 지급
							"when 40 then trunc(sal * 0.2) "+ // 40번 부서 급여의 20% 지급
							"end as bonus "+
							"from emp_large where job != 'PRESIDENT'); "+
					"val number := 0; " + // processing status 를 위한 변수
				"begin "+ // 시작
					"insert into processing(class_name,status,note) values(?,val,'start'); " + 
					// 처리 현황을 기록하는 processing 테이블에 현재 class_name , 상태(몇 건 처리중), 시작 삽입 
					"for i in cur "+ // for loop 시작
					"loop "+
						"insert into bonus7 values(?,i.empno,i.job,i.deptno,i.sal,i.bonus); "+
						"val := val + 1; "+
						"if mod(val,10000)=0 then "+ // 10000 건당 진행 중 삽입
						// if ~ then 으로 if 문 시작
						// mod(n,m) n을 m 으로 나눈 나머지를 구한다
							"insert into processing(class_name,status,note) values(?,val,'ing'); " +
							// 처리 현황을 기록하는 processing 테이블에 현재 class_name , 상태(몇 건 처리중), 진행 중 삽입
							"commit; "+
						"end if; "+ // if 종료
					"end loop; "+ // for loop 종료
					"insert into processing(class_name,status,note) values(?,val,'end'); " +
					// 처리 현황을 기록하는 processing 테이블에 현재 class_name , 상태(완료 건수), 완료 삽입
				"exception "+ // 예외처리 구문
					"when others then "+
						"insert into err_msg(class_name,err_msg,err_backtrace) " 
						+ "values(?,dbms_utility.format_error_stack,dbms_utility.format_error_backtrace); "+
						// err_msg 테이블에 현재 class_name,error메시지,error 발생 위치 기록
				"end; "); // block 의 종료		
		cs.setString(1, currentStack.getClassName()); // class_name - Calc_bonus_by_stmt_8
		cs.setString(2, yyyymm); // 보너스 지급 년월
		cs.setString(3, currentStack.getClassName());
		cs.setString(4, currentStack.getClassName());
		cs.setString(5, currentStack.getClassName());
		cs.execute();
	
		long endTime = System.currentTimeMillis();		
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec");		
		conn.close();
	}
}