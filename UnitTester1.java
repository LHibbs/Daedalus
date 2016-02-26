import java.util.*;
import java.awt.*;

public class UnitTester1
{
	// this class should maybe include whether this instance 
	//of the game is a player or god instance
	public static void main (String[] args)
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
		Room r1 = new Room("Water",150,20,0,0);
		rooms.add(r1);
		Room r2 = new Room("Water",150,20,400,400);
		rooms.add(r2);
		/*Room r3 = new Room("Fire",80,20,400,100);
		rooms.add(r3);
		Room r4 = new Room("Dark",80,20,300,200);
		rooms.add(r4);
		Room r5 = new Room("Dark",80,20,500,300);
		rooms.add(r5);
		*/
		TestController controller = new TestController(rooms);
		controller.setVisible(true);
	}
	
	
}