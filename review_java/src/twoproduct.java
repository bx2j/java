/* 
 * �׸��� �ΰ��� ������ ��� form 
 * 2017.05.24
 * prepared by �躴��  
 * 
 * ��������
 * 	println / printf ȥ�� => printf ����
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class twoproduct {
	public static void main(String args[]){
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3�ڸ����� �޸�(,) �� ��� ���� DecimalFormat ���
		// ### (3�ڸ�����) , (�޸��� ����) => ������ �ڸ��� ��ä��
		Calendar k08_cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ð��� ������
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		// 4�ڸ� �⵵/��/�� �������� ���� �ð��� ��� ���� ����
		SimpleDateFormat k08_sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
		// 4�ڸ� �⵵���Ͻú��� �� �������� ���� �ð��� ��� ���� ����
		SimpleDateFormat k08_sdf4 = new SimpleDateFormat("yyyyMMdd HHmmss");
		// 4�ڸ� �⵵���� �ú��� �� �������� ���� �ð��� ��� ���� ����
		String k08_item1 = "Ǯ��������",k08_item2 = "�ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��)";
		// ǰ�� �̸� "Ǯ��������" / "�ٳ����䱸��Ʈ(�ٳ������䱸��Ʈ��)" ����
		String k08_itemcode1 = "8809169718205",k08_itemcode2 = "8809169213444";
		// ǰ�� �ڵ� "8809169718205" (Ǯ��������) / "8809169213444"(�ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��)) ����
		int k08_price1 = 600,k08_price2 = 600;
		// ǰ�� ���� 600�� (Ǯ�������� / �ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��)) 
		int k08_num1 = 1,k08_num2 = 5;
		// ǰ�� ���� Ǯ�������� 1�� / �ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��) 5��
		int k08_sum = (k08_price1*k08_num1) + (k08_price2*k08_num2);
		// ǰ�� �հ� ��� = Ǯ�������� ���� * Ǯ�������� ���� + �ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��) ���� * �ٳ����䱸��Ʈ(�ٳ����䱸��Ʈ��) ����
		int k08_tax = (int)(k08_sum/1.1);
		// (�� �ݾ�) / (1+(����/100.0)) �� ������ ǥ���� ���ݰ��� 		
		System.out.printf("����(����)�ްԼ�\n������ֽð��ݸ������380-4\n�ֺ��� 677-85-00239 TEL:043-857-9229");
		System.out.printf("\n");
		System.out.printf("\n");
		System.out.printf("[������]" + k08_sdf4.format(k08_cal.getTime())); // ������ �󿡼� 4�ڸ� �⵵���� �ú��� �� �������� ���� �ð� ���
		System.out.printf("%20s\n","POS��ȣ : 0002");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("%s %15s %5s %10s\n","ǰ���ڵ�","�ܰ�","����","�ݾ�");
		System.out.printf("-----------------------------------------------\n");			
		System.out.printf("%-13.13s\n",k08_item1); // 13�ڸ� �Ѿ�� ©���� ����
		System.out.printf("%s %11s %7.7s %13.13s\n",k08_itemcode1,k08_df.format(k08_price1),k08_df.format(k08_num1),(k08_df.format(k08_price1*k08_num1)));
		// ǰ�� �ڵ�, õ���� �޸� ���� ������ ����, õ���� �޸� ���� ������ ����, õ���� �޸� ���� ������ ����*���� = ����
		System.out.printf("%-13.13s\n",k08_item2); // 13�ڸ� �Ѿ�� ©���� ����
		System.out.printf("%s %11s %7.7s %13.13s\n",k08_itemcode2,k08_df.format(k08_price2),k08_df.format(k08_num2),(k08_df.format(k08_price2*k08_num2)));
		// ǰ�� �ڵ�, õ���� �޸� ���� ������ ����, õ���� �޸� ���� ������ ����, õ���� �޸� ���� ������ ����*���� = ����
		System.out.printf("\n");
		System.out.printf("%-10s %30s\n","���� ��ǰ �հ�",k08_df.format(k08_tax)); 
		// �������� 10�ڸ� ����, ���������� 30�ڸ� ���� , 3�ڸ����� �޸� ��� ���� format ���� , ���� ���
		System.out.printf("%-10s %32s\n","��    ��    ��",k08_df.format(k08_sum-k08_tax)); 
		// �������� 10�ڸ� ����, ���������� 30�ڸ� ���� , 3�ڸ����� �޸� ��� ���� format ���� , �ΰ��� ��� 
		System.out.printf("%-10s %32s\n","��          ��",k08_df.format(k08_sum)); 
		// �������� 10�ڸ� ����, ���������� 30�ڸ� ���� , 3�ڸ����� �޸� ��� ���� format ���� , ǰ�� �հ� ���
		System.out.printf("%-10s %31s\n","026-��ī���","00/00A");
		System.out.printf("%-10s %29s\n","ī  ��  ��  ȣ : ","5522-2012-5541-BADD");
		System.out.printf("%-10s %29s\n","ī  ��  ��  �� : ",k08_df.format(k08_sum)); 
		// �������� 10�ڸ� ����, ���������� 30�ڸ� ���� , 3�ڸ����� �޸� ��� ���� format ���� , ǰ�� �հ� ��� => �� ���� �� �ݾ�
		System.out.printf("%-15s %24s\n","��  ��  ��  �� : ","�Ͻú�");
		System.out.printf("%-10s %22s\n","��  ��  ��  ȣ : 04-KICC","75549250");
		System.out.printf("%-10s %29s\n","�� �� �� �� ȣ : ","");
		System.out.printf("%-10s %29s\n","��  ��  ��  �� : ",k08_df.format(k08_sum)); 
		// �������� 10�ڸ� ����, ���������� 30�ڸ� ���� , 3�ڸ����� �޸� ��� ���� format ����, ǰ�� �հ� ��� => �� ���� �� �ݾ�
		System.out.printf("%-10s %29s\n","��    ��    �� : ",k08_df.format(0));
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("%s %10s\n","�ֹ���ȣ:","0920");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("�Ǹſ� : 000002 ������2\n");
		System.out.printf(k08_sdf2.format(k08_cal.getTime()) + "-0002-0922\n");
		// ��¥��Ģ yyyy/MM/dd�� sdf2 ����
		System.out.printf("�������:[00138705 " + k08_sdf3.format(k08_cal.getTime()) + "]\n");
		// ���� ����� ��ȣ�� �����Ͻú����� yyyyMMddHHmmss sdf3���� ���
	}
}
