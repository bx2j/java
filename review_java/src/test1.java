/* 
 * 배열에 저장된(이마트 영수증 출력 내용) 금액의 합계가 일치하는지 확인하는 합계검증program 
 * 2017.05.25
 * prepared by 배병주  
 * 
 * 수정사항
 * 	최초 작성
 */

import java.text.DecimalFormat;

public class test1 {
	public static void main(String args[]){
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3자리마다 콤마(,) 를 찍기 위해 DecimalFormat 사용
		// ### (3자리마다) , (콤마를 찍어라) => 없으면 자릿수 안채움
		String[] k08_arr = {
				"01    초코파이                  2,500             1          2,500",
				"02    몽쉘 * 3박스              1,200             3          3,600",
				"03*   하우스 귤1.3kg            3,000             5         15,000",
				"04    포도맛주스5L 200          5,000             7         35,000",
				"05    포도맛 오렌지주스       129,000             3        387,000",
				"06    초코에몽                  3,000             2          6,000",
				"07    우유우 유우유우유         3,600             1          3,600",
				"08    초코우유                  6,000             8        148,000",
				"09    water                     7,000             9         63,000",
				"10    빵                        8,000             7         56,000",
				"11    포카칩 35개들이           3,000         1,500    114,500,000",
				"12*   당근                        520             1            520",
				"13*   사과                        400             3          1,200",
				"14*   france-포도               6,000             2         12,000",
				"15    바나나 맛 아이스          2,033             8         16,264",
				"16    양념치킨 3000인분        19,000             9        271,000",
				"17    휴지                      4,000             7         28,000",
				"18    냄비                      2,000             4          8,000",
				"19    후라이팬                  1,000             5          5,000",
				"20    치약                      3,000             1          3,000",
				"21*   배추김치                  2,000             6         12,000",
				"22*   블루베리                  1,000             4          4,000",
				"23*   여름엔 수박               3,000             7         21,000",
				"24*   빨간색 딸기               5,000             8         40,000",
				"25*   보라색 가지               4,000            10         40,000",
				"26    칫솔                      3,000            20         60,000",
				"27    샴푸                          2             4            218",
				"28    바디워시              1,219,000             7      8,533,000",
				"29    폼클렌징                  7,000             4         28,000",
				"30    로션                     10,000             3         30,000",
		};
		
		byte[] k08_bb = new byte[k08_arr.length];
		// String 형태의 문자열을 byte로 변환하기 위해 k08_arr.length의 길이를 갖는 byte배열 선언
		
		for (int k08_i=0;k08_i<k08_arr.length;k08_i++){ // 배열의 길이만큼 반복 수행
			k08_bb = k08_arr[k08_i].getBytes(); // byte배열 bb에 k08_arr 배열의 각 항목들을 byte로 변환하여 저장
			
			String k08_price = new String(k08_bb,28,10); // 상품 가격
			// byte로 변환된 k08_arr[k08_i]번째의 항목중에서 28byte 부터 10byte까지를 String 형으로 간주한다.
			int k08_Iprice = Integer.parseInt(k08_price.trim().replaceAll(",", ""));
			// String 형태의 가격정보를 저장한 k08_price 변수에서 양 옆의 공백을 제거하고(trim) 콤마를 제거한다(replaceAll)
			//System.out.printf("%s\n",k08_price.trim().replaceAll(",", "")); 
			// 정상 출력 확인용
			
			String k08_num = new String(k08_bb,46,5); // 상품 개수
			// byte로 변환된 k08_arr[k08_i]번째의 항목중에서 46byte 부터 5byte까지 String 형으로 간주한다.
			int k08_Inum = Integer.parseInt(k08_num.trim().replaceAll(",", ""));
			// String 형태의 상품 개수정보를 저장한 k08_num 변수에서 양 옆의 공백을 제거하고(trim) 콤마를 제거한다(replaceAll)
			//System.out.printf("%s\n",k08_num.trim().replaceAll(",", ""));
			// 정상 출력 확인용			
			
			String k08_sum = new String(k08_bb,51,15); // 총 합계
			// byte로 변환된 k08_arr[k08_i]번째의 항목중에서 51byte 부터 15byte까지 String 형으로 간주한다.
			int k08_Isum = Integer.parseInt(k08_sum.trim().replaceAll(",", ""));
			// String 형태의 상품 가격정보를 저장한 k08_sum 변수에서 양 옆의 공백을 제거하고(trim) 콤마를 제거한다(replaceAll)
			// 정상 가격과 비교 용도로 사용
			
			if ( k08_Isum != (k08_Iprice*k08_Inum)){ // 정상적인 가격과 오류가 생긴 가격 비교 ( 같지 않다면 )
				System.out.printf("************************************************************************\n");
				System.out.printf("오류[%s]\n",k08_arr[k08_i]); // 배열에서 가격 정보가 이상한 배열의 값을 출력한다.
				System.out.printf("수정[%s %10s] \n",new String(k08_bb,0,55) , k08_df.format(k08_Iprice*k08_Inum)); 
				// 상품 개수까지 기존 배열에서 출력하고, 정상적인 값을 계산해준다.
				// 정상적인 값을 계산하고 세자리마다 콤마를 찍어주기 위해 k08_df.format 사용
				System.out.printf("************************************************************************\n");
			}
		}
	}
}
