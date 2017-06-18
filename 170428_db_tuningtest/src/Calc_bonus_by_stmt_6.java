import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calc_bonus_by_stmt_6 {
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
		//PreparedStatement pstmt = conn.prepareStatement("select * from emp_large where job != 'PRESIDENT'");
		PreparedStatement pstmt = conn.prepareStatement("select * from emp_x_large where job != 'PRESIDENT'");
		ResultSet rest = pstmt.executeQuery();
		long startTime = System.currentTimeMillis();
		//PreparedStatement pstmt1 = conn.prepareStatement("insert into bonus_large6 values(?,?,?,?,?,?)");	
		PreparedStatement pstmt1 = conn.prepareStatement("insert into bonus_x_large6 values(?,?,?,?,?,?)");
		int ab =0;
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
				pstmt1.setString(1,time1);
				pstmt1.setInt(2,rest.getInt(1));
				pstmt1.setString(3, rest.getString(3));
				pstmt1.setInt(4,rest.getInt(8));
				pstmt1.setInt(5,rest.getInt(6));
				pstmt1.setInt(6, bonus);
				pstmt1.addBatch();
				ab++;
				if ( (ab % 100000) == 0){
					/*long midtime = System.currentTimeMillis();
					System.out.println(ab + "time :" + (midtime-startTime)/1000);*/
					pstmt1.executeBatch();
					//conn.commit();
				}							
			}
			pstmt1.executeBatch();
			conn.commit();
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
