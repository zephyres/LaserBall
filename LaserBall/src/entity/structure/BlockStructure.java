package entity.structure;

import static entity.structure.Type.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import entity.Entity;

public class BlockStructure extends Entity {
	private Scanner scan;
	private ArrayList<Block> blocks;
	private String dir;
	
	public BlockStructure(String map) {
		this.dir = "src/text/" + map;
	}
	
	public void render(GameContainer gc, StateBasedGame gs, Graphics g)
			throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		if(blocks == null)
			try {
				blocks = parseFile(SMALL_BLOCK, dir);
				blocks = parseFile(LARGE_BLOCK, dir);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	private ArrayList<Block> parseFile(Type type, String dir) throws Exception {
		ArrayList<Block> blocks = new ArrayList<Block>();
		scan = new Scanner(new File(dir + (type == SMALL_BLOCK ? "/small.txt" : "/large.txt")));
		
		for(int j = 0; scan.hasNext(); j++) {
			String line = scan.nextLine();
			
			for(int i = 0; i < line.length(); i++) {
				if(line.toCharArray()[i] == '#') {
					Block block = type == SMALL_BLOCK ? new SmallBlock() : new LargeBlock();
					
					float x = i * block.getWidth() + (float) block.getWidth() / 2;
					float y = j * block.getHeight() + (float) block.getHeight() / 2;
					
					getWorld().addObject(block, x, y);
					blocks.add(block);
				}
			}
		}
		
		return blocks;
	}
}