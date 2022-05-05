import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClientSocket {

	public static void main(String args[]) throws IOException {
		final String host = "localhost";
		final int portNumber = 84;
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);

		while (true) {
			Socket socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("server says:" + br.readLine());

			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			out.println(userInput);

			System.out.println("server says:" + br.readLine());

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}
}