import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.*;

//*****WORK IN PROGRESS*****

/**This is an temporary test Room controller class
 *@author Michelle Lee
 *@version 2.26.16
 *@description Contains info for the room for testing
 *Model: Room class
 *View: RoomView class
 */

public class RoomTestController extends JFrame implements KeyListener{
	final int WIDTH = 600;
	final int HEIGHT = 600;
	private Room room;
	private Room room2;
	private ArrayList<Room> roomList;
	private RoomModel model;
	private RoomView view;
	private Hero hero;
	private RoomComponent rc;
	private Clock timer;

	public RoomTestController(){
		//create the window
		super("Test Controller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);

		room = new Room();
		room2 = new Room();

		Location portalLoc = new Location(280, 340);
		Location portal2Loc = new Location(380, 340);

		rc = new TestComponent();
		hero = new Hero();

		Portal portal = new Portal(null, portalLoc, room);
		Portal portal2 = new Portal(portal, portal2Loc, room2);
		portal.setEndPortal(portal2);
		portal2.setEndPortal(portal);

		timer = new Clock(this, 10);
		room.addComp(rc);
		room.addComp(hero);
		room.addComp(portal);
		room2.addComp(portal2);
		room2.addComp(rc);

		roomList = new ArrayList<Room>();
		roomList.add(room);
		roomList.add(room2);

		model = new RoomModel(roomList, hero);
		model.setActiveRoom(room);

		view = new RoomView(model);
		model.addObserver(view);
		addKeyListener(this);

		timer.start();
		Container c = getContentPane();
		view.update(model, null);
		c.add(view);
	}

	public Hero getHero(){
		return hero;
	}

	//KeyListener methods
	//This method is called when a key is pressed
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();

		//move left
		if(code == KeyEvent.VK_LEFT){
			model.moveInRoom(-1);
			System.out.println(hero.getLoc().getX());
			System.out.println("left key pressed");
		}
		//move right
		else if(code == KeyEvent.VK_RIGHT){
			model.moveInRoom(1);
			System.out.println(hero.getLoc().getX());
			System.out.println("right key pressed");
		}

		//jump
		else if(code == KeyEvent.VK_SPACE){
			System.out.println("spacebar pressed");
			Room r = model.getActiveRoom();
			Portal p = r.getPortal();
			if(p == null){
				System.out.println("blah");
			}
			if(hero.getLoc().getX() < p.getLoc().getX()+p.getWidth() && hero.getLoc().getX()+hero.getWidth() > p.getLoc().getX()){
				model.setActiveRoom(p.getConnectedRoom());
			}
		}
		//move up
	//	else if(code == KeyEvent.VK_UP){
		//	if(/*the hero is on a ladder*/){
		//		h.setIncr(1);
		//		h.move(up);
		//	}
		//	else{ //the hero is jumping
		//		h.jump();
		//	}

	}

	//This method is called when a key is released
	public void keyReleased(KeyEvent e){}

	public void keyTyped(KeyEvent e){}

	public static void main(String[] args){
		RoomTestController rtc = new RoomTestController();
		rtc.setVisible(true);
	}

}