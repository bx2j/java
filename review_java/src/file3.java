/*
 * ���� ���Ͽ� ����
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class file3 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\���������������ǥ�ص�����.csv"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о��
		
		String readtxt; // �о�� ���ϳ��� ������ ���� ���ڿ� ����

		if((readtxt = br.readLine()) == null) // ù���� null�̸� ( �����̸�
			System.out.printf("�� �����Դϴ�\n"); // ��������� ����

		String[] field_name = readtxt.split(","); // ù ���� �ʵ������ ���� �о�� ��
		
		int cnt = 0; // �׸��ȣ ����
		while((readtxt = br.readLine()) != null){ // ������ �����Ѵٸ�
			String[] field = readtxt.split(","); // �о�� ������ ��ǥ�� �����Ͽ� field�迭�� �ִ´�. 
			System.out.printf("[%d]��° �׸�\n",cnt);
			for(int j = 0;j<field_name.length;j++){ // �� �ʵ���� ������ŭ�ݺ�
				System.out.printf("%s : %s \n",field_name[j],field[j]); // �ʵ��� �ʵ� �������
			}			
			System.out.printf("***************************\n");	
			cnt++; 
		}
		br.close();
	}
}

