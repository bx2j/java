import java.io.*;
import java.sql.*;

public class WifiData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		int cnt=0;
		String data = null;
				
		// DB Loading
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:33066/ex2?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		Statement stmt = con.createStatement();
		
		// file i/o
		FileInputStream fis = new FileInputStream("C:\\Users\\kopo\\Desktop\\와이파이.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));

		// label delete
		br.readLine();
		
		// file load & 
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
			stmt.execute(D_data);
			cnt++;
		}
		// find nearby particular latitude & longitude 
		String str ;
		double lat = 37.3860521 , lng = 127.1214038;
		str = String.format("select * from wifi where SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2))="
				+ "(select MIN(SQRT(POWER (latitude-%f,2) + POWER(longitude-%f,2))) from wifi);", lat,lng,lat,lng);
		ResultSet rest = stmt.executeQuery(str);
		while(rest.next()){
			// result print
			System.out.println(
					rest.getString(1) +"\t" + rest.getString(2) +"\t" + rest.getString(3)
			+ "\t" + rest.getString(4) + "\t" + rest.getString(5) + "\t" + rest.getString(6)
			+ "\t" + rest.getString(7) + "\t" + rest.getString(8) + "\t" + rest.getString(9)
			+ "\t" + rest.getString(10) + "\t" + rest.getString(11) + "\t" + rest.getString(12)
			+ "\t" + rest.getString(13) + "\t" + rest.getString(14) + "\t" + rest.getString(15));
		}
		br.close();
		bis.close();
		fis.close();
		stmt.close();
	}
}
