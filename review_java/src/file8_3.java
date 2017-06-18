
/*
 * 삼성전자 주가에 대해 15년 최대,최소값(종가기준) csv파일 생성
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 * 	2017.06.01 -> 천단위 콤마 및 날짜 추가
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class file8_3 {
	public static void main(String[] args) throws IOException{
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		File f = new File("C:\\1234\\A005930.csv"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어오기
		int max = 0; // 최대값 0
		int min = 10000000; // 최소값 10000000 설정
		String max_day = null,min_day = null;
		String rt; // 읽어온 문자열 저장 변수
		long st = System.currentTimeMillis(); // 시작시간 측정
		while((rt=br.readLine()) != null){
			StringBuffer sb = new StringBuffer(); // Stringbuffer 객체 생성
			String[] field = rt.split(","); // 쉼표로 구분된 문자열 field객체에 저장
			if(field[1].trim().substring(0, 4).equals("2015")){ // field[1]의 공백제거 후 0~4번째 문자열이 2015와 일치한다면
				if ( max < Integer.parseInt(field[3])){ // 그중 field[3]의 값이 max보다 크다면
					max = Integer.parseInt(field[3]); // max는 field[3]값 교체
					max_day = field[1];
				}
				if ( min > Integer.parseInt(field[3])){ // field[3]의 값이 max보다 작다면
					min = Integer.parseInt(field[3]); // min 은 field[3]값 교체
					min_day = field[1];
				}
			}
		}
		
		System.out.printf("2015년 삼성전자 종가기준 최대값 : %s [일자 : %s]\n2015년 삼성전자 종가기준 최소값 : %s [일자 : %s]\n",df.format(max),max_day,df.format(min),min_day);
		long et = System.currentTimeMillis(); // 종료시간 측정
		
		System.out.printf("process time : [%d]sec\n",(et-st)/1000); // 최종 결과 시간 출력
	}
}

