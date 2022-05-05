import java.net.*;
import java.io.*;

public class GreetingClient {

	public static void main(String args[]) throws IOException {
		final int portNumber = 84;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println("What's you name?");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = br.readLine();

			pw.println("Hello, " + str);
			pw.close();
			socket.close();

			System.out.println("Just said hello to:" + str);
		}
	}
}