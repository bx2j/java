/*
 * ArrayList 와 HashSet을 이용한 중복제거(distinct)
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class file5_1 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국무료와이파이표준데이터2.txt"); // 지정위치의 file에 대한 File 객체 생성
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일을 읽어온다
		
		String readtxt;
		
		ArrayList<String> al = new ArrayList<String>(); // ArrayList 객체 al 생성
		
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // 파일을 탭으로 구분하여 한줄 씩 읽어와 String field배열에 저장한다.  
			al.add(field[5]); // 5번 필드의 내용 (서비스제공사명) ArrayList al 에 추가
		}
		HashSet<String> hs = new HashSet<String>(al); // HashSet 을 이용해 ArrayList al 의 중복 제거
		ArrayList<String> nal = new ArrayList<String>(hs); // 중복 제거된 al을 담고있는 HashSet hs 를 다시 ArrayList 객체로 생성
		
		Collections.sort(nal); // 오름차순 정렬 후
		Collections.reverse(nal); // 내림차순 정렬
		for(int i=0;i<nal.size();i++) // nal 의 크기만큼 반복
			System.out.println(nal.get(i)); // nal의 내용 출력
	}
}


