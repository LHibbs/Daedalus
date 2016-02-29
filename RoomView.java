import java.util.*;
import java.awt.*;
import javax.swing.*;
/**
 *This class creates the room with all the RoomComponents and the Hero
 *
 * @author Michelle Lee
 * @version 1.00 2015/12/3
 */


public class RoomView extends JPanel implements Observer {

	private RoomModel r;

    public RoomView(RoomModel rm) {
    	r = rm;

    }

    /*Draws the Room with all RoomComponents and the Hero
     *First loops through the list of RoomComponents and paints rectangles
     *according to the length and width of the object.
     *Then paints the hero according to its hit box
     */
    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//Go through the list of RoomComponents
		Room room = r.getActiveRoom();
		for(int a =0; a < room.getList().size(); a++){
			//Create a rectangle of the size of that RoomComponent and fill it with a given color
			//(This is just for now, until we add in more of the visuals, they will just represent
			//what objects are there.)
			RoomComponent rc = room.getComp(a);
			g.setColor(rc.getColor());
			g.fillRect(rc.getLoc().getX(), rc.getLoc().getY(), rc.getWidth(), rc.getHeight());
		}

	}


	public void update(Observable o, Object arg)
    {
    	// Get the object we are observing
    	RoomModel room = (RoomModel)o;
    	r =room;

    	// paint the panel
    	repaint();
    }



}