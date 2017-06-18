/*
 * �Ｚ���� (�����ڵ� A005930) �����Ͽ� A005930.csv���� ����
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file8 {
	public static void main(String[] args) throws IOException{
		
		File f = new File("\\\\192.168.23.161\\sw(����)\\������Ŭ���̾�Ʈ\\�ڹٺ���\\�ǽ�������\\day_data\\THTSKS010H00.dat");
		// ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f));
		// ���� �о����
		File f1 = new File("C:\\1234\\A005930.csv"); // ���ο� ���� �̸� �� ��ġ
		BufferedWriter bw = new BufferedWriter(new FileWriter(f1)); // ���Ͽ� ����
		
		String rt; // ���Ͽ��� �о�� ���ڿ� ���� ����
		int cnt=0,wcnt=0; // ������ ó�� ����
		long st = System.currentTimeMillis();  // ���۽ð�����
		while((rt=br.readLine()) != null){ // 
			StringBuffer sb = new StringBuffer(); // Stringbuffer ��ü ����
			String[] field = rt.split("%_%"); // %_% �� �����ڷ� �Ͽ� �и��ؼ� field �迭�� ����
			
			if(field.length > 2 && field[2].replace("^", "").trim().substring(0, 7).equals("A005930")){
				// field���̰� 2�̰ų� field[2]�� ^�� ���� ����, 0~7��° ���ڿ��� A005930 �� ���
				sb.append(field[0].replace("^", "").trim()); // field[0]�� ^�� ���������� �߰�
				for(int j=1;j<field.length;j++){
					sb.append(","+field[j].replace("^", "").trim()); // field[j]�� ^���� �� ���� ���� �� �߰�
				}
				bw.write(sb.toString()); // bw��ü�� Stringbuffer ��ü�� string�� ����
				bw.newLine(); // �ٹٲ�
				wcnt++; // �ǹ��ִ� ������ ó�� ī��Ʈ
			}			
			cnt++; // ��ü ī��Ʈ
		}
		long et = System.currentTimeMillis(); // ����ð� ����
		System.out.printf("process time : [%d]sec\n",(et-st)/1000); // �� �ɸ� �ð� ����
		br.close(); // br ��ü ��ȯ
		bw.close(); // bw ��ü ��ȯ
		System.out.printf("program ent [%d][%d]records \n",cnt,wcnt);
	}
}
