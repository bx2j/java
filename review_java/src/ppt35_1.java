/*
 * ArrayList sort 성적집계표 Class 배열 생성
 * 2017.05.27
 * prepared by 배병주
 * 
 * 수정사항
 * 	최초 작성
 * */
import java.util.Collections;
import java.util.Comparator;

public class ppt35_1 {
	private int stu_id; // ppt35_1 class 내부의 int 형 변수
	private String name; // ppt35_1 class 내부의 String 형 변수
	private int kor,eng,mat; // ppt35_1 class 내부의 int 형 변수	
	public ppt35_1(int stu_id,String name,int kor,int eng,int mat){
		this.stu_id = stu_id; // ppt35_1 class 의 stu_id 은 파라미터로 입력받은 stu_id값을 사용
		this.name = name; // ppt35_1 class 의 name 은 파라미터로 입력받은 name값을 사용
		this.kor = kor; // ppt35_1 class 의 kor 은 파라미터로 입력받은 kor값을 사용
		this.eng = eng; // ppt35_1 class 의 eng 은 파라미터로 입력받은 eng값을 사용
		this.mat = mat; // ppt35_1 class 의 mat 은 파라미터로 입력받은 mat값을 사용
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
	public static void datasort(){
		Comparator<ppt35_1> aa = new Comparator<ppt35_1>() {
		// 비교 대상 정의
			@Override // compare 메소드 오버로딩 ( 재정의 )
			public int compare(ppt35_1 o1, ppt35_1 o2) {
				return (o2.sum() - o1.sum());
				// 뒷 레코드의 합계에서 앞 레코드의 합을 빼주었을 때, 1이되면 오름차순이 된다 (양수)
				// return 값이 1이라면 뒷 레코드가 큰 값 (오름차순)
				// return 값이 -1 이면 뒷 레코드가 작은 값 (내림차순) => o1 - o2 하면 내림차순이 된다.
			}
		};
		Collections.sort(ppt35_2.aor,aa);
		// sort 대상 , Comparator 이름 대로 정렬 수행 ( 오름차순 )
	}
	
}
