package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import utility.Geometry;
import utility.Vector;

public class Player extends Entity {
	private Vector a, v;
	private float maxSpeed;
	
	public Player() throws SlickException {
		Image i = new Image("images/player.png").getScaledCopy(0.35f);
		a = new Vector(0.1f, 0.1f);
		v = new Vector(0, 0);
		
		setImage(i);
		maxSpeed = 7;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		Input in = gc.getInput();
		
		float mx = in.getMouseX();
		float my = in.getMouseY();
		
		turnTowards(mx, my);
		shootProjectile(in);
		movePlayer(in);
	}
	
	public void movePlayer(Input in) {
		if(getX() < getWidth() / 2 || getX() > 1920 - getWidth() / 2) {
			v.setX(0);
			
			if(getX() < getWidth() / 2)
				setX(getWidth() / 2);
			if(getX() > 1920 - getWidth() / 2)
				setX(1920 - getWidth() / 2);
		}
		if(getY() < getHeight() / 2 || getY() > 1080 - getHeight() / 2) {
			v.setY(0);
			
			if(getY() < getHeight() / 2)
				setY(getHeight() / 2);
			if(getY() > 1080 - getHeight() / 2)
				setY(1080 - getHeight() / 2);
		}
		
		if(in.isKeyDown(Input.KEY_W) && getY() >= getHeight() / 2)
			v.changeY(-a.getY());
		if(in.isKeyDown(Input.KEY_A) && getX() >= getWidth() / 2)
			v.changeX(-a.getX());
		if(in.isKeyDown(Input.KEY_S) && getY() <= 1080 - getHeight() / 2)
			v.changeY(a.getY());
		if(in.isKeyDown(Input.KEY_D) && getX() <= 1920 - getWidth() / 2)
			v.changeX(a.getX());
		
		if(v.getX() > maxSpeed)
			v.setX(maxSpeed);
		if(v.getX() < -maxSpeed)
			v.setX(-maxSpeed);
		if(v.getY() > maxSpeed)
			v.setY(maxSpeed);
		if(v.getY() < -maxSpeed)
			v.setY(-maxSpeed);
		
		changeX(v.getX());
		changeY(v.getY());
	}
	
	public void shootProjectile(Input in) throws SlickException {
		float h = getHeight() * 0.75f;
		float dx = Geometry.getXComponent(h, getRotation());
		float dy = Geometry.getYComponent(h, getRotation());
		
		if(in.isKeyPressed(Input.KEY_SPACE))
			getWorld().addObject(
				new LaserWave(
					v.add(new Vector(10, getRotation(), 0)), 5
				), getX() + dx, getY() + dy
			);
	}
}
