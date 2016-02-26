import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.ArrayList;

public class TestController extends JFrame implements MouseListener, ActionListener, KeyListener, MouseMotionListener
{
	//private ArrayList<Room> rooms;
	private GodViewOverviewTest1 view;
	public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private static final int menuBarOffset=30; 
    private Location mouseLocation;
    private Clock timer;
    private GodModel godModel; 
   	//private Room roomModel; // the current room is a model. controller will switch out roomModel depending on which room is currently the 
   	//active room.
    //private GodUserInterfaceTest1 userInterface; 
    	
    private boolean mouseClicked; 
	private Portal portalToSwitch;
	private Room currentRoom; // the room being dragged around. 
	
	public TestController(ArrayList<Room> gameRooms)
	{
    	setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        Container contentPane = getContentPane();
        //contentPane.setLayout(new BorderLayout());
        
        mouseLocation= new Location();
        
        godModel = new GodModel(gameRooms); 
        view = new GodViewOverviewTest1(godModel);
        godModel.addObserver(view);
        view.update(godModel, null);
        contentPane.add(view);
        
        timer= new Clock(20, this);
        
        //userInterface = new GodUserInterfaceTest1(godModel, view, this); 
        
        setResizable(false);
        
        addMouseListener(this);
        addMouseMotionListener(this);
		mouseClicked = false;   
		//this.setUndecorated(true);
	}
	
	//public ArrayList<Room> getRooms()
	//{
	//	return rooms; 
	//}
	
	/**Switches the connections of two portals
	 *
	 */
//	public void switchPortals(Portal p1, portal p2)	
//	{
		
//	}
	
	public void connectPortal(Portal p1, Portal p2)
	{
		if(p1.getConnectedPortal()!=null)
			p1.getConnectedPortal().removeEndPortal();
		if(p2.getConnectedPortal()!=null)
			p2.getConnectedPortal().removeEndPortal();
		p1.setEndPortal(p2);
		p2.setEndPortal(p1);
	}

/******************************************************************/
	
	public void keyPressed(KeyEvent e){
	}
	
	public void keyReleased(KeyEvent e){
	}
		
		
	public void keyTyped(KeyEvent e)
	{
	/*	int keyCode = e.getKeyCode();
    		switch( keyCode ) { 
		        case KeyEvent.VK_1:
		            // handle ability 1
		            break;
		        case KeyEvent.VK_2:
		            // handle ability 2
		            break;
		        case KeyEvent.VK_3:
		            // handle ability 3
		            break;
		        case KeyEvent.VK_4 :
		            // handle ability 4
		            break;
    	}
    	*/		
	}
	
	
	public void mouseEntered(MouseEvent e){
    }
    
    public void mouseExited(MouseEvent e){ 
    }
    
    public void mousePressed(MouseEvent e){
    	
    	
    } 
        
    public void mouseReleased(MouseEvent e){
    	
    //	if(currentRoom !=null)
    //		currentRoom = null; 
    }
    
    public void mouseClicked(MouseEvent e)
    {
    	System.out.println("apple!!!!!!!!" + mouseClicked);
    	boolean mouseInPortal = false;
    	Portal tempPortal = null;
    	Location mouseLocation = new Location();
	    mouseLocation.setX(e.getX());
	    mouseLocation.setY(e.getY()-menuBarOffset);
	    System.out.println("You clicked x: " + e.getX() + " y: " + (e.getY()-menuBarOffset));
	    
    	if(!mouseClicked)
    	{		
	    	Room thisRoom = null;
	    	ArrayList<Room> rooms = godModel.getRooms();
	    	
	    	for(int k=0; k<rooms.size(); k++ )//go through list of rooms and check if XY coordinate is present in a room.
	   		{
	    		thisRoom =rooms.get(k);
	    		if(thisRoom.isLocationInRoom(mouseLocation))
	    		{
	    			System.out.println("In a room!");
	    			Portal[] portals = thisRoom.getPortalList();
	    			for(Portal p : portals)
	    			{
	    				System.out.println("Portal location centered at x: " + p.getX()  + " y: " + p.getY());
	    				if(p.isLocationInPortal(mouseLocation))
	    				{
	    					mouseInPortal = true;
	    					tempPortal = p;
	    					break;
	    				}
	    			}
	   /*** RIGHT NOW I AM ASSUMING NO PORTALS HAVE PARTNERS (ONLY USE PORTAL CONNECT METHOD)****/
	    			if(mouseInPortal) // a portal was clicked!
	    			{	
	    				System.out.println("In a portal!");
		    			if(portalToSwitch!=null && portalToSwitch.canAddPortal(tempPortal)) // there is already a portal to switch
		    			{
		    				System.out.println("Connecting portals...");
		    				connectPortal(portalToSwitch, tempPortal);
		    				portalToSwitch = null; 
		    				return; 
		    			}
		    			else // there was no portal already to switch
		    			{
		    				portalToSwitch = tempPortal; 
		    				System.out.println("No portal to switch");
		    			}	
	    			}
	    			else // a portal was not clicked, but the room was clicked.
	    			{
	    				System.out.println("banana In a room!");
	    				mouseClicked = true;
	    				if(currentRoom ==null)
	    					currentRoom = thisRoom;
	    				else
	    					currentRoom = null; 
	    				break;
	    				// allow the user to drag the room around the screen. change the xy location of the room. 
	    			}
	    			//break 
	    		}
	    	}
    	}
    	else // mouse has been clicked and this is the second click (release)
    	{
    		mouseClicked = false; 
    		godModel.changeRoomLocation(currentRoom,mouseLocation);
    		currentRoom = null;
    	}	
    	 
    	//check if anything else was clicked. 

   }
   
   public void mouseDragged(MouseEvent e)
   {
   		if(currentRoom!=null)
    	{
    		godModel.changeRoomLocation(currentRoom, new Location(e.getX(),e.getY()));
    		currentRoom.updatePortalLocations(new Location(e.getX(),e.getY()));
    	}
   	
   }
   
   public void mouseMoved(MouseEvent e)
   {
   		//System.out.println("Foxtrot");
   }
   
   public Room getCurrentRoom()
   {
   		return currentRoom;
   }
   
   public boolean isBeingDragged()
   {
   		return mouseClicked; 
   }
    
    /*
     * Do something if a button is pressed. Not sure what buttons will be included yet.
     *@param w the actionEvent that fired.
     */
  	public void actionPerformed(ActionEvent w)
    {
    	
    }
	
}
