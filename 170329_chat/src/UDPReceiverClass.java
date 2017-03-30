import java.io.IOException;
import java.net.*;

public class UDPReceiverClass implements Runnable{
	DatagramSocket ds_receiver = null;
	// 생성자
	UDPReceiverClass(DatagramSocket ds){
		this.ds_receiver = ds;
	}
	// 수신 전용
	public void run(){
		try {			
	  	  	while(true){
		  	  	byte[] receiveFrom_s = new byte[512]; // 서버로부터 전송받을 내용 저장
		  	  	DatagramPacket dp = new DatagramPacket(receiveFrom_s, receiveFrom_s.length);
		  	  	this.ds_receiver.receive(dp); //서버로부터 내용을 전송 받음				       
		  	  	//전송 받은 내용을 출력.
		  	  	String receive_str = new String(dp.getData());
		  	  	//System.out.println("server ip : " + dp.getAddress() + " server port : " + dp.getPort());
		  	  	System.out.println("\nreceive from server : " + receive_str);
	  	  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
