package game;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	int x, y;
	int oX, oY;//Original x and y
	Game game;
	
	public Tile(int x, int y, Game game){
		this.oX = x;
		this.oY = y;
		this.game = game;
		
	}
	public void tick(Game game){
		this.game = game;
		
		x = oX + game.xOffset;
		y = oY + game.yOffset;
	}
	public void render(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 32, 32);
			
			g.setColor(Color.BLACK);
			g.drawRect(x, y, 32, 32);
			
	}

}
