import java.net.*;
import java.io.*;
import java.util.*;
public class UDPServer {
	
	public static void main(String[] args){
		int port ;
		try{
		  DatagramSocket ds = new DatagramSocket(6786); 
		  //30000��Ʈ�� ������ DatagramSocket ��ü�� ����.
		  // client ���� DatagramPacket �� ���� �� �۽��ϱ� ����
		  System.out.println("UDP Server ready");		 
		  while(true){
			  byte[] receiveFrom_c = new byte[512]; //UDP�� ���� �����ʹ� �Ϲ������� 512����Ʈ�� �����ϴ� ��찡 ���� ������ ����Ʈ �迭�� ũ�� 512
			  DatagramPacket dp = new DatagramPacket(receiveFrom_c, receiveFrom_c.length); // DatagramPacket�� ����Ʈ�迭 receiveFrom_c�� ���̸�ŭ ����

			  ds.receive(dp);	//���ŵ� Datagram�� DatagramPacket�� ����
			  String str = new String(dp.getData()); // Datagram�� ���� �����͸� ���ڿ��� ��ȯ		 
			  InetAddress ia = dp.getAddress(); //�۽��� ���� Datagram�� ip�ּ� ��ȯ
			  port = dp.getPort();	//�۽��� ���� Datagram�� ��Ʈ��ȣ ��ȯ
			  System.out.println("client ip : " + ia + ", client port : " + port);			   
			  System.out.println("message of client : " + str);
			 // str = str.toLowerCase();
			  byte[] sendTo_c = new byte[512];
			  Class us = new Class();
			  String str1 = us.cs(str);			  
			  sendTo_c = str1.getBytes();
			  dp = new DatagramPacket(sendTo_c, sendTo_c.length, ia, port); 
			  // �۽��� ���� DatagramPacket ��ü�� �����Ѵ�. 
			  // IP�ּҿ� ��Ʈ��ȣ�� ���ŵ� Datagram�� IP�ּҿ� ��Ʈ�� �ؾ� �Ѵ�.
			  ds.send(dp);
		  }
	  }catch(IOException e){
	   e.printStackTrace();
	  }
	}
}