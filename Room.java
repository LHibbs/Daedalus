/**
 * The abstract class that all room classes extend.
 *
 *@author Lauren Hibbs
 *@version File Name: Room.java
 *@version Date: 12/17/15
 *@version Program: GameProject 
 *@version description:basic stuff that this class must include, to be later 
 *	completed by someone else (probably Noah) 
 */
 
import java.util.ArrayList;
 
public abstract class Room // no methods are abstract, class is declared abstract so it cannot be instantiated
{
	//private static final SCREEN_HEIGHT = 100; // everything should scale to this height
	//private static final SCREEN_WIDTH = 100;
	
	private Location[] portalLocations;//within the room
	private ArrayList<RoomComponent> roomComponents;
	private ArrayList<Location> spawnLocations;//for things that can be added later into the room, a list of valid loctions
	private Portal[] portals;
	private boolean containsShrine; // shrine is a roomComponent
	
	//these locations are for the godView's screen. Related to the representation of the room on the god's view screen. 
	private Location[] godViewPortalLocations; 
	private Location godViewLocation; 
	private int godViewsize;//placeholder that repesents square rooms with a given size. 
		
	public Room()
	{
		// a lot of work will need to be done to initiliaze room components,
		//i believe Ethan is making a class that makes randomized rooms?
	}
	
	
	//checks if a passed location is used. called by the GodView class. Other similar methods will 
	//need to be implemented to the actual objects inside the room for the player interaction. 
	public boolean isLocationInRoom(Location l)
	{
		if((l.getX()<=(godViewLocation.getX()+ godViewsize)&& l.getX()>=godViewLocation.getX())
			&& l.getY()<=(godViewLocation.getY()+ godViewsize )&& l.getY()>=godViewLocation.getY())
			return true;
		else
			return false; 
		
	}
	
	
}