/*
 * �Ÿ� ���
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

public class file4 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\���������������ǥ�ص�����2.txt"); // ���� Ȯ��
		BufferedReader br = new BufferedReader(new FileReader(f)); // ���� �о����
		String readtxt; // ���Ͽ��� �о�� ���ڿ� �����ϴ� ����
		if((readtxt = br.readLine()) == null) // ���ڿ��� ���ٸ�
			System.out.printf("�� �����Դϴ�\n"); // �� ����
		String[] field_name = readtxt.split("\t"); // ���� ó���� ������ ����̴�. ������ ����
		
		// ���� ��ġ (���ձ��������)
		double lat = 37.385842;
		double lng = 127.121274;
		
		// 35.518215, 129.425293 �츮��
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		
		//int cnt = 0; // �Ǽ� ���� ����
		int i = 0,j = 0,k = 0; // �Ÿ� �����ϴ� ����, for���� ���� ������ ����
		double max = 0; // �ִ밪 ����
		int maxp = 0; // �ִ밪 �ε���
		double min = 0; // �ּҰ� ����
		int minp = 0; // �ּҰ� �ε���
		double[] d = new double[14827]; // �ִ� , �ּҸ� ���� �Ÿ��� ������ �迭
		String[] fi = new String[14829]; // �ʵ��̸� ������ �迭
		while((readtxt = br.readLine())!=null){ // ������ �������� �ݺ�
			String[] field = readtxt.split("\t"); // �о�� �����͵��� ������ �����Ͽ� field �迭�� ����
			//System.out.printf("[%d]��° �׸�",cnt);
			//System.out.printf(" %s : %s",field_name[9],field[9]); // ���� �ּ�
			//System.out.printf(" %s : %s",field_name[12],field[12]); // ����
			//System.out.printf(" %s : %s",field_name[13],field[13]); // �浵
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[12])-lat,2) + 
						Math.pow(Double.parseDouble(field[13])-lng, 2));
			// �� ���� �Ÿ� ���
			// ��Ʈ(sqrt) (a^2 + b^2)(pow)
			fi[i] = field[9]; // �����ּ� ����(�ܺο��� Ȱ��)
			d[i] = dist; // �Ÿ��� �迭�� ����	
			i++; // �ε��� ����
			//cnt++;
		}		
		max = d[0]; // �ִ밪�� �Ÿ��迭�� ù �� ����
		min = d[0]; // �ּҰ��� �Ÿ��迭�� ù �� ����
		maxp = 0; // �ִ밪 �ε����� ó�� �ε��� ����
		minp = 0; // �ּҰ� �ε����� ó�� �ε��� ����
		
		for(j=0;j<d.length;j++){ // �Ÿ� �迭�� ���̸�ŭ �ݺ�
			if(max < d[j]){ // ���� ����Ǿ� �ִ� �ִ밪�� ���� ������ �۴ٸ�
				max = d[j]; // �� ��ü
				maxp = j; // �ε��� ��ü
			}			
		}
		for(k=0;k<d.length;k++){ // �Ÿ� �迭�� ���̸�ŭ �ݺ�
			if(min>d[k]){ // ���� ����Ǿ� �ִ� �ּҰ��� ���� ������ ũ�ٸ�
				min = d[k]; // �� ��ü
				minp = k; // �ε��� ��ü
			}
		}		
		System.out.printf("����Ÿ� ������ %s %f \n�ִܰŸ� ������ %s %f",fi[j],max,fi[k],min);		
		br.close();
	}
}

