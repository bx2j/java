import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Calc_bonus_by_stmt_8 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM",Locale.KOREA);
		Date date = new Date();
		String yyyymm = sdf.format(date);
		Connection conn = null;	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver load success");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.149.128:1521:orasparta","scott","tiger");
		conn.setAutoCommit(false); // autocommit ����
		System.out.println("db connect success");	
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement currentStack = stacks[ 0 ]; // ���� class ���
		System.out.println( "current class : " + currentStack.getClassName() );
		long startTime = System.currentTimeMillis();
		CallableStatement cs = conn.prepareCall(
				"declare" + // ���� ����
					" cursor cur is (select empno,job,deptno,sal,"+ // Explicit cursor ����
						"case deptno "+ // �μ��� ���ʽ� ���
							"when 10 then trunc(sal * 0.3) "+ // 10�� �μ� �޿��� 30% ����
							"when 20 then trunc(sal * 0.1) "+ // 20�� �μ� �޿��� 10% ����
							"when 30 then trunc(sal * 0.05) "+ // 30�� �μ� �޿��� 5% ����
							"when 40 then trunc(sal * 0.2) "+ // 40�� �μ� �޿��� 20% ����
							"end as bonus "+
							"from emp_large where job != 'PRESIDENT'); "+
					"val number := 0; " + // processing status �� ���� ����
				"begin "+ // ����
					"insert into processing(class_name,status,note) values(?,val,'start'); " + 
					// ó�� ��Ȳ�� ����ϴ� processing ���̺� ���� class_name , ����(�� �� ó����), ���� ���� 
					"for i in cur "+ // for loop ����
					"loop "+
						"insert into bonus7 values(?,i.empno,i.job,i.deptno,i.sal,i.bonus); "+
						"val := val + 1; "+
						"if mod(val,10000)=0 then "+ // 10000 �Ǵ� ���� �� ����
						// if ~ then ���� if �� ����
						// mod(n,m) n�� m ���� ���� �������� ���Ѵ�
							"insert into processing(class_name,status,note) values(?,val,'ing'); " +
							// ó�� ��Ȳ�� ����ϴ� processing ���̺� ���� class_name , ����(�� �� ó����), ���� �� ����
							"commit; "+
						"end if; "+ // if ����
					"end loop; "+ // for loop ����
					"insert into processing(class_name,status,note) values(?,val,'end'); " +
					// ó�� ��Ȳ�� ����ϴ� processing ���̺� ���� class_name , ����(�Ϸ� �Ǽ�), �Ϸ� ����
				"exception "+ // ����ó�� ����
					"when others then "+
						"insert into err_msg(class_name,err_msg,err_backtrace) " 
						+ "values(?,dbms_utility.format_error_stack,dbms_utility.format_error_backtrace); "+
						// err_msg ���̺� ���� class_name,error�޽���,error �߻� ��ġ ���
				"end; "); // block �� ����		
		cs.setString(1, currentStack.getClassName()); // class_name - Calc_bonus_by_stmt_8
		cs.setString(2, yyyymm); // ���ʽ� ���� ���
		cs.setString(3, currentStack.getClassName());
		cs.setString(4, currentStack.getClassName());
		cs.setString(5, currentStack.getClassName());
		cs.execute();
	
		long endTime = System.currentTimeMillis();		
		System.out.println("Process Time : " + (endTime-startTime)/1000 + "sec");		
		conn.close();
	}
}