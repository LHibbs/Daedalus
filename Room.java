/**
 * A room object that has a type, and contains portals, platforms, and has a location relative
 *	the the god player's view screen. 
 *
 *@author Lauren Hibbs
 *@version File Name: Room.java
 *@version Date: 12/10/15
 *@version Program: GameProject UnitTesting1
 *@version description : includes only portions of the room that need to be completed to test
 *	the controller and godView
 */
public class Room
{
	private Location godViewLocation;
	private String roomType;//a placeholder bc later room hierarchy will have different types of rooms
	private int size;//placeholder that repesents square rooms with a given size. 
	private Portal[] portals;
	private int portalClickRadius;
	private boolean roomSelected; // true if the room is currently being dragged
		
	public Room(String type, int s, int portalClickRadius)
	{
		roomType = type;
		godViewLocation=new Location(0,0); 
		size = s;
		portals = new Portal[4];
		//portals number clockwize starting at top left.
		portals[0] = new Portal(this, new Location((godViewLocation.getX() + size/2),godViewLocation.getY()),portalClickRadius);
		portals[1] = new Portal(this, new Location((godViewLocation.getX() + size),godViewLocation.getY()+size/2),portalClickRadius);
		portals[2] = new Portal(this, new Location((godViewLocation.getX() + size/2),godViewLocation.getY()+size),portalClickRadius);
		portals[3] = new Portal(this, new Location((godViewLocation.getX()),godViewLocation.getY()+size/2),portalClickRadius);
		roomSelected = false;
	}
	
/*	public Room(String type, int s, int portalClickRadius, int xLoc, int yLoc)
	{
		roomType = type;
		godViewLocation=new Location(xLoc, yLoc); 
		size = s;
		portals = new Portal[4];
		//portals number clockwize starting at top left.
		portals[0] = new Portal(this, adjustCircle(new Location((godViewLocation.getX() + size/2),godViewLocation.getY()),portalClickRadius),portalClickRadius);
		portals[1] = new Portal(this, adjustCircle(new Location((godViewLocation.getX() + size),godViewLocation.getY()+size/2),portalClickRadius),portalClickRadius);
		portals[2] = new Portal(this, adjustCircle(new Location((godViewLocation.getX() + size/2),godViewLocation.getY()+size),portalClickRadius),portalClickRadius);
		portals[3] = new Portal(this, adjustCircle(new Location((godViewLocation.getX()),godViewLocation.getY()+size/2),portalClickRadius),portalClickRadius);
		roomSelected = false;
	}
*/
	public Room(String type, int s, int portalClickRadius, int xLoc, int yLoc)
	{
		roomType = type;
		godViewLocation=new Location(xLoc, yLoc); 
		size = s;
		portals = new Portal[4];
		//portals number clockwize starting at top left.
		portals[0] = new Portal(this, new Location((godViewLocation.getX() + size/2),godViewLocation.getY()),portalClickRadius);
		portals[1] = new Portal(this, new Location((godViewLocation.getX() + size),godViewLocation.getY()+size/2),portalClickRadius);
		portals[2] = new Portal(this, new Location((godViewLocation.getX() + size/2),godViewLocation.getY()+size),portalClickRadius);
		portals[3] = new Portal(this, new Location((godViewLocation.getX()),godViewLocation.getY()+size/2),portalClickRadius);
		roomSelected = false;
	}

	
	/*
	 * Adjusts shapes so that they are drawn around the center point, rather than the top left.
	 */
	public static Location adjustCircle(Location loc, int clickRadius)
	{
		return new Location (loc.getX()-clickRadius/2,loc.getY()-clickRadius/2);
	}
	
	public Location getLocation()
	{
		return godViewLocation;
	}
	
	public String getType()
	{
		return roomType;
	}
	
	public boolean isLocationInRoom(Location l)
	{
		if((l.getX()<=(godViewLocation.getX()+ size)&& l.getX()>=godViewLocation.getX())
			&& l.getY()<=(godViewLocation.getY()+ size )&& l.getY()>=godViewLocation.getY())
			return true;
		else
			return false; 
	}
	
	public boolean isLocationInPortal(Location l)
	{
		for(Portal p: portals)
		{
			if(p.isLocationInPortal(l))
				return true;
		}
		return false; 
	}
	
	public String getRoomType()
	{
		return roomType;
	}
	
	public Portal[] getPortalList()
	{
		return portals;
	}
	
	public int getSize()
	{
		return size; 
	}
	
	public void setLocation(Location location)
	{
		godViewLocation = location; 
	}
	
	/*
	 *Changes the locations of the portals to move with the rooms. 
	 *
	 */
	public void updatePortalLocations(Location oldLocation)
	{
		int xDiff= godViewLocation.getX()-oldLocation.getX(); 
        int yDiff= godViewLocation.getY()- oldLocation.getY(); 
		
		for(Portal p: portals)
			p.changePortalLocation(xDiff, yDiff);
		
	
	/*	portals[0].setPortalLocation(new Location((godViewLocation.getX() + size/2),godViewLocation.getY()));
		portals[1].setPortalLocation(new Location((godViewLocation.getX() + size),godViewLocation.getY()+size/2));
		portals[2].setPortalLocatio(new Location((godViewLocation.getX() + size/2),godViewLocation.getY()+size));
		portals[3].setPortalLocation( new Location((godViewLocation.getX()),godViewLocation.getY()+size/2));
		*/
	}
	
	public void roomSelected()
	{
		roomSelected = true; 
	}
	
	public void roomDeselected()
	{
		roomSelected = false; 
	}
	
	public boolean isRoomSelected()
	{
		return roomSelected; 
	}
	
	public void highlightRoom()
	{
		
	}
	

	
}