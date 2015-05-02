package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;
import java.lang.Math;

import utility.Vector;

public class ProjectileEntity extends Entity {
	private Random r;
	private Vector v;
	private float damage;
	private int counter;
	
	public ProjectileEntity(Vector v, float d) {
		this.v = v;
		damage = d;
		counter = 0;
		
		r = new Random();
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
		
		int cap = (int) Math.pow(2, -0.02 * counter + 8) + 10;
		
		if(atWorldEdge() || r.nextInt(cap) < 2) {
			getWorld().addObject(new ExplosionCluster(30, 20), getX(), getY());
			getWorld().removeObject(this);
		}
		
		counter++;
	}

}
