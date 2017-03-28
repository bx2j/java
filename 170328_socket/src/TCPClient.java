import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		try{
			Socket socket;
			InputStream is;
			DataInputStream dis;
			OutputStream os;
			DataOutputStream dos;
			
			String sendString = scan.nextLine();
			socket = new Socket("172.20.30.214",5433);
			is = socket.getInputStream();
			dis = new DataInputStream(is);			
			String st = new String(dis.readUTF());
			System.out.println(st);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dos.writeUTF(" * " + sendString );
			
			st = new String(dis.readUTF());
			System.out.println(st);
			
			dos.close();
			os.close();
			dis.close();
			is.close();
			socket.close();			
		}
		catch(ConnectException connExc){
			System.out.println("server connection fail");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
