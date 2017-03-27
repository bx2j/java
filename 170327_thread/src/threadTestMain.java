import java.util.Scanner;

public class threadTestMain {
	
	public static void main(String[] args) throws InterruptedException{
		Scanner scan = new Scanner(System.in);
		
		//threadClass tc = new threadClass(); // use extends Thread
		Thread tc = new Thread(new threadEndAlarm()); // use implements Runnable
		Thread justThread = new Thread(new threadContinueAlarm());
				
		System.out.println("alarm time designation");
		threadAlarmValue.alarm = scan.nextInt();
		
		tc.start();
		justThread.start();
		
		while(true){
			try{
				System.out.println("working¤Ñ¤Ñ");
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e.toString());				
			}
		}
		
	}
}
