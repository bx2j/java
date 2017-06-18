import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calc_bonus_by_stmt_5 {
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
		conn.setAutoCommit(false); // autocommit ����
		System.out.println("db connect success");		
		PreparedStatement pstmt = conn.prepareStatement("select * from emp_x_large where job != 'PRESIDENT'");
		ResultSet rest = pstmt.executeQuery();
		long startTime = System.currentTimeMillis();
		PreparedStatement pstmt1 = conn.prepareStatement("insert into bonus_x_large values(?,?,?,?,?,?)");	
		try{
			while(rest.next()){
				int bonus = 0;
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
				pstmt1.setString(1,time1); // values�� ù��° ?
				pstmt1.setInt(2,rest.getInt(1)); // values�� �ι�° ?
				pstmt1.setString(3, rest.getString(3)); // values�� ����° ?
				pstmt1.setInt(4,rest.getInt(8)); // values�� �׹�° ?
				pstmt1.setInt(5,rest.getInt(6)); // values�� �ټ���° ?
				pstmt1.setInt(6, bonus); // values�� ������° ?
				pstmt1.executeUpdate();
			}
			conn.commit(); // ������ commit�� ���������� ������ �ȴ�. ��� ���� ��, ��ü���� ������ ���� �� commit
		}catch(Exception e){
			conn.rollback();
			System.out.println(e.toString());
		}
		long endTime = System.currentTimeMillis();
		pstmt1.close();
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec");
		pstmt.close();		
		conn.close();		
	}	
}
