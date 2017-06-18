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
		File f = new File("C:\\1234\\���������������ǥ�ص�����2.txt"); // ������ġ�� file�� ���� File ��ü ����
		BufferedReader br = new BufferedReader(new FileReader(f)); // ������ �о�´�
		
		File f1 = new File("C:\\1234\\���������������ǥ�ص�����2_skt.txt"); // ������ġ�� file�� ���� File ��ü ����
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); // ������ ���Ͽ� ������ �� ��ü ����
		File f2 = new File("C:\\1234\\���������������ǥ�ص�����2_kt.txt"); // ������ġ�� file�� ���� File ��ü ����
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2)); // ������ ���Ͽ� ������ �� ��ü ����
		File f3 = new File("C:\\1234\\���������������ǥ�ص�����2_lgu.txt"); // ������ġ�� file�� ���� File ��ü ����
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3)); // ������ ���Ͽ� ������ �� ��ü ����
		String readtxt,nreadtxt;
		if((readtxt = br.readLine()) == null){ // �о�� ���� ������
			System.out.printf("�� ���� �Դϴ�.\n"); // ���� ������ ���ٴ� ���̹Ƿ� �������Դϴ� ���
		}
		
		bw1.write(readtxt); //bufferedwriter1 ��ü�� ù ��(���)�� �����Ѵ� 
		bw1.newLine(); // ���ο� �� ����
		bw2.write(readtxt); //bufferedwriter2 ��ü�� ù ��(���)�� �����Ѵ�
		bw2.newLine(); // ���ο� �� ����
		bw3.write(readtxt); //bufferedwriter3 ��ü�� ù ��(���)�� �����Ѵ�
		bw3.newLine(); // ���ο� �� ����
		
		ArrayList al = new ArrayList(); // ArrayList ��ü al ����
		int i =0;
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // ������ ������ �����Ͽ� ���� �� �о�� String field�迭�� �����Ѵ�.  
			al.add(field[5]); // 5�� �ʵ��� ���� (�����������) ArrayList al �� �߰�
			if(		((String) al.get(i)).trim().toUpperCase().startsWith("L") || ((String) al.get(i)).trim().toUpperCase().startsWith("U")  
					 ||		((String) al.get(i)).trim().toUpperCase().startsWith("\"L") || ((String) al.get(i)).trim().toUpperCase().startsWith("\"\"\"L")
					 || 	((String) al.get(i)).trim().toUpperCase().startsWith("\"\"L")){
						System.out.println("���ڸ��� L �Ǵ� U�� : " + al.get(i) + " -> " + ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+"));
						nreadtxt = (String) ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+");
						bw3.write(readtxt);
						bw3.write(nreadtxt);
						bw3.newLine();
				}
			i++;
		}
		/*HashSet hs = new HashSet(al); // HashSet �� �̿��� ArrayList al �� �ߺ� ����
		ArrayList<String> nal = new ArrayList<String>(hs); // �ߺ� ���ŵ� al�� ����ִ� HashSet hs �� �ٽ� ArrayList ��ü�� ����
		
		System.out.println(nal.size()); // ArrayList nal �� ũ�� ���
		Collections.sort(nal); // �������� ���� ��
		Collections.reverse(nal); // �������� ����
		for(int i=0;i<nal.size();i++) { // nal �� ũ�⸸ŭ �ݺ�
			System.out.println(nal.get(i));
			if( nal.get(i).trim().toUpperCase().startsWith("L") || nal.get(i).trim().toUpperCase().startsWith("U") || 
					 nal.get(i).trim().toUpperCase().startsWith("\"L") || nal.get(i).trim().toUpperCase().startsWith("\"\"\"L")){
				System.out.println("���ڸ��� L �Ǵ� U�� : " + nal.get(i) + " -> " + nal.get(i).replace(nal.get(i), "LGU+"));
				System.out.println();
			}
		}*/
		
		/*for(int i=0;i<al.size();i++) { // al �� ũ�⸸ŭ �ݺ�		
			if(		((String) al.get(i)).trim().toUpperCase().startsWith("L") || ((String) al.get(i)).trim().toUpperCase().startsWith("U")  
			 ||		((String) al.get(i)).trim().toUpperCase().startsWith("\"L") || ((String) al.get(i)).trim().toUpperCase().startsWith("\"\"\"L")
			 || 	((String) al.get(i)).trim().toUpperCase().startsWith("\"\"L")){
				System.out.println("���ڸ��� L �Ǵ� U�� : " + al.get(i) + " -> " + ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+"));
				nreadtxt = (String) ((String) al.get(i)).replace((CharSequence) al.get(i), "LGU+");
				bw3.write(nreadtxt);
				bw3.newLine();
			}				
		}*/
		System.out.println("�Ϸ�");
		
		
		
		br.close();  // bufferedreader ��ü ��ȯ
		bw1.close(); //bufferedwriter1 ��ü ��ȯ
		bw2.close(); //bufferedwriter2 ��ü ��ȯ
		bw3.close(); //bufferedwriter3 ��ü ��ȯ		
	}
}
