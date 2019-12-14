import processing.core.PApplet;

public class Block {
	
	protected float x, y, w, h;
	protected PApplet drawer;
	
	public Block(PApplet drawer, float x, float y, float w, float h) {
		this.drawer = drawer;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void show() {
		drawer.rect(x, y, w, h);
	}
	
	public boolean isTouching(Block other) {
		return x < other.x + other.w && x + w > other.x && y < other.y + other.h && y + h > other.y;
	}
	
	public boolean isPointInside(float x, float y) {
		return (x > this.x && y > this.y && x < this.x + w && y < this.y + h);
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float in) {
		x = in;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float in) {
		y = in;
	}

	public float getWidth() {
		return w;
	}
	
	public void setWidth(float in) {
		w = in;
	}
	
	public float getHeight() {
		return h;
	}
	
	public void setHeight(float in) {
		h = in;
	}
	
}
