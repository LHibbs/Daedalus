import java.util.*;
import javax.swing.SwingConstants.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;


/**
 * The "default" view for the god. Shows a layout of all of the rooms
 *	and allows the god to rearrange the rooms visually or change portal
 *	connections between the rooms
 *
 *@author Lauren Hibbs
 *@version File Name: GodViewOverviewtest1.java
 *@version Date: 12/10/15
 *@version Program: GameProject UnitTesting1
 *@version description : excludes the godmodel object for unit testing 
 */
public class GodViewOverviewTest1 extends JPanel implements Observer
{
	
	private GodModel god;
//	private PlayerModel hero;
//	private TestController controller; 
//	private final int SCREEN_SIZE; 
//	private static final int ROOM_SIZE = 60; 
	
	public GodViewOverviewTest1( GodModel g /*, TestController c , int screenSize*/)
	{
		god = g; 
	//	controller = c; 
	//	SCREEN_SIZE = screenSize; 
	}
	
	public static Location adjustCircle(Location loc, int clickRadius)
	{
		return new Location (loc.getX()-clickRadius/2,loc.getY()-clickRadius/2);
	}
	
	/*
	 * For the god view, a method can change what is is that the god sees. The default view will
	 *	be the layout of the rooms on the screen. Other views will include zooming in to see a 
	 *	room, information screens, etc.This is the default view only.
	 * Goes through a list of rooms, and draws each one according to its type and location. 
	 * Go through the list of portal connectors and draw each connecting to each room with a line 
	 * between them. Checks the cooldown on each ability and updates it (some sort of icon indicating time left
	 *	maybe like a pie-chart indicator). Increments a timer in the top corner. 
	 *	Any actions that the player causes (i.e a portal lights up as the player goes through it) should
	 *  appear on the screen.How do I do this?  
	 *
	 */
	public void paintComponent(Graphics g)
	{
		List<Room> rooms = god.getRooms(); 
		
		Color roomColor = new Color(0,0,0);
		super.paintComponent(g);
			
			for(int k=0; k<rooms.size(); k++)
			{
				Location roomLocation = rooms.get(k).getLocation(); // make sure that room class has this method
				
				switch(rooms.get(k).getRoomType()){// make sure this
					case "Water":
						//roomColor = new Color(0,191,255);//blue
						g.setColor(new Color(0,191,255));
						break; 
					case "Dark": 
						//roomColor = newColor(0,0,120);//dark blue-black
						g.setColor(new Color(0,0,120));
						//System.out.println("Carrot");
						break;
					case "Fire":
						//roomColor = newColor(255,69,0);//orange - red
						g.setColor(new Color(255,69,0));
						break;
					default:
					break; 
				}
				g.fillRect(rooms.get(k).getLocation().getX(),rooms.get(k).getLocation().getY(),rooms.get(k).getSize(),rooms.get(k).getSize()); 			
			// now draw the room object. Use color, size and relative xy position. 
				for(int z =0; z<rooms.get(k).getPortalList().length; z++)	
				{
					//System.out.println("Portal drawing method");
					Portal[] portals = rooms.get(k).getPortalList();
					for(Portal p: portals)
					{
						if(p != null) // there is a portal present
						{
							
							Location portalStart = p.getGodViewLocation();//location based relative to room and standard portal 
																  //indexing system						  
							Color circleColor = Color.BLACK;
							g.setColor(circleColor);
							System.out.println("portal location: "+portalStart.getX()+" "+portalStart.getY());
							//Location adjustedLocation = adjustCircle();
							g.drawOval(portalStart.getX()-p.getClickRadius(),portalStart.getY()-p.getClickRadius(),p.getClickRadius()*2,p.getClickRadius()*2);
							
							if(p.getConnectedPortal()!=null)
							{
								//System.out.println("Drawing connected portals");
								
								Location portalFinish = p.getConnectedPortal().getGodViewLocation();
								Color lineColor = Color.BLUE; 
								g.setColor(lineColor);
								
								//System.out.println("Starting portal x&y : " + portalStart.getX() + " " + portalStart.getY());
								//System.out.println("End portal x&y : " + portalFinish.getX() + " " + portalFinish.getY());
								
								g.drawLine(portalStart.getX(),portalStart.getY(),portalFinish.getX(),portalFinish.getY());
								//g.drawLine(portalStart.getX()+1,portalStart.getY(),portalFinish.getX()+1,portalFinish.getY());
								
							}

							
						}
					}
				}
			}	
				
		}
			
	
	public void update(Observable o, Object obj)
	{
		GodModel b=(GodModel)o; 
		god = b;
		repaint();
		
	}

}