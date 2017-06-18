import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Calc_bonus_by_stmt_9 {
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
				"declare " +
					"cursor cur is (select empno,job,deptno,sal, " +
					"case deptno " +
						"when 10 then trunc(sal * 0.3) " +
						"when 20 then trunc(sal * 0.1) " +
						"when 30 then trunc(sal * 0.05) " +
						"when 40 then trunc(sal * 0.2) " +
						"end as bonus " +
					"from emp_large where job != 'PRESIDENT'); " +
					"type bulk1 is table of cur%rowtype; " +
					"bulk_t bulk1; " +
					"val number := 0; " + // processing status 를 위한 변수
				"begin " +
					"insert into processing(class_name,status,note) values(?,val,'start'); " + 
					"open cur; " + // 커서 열기
					"loop " + // loop 시작
					"val := val + 1; "+
					"fetch cur bulk collect into bulk_t limit 10000; " +
					"forall i in 1..bulk_t.count " +
						"insert into BULK_BONUS values(?,bulk_t(i).empno,bulk_t(i).job,bulk_t(i).deptno,bulk_t(i).sal,bulk_t(i).bonus); " +
						"if mod(VAL,100)=0 then "+
							"insert into processing(class_name,status,note) values(?,val*10000,'ing'); " + 
						"end if; "+
					    "commit; " +
						"exit when cur%notfound; " + // 조건 만족 시 loop 탈출				    
				    "end loop; " +
				    "insert into processing(class_name,status,note) values(?,(val*10000)-1,'end'); " +  
				    "close cur; " +	// 커서 닫기
				"exception "+ // 예외처리 구문
					"when others then "+
						"insert into err_msg(class_name,err_msg,err_backtrace) "
					+ "values(?,dbms_utility.format_error_stack,dbms_utility.format_error_backtrace); "+
				"end; ");			
		cs.setString(1, currentStack.getClassName()); // class_name - Calc_bonus_by_stmt_9
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