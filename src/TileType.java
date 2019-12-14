import processing.core.PApplet;

public class TileType {
	private PApplet drawer;
	private int row;
	private int column;
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	public TileType(PApplet drawer, int row, int column, int assetNum, boolean isWall, double lightScale) {
		this.drawer = drawer;
		this.row = row;
		this.column = column;
		this.assetNum = assetNum;
		this.isWall = isWall;
		this.lightScale = lightScale;
	}
	
	public void draw() {
		drawer.noStroke();
		drawer.fill(255, 255, 255, (float)lightScale*255);
		drawer.rect(drawer.width - drawer.width/4 + 25 + DrawingSurface.MENU_SIZE*(row) + DrawingSurface.MENU_BUFFER*(row+1), 
				DrawingSurface.MENU_SIZE*(column) + DrawingSurface.MENU_BUFFER*(column+1)+25, 
				DrawingSurface.MENU_SIZE, DrawingSurface.MENU_SIZE, 20);
	}
}
