import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * PictureArray
 *
 * displays and analyzes pixels
 * sent from Chimp Test
 *
 * @author Thomas Schmidter
 * @version 2020
 **/
public class PictureArray {

	private String[][] screenRGB;
	private int[][] red;
	private int[][] green;
	private int[][] blue;
	private int height;
	private int width;

	public PictureArray(String[][] screenRGB) {
		this.screenRGB = screenRGB;
		red = new int[screenRGB.length][screenRGB[0].length];
		green = new int[screenRGB.length][screenRGB[0].length];
		blue = new int[screenRGB.length][screenRGB[0].length];
		width = screenRGB.length;
		height = screenRGB[0].length;
		//assigns values to red, green, and blue arrays
		for (int i = 0; i < screenRGB.length; i++) {
			for (int j = 0; j < screenRGB[0].length; j++) {
				int r = Integer.parseInt(screenRGB[i][j].substring(0,3));
				int g = Integer.parseInt(screenRGB[i][j].substring(3,6));
				int b = Integer.parseInt(screenRGB[i][j].substring(6));
				red[i][j] = r;
				green[i][j] = g;
				blue[i][j] = b;
			}
		}

	}
	//returns color array of given component ('r' == red, etc.)
	//if no valid color is given, return array of screen size
	public int[][] getColor(char color) {
		switch (color) {
			case 'r':
				return red;
			case 'g':
				return green;
			case 'b':
				return blue;
			default:
				return new int[width][height];
		}
	}
	public String[][] getScreen() {
		return screenRGB;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}