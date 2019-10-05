import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean start = true;
		try {
			ServerSocket serverSocket = new ServerSocket(9000);
			while(start) {
				System.out.println("Waiting for Client");
				
				Socket client = serverSocket.accept(); //This statement waits for client
				
				System.out.println("Client Connected: " + client.getRemoteSocketAddress());
				
				String data[] = {"Amul","Chitale","Thorat","Mitkari"};
				
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());	//Sending Data
				DataInputStream dis  = new DataInputStream(client.getInputStream());	//Receive Data
				
				dos.writeInt(data.length);
				
				for(int i = 0;i<data.length;i++) {
					dos.writeUTF(data[i]);
				}
				
			}
		}
		catch(Exception e) {
			
		}

	}

}
