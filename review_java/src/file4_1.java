/*
 * Ư�� ��ġ���� ���� ����� ������� �� ������ ã��
 * 2017.05.31
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 * 	2017.06.01 -> ������ ��������� ����
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class file4_1 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\����������ǥ�ص�����.txt"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о����
		String readtxt; // ���Ͽ��� �о�� ���ڿ� �����ϴ� ����
		if((readtxt = br.readLine()) == null) // ���ڿ��� ���ٸ�
			System.out.printf("�� �����Դϴ�\n"); // �� ����
		String[] field_name = readtxt.split("\t"); // ������ �����Ͽ� �о�� ���ڿ� ����
		
		// ���� ��ġ (���ձ��������)
		double lat = 37.385842;
		double lng = 127.121274;
		
		// 35.518215, 129.425293 �츮��
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		
		int i = 0,j = 0,k = 0; // �Ÿ� �����ϴ� ����, ����� ���� ������ ����
		double max = 0; // �ִ밪 ����
		int maxp = 0; // �ִ밪 �ε���
		double min = 100; // �ּҰ� ����
		int minp = 0; // �ּҰ� �ε���
		double[] d = new double[14000]; // �Ÿ� ������ �迭 ����
		String[] fi = new String[13441]; // �ʵ� �� ������ �迭
		double dist = 0; // �Ÿ� ����
		while((readtxt = br.readLine())!=null){
			String[] field = readtxt.split("\t");			
			if(field.length < 33){ // ������ ����� �迭�� ���̰� 33���϶��
				// ��,�浵���� ���� �ʵ��
			}
			else{
				if( !(field[31].equals("")) && !(field[32].equals("")) ){
					// �� ���� �Ÿ� ���
					// ��Ʈ(sqrt) (a^2 + b^2)(pow)
					dist = Math.sqrt ( Math.pow(Double.parseDouble(field[31])-lat,2) + 
								Math.pow(Double.parseDouble(field[32])-lng, 2));
					d[i] = dist; // ���� �Ÿ��� �迭�� ����
					if(max < d[j]){ // ���� ����Ǿ� �ִ� �ִ밪�� ���� ������ �۴ٸ�
						max = d[j]; // �� ��ü
						maxp = j; // �ε��� ��ü
					}	
					if(min > d[k]){ // ���� ����Ǿ� �ִ� �ּҰ��� ���� ������ ũ�ٸ�
						min = d[k]; // �� ��ü
						minp = k; // �ε��� ��ü
					}
				}
			}			
			fi[i] = field[1]; // ������ �̸� ����	 			
			i++; // �Ÿ��迭�� �ε����� ����
			j++; // �ִ븦 ���� �ε����� ����
			k++; // �ּҸ� ���� �ε����� ����
		}		
	
		System.out.printf("����Ÿ� ������ %s %f \n�ִܰŸ� ������ %s %f",fi[maxp],max,fi[minp],min);	
		br.close();
	}
}

