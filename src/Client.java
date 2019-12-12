import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Client {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 3030;
	
	public static void main(String[] args) throws IOException {
		/*Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		
		ServerConnection serverConn = new ServerConnection(socket);
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		*/
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[] { "DND" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(300, 300);
		window.setMinimumSize(new Dimension(400, 400));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setVisible(true);
		canvas.requestFocus();
		/*
		new Thread(serverConn).start();
		
		
		
		while(true) {
			System.out.println("> ");
			String command = keyboard.readLine();
			
			if(command.equals("quit")) break;
			
			out.println(command);
			
		}
		
		socket.close();
		System.exit(0);*/
	}

}
