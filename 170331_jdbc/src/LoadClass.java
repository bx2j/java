import java.sql.*;

public class LoadClass {
	Statement stmt1 = null;
	// 생성자
	LoadClass(Statement stmt){
		this.stmt1 = stmt;
	}
	public void call() throws SQLException{
		// find nearby particular latitude & longitude 
		String str ;
		double lat = 37.3860521 , lng = 127.1214038;
		/*str = String.format("select * from wifi where SQRT(POWER(latitude-%f,2) + POWER(longitude-%f,2))="
				+ "(select MIN(SQRT(POWER (latitude-%f,2) + POWER(longitude-%f,2))) from wifi);", lat,lng,lat,lng);*/
		
		// 현재 위치와 지정 위치 거리 비교
		str = "select addressdata,latitude,longitude, (6371 * acos(cos(radians(" + lat + ")) * cos(radians(latitude)) * cos(radians(longitude) - "
				+ "radians(" + lng + ")) + sin(radians(" + lat + ")) * sin(radians(latitude)))) AS distance from wifi "
				+ "having distance <= 35 order by distance;";
		ResultSet rest = stmt1.executeQuery(str);
		while(rest.next()){
			// result print
			/*System.out.println(
					rest.getString(1) +"\t" + rest.getString(2) +"\t" + rest.getString(3)
			+ "\t" + rest.getString(4) + "\t" + rest.getString(5) + "\t" + rest.getString(6)
			+ "\t" + rest.getString(7) + "\t" + rest.getString(8) + "\t" + rest.getString(9)
			+ "\t" + rest.getString(10) + "\t" + rest.getString(11) + "\t" + rest.getString(12)
			+ "\t" + rest.getString(13) + "\t" + rest.getString(14) + "\t" + rest.getString(15));*/
			System.out.println(rest.getString(1) + "\t\t" + rest.getString(2) + "\t" + rest.getString(3) + "\t" + rest.getString(4));
		}
	}
}
