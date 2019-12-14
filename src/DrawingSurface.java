import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	public static final int GRID_SIZE = 50;// width/16
	public static final int GRID_LINE = 3;

	public static final int MENU_SIZE = 60;
	public static final int MENU_BUFFER = 5;

	private static final int MAX_ROW = 4;
	private static final int MAX_COLUMN = 10;

	private static int MENU_OPTION = 0; // 0 - GRID
										// 1 - Tiles
										// 2 - Items
										// 3 - Monsters
										// 4 - Character

	private TileType tileTypes[][] = new TileType[MAX_ROW][MAX_COLUMN];

	public void settings() {
		size(1200, 800);

	}

	public void initGame() {

	}

	public void setup() {

		for (int row = 0; row < MAX_ROW; row++) {
			for (int column = 0; column < MAX_COLUMN; column++) {
				tileTypes[row][column] = new TileType(this, row, column, 1, false, 0.5);
			}
		}
	}

	public void draw() {
		background(0);
		if (mouseX < width - width / 4) {
			MENU_OPTION = 0;
		}

		fill(70);
		rect(width - width / 4, 0, width / 4 + 50, height, 50);

		if (MENU_OPTION == 1) {
			fill(255, 250, 0);
			rect(width - width / 4 + 60, height - 40, 30, 40);
		} else {
			fill(255);
			rect(width - width / 4 + 60, height - 40, 30, 40);
		}

		if (MENU_OPTION == 2) {
			fill(255, 250, 0);
			rect(width - width / 4 + 110, height - 40, 30, 40);
		} else {
			fill(255);
			rect(width - width / 4 + 110, height - 40, 30, 40);
		}

		if (MENU_OPTION == 3) {
			fill(255, 250, 0);
			rect(width - width / 4 + 160, height - 40, 30, 40);
		} else {
			fill(255);
			rect(width - width / 4 + 160, height - 40, 30, 40);
		}

		if (MENU_OPTION == 4) {
			fill(255, 250, 0);
			rect(width - width / 4 + 210, height - 40, 30, 40);
		} else {
			fill(255);
			rect(width - width / 4 + 210, height - 40, 30, 40);
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
		if (mouseX >= width - width / 4) {
			if (mouseY > height - 40) {
				if (mouseX <= width - width / 4 + 90 && mouseX >= width - width / 4 + 60) {
					MENU_OPTION = 1;
				} else if (mouseX <= width - width / 4 + 140 && mouseX >= width - width / 4 + 110) {
					MENU_OPTION = 2;
				} else if (mouseX <= width - width / 4 + 190 && mouseX >= width - width / 4 + 160) {
					MENU_OPTION = 3;
				} else if (mouseX <= width - width / 4 + 240 && mouseX >= width - width / 4 + 210) {
					MENU_OPTION = 4;
				}
			}
		}
	}

}