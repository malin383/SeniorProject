package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener /*"Listen" to key inputs*/{

	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_A){
			Game.left = true;
		}
		if(keyCode == e.VK_D){
			Game.right = true;
		}
		if(keyCode == e.VK_W){
			Game.up = true;
		}
		if(keyCode == e.VK_S){
			Game.down = true;
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_A){
			Game.left = false;
		}
		if(keyCode == e.VK_D){
			Game.right = false;
		}
		if(keyCode == e.VK_W){
			Game.up = false;
		}
		if(keyCode == e.VK_S){
			Game.down = false;
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

}
