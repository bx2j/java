/*
 * Buffered �а� ����
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

public class file2 {
	public static void FileWrite() throws IOException{ // ���� ���� �� ���Ͽ� ����
		File f = new File("C:\\1234\\mytest.txt"); // mytest.txt ���� ����
		BufferedWriter bw = new BufferedWriter( new FileWriter(f)); // BufferedWriter ��ü bw����
		
		bw.write("���� ����\n"); // ���Ͽ� ���ڿ� ����
		bw.newLine(); // ���� ������ �о���δ�.
		bw.write("helo g���");
		bw.newLine();
		bw.close(); // bw��ü ��ȯ

	}
	public static void FileRead() throws IOException{ // ���� ���� �� �б�
		File f = new File("C:\\1234\\mytest.txt"); // mytest.txt ���� Ȯ��
		BufferedReader br = new BufferedReader( new FileReader(f)); // bufferedreader��ü�� ������ ����
		
		String readtxt; // �о�� ���ڿ� �����ϱ� ���� ����
		while ((readtxt = br.readLine()) != null) // �о�� ���ڿ��� �� ���� ������ �ƴ϶��(������ ������)
			System.out.printf("%s\n",readtxt); // �� �پ� ���
		br.close(); // br��ü ��ȯ
	}
	
	public static void main(String args[]) throws IOException{
		FileWrite(); // filewriteȣ��
		FileRead();	 // fileread ȣ��
		
	}
}

