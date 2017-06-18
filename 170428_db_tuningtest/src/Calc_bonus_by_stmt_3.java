import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calc_bonus_by_stmt_3 {
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
		conn.setAutoCommit(false); // autocommit 방지
		System.out.println("db connect success");		
		Statement stmt = conn.createStatement();
		//String str = "select * from emp_large where job != 'PRESIDENT' AND ROWNUM < 10000"; // ROWNUM 으로 정상작동 확인
		//ResultSet rest = stmt.executeQuery("select * from emp_large where job != 'PRESIDENT'");
		ResultSet rest = stmt.executeQuery("select * from emp_x_large where job != 'PRESIDENT'");
		// 50000000 test table
		long startTime = System.currentTimeMillis();
		Statement stmt1 = conn.createStatement();		
		while(rest.next()){
			int bonus = 0;			
			/*System.out.println(rest.getString(1) + "\t" + rest.getString(2) + "\t" + rest.getString(3) + "\t" + rest.getString(4) + "\t"
				+ rest.getString(5) + "\t" + rest.getString(6) + "\t" + rest.getString(7) + "\t" + rest.getString(8));*/
			/*if(rest.getString(3).equals("PRESIDENT"))
				continue;*/ 
			// 불필요하게 실행되는 PRESIDENT 걸러내는 구문을 DBMS상에서 처리 (하나의 SQL 을 실행할때 마다 PRESIDENT 조건 검사)
			switch(rest.getInt(8)){
			case 10:
				bonus = (int) ((rest.getInt(6)*0.3));
				break;
			case 20:
				bonus = (int) ((rest.getInt(6)*0.1));
				break;
			case 30:
				bonus = (int) ((rest.getInt(6)*0.05));
				break;
			case 40:
				bonus = (int) ((rest.getInt(6)*0.2));
				break;
			}
			/*stmt1.executeUpdate("insert into bonus_large3 values('" + 
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")");*/
			stmt1.executeUpdate("insert into bonus_x_large values('" + 
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")");
			//50000000 test table
			conn.commit();		
		}
		long endTime = System.currentTimeMillis();
		stmt1.close();
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec");
		stmt.close();		
		conn.close();		
	}	
}
