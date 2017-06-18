/*
 * �ְ������� ���̺� stock ���� �Ｚ����, Ư������ �ҷ����� ���� �ۼ�
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 * 	17.06.02 shrn_iscd->stnd_iscd ����
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class db_at2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 3�ڸ� �޸���� ���� DecimalFormat
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false", "root", "1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = conn.createStatement(); // statement ��ü ����

		// �Ｚ����(A005930)�� �ҷ����� ������		
		ResultSet rest = stmt.executeQuery(
				"select stnd_iscd,bsop_date,shrn_iscd,stck_prpr from stock where shrn_iscd = 'A005930';");

		
		// Ư������(20150112)�� �ҷ����� ������
		/*ResultSet rest = stmt.executeQuery(
				"select stnd_iscd,bsop_date,shrn_iscd,stck_prpr from stock where bsop_date = '20150112';");*/
		   
		int cnt = 0; // �� ���� ���� ����
		   long st = System.currentTimeMillis(); // ���� �ð�
		   while(rest.next()){
			   System.out.printf("*****************************************\n");
			   System.out.printf("%s : %s\n","ǥ�� ���� �ڵ�",rest.getString(1));
			   System.out.printf("%s : %s\n","�ֽ� ���� ����",rest.getString(2));
			   System.out.printf("%s : %s\n","�������� ���� ���� �ڵ�",rest.getString(3));
			   System.out.printf("%s : %s\n","�ֽ� ����",df.format(rest.getInt(4)));
			   cnt++;
		   }
		   System.out.printf("�� ���� [%d]\n",cnt);
		   long et = System.currentTimeMillis(); // ���� �ð�
		   System.out.printf("����ð� : [%d]ms\n",et-st); // ��� �ð� ����
		   
	}
}


