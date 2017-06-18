

import java.text.DecimalFormat;

public class review_170523 {
	public static void main(String args[])
	{
		/*int k08_i,k08_x;
		k08_i = 0; // * 을 찍어주는 k08_i 변수 0 으로 초기화
		while(true){ // 조건에 맞아 break 에 걸리기 전까지 참이라면 무한 반복
			k08_x = 0; // 줄바꿈을 해주는 k08_x 변수 0 으로 초기화
			while(true){ // 조건에 맞아 break 에 걸리기 전까지 참이라면 무한 반복
				System.out.print("*"); // 일단 별 하나 찍는다. ( k08_i 와 k08_x 가 다를 경우에 같아질때까지 별 찍어야 한다 )
				if ( k08_i == k08_x ) // k08_i와 k08_x 는 처음엔 0 으로 초기화 되었기 때문에 조건에 걸리고 break 로 빠져나온다.
					break;
				k08_x++; // if 조건문에 걸리지 않는다면 ( k08_i 와 k08_x 가 다르다면 ) k08_x 는 1 증가하고 다시 while 루프를 돌러 간다.
			}
			System.out.println(""); // 줄바꿈을 한 다음에
			k08_i++; // k08_i 를 1 증가시켜준다
			if ( k08_i == 30) // k08_i 가 아직 (1) 이기 때문에 if 조건문은 넘어가게 된다.
				break;
		}*/
		
		/*int k08_i; // int 형 k08_i 변수 선언
		double k08_d; // double 형 k08_d 변수 선언
		k08_i = 10/3; // int 형끼리 나누기해서 k08_i 에 대입
		k08_d = 10/3.0; // double 형으로 맞춰 준 다음 3.0 k08_d로 대입
		
		if ( k08_i == k08_d ) // int형과 double 형의 값이 같으면
			System.out.println("같다");
		else // int형과 double 형이 다르다면
			System.out.println("다르다 \t " + (double)k08_i + "\t" + k08_d);
		
		if (k08_i == 3.333333) // int형 k08_i 의 값이 임의로 지정한 3.333333 과 같다면
			System.out.println("같다");
		else
			System.out.println("다르다 \t " + k08_i); // int 형은 소수점 이하 잘라버림
		
		k08_d = (int)k08_d; // double 형 변수에 int형으로 형변환시켜서 값을 넣는다
		if ( k08_i == k08_d ) // int형과 double 형이 같다면
			System.out.println("같다");
		else // 다르다면
			System.out.println("다르다 \t " + (double)k08_i + "\t" + k08_d); // int형인 k08_i 를 double형으로 고쳐 출력
		
		System.out.println("int로 인쇄 \t " + k08_i + "\t" + k08_d);
		System.out.println("double로 인쇄 \t " + (double)k08_i + "\t" + k08_d);
		
		char k08_a = 'c'; // char 형 변수 k08_a에 c 문자 한개 대입
		if ( k08_a == 'b' ) // k08_a에 들어있는 c라는 문자가 b와 같다면
			System.out.println("a = b");
		if ( k08_a == 'c' ) // k08_a에 들어있는 c라는 문자가 c와 같다면
			System.out.println("a = c");
		if ( k08_a == 'd' ) // k08_a에 들어있는 c라는 문자가 d와 같다면
			System.out.println("a = d");
		
		String k08_aa = "abcd"; // String 형 변수 k08_aa 에 abcd 라는 문자열 대입
		if ( k08_aa.equals("abcd") ) // k08_aa에 들어있는 문자열과 비교대상 문자열인 abcd가 같다면
			System.out.println("aa 는 abcd 이다");
		else
			System.out.println("aa는 abcd가 아니다");
		
		boolean k08_bb = true; // boolean 형 변수 k08_bb 에 true 값 초기화
		if (!!k08_bb) // k08_bb가 처음에 true 였다가 ! 만나서 false 되고 다시 ! 만나서 true 가 되었다
			System.out.println("k08_bb 가 아니고 아니면 참이다");
		else
			System.out.println("k08_bb 가 아니고 아니면 거짓이다");
		*/
		/*int k08_a; // int형 변수 k08_a 선언
		for ( int k08_i = 0 ; k08_i < 300 ; k08_i++){ // 0부터 299 까지 1씩 증가하면서 반복
			k08_a = 5 * k08_i; // 기존 변수 k08_a에 k08_i * 5 값 대입
			if ( k08_a >= 0 && k08_a < 10 ) // k08_i * 5 의 값이 0이상 9이하라면 
				System.out.println("일 " + k08_a);
			else if ( k08_a >= 10 && k08_a < 100 ) // k08_i * 5 의 값이 10 이상 99이하라면
				System.out.println("십 " + k08_a);
			else if ( k08_a >= 100 && k08_a < 1000 ) // k08_i * 5 의 값이 100 이상 999 이하라면
				System.out.println("백 " + k08_a);
			else // k08_i * 5 의 값이 1000 이상이라면
				System.out.println("천 " + k08_a);
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1부터 12까지 1씩 증가하면서 반복
			System.out.print(k08_i + "월 => "); // 몇월인지 표시
			for ( int k08_j = 1 ; k08_j <32 ; k08_j++){ // 1부터 31까지 1씩 증가하면서 반복
				System.out.print(k08_j + ",");
				if ( k08_i == 1 && k08_j == 31) // 1월은 31일까지 있어서 처음 for 문이 1 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 2 && k08_j == 28) // 2월은 28일까지 있어서 처음 for 문이 2 이고 내부 for 문의 값이 28이 되면 내부 for문 종료
					break;
				if ( k08_i == 3 && k08_j == 31) // 3월은 31일까지 있어서 처음 for 문이 3 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 4 && k08_j == 30) // 4월은 30일까지 있어서 처음 for 문이 4 이고 내부 for 문의 값이 30이 되면 내부 for문 종료
					break;
				if ( k08_i == 5 && k08_j == 31) // 5월은 31일까지 있어서 처음 for 문이 5 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 6 && k08_j == 30) // 6월은 30일까지 있어서 처음 for 문이 6 이고 내부 for 문의 값이 30이 되면 내부 for문 종료
					break;
				if ( k08_i == 7 && k08_j == 31) // 7월은 31일까지 있어서 처음 for 문이 7 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 8 && k08_j == 31) // 8월은 31일까지 있어서 처음 for 문이 8 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 9 && k08_j == 30) // 9월은 30일까지 있어서 처음 for 문이 9 이고 내부 for 문의 값이 30이 되면 내부 for문 종료
					break;
				if ( k08_i == 10 && k08_j == 31) // 10월은 31일까지 있어서 처음 for 문이 10 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
				if ( k08_i == 11 && k08_j == 30) // 11월은 30일까지 있어서 처음 for 문이 11 이고 내부 for 문의 값이 30이 되면 내부 for문 종료
					break;
				if ( k08_i == 12 && k08_j == 31) // 12월은 31일까지 있어서 처음 for 문이 12 이고 내부 for 문의 값이 31이 되면 내부 for문 종료
					break;
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1월부터 12월 까지 반복
			System.out.print(k08_i + "월 ==> ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1일부터 31일까지 반복
				System.out.print(k08_j + ","); // 각 일자 뒤에 콤마 출력
				if ( k08_i == 4 || k08_i == 6 || k08_i == 9 || k08_i ==7 || k08_i == 11 ){
					// 4월 6월 9월 7월 11월 중 하나라면
					if ( k08_j == 30 ) // 30일에 멈춘다
						break;
				}
				if ( k08_i == 2 ){ // 2월이라면
					if ( k08_j == 28 ) // 28일에 멈춘다
						break;
				}					
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1월부터 12월 까지 반복
			System.out.print(k08_i + "월 ==> ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1일부터 31일까지 반복
				System.out.print(k08_j + ","); // 각 일자 뒤에 콤마 출력
				if ( (k08_i == 4 || k08_i == 6 || k08_i == 9 || k08_i ==7 || k08_i == 11) && (k08_j == 30))
					// 4월 6월 9월 7월 11월 이고 30일 이라면 루프 중지
					break;
				if ( k08_i == 2 && k08_j == 28 ) // 2월이고 28일이라면 루프 중지
					break;
			}
			System.out.println();
		}*/
		
		/*for ( int k08_i = 1 ; k08_i < 13 ; k08_i++){ // 1월부터 12월 까지 반복
			System.out.print(k08_i + "월 ==> ");
			LOOP: for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1일부터 31일까지 반복
				System.out.print(k08_j + ",");
				switch(k08_i){
				case 4: // k08_i 의 값이 4 6 9 7 11 일때 break 없이 진행
				case 6:
				case 9:
				case 7:
				case 11:
					if ( k08_j == 30 ) // k08_j 가 30일 때 (30일일경우) 
						break LOOP; // 중지하고 LOOP 로 돌아간다
					break;
				case 2: // k08_i 의 값이 2일 경우
					if ( k08_j == 28 ) // k08_j 가 28 일때 (28일 일 경우)
						break LOOP; // 중지하고 LOOP 로 돌아간다
					break;
				}				
			}
			System.out.println(); // 줄바꿈
		}*/
		
	
		/*int [] k08_arr = {31,28,31,30,31,30,31,31,30,31,30,31};// k08_arr 배열에 월별 마지막 일의 숫자를 저장시켜놓는다.
		for ( int k08_i = 1; k08_i < 13 ; k08_i++){ // 1 ~ 12 까지 반복  ( 1월 ~ 12월 )
			System.out.print(k08_i + "월 => ");
			for ( int k08_j = 1 ; k08_j < 32 ; k08_j++){ // 1 ~ 31까지 반복 ( 1일 ~ 31일  )
				System.out.print(k08_j);
				if ( k08_arr[k08_i-1] == k08_j) // 월의 마지막 일에 도달했을때 루프 탈출을 위한 if 문
					break;
				System.out.print(","); // 마지막 일 일 경우에는 콤마 찍지 않는다 
			}
			System.out.println();
		}*/
		
		/*String [] k08_units = {"영","일","이","삼"	,"사","오","육","칠","팔","구"}; // k08_units 배열에 영 ~ 구 의 단어를 저장시켜놓는다.
		for ( int k08_i = 0 ; k08_i < 101 ; k08_i++){ // 0부터 100 까지 1씩 증가하면서 반복
			if ( k08_i >= 0 && k08_i < 10 ){ // 0이상 9 이하라면 일의 자리
				System.out.println("일의 자리 : " + k08_units[k08_i]);
			}
			else if ( k08_i >= 10 && k08_i < 100 ){ // 10이상 99 이하라면
				int k08_i10, k08_i0; // 십의자리와 일의자리 표시를 위한 변수 두개 선언
				k08_i10 = k08_i / 10; // 십의 자리 표시를 위해 10으로 나눈다.
				k08_i0 = k08_i % 10; // 일의 자리 표시를 위해 10으로 나눈 나머지 저장
				if ( k08_i0 == 0 ){ // k08_i % 10 의 결과가 0 일 경우 
					System.out.println("십의 자리 : " + k08_units[k08_i10] + "십");
				}
				else
					System.out.println("십의 자리 : " + k08_units[k08_i10] + "십" + k08_units[k08_i0]);
			}
			else
				System.out.println("==> " + k08_i);
		}*/
		
		int k08_i = 1001034567;
		String k08_sNumVal = String.valueOf(k08_i); // 숫자를 String.valueOf 를 이용해 String 형으로 변환
		String k08_sNumVoice = "";
		System.out.println("==> " + k08_sNumVal + " " + k08_sNumVal.length() + "자리"); 
		// k08_sNumVal.length() 를 이용해 k08_i변수값의 길이를 알 수 있다.
		// 몇자리인지 알아야 첫 단위가 어떤 것인지 알 수 있다.
		int k08_a, k08_b;
		String [] k08_units = {"영","일","이","삼","사","오","육","칠","팔","구"};
		// k08_units 배열에 영 ~ 구의 단어 저장
		String [] k08_unitx = {"","십","백","천","만","십","백","천","억","십"};
		// k08_unitx 배열에 공백 ~ 십의 단어 저장
		k08_a = 0;
		k08_b = k08_sNumVal.length() - 1; // 길이 10 - 1저장
		
		while ( true ){
			if ( k08_a >= k08_sNumVal.length()) // k08_sNumVal 의 길이가 0이하라면 loop 중지 
				break;
			System.out.println(k08_sNumVal.substring(k08_a, k08_a + 1) + "[" // k08_sNumVal의 첫번째 숫자 1을 substring으로 추출 
				+ k08_units[Integer.parseInt(k08_sNumVal.substring(k08_a,k08_a + 1))] + "]");
			// k08_sNumVal의 첫번째 숫자 1 ( 사실은 문자 ) 를 integer.parseInt 를 사용해 int형으로 변환하고 k08_units 의 값을 불러옴 ( 일 )
			if ( k08_sNumVal.substring(k08_a, k08_a + 1).equals(("0")) ) { // k08_sNumVal의 첫번째 자리가 0과 동일하다면
				if ( k08_unitx[k08_b].equals("만")||k08_unitx[k08_b].equals("억")){
					// k08_b 는 k08_sNumVal 길이의 -1, k08_units[9] 가 십이거나 억이라면
					k08_sNumVoice = k08_sNumVoice + "" + k08_unitx[k08_b];
					// k08_sNumVoice 값에 k08_unitx[9] 저장
				}
				else{}
			}else // k08_sNumVal의 첫번째 자리가 0과 동일하하지 않다면
				k08_sNumVoice = k08_sNumVoice + k08_units[Integer.parseInt(k08_sNumVal.substring(k08_a,k08_a + 1))] 
				// k08_sNumVal의 첫번째 숫자 1 ( 사실은 문자 ) 를 integer.parseInt 를 사용해 int형으로 변환하고 k08_units 의 값을 불러옴 ( 일  )
						+ k08_unitx[k08_b];
			k08_a++; 
			k08_b--; // k08_sNumVal.length() 값 1 감소
		}
		System.out.println(k08_sNumVal + "[" + k08_sNumVoice + "]");
		
		/*for ( int k08_i = 0 ; k08_i < 10 ; k08_i++){ // 0부터 9까지 1씩 증가하면서 반복
			for ( int k08_j = 0 ; k08_j < k08_i ; k08_j++) // k08_i 가 0 일때 k08_j 도 0이 되고 처음엔 조건이 맞지 않아서 실행하지 않는다.
				System.out.print(" "); // 원하는 칸 만큼 빈칸 출력 후
			System.out.println(k08_i); // 숫자 출력
		}*/
		
		/*double k08_fSin; // double 형 변수 선언
		for ( int k08_i = 0 ; k08_i < 360 ; k08_i++){
			k08_fSin = Math.sin(k08_i * 3.141592 / 180); // sin0 ~ sin360을 구한다. 각도에 대한 sin 값 계산
			System.out.println(k08_i + "sin => " + k08_fSin);
		}
		for ( int k08_i = 0 ; k08_i < 360 ; k08_i++){
			k08_fSin = Math.sin(k08_i * 3.141592 / 180); // sin0 ~ sin360을 구한다. 각도에 대한 sin 값 계산
			int k08_iSpace = (int)((1.0 - k08_fSin) * 50); // 음수처리를 위해 1.0에서 - 해준다. 너무 작은 값들이라 눈에 잘 보이도록 하기 위해 50 곱해줌
			// 모든 sin 값들에 대해 양수처리를 해준 k08_iSpace
			for ( int k08_j = 0 ; k08_j < k08_iSpace ; k08_j++) // 0 부터 모든 sin 값들에 대해 양수처리를 해준 k08_iSpace 까지 공백 출력
				System.out.print(" ");
			System.out.println("*[" + k08_fSin + "][" + k08_iSpace + "]"); // [sin값][양수처리하고 잘보이게 한 값]
		}*/
		
		/*int k08_n = 20; // int형 변수 k08_n 선언 및 20으로 초기화
		int k08_m = 1; // int형 변수 k08_m 선언 및 1로 초기화
		while ( true ){
			for ( int k08_i = 0 ; k08_i < k08_n ; k08_i++) // 0부터 20까지 공백 출력
				System.out.print(" ");
			for ( int k08_i = 0 ; k08_i < k08_m ; k08_i++) // 0부터 1까지 * 출력
				System.out.print("*");
			System.out.println(); // 줄바꿈
			k08_n = k08_n - 1; // 공백출력하는 값을 점점 줄여나간다
			k08_m = k08_m + 2; // * 을 출력하는 값을 점점 늘려나간다 2개씩
			if ( k08_n < 0 )
				break;
		}*/
		
		/*String k08_item = "사과"; // 품목이름 사과
		String k08_item2 = "포도"; // 품목이름 포도
		int k08_price = 5000; // 사과 가격 5000원
		int k08_price2 = 3000; // 포도 가격 3000원
		int k08_num = 500; // 사과 및 포도 개수 500개
		int k08_total = 0; // 총 합은 0 으로 초기화 시켜놓음
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 3자리마다 콤마찍어주는 DecimalFormat
		
		System.out.println("========================================"); // 일반적 리포트는 헤더 인쇄 후 내용 인쇄한다.
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","품목","단가","수량","합계");
		System.out.println("========================================"); // 헤더 표시
		
		System.out.printf("%20.20s%10.10s%5.5s%12.10s\n",
				k08_item,df.format(k08_price),df.format(k08_num),df.format(k08_price*k08_num));
		System.out.printf("%20.20s%10.10s%5.5s%12.10s\n",
				k08_item2,df.format(k08_price2),df.format(k08_num),df.format(k08_price2*k08_num));
		// DecimalFormat 으로 세자리마다 콤마찍어준다.
		// 20칸의 공간을 비워두고 20칸을 사용할 수 있다. 오른쪽 숫자가 작으면 짤림 ( 12.5 -> 2,500 
		System.out.println("========================================");*/
	}

}
