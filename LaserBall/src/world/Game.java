package world;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import utility.MapInfo;
import utility.ReferenceFrame;
import entity.Grid;
import entity.Player;
import entity.structure.BlockStructure;

public class Game extends World {
	private ReferenceFrame rf;
	private Player player;
	private Grid grid;

	@Override
	public void init() throws SlickException {
		MapInfo info = new MapInfo("map" + getMapID());
		
		player = new Player();
		grid = new Grid();
		rf = new ReferenceFrame(player, 1280, 720);
		
		addObject(grid, 960, 540);
		
		addObject(new BlockStructure("map" + getMapID()), 0, 0);
		addObject(player, info.getSpawnX(), info.getSpawnY());
		
		setReferenceFrame(rf);
		setBackgroundColor(new Color(16, 30, 45));
	}
	
	@Override
	public int getID() {
		return 3;
	}
	
	private int getMapID() {
		return 1;
	}
}
