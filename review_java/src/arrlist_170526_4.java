import java.util.ArrayList;

public class arrlist_170526_4 {
	public static void main(String args[]){
		ArrayList al = new ArrayList(); // ArrayList ����
		
		al.add("abb"); // Arraylist �׸� �߰� �� �� add ���
		al.add("cdnz");
		al.add("grge");
		al.add("fdqe");
		//al.add(123124);
		// ���ڴ� �ʱ⿡ add�� �־��� ���� �ִµ� sort�� �� �ȸ�����
		al.add("adsf");
		al.add("1234");
		//al.add(123);
		System.out.printf("*********************\n");
		System.out.printf("���� ArraySize [%d] \n",al.size());
		// �迭�� �ٸ��� ArrayList �� .size() �� ���� Ȯ�ΰ���
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.set(3, "llll"); // 3�� ArrayList �� ������ ����
		System.out.printf("*********************\n");
		System.out.printf("���뺯�� ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.sort(null); // 
		System.out.printf("*********************\n");
		System.out.printf("sort ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
		
		al.clear(); // ArrayList �ʱ�ȭ
		System.out.printf("*********************\n");
		System.out.printf("clear_all ArraySize [%d] \n",al.size());
		for (int i =0;i<al.size();i++)
			System.out.printf("ArrayList [%d] = %s\n",i,al.get(i));
	}
}
