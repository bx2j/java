/*
 * Basic Training1 - ���̺� ����
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ� 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db3_pl_create {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		stmt.execute("create table parking( " // ���̺� �� parking
				+ "pl_index int not null primary key, " // �ӽ� �ο� ��ȣ ��Ű
				+ "pl_admin varchar(50), " // ������ ���� ��ȣ
				+ "pl_name varchar(50), " // ������ ��
				+ "pl_div varchar(50), " // ������ ����
				+ "pl_type varchar(50), " // ������ ����
				+ "pl_jibun varchar(100), " // �����������ּ�
				+ "pl_doro varchar(100), " // ���������θ�
				+ "pl_size varchar(20), " // ������ȹ��
				+ "pl_grade varchar(10), " // ��������
				+ "pl_day varchar(50), " // �����
				+ "pl_lat double, " // ����
				+ "pl_lng double )" // �浵
				+ "default charset=utf8;");
		stmt.close();
		con.close();
	}
}

