/*
 * ArrayList sort ��������ǥ Class �迭 ����
 * 2017.05.27
 * prepared by �躴��
 * 
 * ��������
 * 	���� �ۼ�
 * */
import java.util.Collections;
import java.util.Comparator;

public class ppt35_1 {
	private int stu_id; // ppt35_1 class ������ int �� ����
	private String name; // ppt35_1 class ������ String �� ����
	private int kor,eng,mat; // ppt35_1 class ������ int �� ����	
	public ppt35_1(int stu_id,String name,int kor,int eng,int mat){
		this.stu_id = stu_id; // ppt35_1 class �� stu_id �� �Ķ���ͷ� �Է¹��� stu_id���� ���
		this.name = name; // ppt35_1 class �� name �� �Ķ���ͷ� �Է¹��� name���� ���
		this.kor = kor; // ppt35_1 class �� kor �� �Ķ���ͷ� �Է¹��� kor���� ���
		this.eng = eng; // ppt35_1 class �� eng �� �Ķ���ͷ� �Է¹��� eng���� ���
		this.mat = mat; // ppt35_1 class �� mat �� �Ķ���ͷ� �Է¹��� mat���� ���
	}
	
	public int stu_id(){ // stu_id() ȣ��� stu_id ��ȯ
		return this.stu_id;
	}
	public String name(){ // name() ȣ��� name ��ȯ
		return name;
	}
	public int kor(){ // kor() ȣ��� kor ��ȯ
		return kor;
	}
	public int eng(){ // eng() ȣ��� eng ��ȯ
		return eng;
	}
	public int mat(){ // mat() ȣ��� mat ��ȯ
		return mat;
	}
	public int sum(){ // sum() ȣ��� sum ��ȯ
		return this.kor + this.eng + this.mat; // sum = kor + eng + mat
	}
	public double avg(){ // avg() ȣ��� avg ��ȯ
		return this.sum()/3.0; // avg = sum (kor+eng+mat) / 3.0 (double)
	}
	public static void datasort(){
		Comparator<ppt35_1> aa = new Comparator<ppt35_1>() {
		// �� ��� ����
			@Override // compare �޼ҵ� �����ε� ( ������ )
			public int compare(ppt35_1 o1, ppt35_1 o2) {
				return (o2.sum() - o1.sum());
				// �� ���ڵ��� �հ迡�� �� ���ڵ��� ���� ���־��� ��, 1�̵Ǹ� ���������� �ȴ� (���)
				// return ���� 1�̶�� �� ���ڵ尡 ū �� (��������)
				// return ���� -1 �̸� �� ���ڵ尡 ���� �� (��������) => o1 - o2 �ϸ� ���������� �ȴ�.
			}
		};
		Collections.sort(ppt35_2.aor,aa);
		// sort ��� , Comparator �̸� ��� ���� ���� ( �������� )
	}
	
}
