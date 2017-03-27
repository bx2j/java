import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class gs_170327 {
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(System.in);
			Date date = new Date();
			
			InputStream is = new FileInputStream("C:\\Users\\kopo\\Desktop\\gs.csv");
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = new FileOutputStream("C:\\Users\\kopo\\Desktop\\gs_final.csv");
			DataOutputStream dos = new DataOutputStream(os);
			
			int size = 10;
			int goods_size = 4;
			String[] goods_name = new String[size];
			int total_sum=0;
			int[] goods_price = new int[size], goods_stock = new int[size], select_arr = new int[size], count_arr = new int[size];
			int[] arr = new int[size];
			int[] new_arr = new int[size];
			int i=0,x=0,check=0,select=0,count=0,cnt=0;
			int all_sum=0,open=0,sum=0,new_total_sum=0;
			
			System.out.println("===== Goods_list =====");
			System.out.println("goods\tprice\tstock");
			System.out.println("======================");
			while( dis.available() > 0 ){
				String data = dis.readLine();
				String[] split = data.split(","); // 읽어온 데이터를 쉼표로 구분하여 split 배열에 저장한다.
				System.out.print(split[0] + "\t"); // goods_name
				System.out.print(split[1]+ "\t"); // goods_price
				System.out.println(split[2]); // goods_stock
				goods_name[x+1] = split[0];
				goods_price[x+1] = Integer.parseInt(split[1]);
				goods_stock[x+1] = Integer.parseInt(split[2]);
				
				x++;
			}
			System.out.println();
			do{
				select_arr = new int[size];
				count_arr =  new int[size];
				arr =  new int[size];
				total_sum=0;				
				do{
					System.out.print("choose goods_number : ");
					select = scan.nextInt();
					switch(select){
					case 1:
						System.out.println("select " + select + " => " + goods_name[1] + "," + goods_price[1]);	
						System.out.print("input goods_conunt : ");
						try{
							count = scan.nextInt();
							if(count > goods_stock[1])
								throw new Exception();
						}catch(Exception e){
							System.out.print("no stock.. re-select count under "+ goods_stock[1] + " : ");
							count = scan.nextInt();
						}
						System.out.println("goods count : " + count);
						goods_stock[1] = goods_stock[1] - count;
						break;
					case 2:
						System.out.println("select " + select + " => " + goods_name[2] + "," + goods_price[2]);
						System.out.print("input goods_conunt : ");
						try{
							count = scan.nextInt();
							if(count > goods_stock[2])
								throw new Exception();
						}catch(Exception e){
							System.out.print("no stock.. re-select count under "+ goods_stock[2] + " : ");
							count = scan.nextInt();
						}
						System.out.println("goods count : " + count);
						goods_stock[2] = goods_stock[2] - count;					
						break;
					case 3:
						System.out.println("select " + select + " => " + goods_name[3] + "," + goods_price[3]);
						System.out.print("input goods_conunt : ");
						try{
							count = scan.nextInt();
							if(count > goods_stock[3])
								throw new Exception();
						}catch(Exception e){
							System.out.print("no stock.. re-select count under "+ goods_stock[3] + " : ");
							count = scan.nextInt();
						}
						System.out.println("goods count : " + count);
						goods_stock[3] = goods_stock[3] - count;
						break;
					case 4:
						System.out.println("select " + select + " => " + goods_name[4] + "," + goods_price[4]);
						System.out.print("input goods_conunt : ");
						try{
							count = scan.nextInt();
							if(count > goods_stock[4])
								throw new Exception();
						}catch(Exception e){
							System.out.print("no stock.. re-select count under "+ goods_stock[4] + " : ");
							count = scan.nextInt();
						}
						System.out.println("goods count : " + count);
						goods_stock[4] = goods_stock[4] - count;
						break;
					}				
					System.out.print("continue - 1 / stop - 2 : ");
					try{
						check = scan.nextInt();
						if( check <= 0 || check > 2)
							throw new Exception();
						}catch(Exception e){
							System.out.println("input only 1 or 2");
							System.out.print("continue - 1 / stop - 2 : ");
							check = scan.nextInt();
						}
					scan.nextLine();
					
					// 출력을 위해 상품선택, 수량을 배열에 따로 저장
					select_arr[cnt] = select;
					count_arr[cnt] = count;
					cnt++;
					if( check == 2 )
						break;
				}while( check != 2);
				System.out.println("========== receipt ==========");
				System.out.println("goods\tprice\tcount\tsum");
				System.out.println("=============================");
				/*for(i =0;i<cnt;i++){
					System.out.println(goods_name[select_arr[i]] + "\t" + goods_price[select_arr[i]] + "\t" 
							+ count_arr[i] + "\t" + (goods_price[select_arr[i]] * count_arr[i]));
					all_sum += (goods_price[select_arr[i]] * count_arr[i]);
				}
				System.out.println("\n"+"all price : " + all_sum);*/ // 출력 확인
				
				for(i=0;i<cnt;i++){
					for(int j=1;j<=goods_size;j++){
						if(select_arr[i] == j){
							arr[j] = arr[j] + count_arr[i];
							break;
						}
					}
				}
				//System.out.println(arr[1] +" "+arr[2]+" "+arr[3]); // 출력 확인
				for( i=1;i<=goods_size;i++){
					if( arr[i] > 0){
						System.out.println(goods_name[i] + "\t" + goods_price[i] + "\t" + arr[i] + "\t" + (goods_price[i]*arr[i]));
						total_sum += (goods_price[i]*arr[i]);
					}
				}
				System.out.println("total : " + total_sum);
				
				for(i=1;i<=goods_size;i++){ // 마감을 위해 현재까지 입력된 count 누적
					new_arr[i] += arr[i];
					//System.out.println(new_arr[i]); // 출력 확인
				}
				
				System.out.print("continue - 1 close - 2 : ");
				try{
					open = scan.nextInt();
					if( open <= 0 || open > 2)
						throw new IllegalArgumentException();
					}catch(IllegalArgumentException e){
						System.out.println("input only 1 or 2");
						System.out.print("continue - 1 close - 2 : ");
						open = scan.nextInt();
					}
				/*if( open == 2){
					System.out.println("========list========");
					System.out.println("goods\tprice\tcount\tsum");				
					for(i=0;i<cnt;i++){
						if(select_arr[i] == 1){
							arr[1] = arr[1] + count_arr[i];
						}
						else if(select_arr[i] == 2){
							arr[2] = arr[2] + count_arr[i];
						}
						else if(select_arr[i] == 3){
							arr[3] = arr[3] + count_arr[i];
						}
					}
					for(i=0;i<cnt;i++){
						for(int j=1;j<5;j++){
							if(select_arr[i] == j){
								arr[j] = arr[j] + count_arr[i];
								break;
							}
						}
					}
					//System.out.println(arr[1] +" "+arr[2]+" "+arr[3]);
					for( i=1;i<5;i++){
						if( arr[i] > 0){
							System.out.println(goods_name[i] + "\t" + goods_price[i] + "\t" + arr[i] + "\t" + (goods_price[i]*arr[i]));
							total_sum += (goods_price[i]*arr[i]);
						}
					}
					System.out.println("total : " + total_sum);
					System.out.println();
					for(i =0;i<cnt;i++){
					System.out.println(goods_name[select_arr[i]] + "\t" + goods_price[select_arr[i]] + "\t" 
							+ count_arr[i] + "\t" + (goods_price[select_arr[i]] * count_arr[i]));}
					all_sum += (goods_price[select_arr[i]] * count_arr[i]);
					// 한명만 받고 끝나는 코드
				}*/
			}while(open != 2);

			System.out.println("======== "+date);
			System.out.println("goods\tprice\tcount\tsum");
			for( i=1;i<=goods_size;i++){
				if( new_arr[i] > 0){
					System.out.println(goods_name[i] + "\t" + goods_price[i] + "\t" + new_arr[i] + "\t" + (goods_price[i]*new_arr[i]));
					new_total_sum += (goods_price[i]*new_arr[i]);
				}
			}			
			System.out.println("total : " + new_total_sum);
			System.out.println("======== Current state of stock");
			for(i=1;i<=goods_size;i++)
				System.out.print(goods_name[i] + "\t" + goods_stock[i] + "\n");
			
			int add_stock=0;
			for(i=1;i<=goods_size;i++){
				if( goods_stock[i] <= 5 ){
					System.out.println(" warning - stock under 5 of " + goods_name[i]);
					System.out.println(" remanet stock - " + goods_stock[i]);
				}
			}
			
			DateFormat dateform = new SimpleDateFormat("yyMMdd");
			String date_save = dateform.format(date);
			dos.writeBytes(date_save + "\n" + "Goods" + "," + "Price" + "," + "Count" + "," + "sum" + "\n");
			String[] save_list = new String[size];
			for( i=1;i<=goods_size;i++){
				if( new_arr[i] > 0){					
					save_list[i] = goods_name[i] + "," + goods_price[i] + "," + new_arr[i] + "," + (goods_price[i]*new_arr[i] +"\n");
					dos.writeBytes(save_list[i]);
				}
			}		
			dos.writeBytes("total" + "," + new_total_sum + "\n" + "," + "Stock");
			int[] stock = new int[size];
			for(i=1;i<=goods_size;i++){
				stock[i] = goods_stock[i];
				dos.writeBytes("\n" + goods_name[i] +","+stock[i]);
			}
			
			is.close();
			dis.close();
			os.close();
			dos.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		}
		
}


