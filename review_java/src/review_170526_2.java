/*
 * �迭�� �ִ�, �ּҰ� ã��
 * 2017.05.26
 * prepared by �躴��
 * 
 * ��������
 * 	���� �ۼ�
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class review_170526_2 {
	public static void main(String args[]) throws Exception{
		int[] iArr = {1,7,5,3,2,5,3,4,9,12,4,212,33,11,21,11,2121,121,11,5,6,33};
		for ( int i =0;i<iArr.length;i++)
			System.out.printf("iArr[%d] = %d\n",i,iArr[i]);
		// iArr�迭 ó������ ���ʴ�� ����ش�. 
		// �迭�� 0���� ����, iArr.length�� �迭�� ���̸� �� �� �ִ�.
		
		int iMax = iArr[0]; // ������ �迭�� ó�� ������ ���� (1)
		int iMaxp = 0; 	 // �ִ밪�� ��ġ�� �迭�� ��ġ �ε���
		for (int i=0;i<iArr.length;i++){
			if(iMax<iArr[i]){ 	// ������ ���ִ� �� (1)�� �迭�� �� ������ �۴ٸ�
				iMax = iArr[i]; // �ִ밪�� �ƴϴϱ� ���� ���� ���ο� �ִ밪���� ��ü�ϰ�
				iMaxp = i; 		// �ִ밪�� ��ġ�� �迭�� ��ġ �ε����� �������ش�
			}
		}
		System.out.printf("***************\n");
		System.out.printf("iArr[%d] = %d \n",iMaxp,iMax); 
		// �ִ밪�� ����ִ� �迭�� �ε����� �ִ밪 ���
		 
		// �ּҰ��� if (iMax > iArr[i] �� �ε�ȣ������ �ٲ��ش�.
	}
}
