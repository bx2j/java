/* 
 * 항목이 하나인 영수증 출력 form
 * 2017.05.24
 * prepared by 배병주  
 * 
 * 수정사항
 * 	println / printf 혼용 => printf 통일
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class review_170524 {
	public static void main(String args[]){
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3자리마다 콤마(,) 를 찍기 위해 DecimalFormat 사용
				// ### (3자리마다) , (콤마를 찍어라) => 없으면 자릿수 안채움
		Calendar k08_cal = Calendar.getInstance(); // Calendar 클래스는 현재 시간을 가져옴
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 4자리 년도-월-일 시:분 형식으로 현재 시간의 출력 포맷 지정
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyyMMdd");
		// 4자리 년도월일 형식으로 현재 시간의 출력 포맷 지정
		SimpleDateFormat k08_sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 4자리 년도-월-일 시:분:초 형식으로 현재 시간의 출력 포맷 지정
		int k08_price = 140000; // 물품 가격
		int k08_tax = (int)(k08_price/1.1); // 원래 가격 계산
		System.out.printf("%20s\n","영  수  증");
		System.out.printf("====================================\n");
		System.out.printf("%s %14s\n","종로상회(분당서현점)","129-17-77924");
		System.out.printf("%s %13s\n","이상철","031 781 1596");
		System.out.printf("성남시 분당구 서현동 269-3\n테이블명 : 12\n");
		System.out.printf("주문번호 : " + k08_sdf2.format(k08_cal.getTime()) + " 01 " + "00041\n");
		// 주분번호는 연월일 이 앞에 나오고 가게 규칙에 따라 나오기 때문에 yyyyMMdd 포맷인 sdf2 포맷을 사용
		System.out.printf("====================================\n");
		System.out.printf("%-15.15s %16.15s\n","주문합계",k08_df.format(k08_price)); // 상품 가격 천 단위 콤마 찍어 출력
		System.out.printf("%-15.15s %16.16s\n","할인금액",k08_df.format(0)); // 할인금액 0 원이지만 혹시 천단위 넘어 갈수도 있어서 콤마 포맷
		System.out.printf("%-15.15s %16.16s\n","받을금액",k08_df.format(k08_price)); // 상품 가격 천 단위 콤마 찍어 출력
		System.out.printf("====================================\n");
		
		System.out.printf("%s %10.10s %6.6s %9.9s\n","현  금",k08_df.format(0),"과  세",k08_df.format(k08_tax)); 
		// 현금 0 원이지만 혹시 천단위 넘어 갈수도 있어서 콤마 포맷, 원래 가격 계산 
		System.out.printf("%s %10.10s %6.6s %9.9s\n","카  드",k08_df.format(k08_price),"세  액",k08_df.format(k08_price-k08_tax)); 
		// 카드 낼 금액, 주문가격에서 원래 가격을 빼면 세금 확인
		System.out.printf("%s %10.10s %6.6s %9.9s\n","포인트",k08_df.format(0),"면  세",k08_df.format(0));
		// 포인트 및 면세 품 없어서 0으로 채워 넣음
		System.out.printf("%24s %7.7s\n","영수금액",k08_df.format(k08_price));
		// 총 금액 천단위 콤마 포맷 출력
		System.out.printf("====================================\n");
		
		System.out.printf("%20s\n","[우리카드 신용 승인]");
		System.out.printf("승 인 일 시 : %s\n" , k08_sdf3.format(k08_cal.getTime()));
		// 승인 일시는 연-월-일 시:분:초 규칙이기때문에 yyyy-MM-dd HH:mm:ss 포맷인 sdf3포맷 사용
		System.out.printf("카 드 번 호 : 55222059****2021\n");
		System.out.printf("승 인 번 호 : 79753574 할부개월 : 00\n");
		System.out.printf("승 인 금 액 : %s\n" ,k08_df.format(k08_price));
		// 승인 금액 총 금액 천단위 콤마 포맷
		System.out.printf("가 맹 번 호 : 730461774 / 비씨카드사\n");
		System.out.printf("사업자 번호 : 129-17-77924\n");
		System.out.printf("====================================\n");
		System.out.printf(sdf.format(k08_cal.getTime()) + " CASHIER : ");
		// 현재 날짜는 yyyy-MM-dd HH:mm 포맷인 sdf포맷 사용
		System.out.printf("%7.7s\n","직원");
		System.out.printf("====================================\n");
		System.out.printf("감사 합니다.\n");
	}
		
}

