package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class BlastWave extends Entity {
	private int time, counter;
	private float radius;
	
	public BlastWave(int time, float radius) {
		this.time = time;
		this.radius = radius;
		
		counter = 0;
	}
	
	public void render(GameContainer gc, StateBasedGame gs, Graphics g)
			throws SlickException {
		float r = radius * counter / time;
		
		g.setColor(new Color(255, 250, 205, (int) (255 * (float) (time - counter) / counter)));
		g.drawOval(getX() - r - getWorld().getReferenceFrame().getRelativeX(), getY() - r - getWorld().getReferenceFrame().getRelativeY(), r * 2, r * 2);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		if(counter == time)
			getWorld().removeObject(this);
		
		counter++;
	}

}
