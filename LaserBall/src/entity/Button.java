package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import utility.Fonts;

public class Button extends Entity {
	private final static float WIDTH = 300, HEIGHT = 50;
	private Color base, highlight, border;
	private TrueTypeFont font;
	private String name;
	private float mx, my;
	private boolean click;
	
	public Button(String name) {
		this.name = name;
		
		border = Color.white;
		highlight = Color.white;
		base = new Color(12, 23, 34);
		
		font = Fonts.getRoboto();
	}
	
	public void render(GameContainer gc, StateBasedGame gs, Graphics g)
			throws SlickException {
		float x = getX() - WIDTH / 2;
		float y = getY() - HEIGHT / 2;
		
		g.setColor(isHover() ? highlight : base);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
		g.setColor(border);
		g.drawRect(x, y, WIDTH, HEIGHT);
		
		g.setFont(font);
		g.setColor(isHover() ? base : Color.white);
		g.drawString(name, getX() - font.getWidth(name) / 2, getY() - font.getHeight() / 2);
		
		if(isHover()) {
			float w = WIDTH - 5;
			float h = HEIGHT - 5;
			
			g.setColor(base);
			g.drawRect(getX() - w / 2, getY() - h / 2, w, h);
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		Input in = gc.getInput();
		
		mx = in.getMouseX();
		my = in.getMouseY();
		
		click = in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
	}
	
	public void setBaseColor(Color c) {
		base = c;
	}
	
	public void setHightlightColor(Color c) {
		highlight = c;
	}
	
	public void setBorderColor(Color c) {
		border = c;
	}
	
	public Color getBaseColor() {
		return base;
	}
	
	public Color getHighlightColor() {
		return highlight;
	}
	
	public Color getBorderColor() {
		return border;
	}
	
	public boolean isHover() {
		float x1 = getX() - WIDTH / 2;
		float x2 = getX() + WIDTH / 2;
		float y1 = getY() - HEIGHT / 2;
		float y2 = getY() + HEIGHT / 2;
		
		return mx > x1 && mx < x2 && my > y1 && my < y2;
	}
	
	public boolean isClick() {
		return isHover() && click;
	}
}
