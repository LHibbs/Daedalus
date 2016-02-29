import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**This is an temporary test Room class
 *@author Michelle Lee
 *@version 1/1/16
 *@description Contains info for the room for testing
 */

public class Room{
	//a list of all of the roomComponents in the room
	private List<RoomComponent> roomComps;
	private boolean isActive;

	public Room(){
		roomComps = new ArrayList<RoomComponent>();
		isActive = false;
	}

	/**Adds a RoomComponent to the list
	 *@param rc the component to be added
	 */
	public void addComp(RoomComponent rc){
		roomComps.add(rc);
	}

	/**Returns the list of components
	 *@return roomComps
	 */
	public List getList(){
		return roomComps;
	}

	/**Returns the roomComponent at the given index location
	 *@param x the index location
	 *@return a roomComponent
	 */
	public RoomComponent getComp(int x){
		return roomComps.get(x);
	}

	public Hero getHero(){
		if(isActive){
			for(int a = 0; a < roomComps.size(); a++){
				if(roomComps.get(a) instanceof Hero){
					return (Hero) roomComps.get(a);
				}
			}
		}
		return null;
	}

	/**Returns if the room is the current room that the player is in
	 *@param h the Hero in the room
	 *@return isActive
	 */
	public boolean isActiveRoom(){
		return isActive;
	}

	public void setActive(boolean b){
		isActive = b;
	}

	public RoomComponent removeComp(RoomComponent rc){
		roomComps.remove(rc);
		return rc;
	}

	public Portal getPortal(){
		for(int a = 0; a < roomComps.size(); a++){
				if(roomComps.get(a) instanceof Portal){
					return (Portal) roomComps.get(a);
				}
		}
		return null;
	}
}