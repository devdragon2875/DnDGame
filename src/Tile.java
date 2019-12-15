import processing.core.PApplet;

public class Tile extends Block{
	
	private boolean isWall;
	private double lightScale;
	private int assetNum;

	
	public Tile(PApplet drawer, float x, float y, boolean isWall, double lightScale) {
		super(drawer, x, y, DrawingSurface.GRID_SIZE, DrawingSurface.GRID_SIZE);
		this.isWall = isWall;
		this.lightScale = lightScale;
	
		
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
	

	
	
	
}
