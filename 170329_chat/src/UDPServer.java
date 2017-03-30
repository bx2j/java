import java.net.*;
import java.io.*;
import java.util.*;
public class UDPServer {
	
	public static void main(String[] args){
		int port ;
		try{
		  DatagramSocket ds = new DatagramSocket(6786); 
		  //30000포트를 가지는 DatagramSocket 객체를 생성.
		  // client 에게 DatagramPacket 를 수신 및 송신하기 위해
		  System.out.println("UDP Server ready");		 
		  while(true){
			  byte[] receiveFrom_c = new byte[512]; //UDP의 실제 데이터는 일반적으로 512바이트로 제한하는 경우가 많기 때문에 바이트 배열의 크기 512
			  DatagramPacket dp = new DatagramPacket(receiveFrom_c, receiveFrom_c.length); // DatagramPacket을 바이트배열 receiveFrom_c의 길이만큼 저장

			  ds.receive(dp);	//수신된 Datagram을 DatagramPacket에 저장
			  String str = new String(dp.getData()); // Datagram의 실제 데이터를 문자열로 변환		 
			  InetAddress ia = dp.getAddress(); //송신을 위해 Datagram의 ip주소 반환
			  port = dp.getPort();	//송신을 위해 Datagram의 포트번호 반환
			  System.out.println("client ip : " + ia + ", client port : " + port);			   
			  System.out.println("message of client : " + str);
			 // str = str.toLowerCase();
			  byte[] sendTo_c = new byte[512];
			  Class us = new Class();
			  String str1 = us.cs(str);			  
			  sendTo_c = str1.getBytes();
			  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
			  // 송신을 위한 DatagramPacket 객체를 생성한다. 
			  // IP주소와 포트번호는 수신된 Datagram의 IP주소와 포트로 해야 한다.
			  ds.send(dp);
		  }
	  }catch(IOException e){
	   e.printStackTrace();
	  }
	}
}