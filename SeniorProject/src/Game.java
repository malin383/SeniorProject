

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	//WASD IS USED FOR CONTROLS! DO NOT FORGET!
	//OFFSET: How offset something is from a location/origin
		//Core
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int mapX = 100;
		int mapY = 100;
		Game game;
		
		InputHandler UInput = new InputHandler(); 
		Player player = new Player(this);
		
		BufferedImage  image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//
		JFrame frame;
		public static boolean running = true; //is the game actually running
		public static final String TITLE = "Game- Test";
		public static final int WIDTH = 1024;
		public static final int HEIGHT = 768;
		public static final Dimension gameDim = new Dimension(WIDTH, HEIGHT);
		Thread thread;
		
		
		//Controls
		public static boolean left, right, up, down;
		
		//Animation??
		private Animation a;
		
		public void run(){
			while(running){
				tick();
				
				try{
					thread.sleep(1);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		public synchronized void start(){
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		public synchronized static void stop(){
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
			
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			this.addKeyListener(UInput);
			loadPics();
			
			requestFocus();			
			
		}
		
		public void run(DisplayMode dm){//something movie loop that we're running; possibly put in render()??
			try{
				loadPics();
				movieLoop();
			}finally{
				Graphics g = image.getGraphics();
			}
		}
		public void loadPics(){
			BufferStrategy bs = getBufferStrategy();
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			Graphics g = bs.getDrawGraphics();
			g.drawImage(image, 0, 0, Color.BLACK, null);	
			
			
			BufferedImage idle1 = null, down1 = null, down2 = null, idle2 = null;
			BufferedImage map = null;
			
			try {
				idle1 = ImageIO.read(new File("resources/idle.png"));
				down1 = ImageIO.read(new File("resources/down2.png"));
				down2 = ImageIO.read(new File("resources/down1.png"));
				idle2 = ImageIO.read(new File("resources/idle2.png"));
				map = ImageIO.read(new File("resources/map.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			g.drawImage(map, 0, 0, null);
			
			a = new Animation();
			a.addScene(idle1, 500);
			a.addScene(down1, 500);
			a.addScene(idle2, 500);
			a.addScene(down2, 500);
		}
		
		public void movieLoop(){
			long startingTime = System.currentTimeMillis();
			long cumTime = startingTime;
			
			while(cumTime - startingTime < 5000){
				long timePassed = System.currentTimeMillis() - cumTime;
				cumTime += timePassed;
				a.update(timePassed);
				
				Graphics g = image.getGraphics();
				//draw(g);
				g.dispose();
				
				try{
					Thread.sleep(20);
				}catch(Exception ex){}
				
				
			}
		}


	}
