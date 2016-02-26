/**
 * Portal objects. Serve only to pair the current portal with the portal that 
 *they connect to.
 *
 *@author Lauren Hibbs
 *@version File Name: Portal.java
 *@version Date: 12/1/15
 *@version Program: GameProject
 *@version description : portal object
 */
public class Portal{
	
	private Portal connectsTo;
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
	
}