import java.util.ArrayList;

public class divclass {
	static ArrayList<onerec> arrayonerec = new ArrayList <onerec>();
	// onerec 를 가지고 생성한 arraylist arrayonerec
	
	static int sumkor = 0;
	static int sumeng = 0;
	static int summat = 0;
	static int sumsum = 0;
	static int sumavg = 0;
	
	static final int ip = 10;
	
	// 데이터 만들기
	public static void dataset(){
		for (int i =0;i<ip;i++){
			String name = String.format("홍길%02d",i); // 이름 만들기
			int kor = (int)(Math.random() * 100); // 임의의 국어점수 만들기
			int eng = (int)(Math.random() * 100); // 임의의 영어점수 만들기
			int mat = (int)(Math.random() * 100); // 임의의 수학점수 만들기
			arrayonerec.add(new onerec(i,name,kor,eng,mat));
		}
	}
	
	//헤더 출력
	public static void hp(){
		System.out.printf("%s\n","성적집계표");
		System.out.printf("%s %15s \n","PAGE : ","출력일자 : ");
		System.out.printf("**************************************\n");
		System.out.printf("%-3.3s %-7.2s %-3.3s %-3.3s %-3.3s %-3.3s %-3.3s \n","번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("**************************************\n");
	}
	
	// 내용 출력
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
	
	// 테일 출력
	public static void tp(){
		System.out.printf("**************************************\n");
		System.out.printf("국어합계 %d 국어평균 %6.2f\n",sumkor,sumkor/(double)arrayonerec.size());
		System.out.printf("영어합계 %d 영어평균 %6.2f\n",sumeng,sumeng/(double)arrayonerec.size());
		System.out.printf("수학합계 %d 수학평균 %6.2f\n",summat,summat/(double)arrayonerec.size());
		System.out.printf("**************************************\n");
		System.out.printf("반평균합계 %d 반평균 %6.2f\n",sumavg,sumavg/(double)arrayonerec.size());
		
	}
}
