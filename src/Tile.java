import processing.core.PApplet;

public class Tile extends Block{
	
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	
	
	public Tile(PApplet drawer, float x, float y, boolean isWall, double lightScale) {
		super(drawer, x, y, DrawingSurface.GRID_SIZE, DrawingSurface.GRID_SIZE);
	}
	
	
}
