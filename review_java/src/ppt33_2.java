/*
 * 여러 페이지의 성적집계표
 * 2017.05.27
 * prepared by 배병주
 * 
 * 수정사항
 * 	최초 작성
 *  170529 - 누적 페이지 평균 에러 -> 수정
 * */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ppt33_2 {
	static ArrayList<ppt33_1> aor = new ArrayList<ppt33_1>();
	// List 인터페이스를 구현한 ArrayList 사용
	// 명확한 배열의 크기를 알 수 없는 경우 -> 동적으로 크기가 변하는 가변적인 상황에 사용
	// ArrayList 가 사용할 객체의 타입을 ppt33_1클래스 로 정의 -> aor 에 담길 수 있는 자료형은 ppt33_1 타입 뿐
	
	static int sumkor = 0 , sumeng = 0 , summat = 0 , sumsum = 0 , sumavg = 0;
	// 전체 국,영,수,합계,평균을 저장하는 변수
	static final int ip = 31;	// 전체 학생 수
	static int current = 0; // 현재 페이지 학생 수
	static int page = 1; // 현재 페이지의 수
	static int cp_sumkor = 0 , cp_sumeng = 0 , cp_summat = 0 , cp_sumsum = 0 , cp_sumavg = 0;
	// 현재 페이지별로 국,영,수,합계,평균을 저장하는 변수
	static int people = 0; // 누적 학생 수
	
	// data set
	public static void dataset(){
	// 전체 학생의 수 만큼 반복하여 aor ArrayList 에 차례대로 Random 값을 넣는다.
		for ( int i = 0 ; i < ip ; i++){
			String name = String.format("홍길%02d",i);			
			int kor = (int)(Math.random()*100); // 국어 점수를 저장하는 kor 변수에 1~100 사이의 값을 가지는 점수 저장
			int eng = (int)(Math.random()*100); // 영어 점수를 저장하는 kor 변수에 1~100 사이의 값을 가지는 점수 저장
			int mat = (int)(Math.random()*100); // 수학 점수를 저장하는 kor 변수에 1~100 사이의 값을 가지는 점수 저장			
			aor.add(new ppt33_1(i,name,kor,eng,mat));
			// aor ArrayList 에 id,name,kor,eng,mat 추가
			
		}
	}
	
	// print to header
	public static void headerprint(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		
		System.out.printf("%25s\n\n","성적집계표");
		System.out.printf("PAGE: %3d %20s : %15s\n",page,"출력일자",sdf.format(cal.getTime()));
		System.out.printf("********************************************************\n");
		//System.out.printf("%-6.6s %-10s %-4s %-4s %-4s %-4s %-4s\n","번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("%-4s %-4s %8s %4s %4s %4s  %4s\n", "번호", "이름", "국어", "영어", "수학", "합계", "평균");
		System.out.printf("********************************************************\n");
	}
	
	// print to item
	public static void itemprint(int i){
		ppt33_1 rec; // ppt33_1 타입을 가지는 rec 변수 생성, rec는 ppt33_1 사용 가능
		rec = aor.get(i); // aor ArrayList 에서 i 번째의 인덱스 값을 추출해서 rec에 저장
		System.out.printf("%-6s %-10s %4s   %4s   %4s   %4s  %6.2f\n",	
				rec.stu_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.avg());
		sumkor += rec.kor(); // 국어 점수의 합
		sumeng += rec.eng(); // 영어 점수의 합
		summat += rec.mat(); // 수학 점수의 합
		sumsum += rec.sum(); // 국,영,수 전체 합
		sumavg += rec.avg(); // 국,영,수 평균
		current++; // 현재 페이지의 학생 수 증가
		cp_sumkor += rec.kor(); // 현재 페이지에서 학생 수만큼의 국어 점수 합
		cp_sumeng += rec.eng(); // 현재 페이지에서 학생 수만큼의 영어 점수 합
		cp_summat += rec.mat(); // 현재 페이지에서 학생 수만큼의 수학 점수 합
		cp_sumsum += rec.sum(); // 현재 페이지에서 학생 수만큼의 국,영,수 점수 합
		cp_sumavg += rec.avg(); // 현재 페이지에서 학생 수만큼의 국,영,수 평균
		people++; // 누적 평균을 구하기 위해 학생 수 증가
	}
	
	// print to tail
	public static void tailprint(){		
		System.out.printf("********************************************************\n");
		System.out.printf("현재 페이지의\n");
		System.out.printf("%-15s %6s %6s %6s %6s %7s\n","합계",cp_sumkor,cp_sumeng,cp_summat,cp_sumsum,cp_sumavg);
		System.out.printf("%-15s %6d %6d %6d %6d %7d\n","평균",
				(cp_sumkor/current),(cp_sumeng/current),(cp_summat/current),
				(cp_sumsum/current),(cp_sumavg/current));
		// 현재 페이지에는 현재 페이지에 출력하고자 하는 인원수 만큼의 합계, 평균이 출력 된다.
		System.out.printf("********************************************************\n");
		System.out.printf("누적 페이지의\n");
		System.out.printf("%-15s %6s %6s %6s %6s %7s\n","합계",sumkor,sumeng,summat,sumsum,sumavg);
		System.out.printf("%-15s %6d %6d %6d %6d %7d\n","평균",
				(sumkor/people),(sumeng/people),(summat/people),
				(sumsum/people),(sumavg/people));
		System.out.printf("********************************************************\n\n");
		// 누적 페이지에는 처음 페이지부터 누적된 결과가 출력된다 ( 총 합, 총 평균)
		
		cp_sumkor = 0; // 현재 페이지가 끝나면 다음 페이지가 되는 현재 페이지를 계산하기 위해 초기화
		cp_sumeng = 0;
		cp_summat = 0;
		cp_sumsum = 0;
		cp_sumavg = 0;
		page++; // 현재 페이지수 증가
		current = 0; // 현재 페이지의 학생 수 초기화
	}
	
	public static void main(String arg[]){
		ppt33_2.dataset(); // 데이터 세팅
		ppt33_2.headerprint(); // 헤더 출력
		for ( int i = 0;i<ppt33_2.aor.size();i++){
			ppt33_2.itemprint(i); // 내용 출력
			if ( (i+1) % 30 == 0){
				tailprint(); // tail 출력
				// 현재 페이지의 합계, 평균을 초기화 하고 다시 계산 
				headerprint();
			}
		}
		ppt33_2.tailprint(); // tail 출력
	}
}
