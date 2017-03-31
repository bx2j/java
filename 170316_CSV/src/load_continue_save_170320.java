import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class load_continue_save_170320 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		DecimalFormat form = new DecimalFormat("#.##");
		try {
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\170320.csv");
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = new FileOutputStream("C:\\Users\\kopo\\Desktop\\170320_new.csv");
			DataOutputStream dos = new DataOutputStream(os);
			String title = "number" + "," + "math" + "," + "eng" + "," + "kor" + "," + "sum" + "," + "avg" + "\n";
			String space = "\n";
			dos.writeBytes(title);
			int size = 10,subject = 3;
			int[][] arr = new int[size][subject];
			int i=0,j=0,cnt=0,check=0,load = 0,value_cnt=0,save=0;
			boolean bool= true;
			System.out.println("load file - 1 / no - 2");
			try{
				load = scan.nextInt();
				if( load <= 0 || load > 2)
					throw new Exception();
			}catch(Exception e){
				System.out.println("input only 1 or 2");
				System.out.println("load file - 1 / no - 2");
				load = scan.nextInt();
			}
			if( load == 1 ){
				while(dis.available() > 0){
					String data = dis.readLine();
					if( bool == true){  // 원본을 읽어올 때 첫 줄의 label (number, math, eng, kor, sum, avg) 제거를 위한 if문
						bool = false;
						continue;
					}
					String[] split = data.split(","); // 읽어온 데이터를 쉼표로 구분하여 split 배열에 저장한다.
					System.out.println("name = " + split[0] + " ");
					System.out.print("Math = " + split[1]+ " ");
					System.out.print("Eng = " + split[2]+ " ");
					System.out.println("Kor = " + split[3]+ " ");
					for(i =0;i<subject;i++){
						arr[cnt][i] = Integer.parseInt(split[i+1]); // 학번은 값을 저장하면서 추가해주는 부분이므로 불러올 때는 학번을 제외하고 넣어 놓는다.
					}
					cnt++;
				}
				value_cnt = cnt; // no save시에 사용될 cnt 값
			}
			do{
				for( i=cnt;i<arr.length;i++ ){
					System.out.println((i+1) + " student");
					for( j=0;j<subject;j++ ){
						System.out.print("input " + (j+1) + " score : ");
						arr[i][j] = scan.nextInt();
						}
					cnt++;
					System.out.println("continue - 1 / stop - 2");
					try{
						check = scan.nextInt();
						if( check <= 0 || check > 2)
							throw new Exception();
						}catch(Exception e){
							System.out.println("input only 1 or 2");
							System.out.println("continue - 1 / stop - 2");
							check = scan.nextInt();
						}
					scan.nextLine();
					if( check == 2 )
						break;
					}
				}while( check != 2 );
			double[] sum = new double[5],avg = new double[5];
			System.out.println("save - 1 / no - 2");
			try{
				save = scan.nextInt();
				if( save <= 0 || save > 2 )
					throw new Exception();
			}catch(Exception e){
				System.out.println("input only 1 or 2");
				System.out.println("save - 1 / no - 2");
				save = scan.nextInt();
			}
			if( save == 1 ){
				for( i=0;i<cnt;i++ ){
					dos.writeBytes((i+1) + ",");
					for( j=0;j<subject;j++ ){
						sum[i] += arr[i][j];
						avg[i] = sum[i] / subject;
						dos.writeBytes(arr[i][j] + ",");
						}
					dos.writeBytes(sum[i] + "," + form.format(avg[i]) + space);
				}
			}
			else if( save == 2){
				for( i=0;i<value_cnt;i++ ){
					dos.writeBytes((i+1) + ",");
					for( j=0;j<subject;j++ ){
						sum[i] += arr[i][j];
						avg[i] = sum[i] / subject;
						dos.writeBytes(arr[i][j] + ",");
					}
					dos.writeBytes(sum[i] + "," + form.format(avg[i]) + space);
				}
			}
		}catch(Exception e){
			System.out.println(e.toString());
			}
	}
}
