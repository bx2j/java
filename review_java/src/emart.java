/* 
 * ������ (�̸�Ʈ) ��� form 
 * 2017.05.24
 * prepared by �躴��  
 * 
 * ��������
 * 	println / printf ȥ�� => printf ���� 
 * 	�ּ� ���� => line 68 ~ 75 // �ش� ���ڿ� �ּ��� ���� ����ġ
 */

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class emart {
	 public static String k08_cut(String k08_str, int k08_maxLen) // �ش� ���ڿ��� �ڸ� byte ���� �Է�
     {
          StringBuilder k08_sb = new StringBuilder(); // ���ڿ��� ��⸸ �ϴ� String�� �޸� ���� ����
          int k08_Len = 0; // byte���� ������ ���� ����
          String k08_Char; // substring ���� �ϳ��� ���ڸ� �����ϱ� ���� ����
          for (int i = 0; i < k08_str.length(); i++) // �Է¹��� ���ڿ� ���̸�ŭ �ݺ��� ����
          {
        	  k08_Char = k08_str.substring(i, i + 1); // 0,1 ���� ���� ex) �������� -> ��
              k08_Len += k08_Char.getBytes().length; // ó���� ���� ������ ���� ���� ����
              if (k08_Len > k08_maxLen) // ������ ������ �Է¹��� byte���̰� ũ�� �ݺ� ����
            	  break;
              else
            	  k08_sb.append(k08_Char); // ���ο� ���ڿ� �߰�
               // ������ ���ڿ� �ڷ� ������ ���ڵ� �߰� �� -> ���� -> ������ -> ��������
          }
          return k08_sb.toString();
     }
	public static void main(String args[]){		
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3�ڸ����� �޸�(,) �� ��� ���� DecimalFormat ���
		// ### (3�ڸ�����) , (�޸��� ����) => ������ �ڸ��� ��ä��
		Calendar k08_cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ð��� ������
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 4�ڸ� �⵵-��-�� ��:�� �������� ���� �ð��� ��� ���� ����
		String[] k08_item = {"��������","���� * 3�ڽ�","�Ͽ콺 ��1.3kg","�������ֽ�5L 200����","������ �������ֽ�����","���ڿ���","������ ������������������","���ڿ���","water","��",
						 "��īĨ 35������","���","���","france-����","�ٳ��� �� ���̽�ũ��","���ġŲ 3000�κ�","����","����","�Ķ�����","ġ��",
						 "���߱�ġ","��纣��","������ ����","������ ����","����� ����","ĩ��","��Ǫ","�ٵ����","��Ŭ��¡","�μ�"};
		// ��ǰ 30�� �迭 ����
		int[] k08_itemprice = {2500,1200,3000,5000,129000,3000,3600,6000,7000,8000,
							3000,520,400,6000,2033,19000,4000,2000,1000,3000,
							2000,1000,3000,5000,4000,3000,2,1219000,7000,10000};
		// ��ǰ ���� å��
		int[] k08_itemnum = {1,3,5,7,3,2,1,8,9,7,1500,1,3,2,8,9,7,4,5,1,6,4,7,8,10,20,4,7,4,3};
		boolean[] k08_taxfree = {false,false,true,false,false,false,false,false,false,false,
							false,true,true,true,false,false,false,false,false,false,
							true,true,true,true,true,false,false,false,false,false};
		// k08_taxfree => �鼼 ��ǰ ǥ�� true �� �鼼. false �� ���� ���
		int k08_taxfree_sum = 0; // �鼼��ǰ�� �� ��
		int k08_taxfreeno_sum = 0; // ������ǰ�� �� ��
		int k08_all_sum = 0; // �鼼 + ������ǰ�� �� ��
		System.out.printf("%57s\n", "�̸�Ʈ ������ (031)888-1234");
		System.out.printf("%22s %29s\n","emart","206-86-50913 �̰���");
		System.out.printf("%52s\n","���ν� ������ ������� 552");
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�(30�ϳ�)\n��ȯ/ȯ�� ���������� ����(����ī������)\n");
		System.out.printf("üũī��/�ſ�ī�� û����� �ݿ���\n�ִ� 3~5�� �ҿ� (�ָ�,����������)\n\n");
		System.out.printf("[�� ��]" + k08_sdf2.format(k08_cal.getTime())); // ���� ��¥ ��-��-�� �ð�:�� ���
		System.out.printf("%43s\n","POS:0009-2418");
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("%8s %20s %13s %12s\n","�� ǰ ��","��  ��","����","��  ��");
		System.out.printf("------------------------------------------------------------------\n");
		for(int i = 0; i<k08_item.length;i++){
			String k08_subString; // �߶� ���� �����ϱ� ���� ���� k08_subString
			k08_subString = k08_cut(k08_item[i],17); // byte������ �߶󳻱� ���� ���ڿ��� �ڸ� byte���̸� cut�Լ��� �Ѱ���
			while(true){
		    	   if ( k08_subString.getBytes().length >= 17){ 
		    		   // 17��ŭ �߶� ���ڿ� ���� bytes���̰� 17�̻��̶�� while���� �������� �ʰ�
		    		   break;
		    	   }
		    	   k08_subString += " "; // ���̰� 17�� �ȵȴٸ� �߶� ���� �ڿ� ������ �߰��� �ش�.
		    }
			if ( k08_taxfree[i] == true ){ // �鼼 ����̶��				
				System.out.printf("%02d* %1.1s %s %13s %13s %14s\n",i+1,"",k08_subString,k08_df.format(k08_itemprice[i])
						,k08_df.format(k08_itemnum[i]),k08_df.format((int)((k08_itemprice[i] * k08_itemnum[i]))));
				// �鼼 ��� ��ǰ�� ��� ǰ���ڿ� * �� �ٿ��ش�.
				k08_taxfree_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // �鼼 ��� ǰ���� �� �հ踦 ���
			}
			else{ // ���� ����̶��
				System.out.printf("%02d %2.1s %s %13s %13s %14s\n",i+1,"",k08_subString,k08_df.format(k08_itemprice[i])
						,k08_df.format(k08_itemnum[i]),k08_df.format((int)((k08_itemprice[i] * k08_itemnum[i]))));
				k08_taxfreeno_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // ���� ��� ǰ���� �� �հ踦 ���
			}
			k08_all_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // ������ ��ü ǰ�� ���� �հ� ���
		}
		System.out.printf("%28s %33s\n","(*)�� ��  �� ǰ",k08_df.format(k08_taxfree_sum)); // �鼼 ��ǰ�� �� ��
		System.out.printf("%28s %33s\n","   �� ��  �� ǰ",k08_df.format((int)(k08_taxfreeno_sum/1.1))); // ���� ��ǰ ���� - ������ ������
		System.out.printf("%29s %33s\n","   ��   ��   ��",k08_df.format(k08_taxfreeno_sum-(int)(k08_taxfreeno_sum/1.1))); // �ΰ���
		System.out.printf("%30s %33s\n","��        ��",k08_df.format(k08_all_sum)); 
		// �� �հ� = �鼼 ��ǰ�� �� + ���� ��ǰ�� �� + ���� ��ǰ�� ���� �ΰ���
		System.out.printf("%s %43s\n","��  ��  ��  ��  ��  ��",k08_df.format(k08_all_sum)); // �հ迡 ���� ī����� �ݾ�
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("004 ��  ��");
		System.out.printf("%56s\n","5417**8890/07850246");
		System.out.printf("ī�����");
		System.out.printf("%44s %10s\n","�Ͻú� /",k08_df.format(k08_all_sum));
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n");
		System.out.printf("�̸�Ʈ(�ż���) ����Ʈ 3120�� ����\n1000�� �̻���� ����ó�� ��� �� �� �ֽ��ϴ�.\n");
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("���� �մϴ�.\n");
	}
}
