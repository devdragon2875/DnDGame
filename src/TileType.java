import java.util.Random;

import processing.core.PApplet;

public class TileType extends Block {
	private int row;
	private int column;
	private boolean isWall;
	private double lightScale;
	private int assetNum;
	private int r;
	private int g;
	private int b;
	
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
		Random rand = new Random();
		r = rand.nextInt(256);
		g = rand.nextInt(256);
		b = rand.nextInt(256);
	}
	
	public void draw() {
		drawer.fill(r, g, b);
		drawer.rect(x, y, w, h);
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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	
	

}
