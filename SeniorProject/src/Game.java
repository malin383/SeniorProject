

import java.awt.BorderLayout;
import java.awt.Canvas;
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
		int xOffset = 0;
		int yOffset = 0;
		
		InputHandler UInput = new InputHandler(); 
		Player player = new Player(this);
		
		BufferedImage  image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//
		JFrame frame;
		public static boolean running = false; //is the game actually running
		public static final String TITLE = "Game- Test";
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		public static final Dimension gameDim = new Dimension(WIDTH, HEIGHT);
		Thread thread;
		
		public int tileWidth = 10;
		public int tileHeight = 10; 
		
		Tile tileArray[][] = new Tile[tileWidth][tileHeight];
		
		//Controls
		public static boolean left, right, up, down;
		
		//Animation??
		private Animation a;
		
		public void run(){
			while(running){
				tick();
				render();
				
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
			
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			this.addKeyListener(UInput);
			
			init();
			
			requestFocus();			
			
		}
		
		public void init(){
			for(int  x = 0; x < tileWidth; x++){
				for(int y = 0; y < tileHeight; y++){
					tileArray[x][y] = new Tile(x * 32, y * 32, this);
				}
				
			}
		}
		
		public void tick(){
			for(int  x = 0; x < tileWidth; x++){
				for(int y = 0; y < tileHeight; y++){
					tileArray[x][y].tick(this);
				}
			}
			moveMap();
			player.tick(this);
		}
		
		private void moveMap(){
			if(left){
				xOffset++;//set position to x - 1
			}
			else if(right){
				xOffset--;
			}
			else if(up){
				yOffset++;
			}
			else if(down){
				yOffset--;
			}
		}
		
		public void render(){
			BufferStrategy bs = getBufferStrategy();
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			BufferedImage idle1 = null, down1 = null, down2 = null, idle2 = null;
			
			
			try {
				idle1 = ImageIO.read(new File("resources/idle.png"));
				down1 = ImageIO.read(new File("images/down2.png"));
				down2 = ImageIO.read(new File("down1.png"));
				idle2 = ImageIO.read(new File("idle2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(idle1, 0, 0, null);
			//g.drawImage(a.getImage(), 0, 0, null);
			
			/*for(int  x = 0; x < tileWidth; x++){
				for(int y = 0; y < tileHeight; y++){
						tileArray[x][y].render(g);
				}
			}*/
			a = new Animation();
			a.addScene(idle1, 500);
			a.addScene(down1, 500);
			a.addScene(idle2, 500);
			a.addScene(down2, 500);
			
			g.dispose();
			bs.show();
		}
		//BufferedImage idle1 = null, down1 = null, down2 = null, idle2 = null;
		
		public void loadPics(){
			
			/*try {
				idle1 = ImageIO.read(new File("resources/idle.png"));
				down1 = ImageIO.read(new File("images/down2.png"));
				down2 = ImageIO.read(new File("down1.png"));
				idle2 = ImageIO.read(new File("idle2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			a = new Animation();
			a.addScene(idle1, 500);
			a.addScene(down1, 500);
			a.addScene(idle2, 500);
			a.addScene(down2, 500);*/
			
			
		}
		//Display mode, settings for graphics and []
		public void run(DisplayMode dm){
			try{
				loadPics();
				movieLoop();
			}finally{
				Graphics g = image.getGraphics();
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
				draw(g);
				g.dispose();
				
				try{
					Thread.sleep(20);
				}catch(Exception ex){}
				
				
			}
		}
		public void draw(Graphics g){
			g.drawImage(idle1, 0, 0, null);
			g.drawImage(a.getImage(), 0, 0, null);
		}


	}
