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
				country_name[arr_cnt] = split[0]; // ������
				country_exchangeRate[arr_cnt] = Double.parseDouble(split[1]); // ������ ȯ��
				arr_cnt++;
			}
			for(int i=0;i<arr_cnt;i++){
				if( country_name[i].equals(targetCountry) == true ){
					result = money / country_exchangeRate[i]; // �ѱ��ݾ� -> ȯ����󱹰��ݾ�
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
