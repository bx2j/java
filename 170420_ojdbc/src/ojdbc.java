import java.io.*;
import java.sql.*;
public class ojdbc {
	public static void main(String[] args) throws IOException, ClassNotFoundException,Exception {
		Connection conn = null;
		String url = null;
		String id = "scott";
		String passwd = "1q2w3e";		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// upload driver for memory
		System.out.println("driver load success");
		url = "jdbc:oracle:thin:@192.168.149.128:1521:orasparta";
		// hostname(ip), port, sid
		conn = DriverManager.getConnection(url,id,passwd);
		conn.setAutoCommit(false); // autocommit 방지
		System.out.println("db connect success");
		Statement stmt = conn.createStatement();

		try{
		LoadCsv ls = new LoadCsv(stmt);
		ls.FileCall();
		conn.commit();
		}catch(SQLException e){
			conn.rollback();
		}
		stmt.close();
	}
}


/*String sql = "select * from emp";
ResultSet rest = stmt.executeQuery(sql);
while(rest.next()){
	System.out.println("이름 : " + rest.getString("EMPNO") + "\t나이 : " + rest.getString("ENAME") + "\t주소 : " + rest.getString("JOB")); 
}*/