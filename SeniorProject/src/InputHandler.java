import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener /*"Listen" to key inputs*/{

	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_A || keyCode == e.VK_LEFT){
			Game.left = true;
		}
		if(keyCode == e.VK_D || keyCode == e.VK_RIGHT){
			Game.right = true;
		}
		if(keyCode == e.VK_W || keyCode == e.VK_UP){
			Game.up = true;
		}
		if(keyCode == e.VK_S || keyCode == e.VK_DOWN){
			Game.down = true;
		}
		if(keyCode == e.VK_ESCAPE){
			Game.stop();
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_A || keyCode == e.VK_LEFT){
			Game.left = false;
		}
		if(keyCode == e.VK_D || keyCode == e.VK_RIGHT){
			Game.right = false;
		}
		if(keyCode == e.VK_W || keyCode == e.VK_UP){
			Game.up = false;
		}
		if(keyCode == e.VK_S || keyCode == e.VK_DOWN){
			Game.down = false;
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

}
