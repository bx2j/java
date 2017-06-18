/*
 * 특정 위치에서 가장 가까운 주차장과 먼 주차장 찾기
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

public class file4_1 {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\1234\\전국주차장표준데이터.txt"); // 파일 확인
		BufferedReader br = new BufferedReader(new FileReader(f)); // 파일 읽어오기
		String readtxt; // 파일에서 읽어온 문자열 저장하는 변수
		if((readtxt = br.readLine()) == null) // 문자열이 없다면
			System.out.printf("빈 파일입니다\n"); // 빈 파일
		String[] field_name = readtxt.split("\t"); // 탭으로 구분하여 읽어온 문자열 저장
		
		// 현재 위치 (융합기술교육원)
		double lat = 37.385842;
		double lng = 127.121274;
		
		// 35.518215, 129.425293 우리집
		/*double lat = 35.518215;
		double lng = 129.425293;*/
		
		int i = 0,j = 0,k = 0; // 거리 저장하는 변수, 밥녹을 위한 변수들 선언
		double max = 0; // 최대값 변수
		int maxp = 0; // 최대값 인덱스
		double min = 100; // 최소값 변수
		int minp = 0; // 최소값 인덱스
		double[] d = new double[14000]; // 거리 저장할 배열 선언
		String[] fi = new String[13441]; // 필드 명 저장할 배열
		double dist = 0; // 거리 변수
		while((readtxt = br.readLine())!=null){
			String[] field = readtxt.split("\t");			
			if(field.length < 33){ // 탭으로 저장된 배열의 길이가 33이하라면
				// 위,경도값이 없는 필드들
			}
			else{
				if( !(field[31].equals("")) && !(field[32].equals("")) ){
					// 두 점의 거리 계산
					// 루트(sqrt) (a^2 + b^2)(pow)
					dist = Math.sqrt ( Math.pow(Double.parseDouble(field[31])-lat,2) + 
								Math.pow(Double.parseDouble(field[32])-lng, 2));
					d[i] = dist; // 구한 거리를 배열에 저장
					if(max < d[j]){ // 현재 저장되어 있는 최대값이 다음 값보다 작다면
						max = d[j]; // 값 교체
						maxp = j; // 인덱스 교체
					}	
					if(min > d[k]){ // 현재 저장되어 있는 최소값이 다음 값보다 크다면
						min = d[k]; // 값 교체
						minp = k; // 인덱스 교체
					}
				}
			}			
			fi[i] = field[1]; // 주차장 이름 저장	 			
			i++; // 거리배열의 인덱스값 증가
			j++; // 최대를 위한 인덱스값 증가
			k++; // 최소를 위한 인덱스값 증가
		}		
	
		System.out.printf("최장거리 주차장 %s %f \n최단거리 주차장 %s %f",fi[maxp],max,fi[minp],min);	
		br.close();
	}
}

