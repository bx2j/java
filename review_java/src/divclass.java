import java.util.ArrayList;

public class divclass {
	static ArrayList<onerec> arrayonerec = new ArrayList <onerec>();
	// onerec �� ������ ������ arraylist arrayonerec
	
	static int sumkor = 0;
	static int sumeng = 0;
	static int summat = 0;
	static int sumsum = 0;
	static int sumavg = 0;
	
	static final int ip = 10;
	
	// ������ �����
	public static void dataset(){
		for (int i =0;i<ip;i++){
			String name = String.format("ȫ��%02d",i); // �̸� �����
			int kor = (int)(Math.random() * 100); // ������ �������� �����
			int eng = (int)(Math.random() * 100); // ������ �������� �����
			int mat = (int)(Math.random() * 100); // ������ �������� �����
			arrayonerec.add(new onerec(i,name,kor,eng,mat));
		}
	}
	
	//��� ���
	public static void hp(){
		System.out.printf("%s\n","��������ǥ");
		System.out.printf("%s %15s \n","PAGE : ","������� : ");
		System.out.printf("**************************************\n");
		System.out.printf("%-3.3s %-7.2s %-3.3s %-3.3s %-3.3s %-3.3s %-3.3s \n","��ȣ","�̸�","����","����","����","�հ�","���");
		System.out.printf("**************************************\n");
	}
	
	// ���� ���
	public static void itemp(int i){
		onerec rec;
		rec = arrayonerec.get(i);
		if(i>999997)
			hp();
		System.out.printf("%5d %-8.8s %3d %3d %3d %3d %6.2f\n",rec.student_id(),rec.name(),
				rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.avg());
		
		sumkor += rec.kor();
		sumeng += rec.eng();
		summat += rec.mat();
		sumsum += rec.sum();
		sumavg += rec.avg();
	}
	
	// ���� ���
	public static void tp(){
		System.out.printf("**************************************\n");
		System.out.printf("�����հ� %d ������� %6.2f\n",sumkor,sumkor/(double)arrayonerec.size());
		System.out.printf("�����հ� %d ������� %6.2f\n",sumeng,sumeng/(double)arrayonerec.size());
		System.out.printf("�����հ� %d ������� %6.2f\n",summat,summat/(double)arrayonerec.size());
		System.out.printf("**************************************\n");
		System.out.printf("������հ� %d ����� %6.2f\n",sumavg,sumavg/(double)arrayonerec.size());
		
	}
}
