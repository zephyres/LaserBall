package entity.structure;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import entity.Entity;

abstract class Block extends Entity {
	public Block(String link) {
		try {
			setImage(new Image(link));
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
