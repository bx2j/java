/*
 * ���� �и� �� �����ؼ� ����
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

public class file5 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\���������������ǥ�ص�����2.txt"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о��
		
		File f1 = new File("C:\\1234\\���������������ǥ�ص�����2_skt.txt"); // ������ ���� ��ġ �̸� ����
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1)); // ���Ͽ� �� ��ü ����
		File f2 = new File("C:\\1234\\���������������ǥ�ص�����2_kt.txt"); // ������ ���� ��ġ �̸� ����
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2)); // ���Ͽ� �� ��ü ����
		File f3 = new File("C:\\1234\\���������������ǥ�ص�����2_lgu.txt"); // ������ ���� ��ġ �̸� ����
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3)); // ���Ͽ� �� ��ü ����
		File f4 = new File("C:\\1234\\���������������ǥ�ص�����2_�˼�����.txt"); // ������ ���� ��ġ �̸� ����
		BufferedWriter bw4 = new BufferedWriter(new FileWriter(f4)); // ���Ͽ� �� ��ü ����
		String new_readtxt = null; // ���� ������ ���ڿ� ����
		String readtxt; // �о�� ���ڿ� ����
		if((readtxt = br.readLine()) == null){ // ù���� �����̶��
			System.out.printf("�� ���� �Դϴ�.\n"); // ������
		}
		
		bw1.write(readtxt); // bw1 ���Ͽ� ù�� ����
		bw1.newLine(); // �ٹٲ�
		bw2.write(readtxt); // bw2 ���Ͽ� ù�� ����
		bw2.newLine(); // �ٹٲ�
		bw3.write(readtxt); // bw3 ���Ͽ� ù�� ����
		bw3.newLine(); // �ٹٲ�
		bw4.write(readtxt); // bw4 ���Ͽ� ù�� ����
		bw4.newLine(); // �ٹٲ�
		int sk = 0,lg=0,kt=0,etc=0; // �� ��Ż�� �˼������� ����
		int cnt = 0; // ��ü ����
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // ������ �и��� �����͸� field�迭�� ����
			if(field[5].trim().toUpperCase().contains("LG") || field[5].trim().contains("U+") || field[5].trim().contains("����")){
				// field[5] �翷�� ��������(trim) �� LG(��ҹ��� �������),U+,���� ��� �ܾ ���Եȴٸ� (contains)
				new_readtxt = readtxt.replace(field[5], "LGU+"); // ���ο� ���ڿ��� field[5]�� LGU+�� �ٲ� �����ϰ�
				bw3.write(new_readtxt); // ���ο� ���ڿ��� ���Ͽ� ����
				bw3.newLine(); // �ٹٲ�
				lg++; // lg���� ����
			}
			else if(field[5].trim().contains("KT") || field[5].trim().contains("����Ƽ")){
				// field[5] �翷�� ��������(trim) �� KT,����Ƽ ��� �ܾ ���Եȴٸ� (contains)
				new_readtxt = readtxt.replace(field[5], "KT");// ���ο� ���ڿ��� field[5]�� LGU+�� �ٲ� �����ϰ�
				bw2.write(new_readtxt); // ���ο� ���ڿ��� ���Ͽ� ����
				bw2.newLine(); // �ٹٲ�
				kt++; // KT���� ����
			}
			else if(field[5].trim().toUpperCase().contains("SK")){
				// field[5] �翷�� ��������(trim)�� ��,�ҹ��� ������� SK�� ���ٸ� (touppercase.contains)
				new_readtxt = readtxt.replace(field[5], "SKT"); // ���ο� ���ڿ��� field[5]�� SKT�� �ٲ� �����ϰ�
				bw1.write(new_readtxt); // ���ο� ���ڿ��� ���Ͽ� ����
				bw1.newLine(); // �ٹٲ�
				sk++; // SK���� ����
			}
			else{
				bw4.write(readtxt); // ���ο� ���ڿ��� ���Ͽ� ����
				bw4.newLine(); // �ٹٲ�
				etc++; // �˼������� ���� ����
			}
			cnt++; // ��ü ���� ����
		}
		System.out.printf("��ü �� [%d]�� = lg �� [%d]�� + "
				+ "kt �� [%d]�� + sk �� [%d]�� + ������ �� [%d]��",cnt,lg,kt,sk,etc);
		br.close(); // br ��ü ��ȯ
		bw1.close(); // bw1 ��ü ��ȯ
		bw2.close(); // bw2 ��ü ��ȯ
		bw3.close(); // bw3 ��ü ��ȯ
		bw4.close(); // bw4 ��ü ��ȯ
	}
}
