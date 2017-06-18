/*
 * 파일 다루기
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class File1 {
	public static void main(String args[]){
		try{
			File f = new File("C:\\1234\\mytest.txt");
			// test.txt 파일 위치 지정
			FileWriter fw = new FileWriter(f); // File 객체를 이용해 FileWriter 객체 생성
			
			fw.write("하이 파일\n"); // fw객체에 문자열 쓴다
			fw.write("hello g헬로"); // fw객체에 문자열 쓴다
			 
			fw.close(); // fw객체 반환
			
			FileReader fr = new FileReader(f); // fr객체로 File f를 읽어온다.
			
			int n = -1; // 중지시점 값 선언
			char[] ch; // char 배열 ch 선언
			
			while (true){ // while 무한루프
				ch = new char[100]; // char ch배열은 100의 사이즈를 가진다.
				n = fr.read(ch); // char형인 ch크기만큼의 문자수를 n에 저장 
				if ( n == -1)
					break;
				for ( int i=0 ; i<n;i++) // 문자수 크기만큼 반복
					System.out.printf("%c",ch[i]); // 파일의 내용 출력
			}
			
			fr.close(); // fr 객체 반환
			System.out.printf("\nfile read end");
		}catch(Exception e){
			System.out.printf("에러 [%s]",e); //에러났을 경우 표시해줌
		}
	}
}
