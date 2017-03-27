import java.io.*;

public class MoneyChangeClass {
	public double exchangeRate(double money, String targetCountry){
		double result = 0;
		int arr_cnt = 0; 
		String[] country_name = new String[exchange_test.arr_size];
		double[] country_exchangeRate = new double[exchange_test.arr_size];		
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				country_name[arr_cnt] = split[0]; // 국가명
				country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // 국가별 환율
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetCountry) == true ){
					result = money / country_exchangeRate[i]; // 한국금액 -> 환전대상국가금액
					break;
				}
			}
			is.close();
			dis.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return result;
	}
}
