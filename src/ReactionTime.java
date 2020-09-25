import java.awt.*;
import java.awt.event.*;
/**
 * ReactionTime
 *
 * Program completes the reaction speed test at https://humanbenchmark.com/tests/reactiontime to give user inputted results
 *
 * @author Thomas Schmidter
 * @version 2020
 */
public class ReactionTime {

	public static void main(String[]args) {

		Robot robot;
		boolean foundTest = false;
		Color currentColor;
		Color startColor = new Color(43, 135, 209);
		Color clickColor = new Color(75, 219, 106);
		Point mousePos = new Point(0, 0);
		try { 
			robot = new Robot();
			//moves mouse from the top to the bottom of the screen until it reaches its target
			robot.mouseMove((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, 0);
			for (int i = 0; (i + mousePos.y) < (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); i++) {
				mousePos = MouseInfo.getPointerInfo().getLocation();
				robot.mouseMove(mousePos.x, mousePos.y + i);
				currentColor = robot.getPixelColor(mousePos.x, mousePos.y);
				System.out.println(currentColor);
				if(currentColor.equals(startColor)) {
					foundTest = true;
					//stops loop
					i = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				}
			}
			if(!foundTest) {
				System.out.println("Error: Reaction Time Test not found");
				return;
			}
			//starts test
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			//loops for all 5 trials and clicks when the color of the test turns green
			int trials = 0;
			while (trials < 5) {
				currentColor = robot.getPixelColor(mousePos.x, mousePos.y);
				if(currentColor.equals(clickColor)) {
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					
					//waits one second to show the user the reaction time then continues to the next trial
					try {
					    Thread.sleep(1000);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				}
				trials ++;
			}


		} catch (AWTException e) {
    		e.printStackTrace();
		}
			
	}

}
