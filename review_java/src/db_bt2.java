/*
 * Basic Training2 - ���̺� ����, 1000�� ������ �ֱ�, �������� 30�� ���
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 * 	2017.06.04 -> ó��, ������ �л� ��ȣ �߰�, �Ѹ� �����ǵ� ���� ��� 
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
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement(); // stmt��ü ����
		//stmt.execute("delete from stu_info");
		/*stmt.execute("create table stu_info( " // ���̺� �� stu_info
				+ "stu_id int not null primary key, " // �л���ȣ ��Ű
				+ "stu_name varchar(50), " // �л� �̸�
				+ "kor int, " // ���� ����
				+ "eng int, " // ���� ����
				+ "mat int) " // ���� ����				
				+ "default charset=utf8;"); // �⺻ charset utf8 ���� */		
		/*for(int i =1 ;i<1001;i++){ // 1000���� �л� ���� �� ��,��,�� ���� ���� �� stu_info ���̺� ����
			int kor = (int) (Math.random()*100); // ���� ����
			int eng = (int) (Math.random()*100); // ���� ����
			int mat = (int) (Math.random()*100); // ���� ����
			stmt.execute("insert into stu_info values(" + i +  ",'STU" + i + "'," + kor + "," + eng + "," + mat + ")");
			// stu_info���̺� ��ȣ,�̸�,��,��,�� ���� ����
		}*/		
	
		
		Calendar cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ð��� ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 4�ڸ� �⵵-��-�� ��:�� �������� ���� �ð��� ��� ���� ����
		ResultSet rest = null; // select query ������ resultset (��ü �л���, ��,����,�̸�,�հ�,���,id �޴� ����)
		ResultSet rest1 = null; // select query ������ resultset1 (��������,���� ���� ���)
		Statement stmt1 = con.createStatement(); // stmt��ü ����
		int acnt = 0,cnt = 0; // ��ü �ο��� , ���� ������ �ο���
		int p = 1,sc = 0; // ������ ��,  ���������� ��� ������ Ȯ��
		int first=0,last=0; // ó��,������ �л� ��ȣ ����
		rest = stmt.executeQuery("select count(*) from stu_info"); // ��ü �л��� Ȯ��
		rest.next(); // ��ü �л� �� ������ �޾ƿ���
		int total = rest.getInt(1); // ��ü �л� �� ����
		rest = stmt.executeQuery("select kor,eng,mat,stu_name,(kor+eng+mat),(kor+eng+mat)/3,stu_id from stu_info");
		System.out.printf("%20s\n","��������ǥ"); // ù �� ��� ���
		System.out.printf("*********************************************\n");
		System.out.printf("%s %d %12s %s\n","PAGE : ",p,"��¥ : ",sdf.format(cal.getTime()));
		System.out.printf("---------------------------------------------\n");
		System.out.printf("%5s %4s %4s %4s %4s %4s\n","�л��̸�","����","����","����","�հ�","���");
		System.out.printf("*********************************************\n");
		while(rest.next()){						
			acnt++; // ��ü �л� �� ����
			cnt++; // ���� ������ �ο��� ����
			System.out.printf("[%7s]   %4s   %4s   %4s   %4s   %4s\n",rest.getString(4),rest.getInt(1),rest.getInt(2),rest.getInt(3),rest.getInt(5),rest.getInt(6));			
			if(sc == 0) // ó���̸� ù��° �л�id ����
				first = rest.getInt(7);
			sc++; // �������� ������� Ȯ��
			if(sc == 30 || total == acnt) // �л��� ���� ������ 30��°�ų� , ��ü �л����� ������ �л��� ���� ������(������ ������)
				last = rest.getInt(7);			
			// �л� �̸�, ��,��,�� ���� ���
			if ( (acnt % 30) == 0){
				p++; // ������ �� ����
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
				// ���� ���� �л� id ���ǿ� ������ ���� �������� ��,��,�� �ʵ��� �հ�� ����� ���Ѵ�
				rest1.next();
				System.out.printf("*********************************************\n");
				System.out.printf("%-7s %6s %6s %6s %6s %6s\n","�հ�",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
				System.out.printf("%-7s %6s %6s %6s %6s %6s\n","���",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
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
				// ���� ���� �л� id ���ǿ� ������ ������ ��,��,�� �ʵ��� �հ�� ����� ���Ѵ�
				rest1.next();
				System.out.printf("%-4s %7s %6s %6s %6s %6s\n","�����հ�",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
				System.out.printf("%-4s %7s %6s %6s %6s %6s\n","�������",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
				System.out.printf("*********************************************\n");
				System.out.printf("*********************************************\n");
				// ������ ��� ���
				System.out.printf("%20s\n","��������ǥ"); 
				System.out.printf("*********************************************\n");
				System.out.printf("%s %d %12s %s\n","PAGE : ",p,"��¥ : ",sdf.format(cal.getTime()));				
				System.out.printf("---------------------------------------------\n");
				System.out.printf("%5s %4s %4s %4s %4s %4s\n","�л��̸�","����","����","����","�հ�","���");
				System.out.printf("*********************************************\n");				
				cnt=0; // ���� ������ �ο��� �ʱ�ȭ
				sc=0; // �� �������� ��� ������ Ȯ���ϴ� ���� �ʱ�ȭ
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
		// ���� ���� �л� id ���ǿ� ������ ���� ���������� ���� �������� ��,��,�� �ʵ��� �հ�� ����� ���Ѵ�
		rest1.next();
		System.out.printf("*********************************************\n");
		System.out.printf("%-7s %6s %6s %6s %6s %6s\n","�հ�",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
		System.out.printf("%-7s %6s %6s %6s %6s %6s\n","���",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
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
		// ���� ���� �л� id ���ǿ� ������ ������ ��,��,�� �ʵ��� �հ�� ����� ���Ѵ�
		rest1.next();
		System.out.printf("%-4s %7s %6s %6s %6s %6s\n","�����հ�",rest1.getInt(1),rest1.getInt(2),rest1.getInt(3),rest1.getInt(7),rest1.getInt(9));
		System.out.printf("%-4s %7s %6s %6s %6s %6s\n","�������",rest1.getInt(4),rest1.getInt(5),rest1.getInt(6),rest1.getInt(8),rest1.getInt(10));
		System.out.printf("*********************************************\n");
		
		rest1.close();
		rest.close();
		stmt.close();
		stmt1.close();
		con.close();
		}
}
