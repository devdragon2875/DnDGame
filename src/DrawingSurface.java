import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	public static final int GRID_SIZE = 50;// width/16
	public static final int GRID_LINE = 3;

	public static final int MENU_SIZE = 60;
	public static final int MENU_BUFFER = 5;

	private float zoom = (float) 0.75;

	private static final int TILE_MAX_ROW = 10;
	private static final int TILE_MAX_COLUMN = 10;

	private static final int MAX_ROW = 4;
	private static final int MAX_COLUMN = 10;

	private int offsetX;
	private int offsetY;

	private float currX;
	private float currY;
	private static int MENU_OPTION = 1; // 1 - Tiles
										// 2 - Items
										// 3 - Monsters
										// 4 - Character
	private Block optionTile, optionItem, optionCreature, optionCharacter, optionMenu;
	private TileType tileTypes[][] = new TileType[MAX_ROW][MAX_COLUMN];
	private Tile tiles[][] = new Tile[TILE_MAX_ROW][TILE_MAX_COLUMN];
	private TileType tileTypeSelected = null;

	public void settings() {
		size(1200, 800);

	}

	public void initGame() {

	}

	public void setup() {
		// SketchpadSurface drawing = new SketchpadSurface();

		offsetX = 0;
		offsetY = 0;
		optionTile = new Block(this, width - width / 4 + 60, height - 70, 30, 40);
		optionItem = new Block(this, width - width / 4 + 110, height - 70, 30, 40);
		optionCreature = new Block(this, width - width / 4 + 160, height - 70, 30, 40);
		optionCharacter = new Block(this, width - width / 4 + 210, height - 70, 30, 40);
		optionMenu = new Block(this, width - width / 4, 0, width / 4 + 50, height);
		for (int row = 0; row < TILE_MAX_ROW; row++) {
			for (int column = 0; column < TILE_MAX_COLUMN; column++) {
				tiles[row][column] = new Tile(this, row * GRID_SIZE, column * GRID_SIZE, false, 1);
			}
		}
		for (int row = 0; row < MAX_ROW; row++) {
			for (int column = 0; column < MAX_COLUMN; column++) {
				tileTypes[row][column] = new TileType(this, row, column, 1, false, 0.5);
			}
		}
	}

	public void draw() {
		background(0);

		currX = mouseX;
		currY = mouseY;
		pushMatrix();
		translate(5 * width / 16, height / 2);
		scale(zoom);
		translate(-5 * width / 16, -height / 2);
		for (int row = 0; row < TILE_MAX_ROW; row++) {
			for (int column = 0; column < TILE_MAX_COLUMN; column++) {
				if (tiles[row][column].isPointInside((mouseX - 5 * width / 16) / zoom + 5 * width / 16,
						(mouseY - height / 2) / zoom + height / 2)) {
					fill(255);
					stroke(255);
					//System.out.println("Row: " + row + ", Column: " + column);
					tiles[row][column].draw();
				} else {
					//fill(0);
					stroke(255);
					tiles[row][column].show();
				}

			}
		}

		popMatrix();

		noStroke();
		fill(255, 0, 0);
		rect(5 * width / 16 + 1, height / 2 + 15, 30, 2);
		rect(5 * width / 16 + 15, height / 2 + 1, 2, 30);

		noStroke();
		fill(70);
		optionMenu.show();

		if (MENU_OPTION == 1) {
			fill(255, 250, 0);
			optionTile.show();

			for (int row = 0; row < MAX_ROW; row++) {
				for (int column = 0; column < MAX_COLUMN; column++) {
					fill(170, 170, 170);
					tileTypes[row][column].draw();
				}
			}
			if (tileTypeSelected != null) {
				fill(255, 0, 0);
				tileTypeSelected.draw();
			}
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

	}

	public void mousePressed() {
		
		if (mouseButton == LEFT) {
			if (optionMenu.isPointInside(mouseX, mouseY)) {
				for (int row = 0; row < MAX_ROW; row++) {
					for (int column = 0; column < MAX_COLUMN; column++) {
						if (tileTypes[row][column] != null && tileTypes[row][column].isPointInside(mouseX, mouseY)) {

							if (tileTypeSelected == null) {
								tileTypeSelected = tileTypes[row][column];
							} else if (tileTypes[row][column].equals(tileTypeSelected)) {
								tileTypeSelected = null;
							} else {
								tileTypeSelected = tileTypes[row][column];

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
			} else if(tileTypeSelected != null) {
				for (int row = 0; row < TILE_MAX_ROW; row++) {
					for (int column = 0; column < TILE_MAX_COLUMN; column++) {
						if (tiles[row][column].isPointInside((mouseX - 5 * width / 16) / zoom + 5 * width / 16,
								(mouseY - height / 2) / zoom + height / 2)) {
							//System.out.println("Row: " + row + ", Column: " + column + "------------------------------------------------------");
							tiles[row][column].setColor(tileTypeSelected.getR(), tileTypeSelected.getG(), tileTypeSelected.getB());
						}
					}
				}
			}
		}
		

	}

	public void mouseDragged() {
		if (mouseButton == RIGHT) {
			offsetX = (int) ((currX - mouseX) * 0.25);
			offsetY = (int) ((currY - mouseY) * 0.25);
			for (int row = 0; row < TILE_MAX_ROW; row++) {
				for (int column = 0; column < TILE_MAX_COLUMN; column++) {
					tiles[row][column].setX(tiles[row][column].getX() - offsetX);
					tiles[row][column].setY(tiles[row][column].getY() - offsetY);
				}
			}
		} else if(mouseButton == LEFT) {
			for (int row = 0; row < TILE_MAX_ROW; row++) {
				for (int column = 0; column < TILE_MAX_COLUMN; column++) {
					if (tiles[row][column].isPointInside((mouseX - 5 * width / 16) / zoom + 5 * width / 16,
							(mouseY - height / 2) / zoom + height / 2)) {
						//System.out.println("Row: " + row + ", Column: " + column + "------------------------------------------------------");
						tiles[row][column].setColor(tileTypeSelected.getR(), tileTypeSelected.getG(), tileTypeSelected.getB());
					}
				}
			}
		}

	}

	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		zoom += e * 0.1;

		if (zoom < 0.5) {
			zoom = 0.5f;
		} else if (zoom > 3) {
			zoom = 3;
		}
		/*
		 * float offsetTempX; float offsetTempY; for (int row = 0; row < TILE_MAX_ROW;
		 * row++) { for (int column = 0; column < TILE_MAX_COLUMN; column++) {
		 * offsetTempX = tiles[row][column].getX() - width/2; offsetTempY =
		 * tiles[row][column].getY() - height/2;
		 * 
		 * tiles[row][column].setX(tiles[row][column].getX() - offsetX);
		 * tiles[row][column].setY(tiles[row][column].getY() - offsetY);
		 * 
		 * tiles[row][column].setWidth(tiles[row][column].getWidth()*zoom);
		 * tiles[row][column].setHeight(tiles[row][column].getHeight()*zoom);
		 * 
		 * tiles[row][column].setX(tiles[row][column].getX() + offsetTempX*zoom);
		 * tiles[row][column].setY(tiles[row][column].getY() + offsetTempY*zoom); } }
		 */

	}

}