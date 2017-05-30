import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	
	}
	public void render(Graphics g){
		BufferedImage map = null;
	}
}
