/*
 * examtable - ���̺� ����
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db2_createtable {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		stmt.execute("create table examtable(name varchar(20)," // �̸��� varchar��
				+ "studentid int not null primary key, kor int,eng int,mat int) "
				// studentid �ʵ�� not null �̸� pk�� ����, ��,��,�� ������ int�� �ʵ�
				+ "default charset=utf8;"); // �⺻ charset �� utf8
		stmt.close();
		con.close();
	}
}


