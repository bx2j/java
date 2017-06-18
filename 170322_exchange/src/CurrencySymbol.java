import java.io.*;
import java.io.InputStream;

public class CurrencySymbol {
	public String currencySymbol(String targetCountry){
		String currency = null;
		int arr_cnt = 0, arr_size = 100; 
		String[] country_sysmbol = new String[arr_size];
		String[] country_name = new String[arr_size];
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\170322_exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				country_name[arr_cnt] = split[0]; // 국가명
				//country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // 국가별 환율
				country_sysmbol[arr_cnt] = split[2]; // 국가별 통화 기호
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetCountry) == true ){
					currency = country_sysmbol[i]; 
					break;
				}
			}
			is.close();
			dis.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		/*switch(targetCountry){
		case "USD": // 미국
		case "usd":
			currency = "$";
			break;
		case "EUR": // 유럽연합
		case "eur":
			currency = "€";
			break;
		case "JPY": // 일본
		case "jpy":
			currency = "￥";
			break;
		case "CNY": // 중국
		case "cny":
			currency = "元";
			break;
		case "HKD": // 홍콩
		case "hkd":
			currency = "HK$";
			break;
		case "AUD": // 호주
		case "aud":
			currency = "A$";
			break;
		case "NZD": // 뉴질랜드
		case "nzd":
			currency = "NZ$";
			break;
		}
*/		return currency;
	}
}
