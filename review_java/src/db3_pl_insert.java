/*
 * Basic Training1 - parking���̺� �� �ֱ� �� �ִܰŸ�, ����Ÿ� ��ȸ 
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ� 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db3_pl_insert {
	public static void main(String[] args) throws ClassNotFoundException,SQLException, IOException{
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		/*int cnt = 1;
		File f = new File("C:\\1234\\����������ǥ�ص�����.txt"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о����
		String readtxt; // ���Ͽ��� �о�� ���ڿ� �����ϴ� ����
		if((readtxt = br.readLine()) == null) // ���ڿ��� ���ٸ�
			System.out.printf("�� �����Դϴ�\n"); // �� ����
		String[] field_name = readtxt.split("\t"); // ������ �����Ͽ� �о�� ���ڿ� ����
		
		while((readtxt = br.readLine())!=null){
			String[] field = readtxt.split("\t");			
			if(field.length < 33){ // ������ ����� �迭�� ���̰� 33���϶��
				// ��,�浵���� ���� �ʵ��
				stmt.execute("insert into parking values(" + cnt + ","
						+ "'" + field[0] + "','" + field[1] + "','" + field[2] + "','" + field[3] + "','" + 
						field[4] + "','" + field[5] + "','" + field[6] + "','" + field[7]
						+ "','" + field[9] + "'," + null + "," + null + ")");
				// ������ �浵�� �����̸� null ����
			}
			else{
				if( !(field[31].equals("")) && !(field[32].equals("")) ){
					stmt.execute("insert into parking values(" + cnt + ","
						+ "'" + field[0] + "','" + field[1] + "','" + field[2] + "','" + field[3] + "','" + 
							field[4] + "','" + field[5] + "','" + field[6] + "','" + field[7]
						+"','" + field[9] + "'," + field[31] + "," + field[32] + ")");
					// ������ �浵�� ������ �ƴ� ����� ���
				}
			}
			cnt++;
		}*/		
		// 35.518215, 129.425293 �츮��
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		// ���� ��ġ (���ձ��������)
		double lat = 37.385842;
		double lng = 127.121274;
		double max = 0,min=100000; // �ִ밪, �ּҰ� ����
		String max_name = null,min_name = null; // ��ġ�� ��� ����
		ResultSet rest = stmt.executeQuery("select pl_admin,pl_name,pl_lat,pl_lng from parking"); 
		// parking ���̺��� pl_admin,pl_name,pl_lat,pl_lng �޾ƿ´�.
		while(rest.next()){
			double dist = Math.sqrt(Math.pow((rest.getDouble(3) -lat),2) + 
					Math.pow((rest.getDouble(4)-lng), 2));
			if(max < dist){ // ���� ����Ǿ� �ִ� �ִ밪�� ���� ������ �۴ٸ�
				max = dist; // �� ��ü
				max_name = rest.getString(2); // �ε��� ��ü
			}
			if(min > dist){ // ���� ����Ǿ� �ִ� �ִ밪�� ���� ������ �۴ٸ�
				min = dist; // �� ��ü
				min_name = rest.getString(2); // �ε��� ��ü
			}
		}
		System.out.printf("����Ÿ� ������ %s %f \n�ִܰŸ� ������ %s %f",max_name,max,min_name,min);
		stmt.close();
		//br.close();
		con.close();
		
	}
}
