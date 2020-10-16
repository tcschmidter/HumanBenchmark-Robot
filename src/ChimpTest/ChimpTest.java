import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
/**
 * ChimpTest
 *
 * Program completes the Are You Smarter Than a 
 * Chimpanzee test at https://humanbenchmark.com/tests/chimp
 *
 * @author Thomas Schmidter
 * @version 2020
 **/
public class ChimpTest {

	public static void main(String[]args) {
		ChimpTestScreen screen = new ChimpTestScreen(getScreen());
		


	
	}
	//scans image and returns an array of pixels
	public static String[][] getScreen() {
		try {
			Robot robot = new Robot();
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screen = robot.createScreenCapture(rect);
			String[][]screenRGB = new String[screen.getWidth()][screen.getHeight()];
			for (int y = 0; y < screen.getHeight(); y++) {
			    for (int x = 0; x < screen.getWidth(); x++) {
			        int pixel = screen.getRGB(x, y);
			        String red = String.format("%03d", pixel >> 16 & 0xff);
			        String green = String.format("%03d", pixel >> 8 & 0xff);
			        String blue = String.format("%03d", pixel & 0xff);
			        screenRGB[x][y] = red + green + blue; 
		        }
			                                                                                                                                                     
		    }
			return screenRGB;  
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
