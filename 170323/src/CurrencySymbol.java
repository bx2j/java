import java.io.*;


public class CurrencySymbol {
	public String currencySymbol(String targetCountry){
		String currency = null;
		int arr_cnt = 0; 
		String[] country_sysmbol = new String[exchange_test.arr_size];
		String[] country_name = new String[exchange_test.arr_size];
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				country_name[arr_cnt] = split[0]; // 국가명
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
		return currency;
	}
}
