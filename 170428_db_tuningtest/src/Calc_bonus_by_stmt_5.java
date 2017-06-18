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
		conn.setAutoCommit(false); // autocommit 방지
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
				pstmt1.setString(1,time1); // values의 첫번째 ?
				pstmt1.setInt(2,rest.getInt(1)); // values의 두번째 ?
				pstmt1.setString(3, rest.getString(3)); // values의 세번째 ?
				pstmt1.setInt(4,rest.getInt(8)); // values의 네번째 ?
				pstmt1.setInt(5,rest.getInt(6)); // values의 다섯번째 ?
				pstmt1.setInt(6, bonus); // values의 여섯번째 ?
				pstmt1.executeUpdate();
			}
			conn.commit(); // 과도한 commit은 성능저하의 원인이 된다. 모두 수행 후, 전체적인 오류가 없을 시 commit
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
