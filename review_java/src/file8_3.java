
/*
 * �Ｚ���� �ְ��� ���� 15�� �ִ�,�ּҰ�(��������) csv���� ����
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 * 	2017.06.01 -> õ���� �޸� �� ��¥ �߰�
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class file8_3 {
	public static void main(String[] args) throws IOException{
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		File f = new File("C:\\1234\\A005930.csv"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о����
		int max = 0; // �ִ밪 0
		int min = 10000000; // �ּҰ� 10000000 ����
		String max_day = null,min_day = null;
		String rt; // �о�� ���ڿ� ���� ����
		long st = System.currentTimeMillis(); // ���۽ð� ����
		while((rt=br.readLine()) != null){
			StringBuffer sb = new StringBuffer(); // Stringbuffer ��ü ����
			String[] field = rt.split(","); // ��ǥ�� ���е� ���ڿ� field��ü�� ����
			if(field[1].trim().substring(0, 4).equals("2015")){ // field[1]�� �������� �� 0~4��° ���ڿ��� 2015�� ��ġ�Ѵٸ�
				if ( max < Integer.parseInt(field[3])){ // ���� field[3]�� ���� max���� ũ�ٸ�
					max = Integer.parseInt(field[3]); // max�� field[3]�� ��ü
					max_day = field[1];
				}
				if ( min > Integer.parseInt(field[3])){ // field[3]�� ���� max���� �۴ٸ�
					min = Integer.parseInt(field[3]); // min �� field[3]�� ��ü
					min_day = field[1];
				}
			}
		}
		
		System.out.printf("2015�� �Ｚ���� �������� �ִ밪 : %s [���� : %s]\n2015�� �Ｚ���� �������� �ּҰ� : %s [���� : %s]\n",df.format(max),max_day,df.format(min),min_day);
		long et = System.currentTimeMillis(); // ����ð� ����
		
		System.out.printf("process time : [%d]sec\n",(et-st)/1000); // ���� ��� �ð� ���
	}
}

