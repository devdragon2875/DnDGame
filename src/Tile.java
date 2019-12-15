import processing.core.PApplet;

public class Tile extends Block{
	
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	private int r;
	private int g;
	private int b;
	
	public Tile(PApplet drawer, float x, float y, boolean isWall, double lightScale) {
		super(drawer, x, y, DrawingSurface.GRID_SIZE, DrawingSurface.GRID_SIZE);
		this.isWall = isWall;
		this.lightScale = lightScale;
		r = 0;
		g = 0;
		b = 0;
		
	}

	public void show() {
		drawer.fill(r, g, b);
		super.show();
	}
	
	public void draw() {
		super.show();
	}

	public boolean isWall() {
		return isWall;
	}


	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}


	public double getLightScale() {
		return lightScale;
	}


	public void setLightScale(double lightScale) {
		this.lightScale = lightScale;
	}


	public int getAssetNum() {
		return assetNum;
	}


	public void setAssetNum(int assetNum) {
		this.assetNum = assetNum;
	}
	
	public void setColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	
	
}
