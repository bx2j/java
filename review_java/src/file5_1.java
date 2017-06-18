/*
 * ArrayList �� HashSet�� �̿��� �ߺ�����(distinct)
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class file5_1 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\���������������ǥ�ص�����2.txt"); // ������ġ�� file�� ���� File ��ü ����
		BufferedReader br = new BufferedReader(new FileReader(f)); // ������ �о�´�
		
		String readtxt;
		
		ArrayList<String> al = new ArrayList<String>(); // ArrayList ��ü al ����
		
		while ((readtxt = br.readLine()) != null){
			String[] field = readtxt.split("\t"); // ������ ������ �����Ͽ� ���� �� �о�� String field�迭�� �����Ѵ�.  
			al.add(field[5]); // 5�� �ʵ��� ���� (�����������) ArrayList al �� �߰�
		}
		HashSet<String> hs = new HashSet<String>(al); // HashSet �� �̿��� ArrayList al �� �ߺ� ����
		ArrayList<String> nal = new ArrayList<String>(hs); // �ߺ� ���ŵ� al�� ����ִ� HashSet hs �� �ٽ� ArrayList ��ü�� ����
		
		Collections.sort(nal); // �������� ���� ��
		Collections.reverse(nal); // �������� ����
		for(int i=0;i<nal.size();i++) // nal �� ũ�⸸ŭ �ݺ�
			System.out.println(nal.get(i)); // nal�� ���� ���
	}
}


