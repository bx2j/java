import java.io.*;
import java.net.*;
public class TCPServer {
	public static void main(String[] args){
		ServerSocket ssocket = null;
		Socket socket;
		OutputStream os;
		DataOutputStream dos;
		InputStream is;
		DataInputStream dis;
		
		try{
			ssocket = new ServerSocket(7732);
		}catch(IOException e){
			e.printStackTrace();
		}
		while(true){
			try{
			System.out.println("ddd");
			socket = ssocket.accept();
			System.out.println("clear");
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dos.writeUTF("!!!!!!lkjdlkasjflk");
			
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			String st = new String(dis.readUTF());
			System.out.println(st);
			
			
			}catch(IOException e){
				e.toString();
			}
		}
	}
}