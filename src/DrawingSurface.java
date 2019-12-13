import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private static final int GRID_SIZE = 50;
	private static final int GRID_LINE = 3;
	private static boolean MENU = false;

	public void settings() {
		size(1200, 800);
		
	}

	public void initGame() {

	}

	public void setup() {
		
		
		
		
	}

	public void draw() {
		background(0);
		rect(mouseX-(mouseX%GRID_SIZE), mouseY-(mouseY%GRID_SIZE), GRID_SIZE,
		GRID_SIZE);

	}
	
	

}