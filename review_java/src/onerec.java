/*
 * 클래스의 배열
 * onerec.java => onerec class 존재
 * 2017.05.26
 * prepared by 배병주
 * 
 * 수정사항
 * 	최초 작성
 *  오후 1시 이후 student_id 추가
 */
public class onerec {
	private int student_id;
	private String name;
	private int kor;
	private int eng;
	private int mat;	
	
	public onerec(int student_id,String name,int kor,int eng,int mat){ // 생성자 
		this.student_id = student_id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public int student_id(){
		return this.student_id;
	}
	public String name(){
		return this.name;
	}
	public int kor(){
		return this.kor;
	}
	public int eng(){
		return this.eng;
	}
	public int mat(){
		return this.mat;
	}
	public int sum(){
		return this.kor+this.eng+this.mat;
	}
	public double avg(){
		return this.sum()/5.0;
	}
	
}
