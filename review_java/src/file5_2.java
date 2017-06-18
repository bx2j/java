import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class file5_2 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국무료와이파이표준데이터2.txt"); // 지정위치의 file에 대한 File 객체 생성
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일을 읽어온다
		
		File f1 = new File("C:\\1234\\전국무료와이파이표준데이터2_skt.txt"); // 지정위치의 file에 대한 File 객체 생성
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); // 생성된 파일에 내용을 쓸 객체 생성
		File f2 = new File("C:\\1234\\전국무료와이파이표준데이터2_kt.txt"); // 지정위치의 file에 대한 File 객체 생성
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2)); // 생성된 파일에 내용을 쓸 객체 생성
		File f3 = new File("C:\\1234\\전국무료와이파이표준데이터2_lgu.txt"); // 지정위치의 file에 대한 File 객체 생성
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3)); // 생성된 파일에 내용을 쓸 객체 생성
		String readtxt,nreadtxt;
		if((readtxt = br.readLine()) == null){ // 읽어올 줄이 없으면
			System.out.printf("빈 파일 입니다.\n"); // 파일 내용이 없다는 것이므로 빈파일입니다 출력
		}
		
		bw1.write(readtxt); //bufferedwriter1 객체에 첫 줄(헤더)를 저장한다 
		bw1.newLine(); // 새로운 줄 생성
		bw2.write(readtxt); //bufferedwriter2 객체에 첫 줄(헤더)를 저장한다
		bw2.newLine(); // 새로운 줄 생성
		bw3.write(readtxt); //bufferedwriter3 객체에 첫 줄(헤더)를 저장한다
		bw3.newLine(); // 새로운 줄 생성
		
		ArrayList al = new ArrayList(); // ArrayList 객체 al 생성
		int i =0;
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // 파일을 탭으로 구분하여 한줄 씩 읽어와 String field배열에 저장한다.  
			al.add(field[5]); // 5번 필드의 내용 (서비스제공사명) ArrayList al 에 추가
			if(		((String) al.get(i)).trim().toUpperCase().startsWith("L") || ((String) al.get(i)).trim().toUpperCase().startsWith("U")  
					 ||		((String) al.get(i)).trim().toUpperCase().startsWith("\"L") || ((String) al.get(i)).trim().toUpperCase().startsWith("\"\"\"L")
					 || 	((String) al.get(i)).trim().toUpperCase().startsWith("\"\"L")){
						System.out.println("앞자리가 L 또는 U임 : " + al.get(i) + " -> " + ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+"));
						nreadtxt = (String) ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+");
						bw3.write(readtxt);
						bw3.write(nreadtxt);
						bw3.newLine();
				}
			i++;
		}
		/*HashSet hs = new HashSet(al); // HashSet 을 이용해 ArrayList al 의 중복 제거
		ArrayList<String> nal = new ArrayList<String>(hs); // 중복 제거된 al을 담고있는 HashSet hs 를 다시 ArrayList 객체로 생성
		
		System.out.println(nal.size()); // ArrayList nal 의 크기 출력
		Collections.sort(nal); // 오름차순 정렬 후
		Collections.reverse(nal); // 내림차순 정렬
		for(int i=0;i<nal.size();i++) { // nal 의 크기만큼 반복
			System.out.println(nal.get(i));
			if( nal.get(i).trim().toUpperCase().startsWith("L") || nal.get(i).trim().toUpperCase().startsWith("U") || 
					 nal.get(i).trim().toUpperCase().startsWith("\"L") || nal.get(i).trim().toUpperCase().startsWith("\"\"\"L")){
				System.out.println("앞자리가 L 또는 U임 : " + nal.get(i) + " -> " + nal.get(i).replace(nal.get(i), "LGU+"));
				System.out.println();
			}
		}*/
		
		/*for(int i=0;i<al.size();i++) { // al 의 크기만큼 반복		
			if(		((String) al.get(i)).trim().toUpperCase().startsWith("L") || ((String) al.get(i)).trim().toUpperCase().startsWith("U")  
			 ||		((String) al.get(i)).trim().toUpperCase().startsWith("\"L") || ((String) al.get(i)).trim().toUpperCase().startsWith("\"\"\"L")
			 || 	((String) al.get(i)).trim().toUpperCase().startsWith("\"\"L")){
				System.out.println("앞자리가 L 또는 U임 : " + al.get(i) + " -> " + ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+"));
				nreadtxt = (String) ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+");
				bw3.write(nreadtxt);
				bw3.newLine();
			}				
		}*/
		System.out.println("완료");
		
		
		
		br.close();  // bufferedreader 객체 반환
		bw1.close(); //bufferedwriter1 객체 반환
		bw2.close(); //bufferedwriter2 객체 반환
		bw3.close(); //bufferedwriter3 객체 반환		
	}
}
