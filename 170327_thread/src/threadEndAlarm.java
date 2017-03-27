
public class threadEndAlarm implements Runnable{
	public void run(){
		try {
			Thread.sleep(threadAlarmValue.alarm);
			System.out.println("end!!!go home!!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
