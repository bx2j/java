import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Calc_bonus_by_stmt_1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException,Exception {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",Locale.KOREA);
		Date date = new Date();
		String time1 = sdf.format(date); // bonus_large ���̺��� yyyymm �÷��� ���� �����ϱ� ���� ��¥ �޾ƿ��� time1 ����
		Connection conn = null;
		// Ư�� ������ ������ ����� Ŀ�ؼ��� ��Ÿ���� Ư���� SQL������ �����ϰ� �����ų �� �ִ� statement��ü�� ������ ���� ���
		// ��Ÿ�����Ϳ� ���� ������ ������ ������ �����ϴµ� ���
		String url ="jdbc:oracle:thin:@192.168.149.128:1521:orasparta"; // hostname(ip), port, sid
		String id = "scott"; // ����Ŭ dbms �� �����ϱ� ���� id
		String passwd = "tiger"; // ����Ŭ dbms �� �����ϱ� ���� id �� passwd
		Class.forName("oracle.jdbc.driver.OracleDriver"); // upload driver for memory
		// Ư�� Ŭ������ �ε��ϸ� �ڵ����� ��ü�� ����,DriverManager�� ���
		// ����̹� Ŭ������ ã�� ���� ��� ClassNotFoundException ���� �߻�
		System.out.println("driver load success");
		conn = DriverManager.getConnection(url,id,passwd);
		// DriverManager ��ü�� ������ ������ JDBC����̹��� ���Ͽ� Ŀ�ؼ��� ����� ����
		// Class.forName() �޼ҵ带 ���� �����ȴ�. 
		conn.setAutoCommit(false); // autocommit ����
		System.out.println("db connect success");		
		Statement stmt = conn.createStatement();
		// connection ��ü�� ���� �����Ǵ� �޼ҵ� ������ �����Ѵ�. statement �������̽��� ������ ��ü
		// executeQuery() �޼ҵ带 ȣ���Ͽ� SQL ���� ���� ����.
		//String str = "select * from emp_large"; // emp_large ���̺��� ������ ��ȸ�ϴ� ���� str������ ����
		//String str = "select * from emp_large where rownum<=100000";
		ResultSet rest = stmt.executeQuery("select * from emp_x_large"); // emp_x_large test table
		// select ���� ����� ������ ��� ������ ������� ResultSet ��ȯ.
		// SQL���ǿ� ���� ������ ���̺� ����
		long startTime = System.currentTimeMillis(); // ���۽ð� ����
		while(rest.next()){
			Statement stmt1 = conn.createStatement();
			int bonus = 0;			
			/*System.out.println(rest.getString(1) + "\t" + rest.getString(2) + "\t" + rest.getString(3) + "\t" + rest.getString(4) + "\t"
				+ rest.getString(5) + "\t" + rest.getString(6) + "\t" + rest.getString(7) + "\t" + rest.getString(8));*/
			if(rest.getString(3).equals("PRESIDENT")) // �����̸� ���ʽ� ����
				continue;
			switch(rest.getInt(8)){
			case 10: // 10�� �μ�
				bonus = (int) ((rest.getInt(6)*0.3)); // �޿��� 30%
				break;
			case 20: // 20�� �μ�
				bonus = (int) ((rest.getInt(6)*0.1)); // �޿��� 10%
				break;
			case 30: // 30�� �μ�
				bonus = (int) ((rest.getInt(6)*0.05)); // �޿��� 5%
				break;
			case 40: // 40�� �μ�
				bonus = (int) ((rest.getInt(6)*0.2)); // �޿��� 20%
				break;
			}
			/*String sql = "insert into bonus_large values('" + 
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")";*/
			// ���� ������ ����??
			stmt1.executeUpdate("insert into bonus_x_large values('" + // bonus_x_large test table
					time1 + "'," + rest.getInt(1) + ",'" + rest.getString(3) + "'," + 
					rest.getInt(8) + "," + rest.getInt(6) + "," + bonus + ")");
			conn.commit(); // �� �� ���� commit
			stmt1.close();
		}
		long endTime = System.currentTimeMillis(); // ����ð� ����
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec"); // ����ð� - ���۽ð� ms(�и���) ǥ�ø� �ʷ� ��ȯ�� ���
		stmt.close();		
		conn.close();		
	}	
}



