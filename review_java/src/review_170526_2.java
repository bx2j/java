/*
 * 배열의 최대, 최소값 찾기
 * 2017.05.26
 * prepared by 배병주
 * 
 * 수정사항
 * 	최초 작성
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class review_170526_2 {
	public static void main(String args[]) throws Exception{
		int[] iArr = {1,7,5,3,2,5,3,4,9,12,4,212,33,11,21,11,2121,121,11,5,6,33};
		for ( int i =0;i<iArr.length;i++)
			System.out.printf("iArr[%d] = %d\n",i,iArr[i]);
		// iArr배열 처음부터 차례대로 찍어준다. 
		// 배열은 0부터 시작, iArr.length로 배열의 길이를 알 수 있다.
		
		int iMax = iArr[0]; // 시작은 배열의 처음 값으로 설정 (1)
		int iMaxp = 0; 	 // 최대값이 위치한 배열의 위치 인덱스
		for (int i=0;i<iArr.length;i++){
			if(iMax<iArr[i]){ 	// 기존에 들어가있는 값 (1)이 배열에 들어간 값보다 작다면
				iMax = iArr[i]; // 최대값이 아니니까 기존 값은 새로운 최대값으로 교체하고
				iMaxp = i; 		// 최대값이 위치한 배열의 위치 인덱스도 변경해준다
			}
		}
		System.out.printf("***************\n");
		System.out.printf("iArr[%d] = %d \n",iMaxp,iMax); 
		// 최대값이 들어있는 배열의 인덱스와 최대값 출력
		 
		// 최소값은 if (iMax > iArr[i] 로 부등호방향을 바꿔준다.
	}
}
