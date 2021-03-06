package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Spawner extends Entity {
	private String link;
	private int count, imgNum;
	private boolean up;
	
	public Spawner() {
		link = "images/glow/glow";
		imgNum = 0;
		up = true;
		
		try {
			setImage(new Image(link + imgNum + ".png"));
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d) throws SlickException {
		if(count >= 7) {
			if(up) imgNum++;
			else imgNum--;
			
			if(imgNum == 0 || imgNum == 9)
				up = up ? false : true;
				
			try {
				setImage(new Image(link + imgNum + ".png"));
			} catch(SlickException e) {
				e.printStackTrace();
			}
			
			count = 0;
		}
		
		count++;
	}
	
}
