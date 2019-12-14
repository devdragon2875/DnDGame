import processing.core.PApplet;

public class Tile extends Block{
	private int x;
	private int y;
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	
	public Tile(PApplet drawer, int x, int y, boolean isWall, double lightScale) {
		super(drawer, x, y, DrawingSurface.GRID_SIZE, DrawingSurface.GRID_SIZE);
	}
	
	
}
