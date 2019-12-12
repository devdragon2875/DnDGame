import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.awt.Color;
import java.awt.Polygon;
import java.io.Serializable;
import java.util.ArrayList;

public class DrawingSurface extends PApplet {

	private static final int GRID_SIZE = 50;
	private static final int GRID_LINE = 3;
	private static boolean MENU = false;
	Color lineColor = new Color(0);
	int weight = 3;
	int locY = 0;
	public void settings() {
		size(1200, 800);
		smooth(0);

	}

	public void initGame() {

	}

	public void setup() {
		background(255);
	}

	public void draw() {
		//background(0);
		
		
		if(mouseY < 30) {
			MENU = true;
			
			strokeWeight(0);
			fill(255, 81, 81);
			rect(0, locY, 30, 30);
			
			fill(130, 255, 130);
			rect(30, locY, 30, 30);
			
			fill(180, 255, 255);
			rect(60, locY, 30, 30);
			
			fill(255, 255, 255);
			rect(90, locY, 30, 30);
			
			fill(0, 0, 0);
			rect(120, locY, 30, 30);
			
			fill(178, 102, 255);
			rect(150, locY, 30, 30);
			
			fill(255, 155, 153);
			rect(180, locY, 30, 30);
			
			strokeWeight(1);
			stroke(0);
			fill(255, 255, 255);
			rect(210, locY, 30, 30);
			
			fill(255, 255, 255);
			rect(240, locY, 30, 30);
			
			fill(255, 255, 255);
			rect(270, locY, 30, 30);
			
			if(mousePressed == true) {
				if(mouseX < 30) {
					lineColor = new Color(255, 81, 81);
				} else if (mouseX < 60) {
					lineColor = new Color(130, 255, 130);
				} else if (mouseX < 90) {
					lineColor = new Color(180, 255, 255);
				} else if (mouseX < 120) {
					lineColor = new Color(255, 255, 255);
				} else if (mouseX < 150) {
					lineColor = new Color(0, 0, 0);
				} else if (mouseX < 180) {
					lineColor = new Color(178, 102, 255);
				} else if (mouseX < 210) {
					lineColor = new Color(255, 155, 153);
				} else if (mouseX < 240) {
					weight = 8;
				} else if (mouseX < 270) {
					weight = 18;
				} else if (mouseX < 300) {
					//SAVE
					
				}
			}
			
		} else {
			MENU = false;
			
			if (mousePressed == true) {
				strokeWeight(weight);
				stroke(lineColor.getRGB());
				line(mouseX, mouseY, pmouseX, pmouseY);
			}
		}
		
		
		
		// rect(mouseX-(mouseX%GRID_SIZE), mouseY-(mouseY%GRID_SIZE), GRID_SIZE,
		// GRID_SIZE);
		

	}

	public void mouseMoved() {

	}

}