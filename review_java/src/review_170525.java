/* 
 * 좌/우 공백 채우기, 문자열에서 한글 개수 찾기 program 
 * 2017.05.25
 * prepared by 배병주  
 * 
 * 수정사항
 * 	최초 작성
 */
import java.util.regex.Pattern;

public class review_170525 {
	public static String k08_rpad(String k08_str, int k08_size) { // 문자열과 총 길이 입력받는다
        for(int k08_i = (k08_str.getBytes()).length; k08_i < k08_size; k08_i++) { 
        	// 입력받은 문자열의 바이트 길이를 구하고, 입력받은 길이만큼 반복을 하면서
            k08_str += " "; // 문자열의 오른쪽에 공백을 채워넣는다.
        }
        return k08_str; // 반복문 종료 후 공백을 채운 문자열 반환
    }

	public static String k08_lpad(String k08_str, int k08_size) { // 문자열과 총 길이 입력받는다
        for(int k08_i = (k08_str.getBytes()).length; k08_i < k08_size; k08_i++) { 
        	// 입력받은 문자열의 바이트 길이를 구하고, 입력받은 길이만큼 반복을 하면서
            k08_str = " " + k08_str; // 문자열의 왼쪽에 공백을 채워넣는다.
        }
        return k08_str; // 반복문 종료 후 공백을 채운 문자열 반환
    }

	public static void main(String args[]){
		System.out.printf("[%s]\n",k08_rpad("한글abcd",15)); // 한글abcd 의 오른쪽에 지정한 15의 길이에서 한글abcd 길이를 뺀 만큼 공백 추가
		System.out.printf("[%s]\n",k08_rpad("한글한글aa",15)); // 한글한글aa 의 오른쪽에 지정한 15의 길이에서 한글abcd 길이를 뺀 만큼 공백 추가
		System.out.printf("[%s]\n",k08_lpad("한글ab",15)); // 한글ab 의 왼쪽에 지정한 15의 길이에서 한글abcd 길이를 뺀 만큼 공백 추가
		System.out.printf("[%s]\n",k08_lpad("한글한글aa",15)); // 한글한글aa 의 왼쪽에 지정한 15의 길이에서 한글abcd 길이를 뺀 만큼 공백 추가
		System.out.printf("\n");
		String k08_korean = "한글abcd한글입니다z반가워요irfozㅏ";
		/*System.out.println(k08_korean.length()); 
		System.out.println(k08_korean.getBytes().length);*/
		// 1byte 길이 확인 및 byte단위 길이 측정 및 확인용
		System.out.printf("문자열 [%s] 에서 한글 [%s] 개",k08_korean,k08_korean.getBytes().length - k08_korean.length());
		// 전체 길이를 바이트단위로 구하게 되면 한글 2byte로 계산된다.
		// 그 전체 길이에서 단순 length를 구하면 모두 1byte로 취급해서 계산되어진 길이가 구해지는데
		// 한글 2byte로 계산된 전체 길이에서 1byte로 계산된 전체 길이를 빼준다
		// 전체 길이 34 - 1byte길이 22 = 12 => 나머지 길이가 한글의 길이가 된다.
		
		
	}

}
