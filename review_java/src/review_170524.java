/* 
 * �׸��� �ϳ��� ������ ��� form
 * 2017.05.24
 * prepared by �躴��  
 * 
 * ��������
 * 	println / printf ȥ�� => printf ����
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class review_170524 {
	public static void main(String args[]){
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3�ڸ����� �޸�(,) �� ��� ���� DecimalFormat ���
				// ### (3�ڸ�����) , (�޸��� ����) => ������ �ڸ��� ��ä��
		Calendar k08_cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ð��� ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 4�ڸ� �⵵-��-�� ��:�� �������� ���� �ð��� ��� ���� ����
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyyMMdd");
		// 4�ڸ� �⵵���� �������� ���� �ð��� ��� ���� ����
		SimpleDateFormat k08_sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 4�ڸ� �⵵-��-�� ��:��:�� �������� ���� �ð��� ��� ���� ����
		int k08_price = 140000; // ��ǰ ����
		int k08_tax = (int)(k08_price/1.1); // ���� ���� ���
		System.out.printf("%20s\n","��  ��  ��");
		System.out.printf("====================================\n");
		System.out.printf("%s %14s\n","���λ�ȸ(�д缭����)","129-17-77924");
		System.out.printf("%s %13s\n","�̻�ö","031 781 1596");
		System.out.printf("������ �д籸 ������ 269-3\n���̺�� : 12\n");
		System.out.printf("�ֹ���ȣ : " + k08_sdf2.format(k08_cal.getTime()) + " 01 " + "00041\n");
		// �ֺй�ȣ�� ������ �� �տ� ������ ���� ��Ģ�� ���� ������ ������ yyyyMMdd ������ sdf2 ������ ���
		System.out.printf("====================================\n");
		System.out.printf("%-15.15s %16.15s\n","�ֹ��հ�",k08_df.format(k08_price)); // ��ǰ ���� õ ���� �޸� ��� ���
		System.out.printf("%-15.15s %16.16s\n","���αݾ�",k08_df.format(0)); // ���αݾ� 0 �������� Ȥ�� õ���� �Ѿ� ������ �־ �޸� ����
		System.out.printf("%-15.15s %16.16s\n","�����ݾ�",k08_df.format(k08_price)); // ��ǰ ���� õ ���� �޸� ��� ���
		System.out.printf("====================================\n");
		
		System.out.printf("%s %10.10s %6.6s %9.9s\n","��  ��",k08_df.format(0),"��  ��",k08_df.format(k08_tax)); 
		// ���� 0 �������� Ȥ�� õ���� �Ѿ� ������ �־ �޸� ����, ���� ���� ��� 
		System.out.printf("%s %10.10s %6.6s %9.9s\n","ī  ��",k08_df.format(k08_price),"��  ��",k08_df.format(k08_price-k08_tax)); 
		// ī�� �� �ݾ�, �ֹ����ݿ��� ���� ������ ���� ���� Ȯ��
		System.out.printf("%s %10.10s %6.6s %9.9s\n","����Ʈ",k08_df.format(0),"��  ��",k08_df.format(0));
		// ����Ʈ �� �鼼 ǰ ��� 0���� ä�� ����
		System.out.printf("%24s %7.7s\n","�����ݾ�",k08_df.format(k08_price));
		// �� �ݾ� õ���� �޸� ���� ���
		System.out.printf("====================================\n");
		
		System.out.printf("%20s\n","[�츮ī�� �ſ� ����]");
		System.out.printf("�� �� �� �� : %s\n" , k08_sdf3.format(k08_cal.getTime()));
		// ���� �Ͻô� ��-��-�� ��:��:�� ��Ģ�̱⶧���� yyyy-MM-dd HH:mm:ss ������ sdf3���� ���
		System.out.printf("ī �� �� ȣ : 55222059****2021\n");
		System.out.printf("�� �� �� ȣ : 79753574 �Һΰ��� : 00\n");
		System.out.printf("�� �� �� �� : %s\n" ,k08_df.format(k08_price));
		// ���� �ݾ� �� �ݾ� õ���� �޸� ����
		System.out.printf("�� �� �� ȣ : 730461774 / ��ī���\n");
		System.out.printf("����� ��ȣ : 129-17-77924\n");
		System.out.printf("====================================\n");
		System.out.printf(sdf.format(k08_cal.getTime()) + " CASHIER : ");
		// ���� ��¥�� yyyy-MM-dd HH:mm ������ sdf���� ���
		System.out.printf("%7.7s\n","����");
		System.out.printf("====================================\n");
		System.out.printf("���� �մϴ�.\n");
	}
		
}

