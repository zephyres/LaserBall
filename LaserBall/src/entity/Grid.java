package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Grid extends Entity {
	public Grid() throws SlickException {
		Image i = new Image("images/grid.png");
		setImage(i);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		
	}

}
