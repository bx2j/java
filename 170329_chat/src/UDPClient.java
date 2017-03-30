import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPClient {
   public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in);
      int port = 6786;
      // DatagramSocket, InetAddress
      DatagramSocket ds = new DatagramSocket(); // 데이터를 전송하기 위한 DatagramSocket 생성
      InetAddress ia = InetAddress.getByName("127.0.0.1");
      //DatagramPacket에 들어갈 ip주소는 InetAddress 형태여야 하기 때문
      Thread urc = new Thread(new UDPReceiverClass(ds));
	  urc.start();
      while(true){
    	  //서버로 전송할 내용 입력 
    	  System.out.print("message : ");    	  
    	  /*
    	   * BufferedReader message = new BufferedReader(new InputStreamReader(System.in)); 
    	   * // 키보드로부터 입력받아 저장
    	   * String str = message.readLine();
    	   * byte[] sendTo_s = str.getBytes();
    	   * //입력받은 문자열을 바이트배열로 바꾸어 저장한다.
    	   * */       	
    	  
    	  String str = scan.nextLine();
    	  byte[] sendTo_s = new byte[512];
    	  sendTo_s = str.getBytes();
    	  DatagramPacket dp = new DatagramPacket(sendTo_s, sendTo_s.length, ia, port);
    	  // 전달할 데이터,데이터 길이, 서버의 ip주소,서버의 port 주소를 가지는 DatagramPacket (dp) 생성  
    	  ds.send(dp); //DatagramPacket의 내용을 서버로 전송
    	  

    	 /* byte[] receiveFrom_s = new byte[512]; // 서버로부터 전송받을 내용 저장
    	  dp = new DatagramPacket(receiveFrom_s, receiveFrom_s.length, ia, port);
    	  ds.receive(dp); //서버로부터 내용을 전송 받음
         
    	  //전송 받은 내용을 출력.
    	  String receive_str = new String(dp.getData());
    	  System.out.println("server ip : " + dp.getAddress() + " server port : " + dp.getPort());
    	  System.out.println("receive from server : " + receive_str);*/
    	  
    	  
    	  }
      
      }
}