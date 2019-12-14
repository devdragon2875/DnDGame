import processing.core.PApplet;

public class TileType extends Block {
	private int row;
	private int column;
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	private boolean isSelected;

	public TileType(PApplet drawer, int row, int column, int assetNum, boolean isWall, double lightScale) {
		super(drawer,
				(float) (drawer.width - drawer.width / 4 + 25 + DrawingSurface.MENU_SIZE * (row)
						+ DrawingSurface.MENU_BUFFER * (row + 1)),
				(float) (DrawingSurface.MENU_SIZE * (column) + DrawingSurface.MENU_BUFFER * (column + 1) + 25),
				(float) DrawingSurface.MENU_SIZE, (float) DrawingSurface.MENU_SIZE);

		this.isSelected = false;
		this.row = row;
		this.column = column;
		this.assetNum = assetNum;
		this.isWall = isWall;
		this.lightScale = lightScale;
	}

	public void draw() {
		drawer.noStroke();
		if (isSelected) {
			drawer.fill(255, 0, 0);
		} else {
			drawer.fill(255, 255, 255, (float) lightScale * 255);
		}
		drawer.rect(x, y, w, h);
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	public boolean getSelected() {
		return isSelected;
	}
}
