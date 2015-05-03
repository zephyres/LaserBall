package world;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import entity.Grid;
import entity.PrologueText;

public class Prologue extends World {

	@Override
	public void init() throws SlickException {
		try {
			addObject(new PrologueText(), 0, 0);
		} catch(Exception e) {System.out.println(e);}
		
		addObject(new Grid(), 960, 540);
		setBackgroundColor(new Color(13, 24, 36));
	}

	@Override
	public int getID() {
		return 2;
	}

}
