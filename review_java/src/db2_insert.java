/*
 * examtable - ���̺� ���ڵ� ����
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db2_insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		stmt.execute("insert into examtable values ('1��',209901,95,40,85);"); // examtable�� 1��,209901,95,40,85 ����
		stmt.execute("insert into examtable values ('2��',209902,75,60,75);"); // examtable�� 2��,209902,75,60,75 ����
		stmt.execute("insert into examtable values ('3��',209903,55,14,65);"); // examtable�� 3��,209903,55,14,65 ����
		stmt.execute("insert into examtable values ('4��',209904,85,10,35);"); // examtable�� 4��,209904,85,10,35 ����
		stmt.execute("insert into examtable values ('5��',209905,65,12,25);"); // examtable�� 5��,209905,65,12,25 ����
		stmt.execute("insert into examtable values ('6��',209906,75,10,85);"); // examtable�� 6��,209906,75,10,85 ����
		
		stmt.close();
		con.close();
	}
}

