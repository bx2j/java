/*
 * ���� �������� ��������ǥ
 * 2017.05.27
 * prepared by �躴��
 * 
 * ��������
 * 	���� �ۼ�
 * */
public class ppt33_1 {
	private int stu_id; // ppt33_1 class ������ int �� ����
	private String name; // ppt33_1 class ������ String �� ����
	private int kor,eng,mat; // ppt33_1 class ������ int �� ����	
	public ppt33_1(int stu_id,String name,int kor,int eng,int mat){
		this.stu_id = stu_id; // ppt33_1 class �� stu_id �� �Ķ���ͷ� �Է¹��� stu_id���� ���
		this.name = name; // ppt33_1 class �� name �� �Ķ���ͷ� �Է¹��� name���� ���
		this.kor = kor; // ppt33_1 class �� kor �� �Ķ���ͷ� �Է¹��� kor���� ���
		this.eng = eng; // ppt33_1 class �� eng �� �Ķ���ͷ� �Է¹��� eng���� ���
		this.mat = mat; // ppt33_1 class �� mat �� �Ķ���ͷ� �Է¹��� mat���� ���
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
	
	
}

