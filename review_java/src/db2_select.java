/*
 * examtable - ���̺� ��ȸ
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

public class db2_select {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		ResultSet rest = stmt.executeQuery("select * from examtable;"); // select �� ����
		
		System.out.printf("  �̸�   �й�   ���� ���� ����\n");
		while(rest.next()){
			System.out.printf("%4s  %6d  %3d  %3d  %3d\n",rest.getString(1) , 
					rest.getInt(2) , rest.getLong(3) , rest.getInt(4) , rest.getInt(5));
			// examtable ���̺��� ���ڵ带 ��ȸ�Ͽ� ������� ���
		}
		
		rest.close();
		stmt.close();
		con.close();	
	}
}

