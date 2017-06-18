/* 
 * 항목이 두개인 영수증 출력 form 
 * 2017.05.24
 * prepared by 배병주  
 * 
 * 수정사항
 * 	println / printf 혼용 => printf 통일
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class twoproduct {
	public static void main(String args[]){
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3자리마다 콤마(,) 를 찍기 위해 DecimalFormat 사용
		// ### (3자리마다) , (콤마를 찍어라) => 없으면 자릿수 안채움
		Calendar k08_cal = Calendar.getInstance(); // Calendar 클래스는 현재 시간을 가져옴
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		// 4자리 년도/월/일 형식으로 현재 시간의 출력 포맷 지정
		SimpleDateFormat k08_sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
		// 4자리 년도월일시분초 의 형식으로 현재 시간의 출력 포맷 지정
		SimpleDateFormat k08_sdf4 = new SimpleDateFormat("yyyyMMdd HHmmss");
		// 4자리 년도월일 시분초 의 형식으로 현재 시간의 출력 포맷 지정
		String k08_item1 = "풀무원샘물",k08_item2 = "바나나요구르트(바나나요구르트맛)";
		// 품목 이름 "풀무원샘물" / "바나나요구르트(바나나맛요구르트맛)" 선언
		String k08_itemcode1 = "8809169718205",k08_itemcode2 = "8809169213444";
		// 품목 코드 "8809169718205" (풀무원샘물) / "8809169213444"(바나나요구르트(바나나요구르트맛)) 선언
		int k08_price1 = 600,k08_price2 = 600;
		// 품목 가격 600원 (풀무원샘물 / 바나나요구르트(바나나요구르트맛)) 
		int k08_num1 = 1,k08_num2 = 5;
		// 품목 수량 풀무원샘물 1개 / 바나나요구르트(바나나요구르트맛) 5개
		int k08_sum = (k08_price1*k08_num1) + (k08_price2*k08_num2);
		// 품목 합계 계산 = 풀무원샘물 가격 * 풀무원샘물 수량 + 바나나요구르트(바나나요구르트맛) 가격 * 바나나요구르트(바나나요구르트맛) 수량
		int k08_tax = (int)(k08_sum/1.1);
		// (총 금액) / (1+(세금/100.0)) 을 간단히 표현한 세금계산식 		
		System.out.printf("충주(양평)휴게소\n충북충주시가금면용전리380-4\n최병권 677-85-00239 TEL:043-857-9229");
		System.out.printf("\n");
		System.out.printf("\n");
		System.out.printf("[정상등록]" + k08_sdf4.format(k08_cal.getTime())); // 영수증 상에서 4자리 년도월일 시분초 의 형식으로 현재 시간 출력
		System.out.printf("%20s\n","POS번호 : 0002");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("%s %15s %5s %10s\n","품목코드","단가","수량","금액");
		System.out.printf("-----------------------------------------------\n");			
		System.out.printf("%-13.13s\n",k08_item1); // 13자리 넘어가면 짤리게 설정
		System.out.printf("%s %11s %7.7s %13.13s\n",k08_itemcode1,k08_df.format(k08_price1),k08_df.format(k08_num1),(k08_df.format(k08_price1*k08_num1)));
		// 품목 코드, 천단위 콤마 포맷 적용한 가격, 천단위 콤마 포맷 적용한 수량, 천단위 콤마 포맷 적용한 가격*수량 = 총합
		System.out.printf("%-13.13s\n",k08_item2); // 13자리 넘어가면 짤리게 설정
		System.out.printf("%s %11s %7.7s %13.13s\n",k08_itemcode2,k08_df.format(k08_price2),k08_df.format(k08_num2),(k08_df.format(k08_price2*k08_num2)));
		// 품목 코드, 천단위 콤마 포맷 적용한 가격, 천단위 콤마 포맷 적용한 수량, 천단위 콤마 포맷 적용한 가격*수량 = 총합
		System.out.printf("\n");
		System.out.printf("%-10s %30s\n","과세 물품 합계",k08_df.format(k08_tax)); 
		// 왼쪽으로 10자리 정렬, 오른쪽으로 30자리 정렬 , 3자리마다 콤마 찍기 위한 format 설정 , 과세 계산
		System.out.printf("%-10s %32s\n","부    가    세",k08_df.format(k08_sum-k08_tax)); 
		// 왼쪽으로 10자리 정렬, 오른쪽으로 30자리 정렬 , 3자리마다 콤마 찍기 위한 format 설정 , 부가세 계산 
		System.out.printf("%-10s %32s\n","합          계",k08_df.format(k08_sum)); 
		// 왼쪽으로 10자리 정렬, 오른쪽으로 30자리 정렬 , 3자리마다 콤마 찍기 위한 format 설정 , 품목 합계 계산
		System.out.printf("%-10s %31s\n","026-비씨카드사","00/00A");
		System.out.printf("%-10s %29s\n","카  드  번  호 : ","5522-2012-5541-BADD");
		System.out.printf("%-10s %29s\n","카  드  매  출 : ",k08_df.format(k08_sum)); 
		// 왼쪽으로 10자리 정렬, 오른쪽으로 30자리 정렬 , 3자리마다 콤마 찍기 위한 format 설정 , 품목 합계 계산 => 총 결제 할 금액
		System.out.printf("%-15s %24s\n","거  래  구  분 : ","일시불");
		System.out.printf("%-10s %22s\n","승  인  번  호 : 04-KICC","75549250");
		System.out.printf("%-10s %29s\n","가 맹 점 번 호 : ","");
		System.out.printf("%-10s %29s\n","받  은  금  액 : ",k08_df.format(k08_sum)); 
		// 왼쪽으로 10자리 정렬, 오른쪽으로 30자리 정렬 , 3자리마다 콤마 찍기 위한 format 설정, 품목 합계 계산 => 총 결제 할 금액
		System.out.printf("%-10s %29s\n","거    스    름 : ",k08_df.format(0));
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("%s %10s\n","주문번호:","0920");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("판매원 : 000002 편의점2\n");
		System.out.printf(k08_sdf2.format(k08_cal.getTime()) + "-0002-0922\n");
		// 날짜규칙 yyyy/MM/dd인 sdf2 적용
		System.out.printf("연동모듈:[00138705 " + k08_sdf3.format(k08_cal.getTime()) + "]\n");
		// 연동 모듈의 번호와 연월일시분초인 yyyyMMddHHmmss sdf3포맷 사용
	}
}
