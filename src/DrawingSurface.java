import java.awt.Color;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
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

	public static final String path = (System.getProperty("user.dir")+ "\\SavedPics\\");
	private int assetCount = 0;

	private int offsetX;
	private int offsetY;

	private float currX;
	private float currY;
	private static int MENU_OPTION = 1; // 1 - Tiles
										// 2 - Items
										// 3 - Monsters
										// 4 - Character

	private PImage img;
	private PGraphics canvas;
	private int locY = 0;
	private Color lineColor = new Color(0);
	private int alpha = 255;
	private int weight = 3;
	private Block optionTile, optionItem, optionCreature, optionCharacter, optionMenu;
	private TileType tileTypes[][] = new TileType[MAX_ROW][MAX_COLUMN];
	private Tile tiles[][] = new Tile[TILE_MAX_ROW][TILE_MAX_COLUMN];
	private TileType tileTypeSelected = null;
	private boolean sketchPadMode;

	public void settings() {
		size(1200, 800);

	}

	public void initGame() {

	}

	public void setup() {
		// SketchpadSurface drawing = new SketchpadSurface();
		
		offsetX = 0;
		offsetY = 0;
		sketchPadMode = false;
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
		canvas = createGraphics(300, 330, JAVA2D);
		
		
		canvas.beginDraw();
		canvas.format = ARGB;
		canvas.background(255, 0);

		canvas.endDraw();
	}

	public void draw() {
		if (sketchPadMode == false) {
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
						// System.out.println("Row: " + row + ", Column: " + column);
						tiles[row][column].show();
					} else {
						fill(0);
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
						tileTypes[row][column].show();
					}
				}
				if (tileTypeSelected != null) {
					pushMatrix();
					stroke(255, 0, 0);
					strokeWeight(4);
					tileTypeSelected.show();
					strokeWeight(1);
					noStroke();
					popMatrix();
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
		} else {
			
			canvas.beginDraw();
			canvas.loadPixels();
			
			canvas.noStroke();
			canvas.fill(255, 81, 81);
			canvas.rect(0, locY, 30, 30);

			canvas.fill(130, 255, 130);
			canvas.rect(30, locY, 30, 30);

			canvas.fill(180, 255, 255);
			canvas.rect(60, locY, 30, 30);

			canvas.fill(255, 255, 255);
			canvas.rect(90, locY, 30, 30);

			canvas.fill(0, 0, 0);
			canvas.rect(120, locY, 30, 30);

			canvas.fill(178, 102, 255);
			canvas.rect(150, locY, 30, 30);

			canvas.fill(220, 220, 220);
			canvas.rect(180, locY, 30, 30);

			// canvas.stroke(0);
			canvas.fill(180, 180, 180);
			canvas.rect(210, locY, 30, 30);

			canvas.fill(100, 100, 100);
			canvas.rect(240, locY, 30, 30);

			canvas.fill(0, 255, 0);
			canvas.rect(270, locY, 30, 30);
			for (int x = 0; x < canvas.width; x++) {
				for (int y = 0; y < canvas.height; y++) {

					int loc = x + y * canvas.width;

					canvas.pixels[loc] = canvas.get(x, y);

				}
			}
			canvas.updatePixels();
			canvas.endDraw();

			if (mouseY < 30) {
				if (mousePressed == true) {
					if (mouseX < 30) {
						lineColor = new Color(255, 81, 81);
						alpha = 255;
					} else if (mouseX < 60) {
						lineColor = new Color(130, 255, 130);
						alpha = 255;
					} else if (mouseX < 90) {
						lineColor = new Color(180, 255, 255);
						alpha = 255;
					} else if (mouseX < 120) {
						lineColor = new Color(255, 255, 255);
						alpha = 255;
					} else if (mouseX < 150) {
						lineColor = new Color(0, 0, 0);
						alpha = 255;
					} else if (mouseX < 180) {
						lineColor = new Color(178, 102, 255);
						alpha = 255;
					} else if (mouseX < 210) {

						weight = 3;
					} else if (mouseX < 240) {
						weight = 8;
					} else if (mouseX < 270) {
						weight = 18;
					} else if (mouseX < 300) {
						// SAVE
						// img = new PImage(300, 300, RGB);
						canvas.beginDraw();
						img = canvas.get(0, 30, 300, 300);
						// saveFrame("C:\\Users\\devdr\\Desktop\\DnDCoolKids\\DnDSimulator\\SavedPics\\Test.jpg");
						img.save(path +"asset" + assetCount + ".png");
						canvas.clear();
						canvas.endDraw();
						tileTypeSelected.setAssetNum(assetCount);
						tileTypeSelected.isDefault(false);
						assetCount++;
						sketchPadMode = false;
						
					}
				}

			} else {
				// canvas.beginDraw();
				if (mousePressed == true) {
					canvas.beginDraw();
					canvas.loadPixels();
					canvas.strokeWeight(weight);
					canvas.stroke(this.color(lineColor.getRGB()));
					canvas.line(mouseX, mouseY, pmouseX, pmouseY);
					for (int x = 0; x < canvas.width; x++) {
						for (int y = 0; y < canvas.height; y++) {

							int loc = x + y * canvas.width;

							canvas.pixels[loc] = canvas.get(x, y);

						}
					}
					canvas.updatePixels();
					canvas.endDraw();
				}

				// canvas.updatePixels();
				// image(canvas, 0, 30, 300, 300);
				// canvas.endDraw();
			}
			image(canvas, 0, 0);
			// rect(mouseX-(mouseX%GRID_SIZE), mouseY-(mouseY%GRID_SIZE), GRID_SIZE,
			// GRID_SIZE);
			// translate(-(width / 2 - 150), -(height / 2 - 150));
		}

	}

	public void mousePressed() {

		if (mouseButton == LEFT) {
			if (optionMenu.isPointInside(mouseX, mouseY)) {
				for (int row = 0; row < MAX_ROW; row++) {
					for (int column = 0; column < MAX_COLUMN; column++) {
						if (tileTypes[row][column].isPointInside(mouseX, mouseY)) {
							if (!tileTypes[row][column].isDefault()) {

								if (tileTypeSelected == null) {
									tileTypeSelected = tileTypes[row][column];
								} else if (tileTypes[row][column].equals(tileTypeSelected)) {
									tileTypeSelected = null;
								} else {
									tileTypeSelected = tileTypes[row][column];

								}
							} else {
								tileTypeSelected = tileTypes[row][column];
								if (!sketchPadMode) {
									background(0, 0);
									sketchPadMode = true;
								}

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
			} else if (tileTypeSelected != null) {
				for (int row = 0; row < TILE_MAX_ROW; row++) {
					for (int column = 0; column < TILE_MAX_COLUMN; column++) {
						if (tiles[row][column].isPointInside((mouseX - 5 * width / 16) / zoom + 5 * width / 16,
								(mouseY - height / 2) / zoom + height / 2)) {
							// System.out.println("Row: " + row + ", Column: " + column +
							// "------------------------------------------------------");
							// SET TILE ASSET TO TILETYPEASSET
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
		} else if (mouseButton == LEFT) {
			if (tileTypeSelected != null) {
				for (int row = 0; row < TILE_MAX_ROW; row++) {
					for (int column = 0; column < TILE_MAX_COLUMN; column++) {
						if (tiles[row][column].isPointInside((mouseX - 5 * width / 16) / zoom + 5 * width / 16,
								(mouseY - height / 2) / zoom + height / 2)) {
							// System.out.println("Row: " + row + ", Column: " + column +
							// "------------------------------------------------------");
							// SET TILE TO TILETYPEASSET
						}
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