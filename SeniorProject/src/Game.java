

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

//11:33
public class Game extends Canvas implements Runnable{
		//Core
		
		/**
		 * 
		 */	
		//SPRITES
		private Image idle1 = null, down1 = null, down2 = null, idle2 = null;
		private Image lefti = null, left1 = null, lefta = null, left2 = null;
		private Image righti = null, right1 = null, righta = null, right2 = null;
		private Image upi = null, up1 = null, upa = null, up2 = null;
		private Image map = null;
		private Image userIdle = null;
		private static final long serialVersionUID = 1L;
		
		//LOADED OR NOT?
		private boolean loaded = false;
		
		//POSITION
		int imageX = 0;
		int imageY = 0;
		Game game;
		
		//INPUT AND STUFF?
		InputHandler UInput = new InputHandler(); 
		
		BufferedImage  image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//
		JFrame frame;
		public static boolean running = false; //is the game actually running
		public static final String TITLE = "Java 2D Game Engine";
		public static final int WIDTH = 480;
		public static final int HEIGHT = 360;
		public static final Dimension gameDim = new Dimension(WIDTH, HEIGHT);
		Thread thread;
		
		
		//Controls
		public static boolean left, right, up, down;
		
		//Animation??
		private Animation downA, upA, leftA, rightA;
		
		public void run(){
			
			while(running){
				tick();//refreshes state of game
				try{
					Thread.sleep(60);
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
			
			frame.setResizable(false);
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
			//paint(g);
			repaint();
			
		}
		
		public synchronized void moveMap(){
			Thread threadd = new Thread();
			if(left){
				imageX += 32;
				System.out.println(imageX +"x");
				movieLoop(leftA);
				userIdle = lefti;
			}
			if(right){
				imageX -=32;
				System.out.println(imageX + "x");
				movieLoop(rightA);
				userIdle = righti;
			}
			if(up){
				imageY +=32;
				System.out.println(imageY + "y");
				movieLoop(upA);
				userIdle = upi;
			}
			if(down){
				imageY -=32;
				System.out.println(imageY + "y");
				movieLoop(downA);
				userIdle = idle1;
			}
		}
		
		public void loadPics(){
			
			loaded = true;
			try {
				idle1 =  ImageIO.read(new File("resources/idle.png"));
				down1 =  ImageIO.read(new File("resources/down1.png"));
				down2 =  ImageIO.read(new File("resources/down2.png"));
				idle2 =  ImageIO.read(new File("resources/idle2.png"));
				map = ImageIO.read(new File("resources/newbark.png"));
				lefti =  ImageIO.read(new File("resources/lefti.png"));
				left1 =  ImageIO.read(new File("resources/left1.png"));
				left2 =  ImageIO.read(new File("resources/left2.png"));
				lefta =  ImageIO.read(new File("resources/lefta.png"));
				righti = ImageIO.read(new File("resources/righti.png"));
				right1 =  ImageIO.read(new File("resources/right1.png"));
				right2 =  ImageIO.read(new File("resources/right2.png"));
				righta =  ImageIO.read(new File("resources/righta.png"));
				upi =  ImageIO.read(new File("resources/upi.png"));
				up1 = ImageIO.read(new File("resources/up1.png"));
				upa =  ImageIO.read(new File("resources/upa.png"));
				up2 = ImageIO.read(new File("resources/up2.png"));
				
			} catch (IOException e) {
			}
			downA = new Animation();
			upA = new Animation();
			rightA = new Animation();
			leftA = new Animation();
			
			downA.addScene(idle1, 500);
			downA.addScene(down1, 500);
			downA.addScene(idle2, 500);
			downA.addScene(down2, 500);
			leftA.addScene(lefti, 500);
			leftA.addScene(left1, 500);
			leftA.addScene(lefta, 500);
			leftA.addScene(left2, 500);
			rightA.addScene(righti, 500);
			rightA.addScene(right1, 500);
			rightA.addScene(righta, 500);
			rightA.addScene(right2, 500);
			upA.addScene(upi, 500);
			upA.addScene(up1, 500);
			upA.addScene(upa, 500);
			upA.addScene(up2, 500);
			
			userIdle = idle1;
			
			BufferStrategy bs = getBufferStrategy();
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			Graphics c = bs.getDrawGraphics();
			c.drawImage(idle1, 0, 0, null);
		}
		public void paint(Graphics g){
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			loaded = true;
			if(loaded){
				g.drawImage(map, imageX, imageY, null);
				g.drawImage(userIdle, WIDTH/2, HEIGHT/2, null);
			}
		}
		
		public void movieLoop(Animation a){
			long startingTime = System.currentTimeMillis();
			long cumTime = startingTime;
			int count = 0;
			
			while(cumTime - startingTime < 500){
				long timePassed = System.currentTimeMillis() - cumTime;
				cumTime += timePassed;
				a.update(count,timePassed);//UPDATE!!!
				
				Graphics g = frame.getGraphics();
				draw(g, a);
				g.dispose();
				
				try{
					Thread.sleep(20);
				}catch(Exception ex){
				}
			}
		}
		public void draw(Graphics g, Animation a){
			g.drawImage(map, imageX, imageY, null);
			g.drawImage(a.getImage(), WIDTH/2, HEIGHT/2, null);
		}


	}
