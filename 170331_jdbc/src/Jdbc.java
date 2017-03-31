import java.sql.*;
import java.util.Scanner;

public class Jdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{	
		Scanner scan = new Scanner(System.in);
		String name = null;		
		int eng = 0, mat = 0;
		// DB Loading
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.23.91:33066/ex2?useSSL=true&verifyServerCertificate=false","root","1q2w3e");
		Statement stmt = con.createStatement();
		
		while(true){
			// input
			System.out.print("name : ");
			name = scan.nextLine();
			if(name.toLowerCase().equals("end"))
				break;
			System.out.print("eng : ");
			eng = scan.nextInt();
			System.out.print("mat : ");
			mat = scan.nextInt();
			scan.nextLine();
			
			// input data -> insert db
			stmt.execute("insert into score ( name,eng,mat,total,avg) values (" 
			+ "'" + name + "'," + eng + "," + mat + ","	+ (eng+mat) + "," + ((eng+mat)/2) +")");
			
			// print
			System.out.println("name\teng\tmat\ttotal\tavg");
			
			// DB table print
			ResultSet rest = stmt.executeQuery("select * from score;");
			while(rest.next()){
				// result print
				System.out.println(rest.getString(2) +"\t" + rest.getString(3)
				+ "\t" + rest.getString(4) + "\t" + rest.getString(5) + "\t" + rest.getString(6));
			}
			// all total
			rest = stmt.executeQuery("select sum(eng), sum(mat) from score;");
			rest.next();
			System.out.println("all total\t" + rest.getString(1) + "\t" + rest.getString(2));
			// all avg
			rest = stmt.executeQuery("select avg(eng), avg(mat) from score;");
			rest.next();
			System.out.println("all avg\t" + rest.getString(1) + "\t" + rest.getString(2));
		}
		stmt.close();
		con.close();
		scan.close();
	}
}
