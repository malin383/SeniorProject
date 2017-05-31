import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Launcher extends Canvas{
	public static void main(String[] args) {
		long logoTime = System.currentTimeMillis();
		long cumTime = logoTime;
		Image logo = null;	
		try {
			logo =  ImageIO.read(new File("resources/java.gif"));
		} catch (IOException e) {
		}
		
		JFrame frame = new JFrame("Welcome to Java 2D Game Engine Prototype!");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes window
		frame.setLayout(new BorderLayout());
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setSize(256*3, 192*3);
		Graphics g = frame.getGraphics();
		
		g.drawImage(logo, 256/2, 192/2, null);
		
		while(cumTime - logoTime < 5000){
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			
		}
		frame.setVisible(false);
		frame.dispose();
		System.out.println("not");
		Game game = new Game();
		game.start();
		//Go to constructor to create game, then proceeds to start function to run the game
	}


}
