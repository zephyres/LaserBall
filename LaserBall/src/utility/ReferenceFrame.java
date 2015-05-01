package utility;

import entity.Entity;

public class ReferenceFrame {
	private final float W = 1280, H = 720;
	private int width, height;
	private Entity reference;
	
	public ReferenceFrame(Entity e, int width, int height) {
		reference = e;
		this.width = width;
		this.height = height;
	}
	
	public void setReference(Entity e) {
		reference = e;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public Entity getReference() {
		return reference;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getRelativeX() {
		float rx = 0;
		float midWidth = W / 2;
		
		if(reference != null) {
			rx = reference.getX() - midWidth;
			
			if(reference.getX() < width / 2)
				rx = 0;
			if(reference.getX() > width)
				rx = width / 2;
		}
		
		return rx;
	}
	
	public float getRelativeY() {
		float ry = 0;
		float midHeight = H / 2;
		
		if(reference != null) {
			ry = reference.getY() - midHeight;
			
			if(reference.getY() < height / 2)
				ry = 0;
			if(reference.getY() > height)
				ry = height / 2;
		}
		
		return ry;
	}
}
