/*
 * 실제 파일에 응용
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class file3 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국무료와이파이표준데이터.csv"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어옴
		
		String readtxt; // 읽어온 파일내용 저장을 위한 문자열 변수

		if((readtxt = br.readLine()) == null) // 첫줄이 null이면 ( 공백이면
			System.out.printf("빈 파일입니다\n"); // 내용업슨ㄴ 파일

		String[] field_name = readtxt.split(","); // 첫 줄은 필드명으로 먼저 읽어야 함
		
		int cnt = 0; // 항목번호 변수
		while((readtxt = br.readLine()) != null){ // 내용이 존재한다면
			String[] field = readtxt.split(","); // 읽어온 데이터 쉼표로 구분하여 field배열에 넣는다. 
			System.out.printf("[%d]번째 항목\n",cnt);
			for(int j = 0;j<field_name.length;j++){ // 총 필드명의 개수만큼반복
				System.out.printf("%s : %s \n",field_name[j],field[j]); // 필드명과 필드 내용출력
			}			
			System.out.printf("***************************\n");	
			cnt++; 
		}
		br.close();
	}
}

