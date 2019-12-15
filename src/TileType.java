import processing.core.PApplet;

public class TileType extends Block {
	private int row;
	private int column;
	private boolean isWall;
	private double lightScale;
	private int assetNum;

	public TileType(PApplet drawer, int row, int column, int assetNum, boolean isWall, double lightScale) {
		super(drawer,
				(float) (drawer.width - drawer.width / 4 + 25 + DrawingSurface.MENU_SIZE * (row)
						+ DrawingSurface.MENU_BUFFER * (row + 1)),
				(float) (DrawingSurface.MENU_SIZE * (column) + DrawingSurface.MENU_BUFFER * (column + 1) + 25),
				(float) DrawingSurface.MENU_SIZE, (float) DrawingSurface.MENU_SIZE);

		this.row = row;
		this.column = column;
		this.assetNum = assetNum;
		this.isWall = isWall;
		this.lightScale = lightScale;
	}

	public void draw() {
		drawer.rect(x, y, w, h);
	}

}
