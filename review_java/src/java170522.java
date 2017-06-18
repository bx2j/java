

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class java170522 {
	public static void main(String args[]){		
		int k08_sum = 0; // 누적 변수 k08_sum 0으로 초기화
		for (int k08_a = 1; k08_a < 101; k08_a++) // 1부터 1씩 증가하면서 100까지 반복
			k08_sum += k08_a; // k08_sum = k08_sum + k08_a => k08_sum 값에 k08_a값씩 더하면서 k08_sum값에 대입
		// 0 = 0 + 1 > 1 = 1 + 2 ... 
		System.out.println("******");
		System.out.println("* "+ k08_sum); // 최종 k08_sum 값 출력
		System.out.println("*  "+ k08_sum/100); // k08_sum 값의 평균 출력
		System.out.println("******");
		
		int [] k08_bv = {1,2,3,4,5}; // k08_bv 배열에 1,2,3,4,5 값 초기화 시켜놈
		int k08_vsum = 0; // 누적 변수 k08_vsum 0 초기화
		for(int k08_a = 0; k08_a < 5; k08_a++) // 0부터 4까지 1씩 증가하면서 반복
			k08_vsum  += k08_bv[k08_a]; // k08_vsum에 k08_bv[0] 값을 더해서 k08_vsum값에 대입
		// 0 = 0 + 1 > 1 = 1 + 2 ...
		System.out.println("****");
		System.out.println("* " + k08_vsum);
		System.out.println("****");
		
		int k08_i = 0; // k08_i 변수 0으로 초기화
		k08_i = 1000/3; // k08_i변수에 1000 / 3 값 대입. 333.3333... 의 결과가 나오지 않고 333만 나온다
		System.out.println("**************");
		System.out.println("* 1000/3 = " + k08_i); // 결과
		System.out.println("**************");
		k08_i = 1000%3; // k08_i변수에 1000 / 3의 나머지 값 대입
		System.out.println("*************");
		System.out.println("* 1000%3 = " + k08_i); // 결과
		System.out.println("*************");
		
		for(int k08_a=0; k08_a < 20; k08_a++){ // 0부터 19까지 1씩 증가하면서 반복
			System.out.println(k08_a); // 차례대로 출력하고 줄바꿈
			if((k08_a+1)%5 == 0) // 증가 하는 값에 1을 더하고 5로 나눴을 때 나머지가 0이라면
				// k08_a 가 4라면 5%5 == 0 이므로 k08_a 값이 4일때 한줄 띄우고 다음 k08_a값인 5 출력 
				System.out.println("*"); // 줄바꾸는 곳에 '*' 을 넣어서 줄바꿈 표시
		}
		
		k08_i = 12345;
		int k08_x = (k08_i/10)*10; // 12345의 10단위 이하 버려서 처리하기 위함
		// k08_i / 10 => 1234.5가 아니라 1234.0 
		// 1234.5 * 10 => 12340
		System.out.println("***********************");
		System.out.println("* (k08_i/10)*10 = " + k08_x);
		System.out.println("***********************");
		k08_x = ((k08_i+5)/10)*10;
		System.out.println("***************************");
		System.out.println("* ((k08_i+5)/10)*10 = " + k08_x);
		// k08_i 에 5를 더하면 12350이고 얘를 나누면 1235.0인데 다시 10을 곱하면 12350
		k08_i = 12344;
		k08_x = ((k08_i+5)/10)*10;
		System.out.println("* ((k08_i+5)/10)*10 = " + k08_x);
		// k08_i 에 5를 더하면 12349이고 10으로 나누면 1234.9가 아니라 1234.0이 되면서 에서 10을 곱하면 12340 이 된다.
		System.out.println("***************************");
		
		double k08_f1 = 14/5;
		double k08_f2 = 14.0/5;
		double k08_f3 = 14.0/5 + 0.5;		
		double k08_f4 = (int)(14.0/5+0.5);
		System.out.println("*************************");
		System.out.println("* 14/5 = " + k08_f1); 
		// k08_f1은 double형 이지만 14와 5는 int 형이므로 소수점 이하를 버리지만 double이므로 2.0 출력 
		System.out.println("* 14.0/5 = " + k08_f2);
		// 14.0 or 14. 형식으로 둘 중 하나의 값을 double 형으로 표시하면 정상적인 결과 출력
		System.out.println("* 14.0/5 + 0.5 = " + k08_f3);
		// double 형에 0.5를 더하면? 정상 결과 출력
		System.out.println("* (int)(14.0/5+0.5) = " + k08_f4);
		// 3.3이라는 값을 int 형으로 형변환하게 되면 소수점 이하는 버려지는데 int형 변수가 들어가는 변수가 double 형이므로 double형으로 나타남
		System.out.println("*************************");
		
		System.out.println("*******************************");
		int k08_val = 271; // 세전 물건 값
		int k08_rate = 3; // 세금 3퍼센트 0.03
		int k08_tax = k08_taxcalc(k08_val,k08_rate); // k08_taxcalc 함수에 k08_val 271 k08_rate 3 값을 넘겨주고 계산결과를 리턴받는다
		System.out.println("* 실제 세금 계산 : " + k08_val*k08_rate/100.0); // 하나라도 double 형식으로 해줘야 정상 출력 가능
		System.out.println("* 세전 : " + k08_val + " 세금 : " + k08_tax + " 세금 포함 : " + (k08_val+k08_tax));
		System.out.println("*******************************");
		
		System.out.println("*************************************");
		int k08_custom = 280; // 소비자 가격
		int k08_taxrate = 3; // 세금 3퍼센트 0.03
		int k08_taxval, k08_netval; // 세금, 세전 가격 int 형 변수 설정
		k08_netval = (int)(k08_custom / (1 + (k08_taxrate/100.0)) ); // 세전 가격 = 소비자 가격 / (1 + 세금)
		k08_taxval = k08_custom - k08_netval; // 세금 = 물건 값 - 세전 가격
		System.out.println("* 소비자 가격 : " + k08_custom + " 세전 가격 : " + k08_netval + " 세금 : " + k08_taxval);
		System.out.println("*************************************");
		
		int k08_won = 1000000; // 환전할 내 돈 100만원
		double k08_ex = 1238.21; // 달러 환율
		double k08_com = 0.003; // 환전 수수료 0.3%
		
		int k08_money = (int)(k08_won/k08_ex); // 내가 받을 달러를 int 형으로 만들면 버림이 된다.
		int k08_remoney = (int)(k08_won - (k08_money * k08_ex));
		// 전체 금액에서 (환전한 달러 * 환율) 을 뺐다.
		System.out.println("* 환전 금액 : " + k08_won + " 달러 : " + k08_money + " 잔돈 : " + k08_remoney);
		System.out.println("*************************************");
		
		System.out.println("*********************************************************");
		double k08_cpo = k08_ex * k08_com; // 1달러당 수수료 = 환율 * 환전 수수료
		double k08_total = k08_money * k08_cpo; // 총 수수료 = 환전 금액 * 달러당 수수료 
		System.out.println("* 수수료 : " + k08_total + " 달러 : " + k08_money + " 달러 당 수수료 : " + k08_cpo);
		System.out.println("*********************************************************");

		System.out.println("*****************************************************");
		int k08_itotal;
		if(k08_total != (double)((int)k08_total))
			// int 형  수수료의 값과 double 형 수수료의 값이 다르다면
			k08_itotal = (int)k08_total + 1;
			// 총 수수료는 int형으로 소수점 이하를 버리고 +1
		else // int 형  수수료의 값과 double 형 수수료의 값이 같다면
			k08_itotal = (int)k08_total;
			// 총 수수료는 int 형
		System.out.println("* 총 수수료 : " + k08_itotal + " 달러 " + k08_money + " 수수료 : " + k08_cpo);
		k08_remoney = (int) (k08_won - k08_money * k08_ex - k08_itotal);
		// 내 돈 100만원에서 환전금액 * 환율 - 총 수수료를 계산하면 -2233 이라는 잔돈이 나오게 된다. 100만원을 가지고 807달러로 환전할 수 없다.
		System.out.println("* 총 한화환전금액 : " + k08_won + " 달러 " + k08_money + " 수수료 : " + k08_itotal 
				+ " 잔돈 : " + k08_remoney);
		System.out.println("*****************************************************");
		
		System.out.println("***************************************************");
		k08_money = (int)(k08_won/(k08_ex + k08_cpo)); // 환전 달러 = (내돈 / 환율+달러 당 수수료)
		k08_total = k08_money * k08_cpo; // 총 수수료 = 환전 달러 * 달러 당 수수료
		if(k08_total != (double)((int)k08_total))
			// int 형  수수료의 값과 double 형 수수료의 값이 다르다면
			k08_itotal = (int)k08_total + 1;
			// 총 수수료는 int형으로 소수점 이하를 버리고 +1
		else // int 형  수수료의 값과 double 형 수수료의 값이 같다면
			k08_itotal = (int)k08_total;
			// 총 수수료는 int 형
		System.out.println("* 총 수수료 : " + k08_itotal + " 달러 " + k08_money + " 수수료 : " + k08_cpo);
		k08_remoney = (int) (k08_won - k08_money * k08_ex - k08_itotal);
		// 805달러를 환전하고 잔돈을 계산하게 되면 100만원에 맞는 잔돈이 계산된다.
		System.out.println("* 총 한화환전금액 : " + k08_won + " 달러 " + k08_money + " 수수료 : " + k08_itotal 
				+ " 잔돈 : " + k08_remoney);
		System.out.println("***************************************************");
		
		System.out.println("*****************************************************");
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		// 3자리마다 콤마(,) 를 찍기 위해 DecimalFormat 사용
		// ### (3자리마다) , (콤마를 찍어라) => 없으면 자릿수 안채움
		Calendar cal = Calendar.getInstance();
		// Calendar 클래스는 현재 시간을 가져옴
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// 4자리 년도/월/일 시:분:초 의 형식으로 현재 시간의 출력 포맷 지정
		System.out.println("* 총 수수료 : " + df.format(k08_itotal) + " $ " + df.format(k08_money) 
				+ " 수수료 : " + k08_cpo);
		System.out.println("* 총 한화환전금액 : " + df.format(k08_won) + " $ " + df.format(k08_money) 
				+ " 수수료 : " + df.format(k08_itotal) 	+ " 잔돈 : " + k08_remoney);
		System.out.println("* 최종 실행 시간 : " + sdf.format(cal.getTime()));
		System.out.println("*****************************************************");
	}
	
	public static int k08_taxcalc(int k08_val,int k08_rate){ // int형 매개변수 k08_val,k08_rate 설정
		int k08_ret; // 세금 int 형 변수 선언
		if( ((double)k08_val * (double)k08_rate/100.0) == (k08_val * k08_rate/100) ){
			// 물건 값 * 세금 / 100.0 (실수형) 이 int 형 결과와 같을 경우
			k08_ret = k08_val * (k08_rate / 100);
			// 다른 연산처리 하지 않고 그대로 리턴
		}else // 다를 경우
			k08_ret = k08_val * k08_rate/100 + 1;
		// 결과의 소수점 이하를 버리고 +1 로 출력
		return k08_ret; // 계산 int형으로 결과 리턴 
	}
}
