import java.io.*;

public class AddCountry {
	public String Country(String targetCountry){
		String Country = null;
		int arr_cnt = 0;
		String[] country_name = new String[exchange_test.arr_size];
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\exchange.csv");
			DataInputStream dis = new DataInputStream(is);
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); 
				country_name[arr_cnt] = split[0]; // ±¹°¡¸í
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetCountry) == true ){
					Country = country_name[i]; 
					break;
				}
			}
			is.close();
			dis.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return Country;
	}
}
