import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
public class create_array_savecsv {
	public static void main(String[] args){
		try{
			OutputStream os = new FileOutputStream("C:\\Users\\kopo\\Desktop\\170316_grade1.csv") ;
			DataOutputStream dos = new DataOutputStream(os) ;
			DecimalFormat form = new DecimalFormat("#.##") ; // 소수점 2자리까지 표시
			Scanner scan = new Scanner(System.in) ;
			int size = 0 ;
			
			System.out.println("how many people input?? ") ;
			size = scan.nextInt() ;
			scan.nextLine() ;
			
			String str = null;
			String[] grade = new String[size];
			double math_sum = 0, eng_sum = 0, kor_sum = 0, all_sum =0, all_avg=0, math_avg=0, eng_avg=0, kor_avg=0 ;
			int[] eng = new int[size], math= new int[size], kor = new int[size], sum = new int[size] ;
			double[] avg = new double[size] ;
			String[] name = new String[size] , list = new String[size] ;
			String space = "\n";
			
			String t_name = "NAME" , t_math = "MATH" , t_eng = "ENGLISH" ,t_kor = "KOREAN", t_sum = "SUM", t_avg = "AVERAGE" , t_grade = "GRADE";
			String high = t_name + "," + t_math + "," + t_eng + "," + t_kor + "," + t_sum + "," + t_avg + "," + t_grade + space ;
			dos.writeBytes(high); // grade1.csv 상단에 이름, 수학, 영어, 국어, 합계, 평균 출력
			
			for(int i = 0;i < size;i++){
				System.out.print("input name : ") ;
				name[i] = scan.nextLine() ;
				System.out.print("input math-grade : ") ;
				math[i] = scan.nextInt() ;
				System.out.print("input eng-grade : ") ;
				eng[i] = scan.nextInt() ;
				System.out.print("input kor-grade : ") ;
				kor[i] = scan.nextInt() ;
				//System.out.println(name[i] + math[i] + eng[i]);
				scan.nextLine() ;
			}
			
			for(int i = 0;i < size;i++){
				sum[i] += (math[i] + eng[i] + kor[i]) ;
				avg[i] = sum[i] / 3 ;
				if(avg[i] >= 90){
					str = "A";
					grade[i] = str;
				}
				else if( avg[i] >= 80 && avg[i] <= 89 ){
					str = "B";
					grade[i] = str;
				}
				else if( avg[i] >= 70 && avg[i] <= 79 ){
					str = "C";
					grade[i] = str;
				}
				else if( avg[i] >= 60 && avg[i] <= 69 ){
					str = "D";
					grade[i] = str;
				}
				else if( avg[i] < 60 ){
					str = "F";
					grade[i] = str;
				}					
				list[i] = name[i] + "," + math[i] + "," + eng[i] + "," + kor[i] + "," + sum[i] + "," + form.format(avg[i]) + "," + grade[i] + space ;
				dos.writeBytes(list[i]) ;
			}	
			
			for(int i = 0;i < size;i++){
				math_sum += math[i] ;
				eng_sum += eng[i] ;
				kor_sum += kor[i] ;
			}
			all_sum = math_sum + eng_sum + kor_sum ;
			all_avg = all_sum / 3 ;
			String bottom = "," + math_sum + "," + eng_sum + "," + kor_sum + "," + all_sum + "," + form.format(all_avg) + space ;
			dos.writeBytes(bottom) ; // grade1.csv 하단에 수학, 영어, 국어의 각 합계들 출력 및 합계들의 총합과 평균 출력
			
			math_avg = math_sum / size ;
			eng_avg = eng_sum / size ;
			kor_avg = kor_sum / size ;
			String bottom_1 = "," + form.format(math_avg) + "," + form.format(eng_avg) + "," + form.format(kor_avg) ;
			dos.writeBytes(bottom_1) ; // grade1.csv 하단에 수학, 영어, 국어 각각 합계의 평균 출력
			
			scan.close();
			os.close();
			dos.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
