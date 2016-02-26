import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class GodModel extends Observable
{
	private GodAbility[] abilities;
	private ArrayList<Room> rooms;
	
	public GodModel(ArrayList<Room> room)
	{
		rooms = room; 	
		// this is the abilitiy to click in a room and see if a player is there. 
		//abilities[0] = new GodAbility(true,10);
		/// the ability to switch portals at all!
		//abilities[1] = new GodAbility(true,10);
		// the ability to "smite" a room causing damage
		//abilities[2] = new GodAbility(true,10);
	}
	
	public ArrayList<Room> getRooms()
	{
		return rooms; 
	}
	
	public void changeRoomLocation(Room r,Location loc)
	{
		for(int k =0; k<rooms.size();k++)
		{
			Room thisRoom = rooms.get(k);
			if (thisRoom.equals(r))
			{
				Location temp = thisRoom.getLocation();
				thisRoom.setLocation(loc);
				thisRoom.updatePortalLocations(temp);
			}
		}

		setChanged();
		notifyObservers();
	}
	
	public void setRoomBeingDragged(Room r)
	{
		r.roomSelected();
	}
	
	public void deselectRoomBeingDragged(Room r)
	{
		r.roomDeselected();
	}
	
	public Room getDraggedRoom()
	{
		for(Room r : rooms)
			if(r.isRoomSelected())
				return r;
		return null; 
	}
	
} 