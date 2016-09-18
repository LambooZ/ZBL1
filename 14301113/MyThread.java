import java.net.*;
import java.io.*;
public class MyThread implements Runnable {
	private Socket client = null;
	public MyThread(Socket client){
		this.client = client;
	}
	public void run() {
		PrintStream out = null;
		BufferedReader buf = null;	
		try {
			buf = new BufferedReader(
					new InputStreamReader(
					client.getInputStream()));
			out = new PrintStream(
					client.getOutputStream());
			boolean flag = true;
			while(flag){
				String str = buf.readLine();
				if(str == null || "".equals(str)){
					flag = false;
				}else{
					if("endit".equals(str)){
						flag = false;
					}else{
						out.println(str);
					}
				}
			}
			out.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
