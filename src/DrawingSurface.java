import java.util.ArrayList;

import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	public static final int GRID_SIZE = 50;//width/16
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
		
		for(int row = 0; row < MAX_ROW; row++ ) {
			for(int column = 0; column < MAX_COLUMN; column++) {
				tileTypes[row][column] = new TileType(this, row, column, 1, false, 0.5);
			}
		}
	}

	public void draw() {
		background(0);
		if(mouseX < width-width/4) {
			MENU_OPTION = 0;
		}
		
		
		fill(70);
		rect(width-width/4, 0, width/4+50, height, 50);	
		for(int row = 0; row < MAX_ROW; row++) {
			for(int column = 0; column < MAX_COLUMN; column++) {
				tileTypes[row][column].draw();
			}
		}
		
		
		if(mouseX < width-width/4) {
			fill(255);
			rect(mouseX-(mouseX%GRID_SIZE), mouseY-(mouseY%GRID_SIZE), GRID_SIZE, GRID_SIZE);
			
		} else {
			
		}
		
		
		
	}
	
	public void mousePressed() {
		if(mouseX >= width-width/4) {
			
		}
	}
	
	
	
	
	
	
	
	
	

}