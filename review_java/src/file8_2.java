/*
 * 특정일자의 종목 추출하여 csv파일 생성
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file8_2 {
	public static void main(String[] args) throws IOException{
		File f = new File("\\\\192.168.23.161\\sw(교안)\\웹서버클라이언트\\자바복습\\실습데이터\\day_data\\THTSKS010H00.dat");
		//파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 파일 읽어오기
		
		File f1 = new File("C:\\1234\\date.csv"); // 파일 위치 및 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(f1)); // 파일에 쓰기
		
		String rt; // 파일에서 읽어온 문자열 저장 변수
		int cnt=0,wcnt=0; // 데이터 처리 변수
		long st = System.currentTimeMillis(); // 시작시간 측정
		while((rt=br.readLine()) != null){
			StringBuffer sb = new StringBuffer(); // Stringbuffer 객체 생성
			String[] field = rt.split("%_%"); // %_% 를 구분자로 하여 분리해서 field 배열에 저장
			
			if(field.length > 2 && field[2].replace("^","").trim().substring(0, 1).equals("A") 
					&& field[1].replace("^","").trim().equals("20150112") ){
				// field길이가 2이거나 field[2]의 ^와 공백 제거, 0~1번째 문자열이 A인 경우 그리고 field[1]의 ^와 공백제거 후 20150112 인 경우에
				sb.append(field[0].replace("^", "").trim()); // field[0]의 ^와 공백제거후 추가
				for(int j=1;j<field.length;j++){
					sb.append(","+field[j].replace("^", "").trim()); // field[j]의 ^제거 및 공백 제거 후 추가
				}
				bw.write(sb.toString()); // stringbuffer의 내용을 string변환후 추가
				bw.newLine(); // 줄바꿈
				wcnt++; // 의미있는 데이터 처리한 카운트
			}
			cnt++; // 전체 반복횟수 카운트
		}
		long et = System.currentTimeMillis(); // 종료시간 측정
		System.out.printf("process time : [%d]sec\n",(et-st)/1000);// 총 걸린 시간 측정
		br.close(); // br 객체 반환
		bw.close(); // bw 객체 반환
		System.out.printf("program ent [%d][%d]records \n",cnt,wcnt);
	}
}
