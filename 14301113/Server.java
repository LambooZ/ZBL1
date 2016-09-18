import java.io.IOException;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(8888);
			Socket client = null;
			boolean flag = true;
			while (flag) {
				client = server.accept();
				new Thread(new MyThread(client)).start();
			}
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
