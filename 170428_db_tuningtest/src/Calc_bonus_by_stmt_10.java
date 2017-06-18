import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calc_bonus_by_stmt_10 {
	public static void main(String[] args) throws IOException, ClassNotFoundException,Exception {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",Locale.KOREA);
		Date date = new Date();
		String time1 = sdf.format(date);
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.149.128:1521:orasparta";
		// hostname(ip), port, sid
		String id = "scott";
		String passwd = "tiger";		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// upload driver for memory
		System.out.println("driver load success");
		conn = DriverManager.getConnection(url,id,passwd);
		conn.setAutoCommit(false); // autocommit ¹æÁö
		System.out.println("db connect success");
		long startTime = System.currentTimeMillis();
		
		//CallableStatement cs = conn.prepareCall("insert /*+ append */ into sqtest "
		/*		+ "select ?,empno,job,deptno,sal, " +
				"case deptno " +
				"when 10 then trunc(sal * 0.3) " +
				"when 20 then trunc(sal * 0.1) " +
				"when 30 then trunc(sal * 0.05) " +
				"when 40 then trunc(sal * 0.2) " +
				"end as bonus " +
				"from emp_large where job != 'PRESIDENT' ");*/
		// append hint
		CallableStatement cs = conn.prepareCall("insert into sqtest "
				+ "select ?,empno,job,deptno,sal, " +
				"case deptno " +
				"when 10 then trunc(sal * 0.3) " +
				"when 20 then trunc(sal * 0.1) " +
				"when 30 then trunc(sal * 0.05) " +
				"when 40 then trunc(sal * 0.2) " +
				"end as bonus " +
				"from emp_large where job != 'PRESIDENT' ");
		// use subquery 
		cs.setString(1, time1);
		cs.execute();
		long endTime = System.currentTimeMillis();

		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec");
		cs.close();
		conn.close();		
	}	
}
