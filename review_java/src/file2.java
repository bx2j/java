/*
 * Buffered 읽고 쓰기
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

public class file2 {
	public static void FileWrite() throws IOException{ // 파일 생성 및 파일에 쓰기
		File f = new File("C:\\1234\\mytest.txt"); // mytest.txt 파일 생성
		BufferedWriter bw = new BufferedWriter( new FileWriter(f)); // BufferedWriter 객체 bw생성
		
		bw.write("하이 파일\n"); // 파일에 문자열 쓰기
		bw.newLine(); // 한줄 단위로 읽어들인다.
		bw.write("helo g헬로");
		bw.newLine();
		bw.close(); // bw객체 반환

	}
	public static void FileRead() throws IOException{ // 파일 열기 및 읽기
		File f = new File("C:\\1234\\mytest.txt"); // mytest.txt 파일 확인
		BufferedReader br = new BufferedReader( new FileReader(f)); // bufferedreader객체로 파일을 읽음
		
		String readtxt; // 읽어온 문자열 저장하기 위한 변수
		while ((readtxt = br.readLine()) != null) // 읽어온 문자열의 한 줄이 공백이 아니라면(내용이 있으면)
			System.out.printf("%s\n",readtxt); // 한 줄씩 출력
		br.close(); // br객체 반환
	}
	
	public static void main(String args[]) throws IOException{
		FileWrite(); // filewrite호출
		FileRead();	 // fileread 호출
		
	}
}

