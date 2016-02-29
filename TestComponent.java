import java.util.*;
import java.awt.*;
import javax.swing.*;

/**This is an temporary test RoomComponent class
 *@author Michelle Lee
 *@version 1/1/16
 *@description Makes an object that has a height, width and location
 */
public class TestComponent implements RoomComponent{
	private int height;
	private int width;
	private Location loc;
	private Color c;

	public TestComponent(){
		height = 25;
		width = 400;
		loc = new Location(100,390);
		c = Color.red;
	}

	/**Returns the location of the component
	 *@return loc the location
	 */
	public Location getLoc(){
		return loc;
	}

	/**Returns the height (in pixels) of the component
	 *@return height the height
	 */
	public int getHeight(){
		return height;
	}

	/**Returns the width of the component
	 *@return width the width
	 */
	public int getWidth(){
		return width;
	}

	/**Returns the color of the component
	 *@return c the color
	 */
	public Color getColor(){
		return c;
	}


}