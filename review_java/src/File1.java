/*
 * ���� �ٷ��
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class File1 {
	public static void main(String args[]){
		try{
			File f = new File("C:\\1234\\mytest.txt");
			// test.txt ���� ��ġ ����
			FileWriter fw = new FileWriter(f); // File ��ü�� �̿��� FileWriter ��ü ����
			
			fw.write("���� ����\n"); // fw��ü�� ���ڿ� ����
			fw.write("hello g���"); // fw��ü�� ���ڿ� ����
			 
			fw.close(); // fw��ü ��ȯ
			
			FileReader fr = new FileReader(f); // fr��ü�� File f�� �о�´�.
			
			int n = -1; // �������� �� ����
			char[] ch; // char �迭 ch ����
			
			while (true){ // while ���ѷ���
				ch = new char[100]; // char ch�迭�� 100�� ����� ������.
				n = fr.read(ch); // char���� chũ�⸸ŭ�� ���ڼ��� n�� ���� 
				if ( n == -1)
					break;
				for ( int i=0 ; i<n;i++) // ���ڼ� ũ�⸸ŭ �ݺ�
					System.out.printf("%c",ch[i]); // ������ ���� ���
			}
			
			fr.close(); // fr ��ü ��ȯ
			System.out.printf("\nfile read end");
		}catch(Exception e){
			System.out.printf("���� [%s]",e); //�������� ��� ǥ������
		}
	}
}
