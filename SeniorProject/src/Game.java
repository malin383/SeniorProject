

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	//WASD IS USED FOR CONTROLS! DO NOT FORGET!
	//OFFSET: How offset something is from a location/origin
		//Core
		
		/**
		 * 
		 */

		private Image idle1 = null, down1 = null, down2 = null, idle2 = null;
		private BufferedImage map = null;
		private static final long serialVersionUID = 1L;
	
		private boolean loaded = false;
		
		int imageX = 0;
		int imageY = 0;
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
				tick();//refreshes state of game
				
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
			frame = new JFrame(TITLE);//Window for game is initialized
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes window
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
		public void tick(){//refreshes state of game
			BufferStrategy bs = getBufferStrategy();
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			Graphics g = bs.getDrawGraphics();	
			
			moveMap();
			loadPics();
		}
		
		public void moveMap(){
			if(left){
				imageX--;
				System.out.println(imageX);
			}
			if(right){
				imageX++;
				System.out.println(imageX);
			}
			if(up){
				imageY++;
				System.out.println(imageY);
			}
			if(down){
				imageY--;
				System.out.println(imageY);
			}
		}
		
		public void run(DisplayMode dm){//something movie loop that we're running; possibly put in render()??

		}
		public void loadPics(){
			BufferStrategy bs = getBufferStrategy();
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			Graphics g = bs.getDrawGraphics();
			idle1 = new ImageIcon("resources/idle.png").getImage();
			down1 = new ImageIcon("resources/down1.png").getImage();
			down2 = new ImageIcon("resources/down2.png").getImage();
			idle2 = new ImageIcon("resources/idle2.png").getImage();
		
			
			loaded = true;
			if(loaded){
				System.out.println("True");
			}
			
			try {
				map = ImageIO.read(new File("resources/azalea.png"));
			} catch (IOException e) {
			} 

			g.drawImage(map, 0, 0, null);
			paint(g);
		
		}
		
		public void paint(Graphics g){
			System.out.println("render");
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			if(loaded){
				System.out.println("loaded");
				g.drawImage(map, imageX, imageY, null);
			}
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
