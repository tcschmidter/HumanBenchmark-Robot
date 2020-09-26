import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * ChimpTest
 *
 * Program completes the Are You Smarter Than a Chimpanzee test at https://humanbenchmark.com/tests/chimp
 * @author Thomas Schmidter
 * @version 2020
 **/
public class ChimpTest {

	public static void main(String[]args) {
		Robot robot;
		try { 
			robot = new Robot();
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenCap;

			screenCap = robot.createScreenCapture(rect);
			scanImage(screenCap);


		} catch (AWTException e) {
    		e.printStackTrace();
		}
	
	}

	public static void scanImage(BufferedImage screen) {
		int pixel = (screen.getRGB(0, 0));
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff; 
        int lastPixel = pixel;
        int lastRed = red;
        int lastGreen = green;
        int lastBlue = blue;
		for (int y = 0; y < screen.getHeight(); y++) {
		    for (int x = 0; x < screen.getWidth(); x++) {
		        pixel = screen.getRGB(x, y);
		        red = (pixel >> 16) & 0xff;
		        green = (pixel >> 8) & 0xff;
		        blue = (pixel) & 0xff;
		        if (red - lastRed > 10 || blue - lastBlue > 10 || green - lastGreen > 10) {
		        	System.out.println("Color changed from RGB(" + lastRed + ", " + lastGreen + ", " + lastBlue + ") " +
		        		"to RGB(" + red + ", " + green + ", " + blue + ") at (x,y) = (" + x + ", " + y + ")");     
		        	lastPixel = pixel;
			        lastRed = red;
			        lastGreen = green;
			        lastBlue = blue;
		        }
		                                                                                                                                                     
		    }
		    lastPixel = pixel;
	        lastRed = red;
	        lastGreen = green;
	        lastBlue = blue;
		}

	}

}