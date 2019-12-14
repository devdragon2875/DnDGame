import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	public static final int GRID_SIZE = 50;// width/16
	public static final int GRID_LINE = 3;

	public static final int MENU_SIZE = 60;
	public static final int MENU_BUFFER = 5;

	private static final int MAX_ROW = 4;
	private static final int MAX_COLUMN = 10;

	private static int MENU_OPTION = 1; // 1 - Tiles
										// 2 - Items
										// 3 - Monsters
										// 4 - Character
	private Block optionTile, optionItem, optionCreature, optionCharacter;
	private TileType tileTypes[][] = new TileType[MAX_ROW][MAX_COLUMN];
	private TileType tileTypeSelected = null;

	public void settings() {
		size(1200, 800);

	}

	public void initGame() {

	}

	public void setup() {
		// SketchpadSurface drawing = new SketchpadSurface();
		optionTile = new Block(this, width - width / 4 + 60, height - 70, 30, 40);
		optionItem = new Block(this, width - width / 4 + 110, height - 70, 30, 40);
		optionCreature = new Block(this, width - width / 4 + 160, height - 70, 30, 40);
		optionCharacter = new Block(this, width - width / 4 + 210, height - 70, 30, 40);

		for (int row = 0; row < MAX_ROW; row++) {
			for (int column = 0; column < MAX_COLUMN; column++) {
				tileTypes[row][column] = new TileType(this, row, column, 1, false, 0.5);
			}
		}
	}

	public void draw() {
		background(0);

		fill(70);
		rect(width - width / 4, 0, width / 4 + 50, height, 50);

		if (MENU_OPTION == 1) {
			fill(255, 250, 0);
			optionTile.show();
		} else {
			fill(255);
			optionTile.show();
		}

		if (MENU_OPTION == 2) {
			fill(255, 250, 0);
			optionItem.show();
		} else {
			fill(255);
			optionItem.show();
		}

		if (MENU_OPTION == 3) {
			fill(255, 250, 0);
			optionCreature.show();
		} else {
			fill(255);
			optionCreature.show();
		}

		if (MENU_OPTION == 4) {
			fill(255, 250, 0);
			optionCharacter.show();
		} else {
			fill(255);
			optionCharacter.show();
		}

		if (MENU_OPTION == 1) {
			for (int row = 0; row < MAX_ROW; row++) {
				for (int column = 0; column < MAX_COLUMN; column++) {

					tileTypes[row][column].draw();
				}
			}
		}

		if (mouseX < width - width / 4) {
			fill(255);
			rect(mouseX - (mouseX % GRID_SIZE), mouseY - (mouseY % GRID_SIZE), GRID_SIZE, GRID_SIZE);

		} else {

		}

	}

	public void mousePressed() {
		for (int row = 0; row < MAX_ROW; row++) {
			for (int column = 0; column < MAX_COLUMN; column++) {
				if (tileTypes[row][column] != null && tileTypes[row][column].isPointInside(mouseX, mouseY)) {

					if (tileTypeSelected == null) {
						tileTypeSelected = tileTypes[row][column];
						tileTypes[row][column].setSelected(true);
					} else if (tileTypes[row][column].equals(tileTypeSelected)) {
						tileTypeSelected = null;
						tileTypes[row][column].setSelected(false);
					} else {
						for (int row2 = 0; row2 < MAX_ROW; row2++) {
							for (int column2 = 0; column2 < MAX_COLUMN; column2++) {
								if (tileTypes[row2][column2].equals(tileTypeSelected)) {
									tileTypes[row2][column2].setSelected(false);
								}
							}
						}
						tileTypeSelected = tileTypes[row][column];
						tileTypes[row][column].setSelected(true);

					}
				}
			}
		}
		if (optionTile.isPointInside(mouseX, mouseY)) {
			MENU_OPTION = 1;
		} else if (optionItem.isPointInside(mouseX, mouseY)) {
			MENU_OPTION = 2;
		} else if (optionCreature.isPointInside(mouseX, mouseY)) {
			MENU_OPTION = 3;
		} else if (optionCharacter.isPointInside(mouseX, mouseY)) {
			MENU_OPTION = 4;
		}

	}

}