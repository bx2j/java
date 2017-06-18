/*
 * 파일 정제
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file7 {
	public static void main(String[] args) throws IOException{
		File f = new File("\\\\192.168.23.161\\sw(교안)\\웹서버클라이언트\\자바복습\\실습데이터\\day_data\\THTSKS010H00.dat");
		//파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 파일 읽어오기
		File f1 = new File("C:\\1234\\StockDailyPrice.csv");
		// 새로운 파일 생성 및 위치 지정
		BufferedWriter bw = new BufferedWriter(new FileWriter(f1)); // 파일에 쓰기
		
		String rt; // 파일에서 읽어온 문자열 저장 변수
		int cnt=0,wcnt=0; // 데이터 처리 변수
		long st = System.currentTimeMillis();  // 시작시간측정
		while((rt=br.readLine()) != null){
			StringBuffer sb = new StringBuffer(); // Stringbuffer 객체 생성
			String[] field = rt.split("%_%"); // 정제 하지 않는곳에 ^%_%^있는데 %_%를 구분자로 사용해서 field에 저장
			
			if(field.length > 2 && field[2].replace("^", "").trim().substring(0, 1).equals("A")){
				// field길이가 2거나 단축코드(field[2])의 ^를 제거하고 공백제거하고 0~1까지의 범위가 A라면
				sb.append(field[0].replace("^", "").trim()); // field[0]의 ^과 공백제거한 것을 추가한다.
				for(int j=1;j<field.length;j++){
					sb.append(","+field[j].replace("^", "").trim()); // field의 ^를 제거하고 공백제거하여 추가한다
				}
				bw.write(sb.toString()); // stringbuffer의 내용을 string변환후 추가
				bw.newLine(); // 줄바꿈
				wcnt++; // 의미있는 데이터 처리한 카운트
			}
			cnt++; // 전체 반복횟수 카운트
		}
		long et = System.currentTimeMillis(); // 종료시간 측정
		System.out.printf("process time : [%d]sec\n",(et-st)/1000); // 총 걸린 시간 측정
		br.close(); // br 객체 반환
		bw.close(); // bw 객체 반환
		System.out.printf("program ent [%d][%d]records \n",cnt,wcnt);
	}
}
