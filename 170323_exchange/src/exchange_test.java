import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class exchange_test {
	static DecimalFormat form = new DecimalFormat("#.##");
	static int arr_size = 100;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int check = 0 , arr_cnt = 0;
		String change_country = null;
		String[] arr = new String[arr_size] , arr_country = new String[arr_size];
		double[] arr_money = new double[arr_size];

		MoneyChangeClass exchange = new MoneyChangeClass();
		CurrencySymbol exchange_name = new CurrencySymbol();
		AddCountry addCountry = new AddCountry();
		try{
			OutputStream os = new FileOutputStream("C:\\Users\\kopo\\Desktop\\exchange_output.csv");
			DataOutputStream dos = new DataOutputStream(os);
		
			System.out.print("input exchange korea_money : ");
			int korea_money = scan.nextInt();
			do{
				scan.nextLine();
				System.out.print("input exchange country : ");
				try{
				change_country = scan.nextLine();
				if( (change_country.toUpperCase().equals("USD") || change_country.toUpperCase().equals("EUR") || change_country.toUpperCase().equals("JPY") 
					|| change_country.toUpperCase().equals("CNY") || change_country.toUpperCase().equals("HKD") || change_country.toUpperCase().equals("AUD")
					|| change_country.toUpperCase().equals("NZD") || change_country.toUpperCase().equals("TWD") || change_country.toUpperCase().equals("DKK")) == true){
					arr[arr_cnt] = exchange_name.currencySymbol(change_country.toUpperCase());
					String rounding = form.format(exchange.exchangeRate(korea_money, change_country.toUpperCase()));
					arr_money[arr_cnt] = Double.parseDouble(rounding);
					arr_country[arr_cnt] = addCountry.Country(change_country.toUpperCase());
					arr_cnt++;
				}
				else
					throw new Exception();
				}catch(Exception e){
					System.out.println("no code");
				}
				System.out.print("add - 1 no - 2 : ");
				try{
				check = scan.nextInt();
				if( check < 1 || check > 2)
					throw new Exception();
				}catch(Exception e){
					System.out.println("input only 1,2");
					System.out.print("add - 1 no - 2 : ");
					check = scan.nextInt();
				}
			}while(check != 2);
			dos.writeBytes("input" + "," + korea_money + "\n" + "country" + "," + "exchange" + "\n");
			for(int i=0;i<arr_cnt;i++)
				dos.writeBytes(arr_country[i] + "," + arr[i] + arr_money[i] + "\n");
			System.out.println("save clear");			
			os.close();
			dos.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}

	}
}
