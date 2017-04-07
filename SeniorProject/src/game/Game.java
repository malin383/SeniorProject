package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game implements Runnable{
	
	//Core
	BufferedImage  image = new BufferedImage(WIDTH, HEIGHT, BuffereImage.TYPE_INT_RGB);//
	JFrame frame;
	public static boolean isRunning = true; //is the game actually running
	public static final String TITLE = "Game1";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public static final Dimension gameDim = new Dimensions(WIDTH, HEIGHT);
	
	
	public void run(){
		while(running){
			tick();
			render();
		}
	}
	public synchronized void start(){
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		running = false;
		System.exit(0);
	}
	public Game(){
		setMinimumSize(gameDim);
		setMaximumSize(gameDim);
		setPreferredSize(gameDim);
		frame = new JFrame(TITLE);
	}
	
	public void tick(){
		
	}
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
}
