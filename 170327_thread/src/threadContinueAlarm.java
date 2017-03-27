
public class threadContinueAlarm implements Runnable{
	public void run(){
		try{
			while(true){
				Thread.sleep((threadAlarmValue.alarm + 3500));
				System.out.println("give me money!!!");
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
}
