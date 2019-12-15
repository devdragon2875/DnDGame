import processing.core.PApplet;
import processing.core.PImage;

public class Tile extends Block{
	
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	private boolean isDefault;
	private PImage img;
	public Tile(PApplet drawer, float x, float y, boolean isWall, double lightScale, int assetNum) {
		super(drawer, x, y, DrawingSurface.GRID_SIZE, DrawingSurface.GRID_SIZE);
		this.isWall = isWall;
		this.lightScale = lightScale;
		this.assetNum = assetNum;
		
	}

	public void show() {

		super.show();
		if (assetNum != -1) {
			drawer.image(img, super.x, super.y, super.w, super.h);
		}
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
		img = drawer.loadImage(DrawingSurface.path +"asset" + assetNum + ".png");
		this.assetNum = assetNum;
	}
	

	
	
	
}
