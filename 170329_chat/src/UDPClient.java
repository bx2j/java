import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPClient {
   public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in);
      int port = 6786;
      // DatagramSocket, InetAddress
      DatagramSocket ds = new DatagramSocket(); // �����͸� �����ϱ� ���� DatagramSocket ����
      InetAddress ia = InetAddress.getByName("127.0.0.1");
      //DatagramPacket�� �� ip�ּҴ� InetAddress ���¿��� �ϱ� ����
      Thread urc = new Thread(new UDPReceiverClass(ds));
	  urc.start();
      while(true){
    	  //������ ������ ���� �Է� 
    	  System.out.print("message : ");    	  
    	  /*
    	   * BufferedReader message = new BufferedReader(new InputStreamReader(System.in)); 
    	   * // Ű����κ��� �Է¹޾� ����
    	   * String str = message.readLine();
    	   * byte[] sendTo_s = str.getBytes();
    	   * //�Է¹��� ���ڿ��� ����Ʈ�迭�� �ٲپ� �����Ѵ�.
    	   * */       	
    	  
    	  String str = scan.nextLine();
    	  byte[] sendTo_s = new byte[512];
    	  sendTo_s = str.getBytes();
    	  DatagramPacket dp = new DatagramPacket(sendTo_s, sendTo_s.length, ia, port);
    	  // ������ ������,������ ����, ������ ip�ּ�,������ port �ּҸ� ������ DatagramPacket (dp) ����  
    	  ds.send(dp); //DatagramPacket�� ������ ������ ����
    	  

    	 /* byte[] receiveFrom_s = new byte[512]; // �����κ��� ���۹��� ���� ����
    	  dp = new DatagramPacket(receiveFrom_s, receiveFrom_s.length, ia, port);
    	  ds.receive(dp); //�����κ��� ������ ���� ����
         
    	  //���� ���� ������ ���.
    	  String receive_str = new String(dp.getData());
    	  System.out.println("server ip : " + dp.getAddress() + " server port : " + dp.getPort());
    	  System.out.println("receive from server : " + receive_str);*/
    	  
    	  
    	  }
      
      }
}