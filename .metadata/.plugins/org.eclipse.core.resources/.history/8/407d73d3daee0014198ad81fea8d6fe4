package world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import entity.Grid;
import entity.Player;

public class Game extends World {
	Player player;
	Grid grid;
	
	public Game() throws SlickException {
		
	}
	
	@Override
	public int getID() {
		return 2;
	}

	@Override
	public void init() throws SlickException {
		player = new Player();
		grid = new Grid();
		
		addObject(grid, 640, 360);
		addObject(player, 100f, 100f);
		setBackgroundColor(new Color(16, 30, 45));
	}

}
