/*
 * 거리 계산
 * 2017.05.31
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 * 	2017.06.01 -> 기준점 융기원으로 변경
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class file4 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국무료와이파이표준데이터2.txt"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어오기
		String readtxt; // 파일에서 읽어온 문자열 저장하는 변수
		if((readtxt = br.readLine()) == null) // 문자열이 없다면
			System.out.printf("빈 파일입니다\n"); // 빈 파일
		String[] field_name = readtxt.split("\t"); // 가장 처음은 파일의 헤더이다. 탭으로 구분
		
		// 현재 위치 (융합기술교육원)
		double lat = 37.385842;
		double lng = 127.121274;
		
		// 35.518215, 129.425293 우리집
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		
		//int cnt = 0; // 건수 측정 변수
		int i = 0,j = 0,k = 0; // 거리 저장하는 변수, for문을 위한 변수들 선언
		double max = 0; // 최대값 변수
		int maxp = 0; // 최대값 인덱스
		double min = 0; // 최소값 변수
		int minp = 0; // 최소값 인덱스
		double[] d = new double[14827]; // 최대 , 최소를 구할 거리를 저장할 배열
		String[] fi = new String[14829]; // 필드이름 저장할 배열
		while((readtxt = br.readLine())!=null){ // 내용이 있을동안 반복
			String[] field = readtxt.split("\t"); // 읽어온 데이터들을 탭으로 구분하여 field 배열에 저장
			//System.out.printf("[%d]번째 항목",cnt);
			//System.out.printf(" %s : %s",field_name[9],field[9]); // 지번 주소
			//System.out.printf(" %s : %s",field_name[12],field[12]); // 위도
			//System.out.printf(" %s : %s",field_name[13],field[13]); // 경도
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[12])-lat,2) + 
						Math.pow(Double.parseDouble(field[13])-lng, 2));
			// 두 점의 거리 계산
			// 루트(sqrt) (a^2 + b^2)(pow)
			fi[i] = field[9]; // 지번주소 저장(외부에서 활용)
			d[i] = dist; // 거리를 배열에 저장	
			i++; // 인덱스 증가
			//cnt++;
		}		
		max = d[0]; // 최대값에 거리배열의 첫 값 저장
		min = d[0]; // 최소값에 거리배열의 첫 값 저장
		maxp = 0; // 최대값 인덱스에 처음 인덱스 저장
		minp = 0; // 최소값 인덱스에 처음 인덱스 저장
		
		for(j=0;j<d.length;j++){ // 거리 배열의 길이만큼 반복
			if(max < d[j]){ // 현재 저장되어 있는 최대값이 다음 값보다 작다면
				max = d[j]; // 값 교체
				maxp = j; // 인덱스 교체
			}			
		}
		for(k=0;k<d.length;k++){ // 거리 배열의 길이만큼 반복
			if(min>d[k]){ // 현재 저장되어 있는 최소값이 다음 값보다 크다면
				min = d[k]; // 값 교체
				minp = k; // 인덱스 교체
			}
		}		
		System.out.printf("최장거리 주차장 %s %f \n최단거리 주차장 %s %f",fi[j],max,fi[k],min);		
		br.close();
	}
}

