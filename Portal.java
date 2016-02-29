import java.util.*;
import java.awt.*;
import javax.swing.*;

/**This class contains informations for portals in the Hero's view
 * (Contains methods and parameters for Lauren's god view)
 *
 *@author: Michelle Lee
 *@version 2/19/16
 *@description: When a hero interacts with a portal, they will change
 *rooms to whichever room is connected
 */
public class Portal implements RoomComponent{
	private Portal connectsTo;
	private Location loc;
	private int height;
	private int width;
	private Color color;
	private Room thisRoom;
	private Location godViewLocation;
	private int godViewLocationRadius;
	private boolean connectsToPortal;//if this portal has no connections yet is false

	public Portal(){
	}

	public Portal(Room room, Location l, int size){
		thisRoom = room;
		godViewLocation = l;
		connectsToPortal = false;
		godViewLocationRadius = size;
	}

	public Portal(Portal p,Room room)
	{
		connectsTo=p;
		thisRoom = room;
		connectsToPortal = true;
	}

	//Constructor for the hero
	public Portal(Portal p, Location l, Room r){
		connectsTo = p;
		loc = l;
		thisRoom = r;
		connectsToPortal = true;
		godViewLocation = null;
		height = 50;
		width = 50;
		color = Color.green;
		godViewLocationRadius = 0;
	}

/*
	 *Sets the given portal to portal that this portal connects to.
	 *If a end Portal is still present, deletes that object. When the end portal is removed this
	 *portal reference is also removed from that portal object
	 *@param p the portal object to be set.
	 *@post this object and p both contain references to eachother. No other
	 *	portal objects contain references to these portals.
	 */
	public void setPortalConnection(Portal p)
	{
		if(connectsTo != null)
		{
			connectsTo.removeEndPortal();
			removeEndPortal();
			setEndPortal(p);
			p.setPortalConnection(this);
		}
		else
		{
			connectsTo = p;
		}
	}

	public Location getGodViewLocation()
	{
		return godViewLocation;
	}

	/*
	 * Removes the portal that this portal connects to.
	 */
	public void removeEndPortal()
	{
		connectsTo=null;
	}

	/*
	 *Sets the portal that this portal is coupled with to a new portal.
	 *@param p the portal object to be connected with this portal.
	 *
	 */
	public void setEndPortal(Portal p)
	{
		connectsTo=p;
	}

	public Portal getConnectedPortal()
	{
		return connectsTo;
	}

	public Room getRoom()
	{
		return thisRoom;
	}

	public boolean isLocationInPortal(Location l)
	{
		int xDiff= l.getX()-this.godViewLocation.getX();
        int yDiff= l.getY()- this.godViewLocation.getY();
        int totalDist=(int)Math.sqrt(Math.pow(xDiff,2.0)+Math.pow(yDiff,2.0));
        System.out.println("In portal? Distance from center: " + (totalDist) + (totalDist<=godViewLocationRadius));
        return totalDist<=godViewLocationRadius;

	}

	public int getClickRadius()
	{
		return godViewLocationRadius;
	}

	public void setPortalLocation(Location loc)
	{
		godViewLocation = loc;
	}

	public void changePortalLocation(int xChange, int yChange)
	{
		godViewLocation.setX(godViewLocation.getX()+xChange);
		godViewLocation.setY(godViewLocation.getY()+yChange);
	}

	public int getX()
	{
		return godViewLocation.getX();
	}

	public int getY()
	{
		return godViewLocation.getY();
	}

	/**
	 *Returns false if the portal to connect is in the same room as the current portal
	 *
	 */
	public boolean canAddPortal(Portal p)
	{
		return !(thisRoom==p.getRoom());
	}

	//HERO view Methods

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
		return color;
	}

	/**Returns the room that the portal connects to
	 *@return the room
	 */
	public Room getConnectedRoom(){
		return connectsTo.getRoom();
	}


}