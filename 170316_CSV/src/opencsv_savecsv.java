import java.io.*;
public class opencsv_savecsv {
	public static void main(String[] args){
		try{
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\170316_2.csv"); 
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = new FileOutputStream("C:\\Users\\kopo\\Desktop\\170316_3.csv");
			DataOutputStream dos = new DataOutputStream(os);
			String s_name = "NAME" , s_math = "MATH" , s_eng = "ENGLISH" ,s_kor = "KOREAN", 
					s_sum = "SUM", s_avg = "AVERAGE";
			String high = s_name + "," + s_math + "," + s_eng + "," + s_kor + "," + s_sum + "," + s_avg + "\n" ;
			dos.writeBytes(high);
			int size=7;
			int[] math = new int[size];			int[] eng = new int[size];
			int[] kor = new int[size];			int math1=0,eng1=0,kor1=0;
			int math_sum =0;			int eng_sum =0;			int kor_sum = 0;
			while(dis.available() > 0){
				String data = dis.readLine();
				String[] split = data.split(",");
				System.out.println("original data = "+data);
				System.out.println("name = " + split[0] + " ");
				System.out.print("Math = " + split[1]+ " ");
				System.out.print("Eng = " + split[2]+ " ");
				System.out.println("Kor = " + split[3]+ " ");		
				math1 = Integer.parseInt(split[1]);
				eng1 = Integer.parseInt(split[2]);
				kor1 = Integer.parseInt(split[3]);
				for(int i=0;i<size;i++){
					math[i] = Integer.parseInt(split[1]);
					eng[i] = Integer.parseInt(split[2]);
					kor[i] = Integer.parseInt(split[3]);
					
				}
				
				int sum = (math1 + eng1 + kor1);
				int avg = sum/3;
				System.out.println("all subject sum = " + (math1 + eng1 + kor1));
				System.out.println("all subject avg = " + (sum / 3));
				String ndata = 
						split[0]+","+split[1] + "," + split[2] + "," +split[3] + "," + sum + "," + avg + "," + "\n";			
				dos.writeBytes(ndata);
				
				}
			int all_sum=0;
			int all_avg = 0;
			for(int i=0;i<size;i++){
				math_sum += math[i];
				eng_sum += eng[i];
				kor_sum += kor[i];
			}
			all_sum = math_sum + eng_sum + kor_sum;
			all_avg = all_sum/3;
			String bottom = "," + math_sum + "," + eng_sum + "," + kor_sum + "," + all_sum + "," + all_avg ;
			dos.writeBytes(bottom);
			
			is.close();
			dis.close();
			os.close();
			dos.close();
		
			}catch(Exception e){
				e.printStackTrace();
			}	
	}
}
