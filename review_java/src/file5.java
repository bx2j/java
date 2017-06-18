/*
 * 파일 분리 및 수정해서 저장
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

public class file5 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국무료와이파이표준데이터2.txt"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어옴
		
		File f1 = new File("C:\\1234\\전국무료와이파이표준데이터2_skt.txt"); // 생성할 파일 위치 이름 지정
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); // 파일에 쓸 객체 생성
		File f2 = new File("C:\\1234\\전국무료와이파이표준데이터2_kt.txt"); // 생성할 파일 위치 이름 지정
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2)); // 파일에 쓸 객체 생성
		File f3 = new File("C:\\1234\\전국무료와이파이표준데이터2_lgu.txt"); // 생성할 파일 위치 이름 지정
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3)); // 파일에 쓸 객체 생성
		File f4 = new File("C:\\1234\\전국무료와이파이표준데이터2_알수없음.txt"); // 생성할 파일 위치 이름 지정
		BufferedWriter bw4 = new BufferedWriter(new FileWriter(f4)); // 파일에 쓸 객체 생성
		String new_readtxt = null; // 새로 수정한 문자열 저장
		String readtxt; // 읽어온 문자열 저장
		if((readtxt = br.readLine()) == null){ // 첫줄이 공백이라면
			System.out.printf("빈 파일 입니다.\n"); // 빈파일
		}
		
		bw1.write(readtxt); // bw1 파일에 첫줄 저장
		bw1.newLine(); // 줄바꿈
		bw2.write(readtxt); // bw2 파일에 첫줄 저장
		bw2.newLine(); // 줄바꿈
		bw3.write(readtxt); // bw3 파일에 첫줄 저장
		bw3.newLine(); // 줄바꿈
		bw4.write(readtxt); // bw4 파일에 첫줄 저장
		bw4.newLine(); // 줄바꿈
		int sk = 0,lg=0,kt=0,etc=0; // 각 통신사와 알수없음의 개수
		int cnt = 0; // 전체 개수
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // 탭으로 분리된 데이터를 field배열에 저장
			if(field[5].trim().toUpperCase().contains("LG") || field[5].trim().contains("U+") || field[5].trim().contains("엘지")){
				// field[5] 양옆의 공백제거(trim) 후 LG(대소문자 상관없이),U+,엘지 라는 단어가 포함된다면 (contains)
				new_readtxt = readtxt.replace(field[5], "LGU+"); // 새로운 문자열에 field[5]를 LGU+로 바꿔 저장하고
				bw3.write(new_readtxt); // 새로운 문자열을 파일에 쓴다
				bw3.newLine(); // 줄바꿈
				lg++; // lg개수 증가
			}
			else if(field[5].trim().contains("KT") || field[5].trim().contains("케이티")){
				// field[5] 양옆의 공백제거(trim) 후 KT,케이티 라는 단어가 포함된다면 (contains)
				new_readtxt = readtxt.replace(field[5], "KT");// 새로운 문자열에 field[5]를 LGU+로 바꿔 저장하고
				bw2.write(new_readtxt); // 새로운 문자열을 파일에 쓴다
				bw2.newLine(); // 줄바꿈
				kt++; // KT개수 증가
			}
			else if(field[5].trim().toUpperCase().contains("SK")){
				// field[5] 양옆의 공백제거(trim)후 대,소문자 상관없이 SK가 들어간다면 (touppercase.contains)
				new_readtxt = readtxt.replace(field[5], "SKT"); // 새로운 문자열에 field[5]를 SKT로 바꿔 저장하고
				bw1.write(new_readtxt); // 새로운 문자열을 파일에 쓴다
				bw1.newLine(); // 줄바꿈
				sk++; // SK개수 증가
			}
			else{
				bw4.write(readtxt); // 새로운 문자열을 파일에 쓴다
				bw4.newLine(); // 줄바꿈
				etc++; // 알수없음의 개수 증가
			}
			cnt++; // 전체 개수 증가
		}
		System.out.printf("전체 수 [%d]개 = lg 수 [%d]개 + "
				+ "kt 수 [%d]개 + sk 수 [%d]개 + 나머지 수 [%d]개",cnt,lg,kt,sk,etc);
		br.close(); // br 객체 반환
		bw1.close(); // bw1 객체 반환
		bw2.close(); // bw2 객체 반환
		bw3.close(); // bw3 객체 반환
		bw4.close(); // bw4 객체 반환
	}
}
