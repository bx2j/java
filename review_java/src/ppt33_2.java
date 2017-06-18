/*
 * ���� �������� ��������ǥ
 * 2017.05.27
 * prepared by �躴��
 * 
 * ��������
 * 	���� �ۼ�
 *  170529 - ���� ������ ��� ���� -> ����
 * */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ppt33_2 {
	static ArrayList<ppt33_1> aor = new ArrayList<ppt33_1>();
	// List �������̽��� ������ ArrayList ���
	// ��Ȯ�� �迭�� ũ�⸦ �� �� ���� ��� -> �������� ũ�Ⱑ ���ϴ� �������� ��Ȳ�� ���
	// ArrayList �� ����� ��ü�� Ÿ���� ppt33_1Ŭ���� �� ���� -> aor �� ��� �� �ִ� �ڷ����� ppt33_1 Ÿ�� ��
	
	static int sumkor = 0 , sumeng = 0 , summat = 0 , sumsum = 0 , sumavg = 0;
	// ��ü ��,��,��,�հ�,����� �����ϴ� ����
	static final int ip = 31;	// ��ü �л� ��
	static int current = 0; // ���� ������ �л� ��
	static int page = 1; // ���� �������� ��
	static int cp_sumkor = 0 , cp_sumeng = 0 , cp_summat = 0 , cp_sumsum = 0 , cp_sumavg = 0;
	// ���� ���������� ��,��,��,�հ�,����� �����ϴ� ����
	static int people = 0; // ���� �л� ��
	
	// data set
	public static void dataset(){
	// ��ü �л��� �� ��ŭ �ݺ��Ͽ� aor ArrayList �� ���ʴ�� Random ���� �ִ´�.
		for ( int i = 0 ; i < ip ; i++){
			String name = String.format("ȫ��%02d",i);			
			int kor = (int)(Math.random()*100); // ���� ������ �����ϴ� kor ������ 1~100 ������ ���� ������ ���� ����
			int eng = (int)(Math.random()*100); // ���� ������ �����ϴ� kor ������ 1~100 ������ ���� ������ ���� ����
			int mat = (int)(Math.random()*100); // ���� ������ �����ϴ� kor ������ 1~100 ������ ���� ������ ���� ����			
			aor.add(new ppt33_1(i,name,kor,eng,mat));
			// aor ArrayList �� id,name,kor,eng,mat �߰�
			
		}
	}
	
	// print to header
	public static void headerprint(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		
		System.out.printf("%25s\n\n","��������ǥ");
		System.out.printf("PAGE: %3d %20s : %15s\n",page,"�������",sdf.format(cal.getTime()));
		System.out.printf("********************************************************\n");
		//System.out.printf("%-6.6s %-10s %-4s %-4s %-4s %-4s %-4s\n","��ȣ","�̸�","����","����","����","�հ�","���");
		System.out.printf("%-4s %-4s %8s %4s %4s %4s  %4s\n", "��ȣ", "�̸�", "����", "����", "����", "�հ�", "���");
		System.out.printf("********************************************************\n");
	}
	
	// print to item
	public static void itemprint(int i){
		ppt33_1 rec; // ppt33_1 Ÿ���� ������ rec ���� ����, rec�� ppt33_1 ��� ����
		rec = aor.get(i); // aor ArrayList ���� i ��°�� �ε��� ���� �����ؼ� rec�� ����
		System.out.printf("%-6s %-10s %4s   %4s   %4s   %4s  %6.2f\n",	
				rec.stu_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.avg());
		sumkor += rec.kor(); // ���� ������ ��
		sumeng += rec.eng(); // ���� ������ ��
		summat += rec.mat(); // ���� ������ ��
		sumsum += rec.sum(); // ��,��,�� ��ü ��
		sumavg += rec.avg(); // ��,��,�� ���
		current++; // ���� �������� �л� �� ����
		cp_sumkor += rec.kor(); // ���� ���������� �л� ����ŭ�� ���� ���� ��
		cp_sumeng += rec.eng(); // ���� ���������� �л� ����ŭ�� ���� ���� ��
		cp_summat += rec.mat(); // ���� ���������� �л� ����ŭ�� ���� ���� ��
		cp_sumsum += rec.sum(); // ���� ���������� �л� ����ŭ�� ��,��,�� ���� ��
		cp_sumavg += rec.avg(); // ���� ���������� �л� ����ŭ�� ��,��,�� ���
		people++; // ���� ����� ���ϱ� ���� �л� �� ����
	}
	
	// print to tail
	public static void tailprint(){		
		System.out.printf("********************************************************\n");
		System.out.printf("���� ��������\n");
		System.out.printf("%-15s %6s %6s %6s %6s %7s\n","�հ�",cp_sumkor,cp_sumeng,cp_summat,cp_sumsum,cp_sumavg);
		System.out.printf("%-15s %6d %6d %6d %6d %7d\n","���",
				(cp_sumkor/current),(cp_sumeng/current),(cp_summat/current),
				(cp_sumsum/current),(cp_sumavg/current));
		// ���� ���������� ���� �������� ����ϰ��� �ϴ� �ο��� ��ŭ�� �հ�, ����� ��� �ȴ�.
		System.out.printf("********************************************************\n");
		System.out.printf("���� ��������\n");
		System.out.printf("%-15s %6s %6s %6s %6s %7s\n","�հ�",sumkor,sumeng,summat,sumsum,sumavg);
		System.out.printf("%-15s %6d %6d %6d %6d %7d\n","���",
				(sumkor/people),(sumeng/people),(summat/people),
				(sumsum/people),(sumavg/people));
		System.out.printf("********************************************************\n\n");
		// ���� ���������� ó�� ���������� ������ ����� ��µȴ� ( �� ��, �� ���)
		
		cp_sumkor = 0; // ���� �������� ������ ���� �������� �Ǵ� ���� �������� ����ϱ� ���� �ʱ�ȭ
		cp_sumeng = 0;
		cp_summat = 0;
		cp_sumsum = 0;
		cp_sumavg = 0;
		page++; // ���� �������� ����
		current = 0; // ���� �������� �л� �� �ʱ�ȭ
	}
	
	public static void main(String arg[]){
		ppt33_2.dataset(); // ������ ����
		ppt33_2.headerprint(); // ��� ���
		for ( int i = 0;i<ppt33_2.aor.size();i++){
			ppt33_2.itemprint(i); // ���� ���
			if ( (i+1) % 30 == 0){
				tailprint(); // tail ���
				// ���� �������� �հ�, ����� �ʱ�ȭ �ϰ� �ٽ� ��� 
				headerprint();
			}
		}
		ppt33_2.tailprint(); // tail ���
	}
}
