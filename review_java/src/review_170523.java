

import java.text.DecimalFormat;

public class review_170523 {
	public static void main(String args[])
	{
		/*int k08_i,k08_x;
		k08_i = 0; // * �� ����ִ� k08_i ���� 0 ���� �ʱ�ȭ
		while(true){ // ���ǿ� �¾� break �� �ɸ��� ������ ���̶�� ���� �ݺ�
			k08_x = 0; // �ٹٲ��� ���ִ� k08_x ���� 0 ���� �ʱ�ȭ
			while(true){ // ���ǿ� �¾� break �� �ɸ��� ������ ���̶�� ���� �ݺ�
				System.out.print("*"); // �ϴ� �� �ϳ� ��´�. ( k08_i �� k08_x �� �ٸ� ��쿡 ������������ �� ���� �Ѵ� )
				if ( k08_i == k08_x ) // k08_i�� k08_x �� ó���� 0 ���� �ʱ�ȭ �Ǿ��� ������ ���ǿ� �ɸ��� break �� �������´�.
					break;
				k08_x++; // if ���ǹ��� �ɸ��� �ʴ´ٸ� ( k08_i �� k08_x �� �ٸ��ٸ� ) k08_x �� 1 �����ϰ� �ٽ� while ������ ���� ����.
			}
			System.out.println(""); // �ٹٲ��� �� ������
			k08_i++; // k08_i �� 1 ���������ش�
			if ( k08_i == 30) // k08_i �� ���� (1) �̱� ������ if ���ǹ��� �Ѿ�� �ȴ�.
				break;
		}*/
		
		/*int k08_i; // int �� k08_i ���� ����
		double k08_d; // double �� k08_d ���� ����
		k08_i = 10/3; // int ������ �������ؼ� k08_i �� ����
		k08_d = 10/3.0; // double ������ ���� �� ���� 3.0 k08_d�� ����
		
		if ( k08_i == k08_d ) // int���� double ���� ���� ������
			System.out.println("����");
		else // int���� double ���� �ٸ��ٸ�
			System.out.println("�ٸ��� \t " + (double)k08_i + "\t" + k08_d);
		
		if (k08_i == 3.333333) // int�� k08_i �� ���� ���Ƿ� ������ 3.333333 �� ���ٸ�
			System.out.println("����");
		else
			System.out.println("�ٸ��� \t " + k08_i); // int ���� �Ҽ��� ���� �߶����
		
		k08_d = (int)k08_d; // double �� ������ int������ ����ȯ���Ѽ� ���� �ִ´�
		if ( k08_i == k08_d ) // int���� double ���� ���ٸ�
			System.out.println("����");
		else // �ٸ��ٸ�
			System.out.println("�ٸ��� \t " + (double)k08_i + "\t" + k08_d); // int���� k08_i �� double������ ���� ���
		
		System.out.println("int�� �μ� \t " + k08_i + "\t" + k08_d);
		System.out.println("double�� �μ� \t " + (double)k08_i + "\t" + k08_d);
		
		char k08_a = 'c'; // char �� ���� k08_a�� c ���� �Ѱ� ����
		if ( k08_a == 'b' ) // k08_a�� ����ִ� c��� ���ڰ� b�� ���ٸ�
			System.out.println("a = b");
		if ( k08_a == 'c' ) // k08_a�� ����ִ� c��� ���ڰ� c�� ���ٸ�
			System.out.println("a = c");
		if ( k08_a == 'd' ) // k08_a�� ����ִ� c��� ���ڰ� d�� ���ٸ�
			System.out.println("a = d");
		
		String k08_aa = "abcd"; // String �� ���� k08_aa �� abcd ��� ���ڿ� ����
		if ( k08_aa.equals("abcd") ) // k08_aa�� ����ִ� ���ڿ��� �񱳴�� ���ڿ��� abcd�� ���ٸ�
			System.out.println("aa �� abcd �̴�");
		else
			System.out.println("aa�� abcd�� �ƴϴ�");
		
		boolean k08_bb = true; // boolean �� ���� k08_bb �� true �� �ʱ�ȭ
		if (!!k08_bb) // k08_bb�� ó���� true ���ٰ� ! ������ false �ǰ� �ٽ� ! ������ true �� �Ǿ���
			System.out.println("k08_bb �� �ƴϰ� �ƴϸ� ���̴�");
		else
			System.out.println("k08_bb �� �ƴϰ� �ƴϸ� �����̴�");
		*/
		/*int k08_a; // int�� ���� k08_a ����
		for ( int k08_i = 0 ; k08_i < 300 ; k08_i++){ // 0���� 299 ���� 1�� �����ϸ鼭 �ݺ�
			k08_a = 5 * k08_i; // ���� ���� k08_a�� k08_i * 5 �� ����
			if ( k08_a >= 0 && k08_a < 10 ) // k08_i * 5 �� ���� 0�̻� 9���϶�� 
				System.out.println("�� " + k08_a);
			else if ( k08_a >= 10 && k08_a < 100 ) // k08_i * 5 �� ���� 10 �̻� 99���϶��
				System.out.println("�� " + k08_a);
			else if ( k08_a >= 100 && k08_a < 1000 ) // k08_i * 5 �� ���� 100 �̻� 999 ���϶��
				System.out.println("�� " + k08_a);
			else // k08_i * 5 �� ���� 1000 �̻��̶��
				System.out.println("õ " + k08_a);
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1���� 12���� 1�� �����ϸ鼭 �ݺ�
			System.out.print(k08_i + "�� => "); // ������� ǥ��
			for ( int k08_j = 1 ; k08_j <32 ; k08_j++){ // 1���� 31���� 1�� �����ϸ鼭 �ݺ�
				System.out.print(k08_j + ",");
				if ( k08_i == 1 && k08_j == 31) // 1���� 31�ϱ��� �־ ó�� for ���� 1 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 2 && k08_j == 28) // 2���� 28�ϱ��� �־ ó�� for ���� 2 �̰� ���� for ���� ���� 28�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 3 && k08_j == 31) // 3���� 31�ϱ��� �־ ó�� for ���� 3 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 4 && k08_j == 30) // 4���� 30�ϱ��� �־ ó�� for ���� 4 �̰� ���� for ���� ���� 30�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 5 && k08_j == 31) // 5���� 31�ϱ��� �־ ó�� for ���� 5 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 6 && k08_j == 30) // 6���� 30�ϱ��� �־ ó�� for ���� 6 �̰� ���� for ���� ���� 30�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 7 && k08_j == 31) // 7���� 31�ϱ��� �־ ó�� for ���� 7 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 8 && k08_j == 31) // 8���� 31�ϱ��� �־ ó�� for ���� 8 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 9 && k08_j == 30) // 9���� 30�ϱ��� �־ ó�� for ���� 9 �̰� ���� for ���� ���� 30�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 10 && k08_j == 31) // 10���� 31�ϱ��� �־ ó�� for ���� 10 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 11 && k08_j == 30) // 11���� 30�ϱ��� �־ ó�� for ���� 11 �̰� ���� for ���� ���� 30�� �Ǹ� ���� for�� ����
					break;
				if ( k08_i == 12 && k08_j == 31) // 12���� 31�ϱ��� �־ ó�� for ���� 12 �̰� ���� for ���� ���� 31�� �Ǹ� ���� for�� ����
					break;
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1������ 12�� ���� �ݺ�
			System.out.print(k08_i + "�� ==> ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1�Ϻ��� 31�ϱ��� �ݺ�
				System.out.print(k08_j + ","); // �� ���� �ڿ� �޸� ���
				if ( k08_i == 4 || k08_i == 6 || k08_i == 9 || k08_i ==7 || k08_i == 11 ){
					// 4�� 6�� 9�� 7�� 11�� �� �ϳ����
					if ( k08_j == 30 ) // 30�Ͽ� �����
						break;
				}
				if ( k08_i == 2 ){ // 2���̶��
					if ( k08_j == 28 ) // 28�Ͽ� �����
						break;
				}					
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1������ 12�� ���� �ݺ�
			System.out.print(k08_i + "�� ==> ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1�Ϻ��� 31�ϱ��� �ݺ�
				System.out.print(k08_j + ","); // �� ���� �ڿ� �޸� ���
				if ( (k08_i == 4 || k08_i == 6 || k08_i == 9 || k08_i ==7 || k08_i == 11) && (k08_j == 30))
					// 4�� 6�� 9�� 7�� 11�� �̰� 30�� �̶�� ���� ����
					break;
				if ( k08_i == 2 && k08_j == 28 ) // 2���̰� 28���̶�� ���� ����
					break;
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1������ 12�� ���� �ݺ�
			System.out.print(k08_i + "�� ==> ");
			LOOP: for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1�Ϻ��� 31�ϱ��� �ݺ�
				System.out.print(k08_j + ",");
				switch(k08_i){
				case 4: // k08_i �� ���� 4 6 9 7 11 �϶� break ���� ����
				case 6:
				case 9:
				case 7:
				case 11:
					if ( k08_j == 30 ) // k08_j �� 30�� �� (30���ϰ��) 
						break LOOP; // �����ϰ� LOOP �� ���ư���
					break;
				case 2: // k08_i �� ���� 2�� ���
					if ( k08_j == 28 ) // k08_j �� 28 �϶� (28�� �� ���)
						break LOOP; // �����ϰ� LOOP �� ���ư���
					break;
				}				
			}
			System.out.println(); // �ٹٲ�
		}*/
		
	
		/*int [] k08_arr = {31,28,31,30,31,30,31,31,30,31,30,31};// k08_arr �迭�� ���� ������ ���� ���ڸ� ������ѳ��´�.
		for ( int k08_i = 1; k08_i < 13 ; k08_i++){ // 1 ~ 12 ���� �ݺ�  ( 1�� ~ 12�� )
			System.out.print(k08_i + "�� => ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1 ~ 31���� �ݺ� ( 1�� ~ 31��  )
				System.out.print(k08_j);
				if ( k08_arr[k08_i-1] == k08_j) // ���� ������ �Ͽ� ���������� ���� Ż���� ���� if ��
					break;
				System.out.print(","); // ������ �� �� ��쿡�� �޸� ���� �ʴ´� 
			}
			System.out.println();
		}*/
		
		/*String [] k08_units = {"��","��","��","��"	,"��","��","��","ĥ","��","��"}; // k08_units �迭�� �� ~ �� �� �ܾ ������ѳ��´�.
		for ( int k08_i = 0 ; k08_i < 101 ; k08_i++){ // 0���� 100 ���� 1�� �����ϸ鼭 �ݺ�
			if ( k08_i >= 0 && k08_i < 10 ){ // 0�̻� 9 ���϶�� ���� �ڸ�
				System.out.println("���� �ڸ� : " + k08_units[k08_i]);
			}
			else if ( k08_i >= 10 && k08_i < 100 ){ // 10�̻� 99 ���϶��
				int k08_i10, k08_i0; // �����ڸ��� �����ڸ� ǥ�ø� ���� ���� �ΰ� ����
				k08_i10 = k08_i / 10; // ���� �ڸ� ǥ�ø� ���� 10���� ������.
				k08_i0 = k08_i % 10; // ���� �ڸ� ǥ�ø� ���� 10���� ���� ������ ����
				if ( k08_i0 == 0 ){ // k08_i % 10 �� ����� 0 �� ��� 
					System.out.println("���� �ڸ� : " + k08_units[k08_i10] + "��");
				}
				else
					System.out.println("���� �ڸ� : " + k08_units[k08_i10] + "��" + k08_units[k08_i0]);
			}
			else
				System.out.println("==> " + k08_i);
		}*/
		
		int k08_i = 1001034567;
		String k08_sNumVal = String.valueOf(k08_i); // ���ڸ� String.valueOf �� �̿��� String ������ ��ȯ
		String k08_sNumVoice = "";
		System.out.println("==> " + k08_sNumVal + " " + k08_sNumVal.length() + "�ڸ�"); 
		// k08_sNumVal.length() �� �̿��� k08_i�������� ���̸� �� �� �ִ�.
		// ���ڸ����� �˾ƾ� ù ������ � ������ �� �� �ִ�.
		int k08_a, k08_b;
		String [] k08_units = {"��","��","��","��","��","��","��","ĥ","��","��"};
		// k08_units �迭�� �� ~ ���� �ܾ� ����
		String [] k08_unitx = {"","��","��","õ","��","��","��","õ","��","��"};
		// k08_unitx �迭�� ���� ~ ���� �ܾ� ����
		k08_a = 0;
		k08_b = k08_sNumVal.length() - 1; // ���� 10 - 1����
		
		while ( true ){
			if ( k08_a >= k08_sNumVal.length()) // k08_sNumVal �� ���̰� 0���϶�� loop ���� 
				break;
			System.out.println(k08_sNumVal.substring(k08_a, k08_a + 1) + "[" // k08_sNumVal�� ù��° ���� 1�� substring���� ���� 
				+ k08_units[Integer.parseInt(k08_sNumVal.substring(k08_a,k08_a + 1))] + "]");
			// k08_sNumVal�� ù��° ���� 1 ( ����� ���� ) �� integer.parseInt �� ����� int������ ��ȯ�ϰ� k08_units �� ���� �ҷ��� ( �� )
			if ( k08_sNumVal.substring(k08_a, k08_a + 1).equals(("0")) ) { // k08_sNumVal�� ù��° �ڸ��� 0�� �����ϴٸ�
				if ( k08_unitx[k08_b].equals("��")||k08_unitx[k08_b].equals("��")){
					// k08_b �� k08_sNumVal ������ -1, k08_units[9] �� ���̰ų� ���̶��
					k08_sNumVoice = k08_sNumVoice + "" + k08_unitx[k08_b];
					// k08_sNumVoice ���� k08_unitx[9] ����
				}
				else{}
			}else // k08_sNumVal�� ù��° �ڸ��� 0�� ���������� �ʴٸ�
				k08_sNumVoice = k08_sNumVoice + k08_units[Integer.parseInt(k08_sNumVal.substring(k08_a,k08_a + 1))] 
				// k08_sNumVal�� ù��° ���� 1 ( ����� ���� ) �� integer.parseInt �� ����� int������ ��ȯ�ϰ� k08_units �� ���� �ҷ��� ( ��  )
						+ k08_unitx[k08_b];
			k08_a++; 
			k08_b--; // k08_sNumVal.length() �� 1 ����
		}
		System.out.println(k08_sNumVal + "[" + k08_sNumVoice + "]");
		
		/*for ( int k08_i = 0 ; k08_i < 10 ; k08_i++){ // 0���� 9���� 1�� �����ϸ鼭 �ݺ�
			for ( int k08_j = 0 ; k08_j < k08_i ; k08_j++) // k08_i �� 0 �϶� k08_j �� 0�� �ǰ� ó���� ������ ���� �ʾƼ� �������� �ʴ´�.
				System.out.print(" "); // ���ϴ� ĭ ��ŭ ��ĭ ��� ��
			System.out.println(k08_i); // ���� ���
		}*/
		
		/*double k08_fSin; // double �� ���� ����
		for ( int k08_i = 0 ; k08_i < 360 ; k08_i++){
			k08_fSin = Math.sin(k08_i * 3.141592 / 180); // sin0 ~ sin360�� ���Ѵ�. ������ ���� sin �� ���
			System.out.println(k08_i + "sin => " + k08_fSin);
		}
		for ( int k08_i = 0 ; k08_i < 360 ; k08_i++){
			k08_fSin = Math.sin(k08_i * 3.141592 / 180); // sin0 ~ sin360�� ���Ѵ�. ������ ���� sin �� ���
			int k08_iSpace = (int)((1.0 - k08_fSin) * 50); // ����ó���� ���� 1.0���� - ���ش�. �ʹ� ���� �����̶� ���� �� ���̵��� �ϱ� ���� 50 ������
			// ��� sin ���鿡 ���� ���ó���� ���� k08_iSpace
			for ( int k08_j = 0 ; k08_j < k08_iSpace ; k08_j++) // 0 ���� ��� sin ���鿡 ���� ���ó���� ���� k08_iSpace ���� ���� ���
				System.out.print(" ");
			System.out.println("*[" + k08_fSin + "][" + k08_iSpace + "]"); // [sin��][���ó���ϰ� �ߺ��̰� �� ��]
		}*/
		
		/*int k08_n = 20; // int�� ���� k08_n ���� �� 20���� �ʱ�ȭ
		int k08_m = 1; // int�� ���� k08_m ���� �� 1�� �ʱ�ȭ
		while ( true ){
			for ( int k08_i = 0 ; k08_i < k08_n ; k08_i++) // 0���� 20���� ���� ���
				System.out.print(" ");
			for ( int k08_i = 0 ; k08_i < k08_m ; k08_i++) // 0���� 1���� * ���
				System.out.print("*");
			System.out.println(); // �ٹٲ�
			k08_n = k08_n - 1; // ��������ϴ� ���� ���� �ٿ�������
			k08_m = k08_m + 2; // * �� ����ϴ� ���� ���� �÷������� 2����
			if ( k08_n < 0 )
				break;
		}*/
		
		/*String k08_item = "���"; // ǰ���̸� ���
		String k08_item2 = "����"; // ǰ���̸� ����
		int k08_price = 5000; // ��� ���� 5000��
		int k08_price2 = 3000; // ���� ���� 3000��
		int k08_num = 500; // ��� �� ���� ���� 500��
		int k08_total = 0; // �� ���� 0 ���� �ʱ�ȭ ���ѳ���
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 3�ڸ����� �޸�����ִ� DecimalFormat
		
		System.out.println("========================================"); // �Ϲ��� ����Ʈ�� ��� �μ� �� ���� �μ��Ѵ�.
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","ǰ��","�ܰ�","����","�հ�");
		System.out.println("========================================"); // ��� ǥ��
		
		System.out.printf("%20.20s%10.10s%5.5s%12.10s\n",
				k08_item,df.format(k08_price),df.format(k08_num),df.format(k08_price*k08_num));
		System.out.printf("%20.20s%10.10s%5.5s%12.10s\n",
				k08_item2,df.format(k08_price2),df.format(k08_num),df.format(k08_price2*k08_num));
		// DecimalFormat ���� ���ڸ����� �޸�����ش�.
		// 20ĭ�� ������ ����ΰ� 20ĭ�� ����� �� �ִ�. ������ ���ڰ� ������ ©�� ( 12.5 -> 2,500 
		System.out.println("========================================");*/
	}

}
