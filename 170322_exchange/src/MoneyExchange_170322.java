import java.io.*;
import java.text.*;
import java.util.*;

public class MoneyExchange_170322 {	
	public static void main(String[] args){
		DecimalFormat form = new DecimalFormat("#.##");
		DecimalFormat form_comma = new DecimalFormat("#,###"); // Ãµ´ÜÀ§ ÄÞ¸¶Âï±â
		Scanner scan = new Scanner(System.in);
		String kor = Currency.getInstance(Locale.KOREA).getSymbol(); // ¿øÈ­ Ç¥½Ã
		
		try{
			MoneyChangeClass exchange = new MoneyChangeClass();
			CurrencySymbol exchange_name = new CurrencySymbol();

			System.out.print("input exchange korea_money : ");
			int korea_money = scan.nextInt();
			scan.nextLine();
			System.out.print("input exchange country : ");
			String change_country = scan.nextLine();
			System.out.println(exchange_name.currencySymbol(change_country)+
					form.format(exchange.exchangeRate(korea_money, change_country)));
			
			System.out.print("input exchange foreign_money : ");
			double foreign_money = scan.nextDouble();
			scan.nextLine();
			System.out.print("where is the country? : ");
			String select_country = scan.nextLine();
			double fm = exchange.exchangeToKor(foreign_money, select_country);
			String str = String.format("%,.2f", fm);
			System.out.println(str + kor);
//			System.out.println(form_comma.format(fm)); // Ãµ´ÜÀ§ ÄÞ¸¶Âï±â
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}
