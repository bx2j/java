import java.lang.reflect.Method;

public class CurrentClassName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement currentStack = stacks[ 0 ];
		System.out.println( "my class : " + currentStack.getClassName() );
		//System.out.println( "my method : " + currentStack.getMethodName() );  

		
		
		
	}

}
