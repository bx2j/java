

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class java170522 {
	public static void main(String args[]){		
		int k08_sum = 0; // ���� ���� k08_sum 0���� �ʱ�ȭ
		for (int k08_a = 1; k08_a < 101; k08_a++) // 1���� 1�� �����ϸ鼭 100���� �ݺ�
			k08_sum += k08_a; // k08_sum = k08_sum + k08_a => k08_sum ���� k08_a���� ���ϸ鼭 k08_sum���� ����
		// 0 = 0 + 1 > 1 = 1 + 2 ... 
		System.out.println("******");
		System.out.println("* "+ k08_sum); // ���� k08_sum �� ���
		System.out.println("*  "+ k08_sum/100); // k08_sum ���� ��� ���
		System.out.println("******");
		
		int [] k08_bv = {1,2,3,4,5}; // k08_bv �迭�� 1,2,3,4,5 �� �ʱ�ȭ ���ѳ�
		int k08_vsum = 0; // ���� ���� k08_vsum 0 �ʱ�ȭ
		for(int k08_a = 0; k08_a < 5; k08_a++) // 0���� 4���� 1�� �����ϸ鼭 �ݺ�
			k08_vsum  += k08_bv[k08_a]; // k08_vsum�� k08_bv[0] ���� ���ؼ� k08_vsum���� ����
		// 0 = 0 + 1 > 1 = 1 + 2 ...
		System.out.println("****");
		System.out.println("* " + k08_vsum);
		System.out.println("****");
		
		int k08_i = 0; // k08_i ���� 0���� �ʱ�ȭ
		k08_i = 1000/3; // k08_i������ 1000 / 3 �� ����. 333.3333... �� ����� ������ �ʰ� 333�� ���´�
		System.out.println("**************");
		System.out.println("* 1000/3 = " + k08_i); // ���
		System.out.println("**************");
		k08_i = 1000%3; // k08_i������ 1000 / 3�� ������ �� ����
		System.out.println("*************");
		System.out.println("* 1000%3 = " + k08_i); // ���
		System.out.println("*************");
		
		for(int k08_a=0; k08_a < 20; k08_a++){ // 0���� 19���� 1�� �����ϸ鼭 �ݺ�
			System.out.println(k08_a); // ���ʴ�� ����ϰ� �ٹٲ�
			if((k08_a+1)%5 == 0) // ���� �ϴ� ���� 1�� ���ϰ� 5�� ������ �� �������� 0�̶��
				// k08_a �� 4��� 5%5 == 0 �̹Ƿ� k08_a ���� 4�϶� ���� ���� ���� k08_a���� 5 ��� 
				System.out.println("*"); // �ٹٲٴ� ���� '*' �� �־ �ٹٲ� ǥ��
		}
		
		k08_i = 12345;
		int k08_x = (k08_i/10)*10; // 12345�� 10���� ���� ������ ó���ϱ� ����
		// k08_i / 10 => 1234.5�� �ƴ϶� 1234.0 
		// 1234.5 * 10 => 12340
		System.out.println("***********************");
		System.out.println("* (k08_i/10)*10 = " + k08_x);
		System.out.println("***********************");
		k08_x = ((k08_i+5)/10)*10;
		System.out.println("***************************");
		System.out.println("* ((k08_i+5)/10)*10 = " + k08_x);
		// k08_i �� 5�� ���ϸ� 12350�̰� �긦 ������ 1235.0�ε� �ٽ� 10�� ���ϸ� 12350
		k08_i = 12344;
		k08_x = ((k08_i+5)/10)*10;
		System.out.println("* ((k08_i+5)/10)*10 = " + k08_x);
		// k08_i �� 5�� ���ϸ� 12349�̰� 10���� ������ 1234.9�� �ƴ϶� 1234.0�� �Ǹ鼭 ���� 10�� ���ϸ� 12340 �� �ȴ�.
		System.out.println("***************************");
		
		double k08_f1 = 14/5;
		double k08_f2 = 14.0/5;
		double k08_f3 = 14.0/5 + 0.5;		
		double k08_f4 = (int)(14.0/5+0.5);
		System.out.println("*************************");
		System.out.println("* 14/5 = " + k08_f1); 
		// k08_f1�� double�� ������ 14�� 5�� int ���̹Ƿ� �Ҽ��� ���ϸ� �������� double�̹Ƿ� 2.0 ��� 
		System.out.println("* 14.0/5 = " + k08_f2);
		// 14.0 or 14. �������� �� �� �ϳ��� ���� double ������ ǥ���ϸ� �������� ��� ���
		System.out.println("* 14.0/5 + 0.5 = " + k08_f3);
		// double ���� 0.5�� ���ϸ�? ���� ��� ���
		System.out.println("* (int)(14.0/5+0.5) = " + k08_f4);
		// 3.3�̶�� ���� int ������ ����ȯ�ϰ� �Ǹ� �Ҽ��� ���ϴ� �������µ� int�� ������ ���� ������ double ���̹Ƿ� double������ ��Ÿ��
		System.out.println("*************************");
		
		System.out.println("*******************************");
		int k08_val = 271; // ���� ���� ��
		int k08_rate = 3; // ���� 3�ۼ�Ʈ 0.03
		int k08_tax = k08_taxcalc(k08_val,k08_rate); // k08_taxcalc �Լ��� k08_val 271 k08_rate 3 ���� �Ѱ��ְ� ������� ���Ϲ޴´�
		System.out.println("* ���� ���� ��� : " + k08_val*k08_rate/100.0); // �ϳ��� double �������� ����� ���� ��� ����
		System.out.println("* ���� : " + k08_val + " ���� : " + k08_tax + " ���� ���� : " + (k08_val+k08_tax));
		System.out.println("*******************************");
		
		System.out.println("*************************************");
		int k08_custom = 280; // �Һ��� ����
		int k08_taxrate = 3; // ���� 3�ۼ�Ʈ 0.03
		int k08_taxval, k08_netval; // ����, ���� ���� int �� ���� ����
		k08_netval = (int)(k08_custom / (1 + (k08_taxrate/100.0)) ); // ���� ���� = �Һ��� ���� / (1 + ����)
		k08_taxval = k08_custom - k08_netval; // ���� = ���� �� - ���� ����
		System.out.println("* �Һ��� ���� : " + k08_custom + " ���� ���� : " + k08_netval + " ���� : " + k08_taxval);
		System.out.println("*************************************");
		
		int k08_won = 1000000; // ȯ���� �� �� 100����
		double k08_ex = 1238.21; // �޷� ȯ��
		double k08_com = 0.003; // ȯ�� ������ 0.3%
		
		int k08_money = (int)(k08_won/k08_ex); // ���� ���� �޷��� int ������ ����� ������ �ȴ�.
		int k08_remoney = (int)(k08_won - (k08_money * k08_ex));
		// ��ü �ݾ׿��� (ȯ���� �޷� * ȯ��) �� ����.
		System.out.println("* ȯ�� �ݾ� : " + k08_won + " �޷� : " + k08_money + " �ܵ� : " + k08_remoney);
		System.out.println("*************************************");
		
		System.out.println("*********************************************************");
		double k08_cpo = k08_ex * k08_com; // 1�޷��� ������ = ȯ�� * ȯ�� ������
		double k08_total = k08_money * k08_cpo; // �� ������ = ȯ�� �ݾ� * �޷��� ������ 
		System.out.println("* ������ : " + k08_total + " �޷� : " + k08_money + " �޷� �� ������ : " + k08_cpo);
		System.out.println("*********************************************************");

		System.out.println("*****************************************************");
		int k08_itotal;
		if(k08_total != (double)((int)k08_total))
			// int ��  �������� ���� double �� �������� ���� �ٸ��ٸ�
			k08_itotal = (int)k08_total + 1;
			// �� ������� int������ �Ҽ��� ���ϸ� ������ +1
		else // int ��  �������� ���� double �� �������� ���� ���ٸ�
			k08_itotal = (int)k08_total;
			// �� ������� int ��
		System.out.println("* �� ������ : " + k08_itotal + " �޷� " + k08_money + " ������ : " + k08_cpo);
		k08_remoney = (int) (k08_won - k08_money * k08_ex - k08_itotal);
		// �� �� 100�������� ȯ���ݾ� * ȯ�� - �� �����Ḧ ����ϸ� -2233 �̶�� �ܵ��� ������ �ȴ�. 100������ ������ 807�޷��� ȯ���� �� ����.
		System.out.println("* �� ��ȭȯ���ݾ� : " + k08_won + " �޷� " + k08_money + " ������ : " + k08_itotal 
				+ " �ܵ� : " + k08_remoney);
		System.out.println("*****************************************************");
		
		System.out.println("***************************************************");
		k08_money = (int)(k08_won/(k08_ex + k08_cpo)); // ȯ�� �޷� = (���� / ȯ��+�޷� �� ������)
		k08_total = k08_money * k08_cpo; // �� ������ = ȯ�� �޷� * �޷� �� ������
		if(k08_total != (double)((int)k08_total))
			// int ��  �������� ���� double �� �������� ���� �ٸ��ٸ�
			k08_itotal = (int)k08_total + 1;
			// �� ������� int������ �Ҽ��� ���ϸ� ������ +1
		else // int ��  �������� ���� double �� �������� ���� ���ٸ�
			k08_itotal = (int)k08_total;
			// �� ������� int ��
		System.out.println("* �� ������ : " + k08_itotal + " �޷� " + k08_money + " ������ : " + k08_cpo);
		k08_remoney = (int) (k08_won - k08_money * k08_ex - k08_itotal);
		// 805�޷��� ȯ���ϰ� �ܵ��� ����ϰ� �Ǹ� 100������ �´� �ܵ��� ���ȴ�.
		System.out.println("* �� ��ȭȯ���ݾ� : " + k08_won + " �޷� " + k08_money + " ������ : " + k08_itotal 
				+ " �ܵ� : " + k08_remoney);
		System.out.println("***************************************************");
		
		System.out.println("*****************************************************");
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		// 3�ڸ����� �޸�(,) �� ��� ���� DecimalFormat ���
		// ### (3�ڸ�����) , (�޸��� ����) => ������ �ڸ��� ��ä��
		Calendar cal = Calendar.getInstance();
		// Calendar Ŭ������ ���� �ð��� ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// 4�ڸ� �⵵/��/�� ��:��:�� �� �������� ���� �ð��� ��� ���� ����
		System.out.println("* �� ������ : " + df.format(k08_itotal) + " $ " + df.format(k08_money) 
				+ " ������ : " + k08_cpo);
		System.out.println("* �� ��ȭȯ���ݾ� : " + df.format(k08_won) + " $ " + df.format(k08_money) 
				+ " ������ : " + df.format(k08_itotal) 	+ " �ܵ� : " + k08_remoney);
		System.out.println("* ���� ���� �ð� : " + sdf.format(cal.getTime()));
		System.out.println("*****************************************************");
	}
	
	public static int k08_taxcalc(int k08_val,int k08_rate){ // int�� �Ű����� k08_val,k08_rate ����
		int k08_ret; // ���� int �� ���� ����
		if( ((double)k08_val * (double)k08_rate/100.0) == (k08_val * k08_rate/100) ){
			// ���� �� * ���� / 100.0 (�Ǽ���) �� int �� ����� ���� ���
			k08_ret = k08_val * (k08_rate / 100);
			// �ٸ� ����ó�� ���� �ʰ� �״�� ����
		}else // �ٸ� ���
			k08_ret = k08_val * k08_rate/100 + 1;
		// ����� �Ҽ��� ���ϸ� ������ +1 �� ���
		return k08_ret; // ��� int������ ��� ���� 
	}
}
