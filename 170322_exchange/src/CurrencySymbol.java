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
				country_name[arr_cnt] = split[0]; // ������
				//country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // ������ ȯ��
				country_sysmbol[arr_cnt] = split[2]; // ������ ��ȭ ��ȣ
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
		case "USD": // �̱�
		case "usd":
			currency = "$";
			break;
		case "EUR": // ��������
		case "eur":
			currency = "��";
			break;
		case "JPY": // �Ϻ�
		case "jpy":
			currency = "��";
			break;
		case "CNY": // �߱�
		case "cny":
			currency = "�";
			break;
		case "HKD": // ȫ��
		case "hkd":
			currency = "HK$";
			break;
		case "AUD": // ȣ��
		case "aud":
			currency = "A$";
			break;
		case "NZD": // ��������
		case "nzd":
			currency = "NZ$";
			break;
		}
*/		return currency;
	}
}
