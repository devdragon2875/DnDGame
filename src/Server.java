import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private static String[] names = {"Wily", "Felix", "Carlsbad", "Hobob"};
	private static final int PORT = 3030;
	
	private static ArrayList<ClientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(4);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket listener = new ServerSocket(PORT);
		
		while(true) {
			System.out.println("[SERVER] Waiting for client connection...");
			Socket client = listener.accept();
			System.out.println("[Server] Connected to client!");
			ClientHandler clientThread = new ClientHandler(client, clients);
			clients.add(clientThread);
			
			pool.execute(clientThread);
		}
	}
	
	public static String getRandomName() {
		String name = names[(int) (Math.random()*names.length)];
		return name;
	}

}
