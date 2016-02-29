import java.util.*;
import java.awt.*;
import javax.swing.*;

/**This is an temporary test Hero class
 *@author Michelle Lee
 *@version 1/1/16
 *@description Makes an object that has a height, width and location
 */

public class Hero implements RoomComponent {
	private int height;
	private int width;
	private Location loc;
	private Color c;
	private int increment;

	public Hero(){
		height = 50;
		width = 50;
		loc = new Location(150, 340);
		c = Color.blue;
		increment =5;

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

	/**Returns the color of the hero
	 *@return c the color
	 */
	public Color getColor(){
		return c;
	}

	/**Moves the player by the increment
	 */
	public void move(int dir){
		loc.setX(loc.getX() + increment*dir);
	}

	public void setLoc(Location l){
		loc = l;
	}
}