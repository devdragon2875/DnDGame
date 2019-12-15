import processing.core.PApplet;
import processing.core.PImage;

public class TileType extends Block {
	private int row;
	private int column;
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	private boolean isDefault;

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
		this.isDefault = true;
	}

	public void show() {

		super.show();
		if (!isDefault) {
			PImage img = drawer.loadImage(
					"C:\\Users\\devdr\\Desktop\\DnDCoolKids\\DnDSimulator\\SavedPics\\asset" + assetNum + ".png");
			drawer.image(img, super.x, super.y, super.w, super.h);
		}
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
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

	public boolean isDefault() {
		// TODO Auto-generated method stub
		return isDefault;
	}

	public void isDefault(boolean isDefault) {
		// TODO Auto-generated method stub
		this.isDefault = isDefault;
	}

}
