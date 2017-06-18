import java.io.*;

public class MoneyChangeClass {
	public double exchangeRate(double money, String targetMoney){
		double result = 0;
		int arr_cnt = 0, arr_size = 100; 
		String[] country_name = new String[arr_size];
		double[] country_exchangeRate = new double[arr_size];		
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\170322_exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				//System.out.print(split[0] + "\t"); 
				//System.out.println(split[1]+ "\t"); 
				country_name[arr_cnt] = split[0]; // ������
				country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // ������ ȯ��
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetMoney) == true ){
					result = money / country_exchangeRate[i]; // �ѱ��ݾ� -> ȯ����󱹰��ݾ�
					break;
				}
			}
			/*switch(targetMoney){
			case "USD": // �̱�
			case "usd":
				result = money / country_exchangeRate[0];
				break;
			case "EUR": // ��������
			case "eur":
				result = money / country_exchangeRate[1];
				break;
			case "JPY": // �Ϻ�
			case "jpy":
				result = money / country_exchangeRate[2];
				break;
			case "CNY": // �߱�
			case "cny":
				result = money / country_exchangeRate[3];
				break;
			case "HKD": // ȫ��
			case "hkd":
				result = money / country_exchangeRate[4];
				break;
			case "AUD": // ȣ��
			case "aud":
				result = money / country_exchangeRate[5];
				break;
			case "NZD": // ��������
			case "nzd":
				result = money / country_exchangeRate[6];
				break;
			}*/
			is.close();
			dis.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return result;
	}
	
	public double exchangeToKor(double countryMoney, String targetCountry){
		double result = 0;
		int arr_cnt = 0, arr_size = 100; 
		String[] country_name = new String[arr_size];
		double[] country_exchangeRate = new double[arr_size];		
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				country_name[arr_cnt] = split[0]; // ������
				country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // ������ ȯ��
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetCountry) == true ){
					result = countryMoney * country_exchangeRate[i]; // ȯ����󱹰��ݾ� -> �ѱ��ݾ�
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
