package laserball;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import world.Game;
import world.MainMenu;
import world.Prologue;
import world.World;


public class LaserBall extends StateBasedGame {
	
	private ArrayList<World> states;
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new LaserBall("LaserBall"));
		
		app.setDisplayMode(1280, 720, false);
		app.setAlwaysRender(true);
		app.setShowFPS(false);
		app.setTargetFrameRate(60);
		
		app.start();
	}
	
	public LaserBall(String name) {
		super(name);
		
		states = new ArrayList<World>();
		states.add(new MainMenu());
		states.add(new Prologue());
		states.add(new Game());
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		for(World s : states)
			addState(s);
	}
}
