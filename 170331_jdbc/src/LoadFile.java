import java.io.*;
import java.sql.*;

public class LoadFile {
	Statement stmt2 = null;
	// 생성자
	LoadFile(Statement stmt){
		this.stmt2 = stmt;
	}
	public void FileCall() throws IOException, SQLException{
		int cnt = 0; String data = null;
		// file i/o
		FileInputStream fis = new FileInputStream
				("C:\\Users\\kopo\\Desktop\\gith\\170331_jdbc\\src\\와이파이.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));

		// label delete
		br.readLine();
		
		// file load 
		while( (data=br.readLine()) != null ){			
			String[] split = data.split("\t");
			String D_data;
			D_data = String.format("insert into wifi "
					+ "(place,detail,city,division_section,facilities,provider,"
					+ "wifiSSID,fityear,loadname,addressdata,management_agency,"
					+ "macall,latitude,longitude,reference_data) values ("+
			"'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%s,%s,'%s');", 
			split[0],split[1],split[2],split[3],split[4],split[5],split[6],split[7],
			split[8],split[9],split[10],split[11],split[12],split[13],split[14]);
			stmt2.execute(D_data);
			cnt++;
		}
		br.close();
		bis.close();
		fis.close();
	}
}
