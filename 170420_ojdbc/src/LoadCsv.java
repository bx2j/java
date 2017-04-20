import java.io.*;
import java.sql.*;
import java.util.Date;
public class LoadCsv {
	Statement stmt2 = null;
	// ������
	LoadCsv(Statement stmt){
		this.stmt2 = stmt;
	}	
	public void FileCall() throws IOException, SQLException{
		FileOutputStream fos = new FileOutputStream("error.log",true);
		PrintStream ps = new PrintStream(fos);
		// �����ġ�� ������� ���ϰ� ���� ����� �����ִ� ��Ʈ�� Ŭ���� ex) print() / println()
		System.setErr(ps);
		// ǥ�� ���� ��� ��ġ, �Ϲ����� ��������� System.out, ������ System.err
		int cnt = 0; 
		String data = null;
		// file i/o
		FileInputStream fis = new FileInputStream
				("C:\\Users\\kopo\\Desktop\\01 �����ȣ ������ �ε�\\zipcode_20130201.csv");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		// label delete
		br.readLine();		
		// file load 
		try{
			while( (data=br.readLine()) != null ){					
				String[] split = data.split(",");
				String D_data;
				D_data = String.format("insert into ZIPCODE "
						+ "(ZIPCODE,SIDO,GUGUN,DONG,RI,BUNJI,SEQ)"
						+ "values ('%s','%s','%s','%s','%s','%s',%s)", 
				split[0],split[1],split[2],split[3],split[4],split[5],split[6]);
				stmt2.execute(D_data);
				cnt++;			
			}
		}catch(Exception e){
			System.out.println(e.toString());
			System.err.println("exception time : " + new Date());
			e.printStackTrace(System.err);
			System.err.println("message : "+ e.getMessage());				
		}
		br.close();
		bis.close();
		fis.close();
		fos.close();
	}
}


