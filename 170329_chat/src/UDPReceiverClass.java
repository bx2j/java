import java.io.IOException;
import java.net.*;

public class UDPReceiverClass implements Runnable{
	DatagramSocket ds_receiver = null;
	// ������
	UDPReceiverClass(DatagramSocket ds){
		this.ds_receiver = ds;
	}
	// ���� ����
	public void run(){
		try {			
	  	  	while(true){
		  	  	byte[] receiveFrom_s = new byte[512]; // �����κ��� ���۹��� ���� ����
		  	  	DatagramPacket dp = new DatagramPacket(receiveFrom_s, receiveFrom_s.length);
		  	  	this.ds_receiver.receive(dp); //�����κ��� ������ ���� ����				       
		  	  	//���� ���� ������ ���.
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
