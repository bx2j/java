/*
 * 파일 훑어보고 감 잡기
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class file6 {
	public static void main(String[] args) throws IOException{
		File f = new File("\\\\192.168.23.161\\sw(교안)\\웹서버클라이언트\\자바복습\\실습데이터\\day_data\\THTSKS010H00.dat");
		// 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 파일 읽어온다
		String rt; // 읽어온 파일의 문자열 저장 변수
		
		int n = -1; // 파일끝을 알려주는 변수 선언
		StringBuffer sb = new StringBuffer(); // StringBuffer 객체 생성
		
		while (true) { // 무한 반복
			char[] ch = new char[1000]; // char ch배열은 100의 사이즈를 가진다.
			n = br.read(ch); // char형인 ch크기만큼의 문자수를 n에 저장 
			if(n==-1) // -1을 만나면
				break; // 루프 탈출
			for(char c : ch){
				if ( c=='\n'){ // 문자 c가 줄바꿈 문자를 만나면
					System.out.printf("[%s]***\n",sb.toString()); // String형으로 출력
					sb.delete(0, sb.length()); // 0에서 stringbuffer 길이까지 삭제
				}
				else
					sb.append(c); // 아니라면 c 추가
			}
			
		}
		System.out.printf("[%s]***\n",sb.toString());
		br.close();
	}
}
