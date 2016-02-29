import java.util.*;
import java.awt.*;
import javax.swing.*;

/**This is an interface for RoomComponent
 *@author Michelle Lee
 *@version 12/17/15
 *@description Contains the height, width and location of the component
 *	and accessor method for each
 */
public interface RoomComponent{

	/**Returns the location of the component
	 *@return loc the location
	 */
	public Location getLoc();

	/**Returns the height (in pixels) of the component
	 *@return height the height
	 */
	public int getHeight();

	/**Returns the width of the component
	 *@return width the width
	 */
	public int getWidth();

	/**Returns the color of the component
	 *@return c the color
	 */
	public Color getColor();


}