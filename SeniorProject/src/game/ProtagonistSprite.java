package game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class ProtagonistSprite {
	//Creating varibles
	private int dx;//x modifier
    private int dy;//y modifier
    private int x;//x pos.
    private int y;//y pos.
    private Image image;//spirt accessor
    
    public ProtagonistSprite(){
    	initProtagonistSprite();
    }
    
    private void initProtagonistSprite(){
    	
    	ImageIcon mainc = new ImageIcon("idlemainc.png");//importing idle main sprite
    	image = mainc.getImage();
    	x = 40;
    	y = 60;
    	
    }
    
    public void move(){//x and y modifier(movement)
    	x += dx;
    	y += dy;
    	
    }
    
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    
    public Image getImage(){
    	return image;
    }
    public void keyPressedEvent(KeyEvent e){
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    	
    }
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
