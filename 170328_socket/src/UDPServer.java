import java.net.*;
import java.io.*;

public class UDPServer {
	public static void main(String[] args){
		int port = 30000;
		try{
		  DatagramSocket ds = new DatagramSocket(port); 
		  //30000��Ʈ�� ������ DatagramSocket ��ü�� ����.
		  // client ���� DatagramPacket �� ���� �� �۽��ϱ� ����
		  while(true){
			  byte[] receiveFrom_c = new byte[512]; //UDP�� ���� �����ʹ� �Ϲ������� 512����Ʈ�� �����ϴ� ��찡 ���� ������ ����Ʈ �迭�� ũ�� 512
			  DatagramPacket dp = new DatagramPacket(receiveFrom_c, receiveFrom_c.length); // DatagramPacket�� ����Ʈ�迭 receiveFrom_c�� ���̸�ŭ ����
			  System.out.println("UDP Server ready");
			  ds.receive(dp);	//���ŵ� Datagram�� DatagramPacket�� ����

			  String str = new String(dp.getData()); // Datagram�� ���� �����͸� ���ڿ��� ��ȯ		 
			  InetAddress ia = dp.getAddress(); //�۽��� ���� Datagram�� ip�ּ� ��ȯ
			  port = dp.getPort();	//�۽��� ���� Datagram�� ��Ʈ��ȣ ��ȯ
			  System.out.println("client ip : " + ia + ", client port : " + port);			   
			  System.out.println("message of client : " + str);
			  
			  byte[] sendTo_c = new byte[512];
			  if(str.contains("weather")){
				  sendTo_c = "today is sunny!! :-)".getBytes();			  
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  // �۽��� ���� DatagramPacket ��ü�� �����Ѵ�. 
				  // IP�ּҿ� ��Ʈ��ȣ�� ���ŵ� Datagram�� IP�ּҿ� ��Ʈ�� �ؾ� �Ѵ�.
				  ds.send(dp);
			  }
			  else if(str.contains("a")){
				  sendTo_c = str.toUpperCase().getBytes();			  
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  ds.send(dp);
			  }
			  else if(str.contains("home")){
				  sendTo_c = "go home!!!".getBytes();			  
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  ds.send(dp);
			  }
			  else if(str.contains("money")){
				  sendTo_c = "give me money!!!".getBytes();			  
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  ds.send(dp);
			  }			  
			  else if(str.contains("hungry")){
				  sendTo_c = "me too!".getBytes();
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  ds.send(dp);
			  }
			  else{
				  sendTo_c = "nono!!!!!!!!".getBytes();
				  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
				  ds.send(dp);
			  }		  
		  }
	  }catch(IOException e){
	   e.printStackTrace();
	  }
	}
}