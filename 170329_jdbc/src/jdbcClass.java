import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcClass {
	Statement stmt1 = null;
	jdbcClass(Statement stmt){
		this.stmt1 = stmt;
	}
	public void a() throws SQLException{
		String name=null;
		double kor=0,mat=0,avg=0,total=0,eng=0; 
		int a=0;
		Scanner scan = new Scanner(System.in);		
		while(true){
			a++;
			System.out.print("input name (want end -> input end) : ");
			name = scan.nextLine();
			if(name.equals("end") == true)
				break;
			System.out.print("korean score : ");
			kor = scan.nextInt();
			System.out.print("math score : ");
			mat = scan.nextInt();
			System.out.print("eng score : ");
			eng = scan.nextInt();
			total = (kor + mat + eng);
			avg = total / 3;
			
			stmt1.execute("insert into NewTable values ('" + name + "'," + a + "," + kor + "," + mat + "," + eng + ","  
					+ total + "," + avg +")");		
			 
			ResultSet rest = stmt1.executeQuery("select * from NewTable;");
			while(rest.next()){
				System.out.println(rest.getString(1) + "\t" + rest.getString(2) +"\t" + rest.getString(3)
				+ "\t" + rest.getString(4) + "\t" + rest.getString(5) + "\t" + rest.getString(6) + "\t" + rest.getString(7));
			}	
			scan.nextLine();
		}
	}
}
