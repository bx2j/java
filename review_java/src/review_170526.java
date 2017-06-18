import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class review_170526 {
	public static void main(String args[]) throws Exception{
		// 
		FileWriter fw = new FileWriter("c:\\1234\\123.txt",true);
		// 텍스트파일열때 사용
		
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(!(str = br.readLine()).startsWith("s"));
		sb.append(str+"\n");
		br.close();
		fw.write((sb.toString()));
		fw.flush();
		fw.close();
		System.out.println("저장이 완료");
		
	}
}
