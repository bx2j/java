/*
 * Basic Training1 - parking테이블에 값 넣기 및 최단거리, 최장거리 조회 
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성 
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
		Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		// jdbc:mysql://localhost/dbname , dbuser, dbpassword
		Statement stmt = con.createStatement();
		
		/*int cnt = 1;
		File f = new File("C:\\1234\\전국주차장표준데이터.txt"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어오기
		String readtxt; // 파일에서 읽어온 문자열 저장하는 변수
		if((readtxt = br.readLine()) == null) // 문자열이 없다면
			System.out.printf("빈 파일입니다\n"); // 빈 파일
		String[] field_name = readtxt.split("\t"); // 탭으로 구분하여 읽어온 문자열 저장
		
		while((readtxt = br.readLine())!=null){
			String[] field = readtxt.split("\t");			
			if(field.length < 33){ // 탭으로 저장된 배열의 길이가 33이하라면
				// 위,경도값이 없는 필드들
				stmt.execute("insert into parking values(" + cnt + ","
						+ "'" + field[0] + "','" + field[1] + "','" + field[2] + "','" + field[3] + "','" + 
						field[4] + "','" + field[5] + "','" + field[6] + "','" + field[7]
						+ "','" + field[9] + "'," + null + "," + null + ")");
				// 위도와 경도가 공백이면 null 삽입
			}
			else{
				if( !(field[31].equals("")) && !(field[32].equals("")) ){
					stmt.execute("insert into parking values(" + cnt + ","
						+ "'" + field[0] + "','" + field[1] + "','" + field[2] + "','" + field[3] + "','" + 
							field[4] + "','" + field[5] + "','" + field[6] + "','" + field[7]
						+"','" + field[9] + "'," + field[31] + "," + field[32] + ")");
					// 위도와 경도가 공백이 아닌 내용들 출력
				}
			}
			cnt++;
		}*/		
		// 35.518215, 129.425293 우리집
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		// 현재 위치 (융합기술교육원)
		double lat = 37.385842;
		double lng = 127.121274;
		double max = 0,min=100000; // 최대값, 최소값 지정
		String max_name = null,min_name = null; // 위치명 출력 변수
		ResultSet rest = stmt.executeQuery("select pl_admin,pl_name,pl_lat,pl_lng from parking"); 
		// parking 테이블에서 pl_admin,pl_name,pl_lat,pl_lng 받아온다.
		while(rest.next()){
			double dist = Math.sqrt(Math.pow((rest.getDouble(3) -lat),2) + 
					Math.pow((rest.getDouble(4)-lng), 2));
			if(max < dist){ // 현재 저장되어 있는 최대값이 다음 값보다 작다면
				max = dist; // 값 교체
				max_name = rest.getString(2); // 인덱스 교체
			}
			if(min > dist){ // 현재 저장되어 있는 최대값이 다음 값보다 작다면
				min = dist; // 값 교체
				min_name = rest.getString(2); // 인덱스 교체
			}
		}
		System.out.printf("최장거리 주차장 %s %f \n최단거리 주차장 %s %f",max_name,max,min_name,min);
		stmt.close();
		//br.close();
		con.close();
		
	}
}
