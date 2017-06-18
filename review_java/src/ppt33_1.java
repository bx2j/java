/*
 * 여러 페이지의 성적집계표
 * 2017.05.27
 * prepared by 배병주
 * 
 * 수정사항
 * 	최초 작성
 * */
public class ppt33_1 {
	private int stu_id; // ppt33_1 class 내부의 int 형 변수
	private String name; // ppt33_1 class 내부의 String 형 변수
	private int kor,eng,mat; // ppt33_1 class 내부의 int 형 변수	
	public ppt33_1(int stu_id,String name,int kor,int eng,int mat){
		this.stu_id = stu_id; // ppt33_1 class 의 stu_id 은 파라미터로 입력받은 stu_id값을 사용
		this.name = name; // ppt33_1 class 의 name 은 파라미터로 입력받은 name값을 사용
		this.kor = kor; // ppt33_1 class 의 kor 은 파라미터로 입력받은 kor값을 사용
		this.eng = eng; // ppt33_1 class 의 eng 은 파라미터로 입력받은 eng값을 사용
		this.mat = mat; // ppt33_1 class 의 mat 은 파라미터로 입력받은 mat값을 사용
	}
	
	public int stu_id(){ // stu_id() 호출시 stu_id 반환
		return this.stu_id;
	}
	public String name(){ // name() 호출시 name 반환
		return name;
	}
	public int kor(){ // kor() 호출시 kor 반환
		return kor;
	}
	public int eng(){ // eng() 호출시 eng 반환
		return eng;
	}
	public int mat(){ // mat() 호출시 mat 반환
		return mat;
	}
	public int sum(){ // sum() 호출시 sum 반환
		return this.kor + this.eng + this.mat; // sum = kor + eng + mat
	}
	public double avg(){ // avg() 호출시 avg 반환
		return this.sum()/3.0; // avg = sum (kor+eng+mat) / 3.0 (double)
	}
	
	
}

