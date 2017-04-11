package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	//Core
	BufferedImage  image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//
	JFrame frame;
	public static boolean running = true; //is the game actually running
	public static final String TITLE = "Game1";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Dimension gameDim = new Dimension(WIDTH, HEIGHT);
	
	public int tileWidth = WIDTH/32 + 1;
	public int tileHeight = HEIGHT/32 + 1; 
	
	Tile tileArray[][] = new Tile[tileWidth][tileHeight];
	
	
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
	public Game(){//constructor
		setMinimumSize(gameDim);
		setMaximumSize(gameDim);
		setPreferredSize(gameDim);
		frame = new JFrame(TITLE);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		init();
		
		requestFocus();
		
		
	}
	public void init(){
		for(int  x = 0; x < tileWidth; x++){
			for(int y = 0; y > tileHeight; y++){
				tileArray[x][y] = new Tile(x * 32, y * 32, this);
			}
			
		}
	}
	
	public void tick(){
		for(int  x = 0; x < tileWidth; x++){
			for(int y = 0; y > tileHeight; y++){
				tileArray[x][y] = new Tile(x * 32, y * 32, this);
			}
			
		}
		
	}
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		for(int  x = 0; x < tileWidth; x++){
			for(int y = 0; y > tileHeight; y++){
				tileArray[x][y].render(g);
			}
			
		}
		
		g.dispose();
		bs.show();
	}
}
