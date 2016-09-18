import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String args[]) throws Exception {
		Socket client = new Socket("localhost", 8080);
		BufferedReader buf = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		PrintStream out = new PrintStream(client.getOutputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean flag = true;
		while (flag) {
			String str = input.readLine();
			out.println(str);
			if ("endit".equals(str)) {
				flag = false;
			} else {
				String echo = buf.readLine();
				System.out.println(echo);
			}
		}
		client.close();
		buf.close();
	}
}
