import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**This is an temporary test RoomModel class containing a list of rooms
 *@author Michelle Lee
 *@version 1/20/16
 *@description Contains info for the room for testing
 */
public class RoomModel extends Observable{
	private ArrayList<Room> roomList;
	private Room activeRoom;
	private Hero h;

	public RoomModel(ArrayList<Room> rooms, Hero hero){
		roomList = rooms;
		h = hero;
		for(int a = 0; a < rooms.size(); a++){
			if(rooms.get(a).isActiveRoom()){
				activeRoom = rooms.get(a);
			}
		}
		activeRoom = rooms.get(0);
	}

	/*Sets the given room to be the active room
	 */
	public void setActiveRoom(Room r){
		r.addComp(h);
		activeRoom.removeComp(h);

		activeRoom = r;
		setChanged();
		notifyObservers();
	}

	/**Returns the current room the player is in
	 *@return the room
	 */
	public Room getActiveRoom(){
		return activeRoom;
	}

	/*Returns a room given an index number
	 *@param x the index to be found
	 *@return the room at that index location
	 */
	public Room getRoom(int x){
		return roomList.get(x);
	}

	public void moveInRoom(int x){
		h.move(x);
		//System.out.println("moving hero");
		setChanged();
		notifyObservers();
	}


}