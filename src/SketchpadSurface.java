import java.awt.Color;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

public class SketchpadSurface extends PApplet {

	private static final int GRID_SIZE = 50;
	private static final int GRID_LINE = 3;
	private static boolean MENU = false;
	PImage img;
	PGraphics canvas;
	Color lineColor = new Color(0);
	private boolean eraseMode = false;
	int weight = 3;
	int locY = 0;
	private int alpha = 255;
	private boolean clearCanvas = false;

	public void settings() {
		size(306, 359);

	}

	public void initGame() {

	}

	public void setup() {

		canvas = createGraphics(300, 330, JAVA2D);
		canvas.beginDraw();
		canvas.format = ARGB;
		canvas.background(255, 0);
		
		canvas.endDraw();
		
	}

	public void draw() {
		// background(255, 0);

		canvas.beginDraw();
		canvas.loadPixels();
		MENU = true;

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

		
		//canvas.stroke(0);
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
					img  = canvas.get(0, 30, 300, 300);
					// saveFrame("C:\\Users\\devdr\\Desktop\\DnDCoolKids\\DnDSimulator\\SavedPics\\Test.jpg");
					img.save("C:\\Users\\devdr\\Desktop\\DnDCoolKids\\DnDSimulator\\SavedPics\\Test.png");
					canvas.endDraw();
					exit();
				}
			} 

		} else {
			MENU = false;
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

	}
	
	

}