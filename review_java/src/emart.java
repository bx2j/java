/* 
 * 영수증 (이마트) 출력 form 
 * 2017.05.24
 * prepared by 배병주  
 * 
 * 수정사항
 * 	println / printf 혼용 => printf 통일 
 * 	주석 수정 => line 68 ~ 75 // 해당 숫자와 주석의 내용 불일치
 */

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class emart {
	 public static String k08_cut(String k08_str, int k08_maxLen) // 해당 문자열과 자를 byte 길이 입력
     {
          StringBuilder k08_sb = new StringBuilder(); // 문자열을 담기만 하는 String와 달리 수정 가능
          int k08_Len = 0; // byte길이 누적을 위한 변수
          String k08_Char; // substring 으로 하나의 문자를 추출하기 위한 변수
          for (int i = 0; i < k08_str.length(); i++) // 입력받은 문자열 길이만큼 반복문 수행
          {
        	  k08_Char = k08_str.substring(i, i + 1); // 0,1 문자 추출 ex) 초코파이 -> 초
              k08_Len += k08_Char.getBytes().length; // 처음의 문자 추출한 길이 구해 누적
              if (k08_Len > k08_maxLen) // 길이의 누적이 입력받은 byte길이가 크면 반복 중지
            	  break;
              else
            	  k08_sb.append(k08_Char); // 새로운 문자열 추가
               // 추출한 문자열 뒤로 나머지 문자들 추가 초 -> 초코 -> 초코파 -> 초코파이
          }
          return k08_sb.toString();
     }
	public static void main(String args[]){		
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");
		// 3자리마다 콤마(,) 를 찍기 위해 DecimalFormat 사용
		// ### (3자리마다) , (콤마를 찍어라) => 없으면 자릿수 안채움
		Calendar k08_cal = Calendar.getInstance(); // Calendar 클래스는 현재 시간을 가져옴
		SimpleDateFormat k08_sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// 4자리 년도-월-일 시:분 형식으로 현재 시간의 출력 포맷 지정
		String[] k08_item = {"초코파이","몽쉘 * 3박스","하우스 귤1.3kg","포도맛주스5L 200개입","포도맛 오렌지주스우유","초코에몽","우유우 유우유우유우유우유","초코우유","water","빵",
						 "포카칩 35개들이","당근","사과","france-포도","바나나 맛 아이스크림","양념치킨 3000인분","휴지","냄비","후라이팬","치약",
						 "배추김치","블루베리","여름엔 수박","빨간색 딸기","보라색 가지","칫솔","샴푸","바디워시","폼클렌징","로션"};
		// 물품 30개 배열 저장
		int[] k08_itemprice = {2500,1200,3000,5000,129000,3000,3600,6000,7000,8000,
							3000,520,400,6000,2033,19000,4000,2000,1000,3000,
							2000,1000,3000,5000,4000,3000,2,1219000,7000,10000};
		// 물품 가격 책정
		int[] k08_itemnum = {1,3,5,7,3,2,1,8,9,7,1500,1,3,2,8,9,7,4,5,1,6,4,7,8,10,20,4,7,4,3};
		boolean[] k08_taxfree = {false,false,true,false,false,false,false,false,false,false,
							false,true,true,true,false,false,false,false,false,false,
							true,true,true,true,true,false,false,false,false,false};
		// k08_taxfree => 면세 물품 표시 true 면 면세. false 면 과세 대상
		int k08_taxfree_sum = 0; // 면세물품의 총 합
		int k08_taxfreeno_sum = 0; // 과세물품의 총 합
		int k08_all_sum = 0; // 면세 + 과세물품의 총 합
		System.out.printf("%57s\n", "이마트 죽전점 (031)888-1234");
		System.out.printf("%22s %29s\n","emart","206-86-50913 이갑수");
		System.out.printf("%52s\n","용인시 수지구 포은대로 552");
		System.out.printf("영수증 미지참시 교환/환불 불가(30일내)\n교환/환불 구매점에서 가능(결제카드지참)\n");
		System.out.printf("체크카드/신용카드 청구취소 반영은\n최대 3~5일 소요 (주말,공휴일제외)\n\n");
		System.out.printf("[구 매]" + k08_sdf2.format(k08_cal.getTime())); // 구매 날짜 년-월-일 시간:분 출력
		System.out.printf("%43s\n","POS:0009-2418");
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("%8s %20s %13s %12s\n","상 품 명","단  가","수량","금  액");
		System.out.printf("------------------------------------------------------------------\n");
		for(int i = 0; i<k08_item.length;i++){
			String k08_subString; // 잘라낸 문자 저장하기 위한 변수 k08_subString
			k08_subString = k08_cut(k08_item[i],17); // byte단위로 잘라내기 위한 문자열과 자를 byte길이를 cut함수로 넘겨줌
			while(true){
		    	   if ( k08_subString.getBytes().length >= 17){ 
		    		   // 17만큼 잘라낸 문자에 대해 bytes길이가 17이상이라면 while문을 수행하지 않고
		    		   break;
		    	   }
		    	   k08_subString += " "; // 길이가 17이 안된다면 잘라낸 문자 뒤에 공백을 추가해 준다.
		    }
			if ( k08_taxfree[i] == true ){ // 면세 대상이라면				
				System.out.printf("%02d* %1.1s %s %13s %13s %14s\n",i+1,"",k08_subString,k08_df.format(k08_itemprice[i])
						,k08_df.format(k08_itemnum[i]),k08_df.format((int)((k08_itemprice[i] * k08_itemnum[i]))));
				// 면세 대상 물품일 경우 품번뒤에 * 를 붙여준다.
				k08_taxfree_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // 면세 대상 품목의 총 합계를 계산
			}
			else{ // 과세 대상이라면
				System.out.printf("%02d %2.1s %s %13s %13s %14s\n",i+1,"",k08_subString,k08_df.format(k08_itemprice[i])
						,k08_df.format(k08_itemnum[i]),k08_df.format((int)((k08_itemprice[i] * k08_itemnum[i]))));
				k08_taxfreeno_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // 과세 대상 품목의 총 합계를 계산
			}
			k08_all_sum += (int)((k08_itemprice[i] * k08_itemnum[i])); // 구매한 전체 품목에 대한 합계 계산
		}
		System.out.printf("%28s %33s\n","(*)면 세  물 품",k08_df.format(k08_taxfree_sum)); // 면세 물품의 총 합
		System.out.printf("%28s %33s\n","   과 세  물 품",k08_df.format((int)(k08_taxfreeno_sum/1.1))); // 과세 물품 가격 - 세금을 제외한
		System.out.printf("%29s %33s\n","   부   가   세",k08_df.format(k08_taxfreeno_sum-(int)(k08_taxfreeno_sum/1.1))); // 부가세
		System.out.printf("%30s %33s\n","합        계",k08_df.format(k08_all_sum)); 
		// 총 합계 = 면세 물품의 합 + 과세 물품의 합 + 과세 물품에 대한 부가세
		System.out.printf("%s %43s\n","결  제  대  상  금  액",k08_df.format(k08_all_sum)); // 합계에 대한 카드결제 금액
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("004 하  나");
		System.out.printf("%56s\n","5417**8890/07850246");
		System.out.printf("카드결제");
		System.out.printf("%44s %10s\n","일시불 /",k08_df.format(k08_all_sum));
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("홍*두 고객님의 포인트 현황입니다.\n");
		System.out.printf("이마트(신세계) 포인트 3120점 보유\n1000점 이상부터 현금처럼 사용 할 수 있습니다.\n");
		System.out.printf("------------------------------------------------------------------\n");
		System.out.printf("감사 합니다.\n");
	}
}
