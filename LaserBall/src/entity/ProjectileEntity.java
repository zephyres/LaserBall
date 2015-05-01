package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import utility.Vector;

public class ProjectileEntity extends Entity {
	private Vector v;
	private float damage;
	
	public ProjectileEntity(Vector v, float d) {
		this.v = v;
		damage = d;
	}

	public float getDamage() {
		return damage;
	}
	
	public void setDamage(float d) {
		damage = d;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		changeX(v.getX());
		changeY(v.getY());
		
		if(atWorldEdge())
			getWorld().removeObject(this);
	}

}
