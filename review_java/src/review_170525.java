/* 
 * ��/�� ���� ä���, ���ڿ����� �ѱ� ���� ã�� program 
 * 2017.05.25
 * prepared by �躴��  
 * 
 * ��������
 * 	���� �ۼ�
 */
import java.util.regex.Pattern;

public class review_170525 {
	public static String k08_rpad(String k08_str, int k08_size) { // ���ڿ��� �� ���� �Է¹޴´�
        for(int k08_i = (k08_str.getBytes()).length; k08_i < k08_size; k08_i++) { 
        	// �Է¹��� ���ڿ��� ����Ʈ ���̸� ���ϰ�, �Է¹��� ���̸�ŭ �ݺ��� �ϸ鼭
            k08_str += " "; // ���ڿ��� �����ʿ� ������ ä���ִ´�.
        }
        return k08_str; // �ݺ��� ���� �� ������ ä�� ���ڿ� ��ȯ
    }

	public static String k08_lpad(String k08_str, int k08_size) { // ���ڿ��� �� ���� �Է¹޴´�
        for(int k08_i = (k08_str.getBytes()).length; k08_i < k08_size; k08_i++) { 
        	// �Է¹��� ���ڿ��� ����Ʈ ���̸� ���ϰ�, �Է¹��� ���̸�ŭ �ݺ��� �ϸ鼭
            k08_str = " " + k08_str; // ���ڿ��� ���ʿ� ������ ä���ִ´�.
        }
        return k08_str; // �ݺ��� ���� �� ������ ä�� ���ڿ� ��ȯ
    }

	public static void main(String args[]){
		System.out.printf("[%s]\n",k08_rpad("�ѱ�abcd",15)); // �ѱ�abcd �� �����ʿ� ������ 15�� ���̿��� �ѱ�abcd ���̸� �� ��ŭ ���� �߰�
		System.out.printf("[%s]\n",k08_rpad("�ѱ��ѱ�aa",15)); // �ѱ��ѱ�aa �� �����ʿ� ������ 15�� ���̿��� �ѱ�abcd ���̸� �� ��ŭ ���� �߰�
		System.out.printf("[%s]\n",k08_lpad("�ѱ�ab",15)); // �ѱ�ab �� ���ʿ� ������ 15�� ���̿��� �ѱ�abcd ���̸� �� ��ŭ ���� �߰�
		System.out.printf("[%s]\n",k08_lpad("�ѱ��ѱ�aa",15)); // �ѱ��ѱ�aa �� ���ʿ� ������ 15�� ���̿��� �ѱ�abcd ���̸� �� ��ŭ ���� �߰�
		System.out.printf("\n");
		String k08_korean = "�ѱ�abcd�ѱ��Դϴ�z�ݰ�����irfoz��";
		/*System.out.println(k08_korean.length()); 
		System.out.println(k08_korean.getBytes().length);*/
		// 1byte ���� Ȯ�� �� byte���� ���� ���� �� Ȯ�ο�
		System.out.printf("���ڿ� [%s] ���� �ѱ� [%s] ��",k08_korean,k08_korean.getBytes().length - k08_korean.length());
		// ��ü ���̸� ����Ʈ������ ���ϰ� �Ǹ� �ѱ� 2byte�� ���ȴ�.
		// �� ��ü ���̿��� �ܼ� length�� ���ϸ� ��� 1byte�� ����ؼ� ���Ǿ��� ���̰� �������µ�
		// �ѱ� 2byte�� ���� ��ü ���̿��� 1byte�� ���� ��ü ���̸� ���ش�
		// ��ü ���� 34 - 1byte���� 22 = 12 => ������ ���̰� �ѱ��� ���̰� �ȴ�.
		
		
	}

}
