/*
 * ���� �Ⱦ�� �� ���
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class file6 {
	public static void main(String[] args) throws IOException{
		File f = new File("\\\\192.168.23.161\\sw(����)\\������Ŭ���̾�Ʈ\\�ڹٺ���\\�ǽ�������\\day_data\\THTSKS010H00.dat");
		// ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f));
		// ���� �о�´�
		String rt; // �о�� ������ ���ڿ� ���� ����
		
		int n = -1; // ���ϳ��� �˷��ִ� ���� ����
		StringBuffer sb = new StringBuffer(); // StringBuffer ��ü ����
		
		while (true) { // ���� �ݺ�
			char[] ch = new char[1000]; // char ch�迭�� 100�� ����� ������.
			n = br.read(ch); // char���� chũ�⸸ŭ�� ���ڼ��� n�� ���� 
			if(n==-1) // -1�� ������
				break; // ���� Ż��
			for(char c : ch){
				if ( c=='\n'){ // ���� c�� �ٹٲ� ���ڸ� ������
					System.out.printf("[%s]***\n",sb.toString()); // String������ ���
					sb.delete(0, sb.length()); // 0���� stringbuffer ���̱��� ����
				}
				else
					sb.append(c); // �ƴ϶�� c �߰�
			}
			
		}
		System.out.printf("[%s]***\n",sb.toString());
		br.close();
	}
}
