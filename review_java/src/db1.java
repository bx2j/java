/*
 * jdbc �⺻ ���α׷�
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

public class db1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		ResultSet rest = stmt.executeQuery("show databases"); // show databases ���� ����
		
		while(rest.next()){
			System.out.println("�� : "+rest.getString(1)); // �޾ƿ� ���� ���
			
		}
		rest.close();
		stmt.close();
		con.close();
	}
}

