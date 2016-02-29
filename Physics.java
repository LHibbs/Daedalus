import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Physics
{
    private Room room;
    private int roomLength;
    private int roomHeight;
    private final int GRAVITY = 4;
    private int multiplier;
    private boolean doubleJump;
    private Location location;
    private int heroHeight;
    private int heroLength;

    /*
     *    Deafault constructor for the Physics class
     */
    public Physics(){
        roomLength = 0;
        roomHeight = 0;
        multiplier = 0;
    }

    /*
     *    Constructor for the Physics class
     *    @param length is the length of the room
     *    @param width is the width of the room
     */
    public Physics(Room room, int length, int height, Location l, int heroLength, int heroHeight){
        this.room = room;
        location =  l;
        boolean doubleJump = false;
        roomLength = length;
        roomHeight = height;
        multiplier = 100;
        this.heroLength = heroLength;
        this.heroHeight = heroHeight;
    }

    /*
     *    Moves the player
     *    @param x is the amount of x coords it has to move
     *    @param y is the amount of y coords it has to move
     *    @postcondition when applying the x and y coords we have to make sure it stays within the room
     */
    public Location move(int x, int y){
        Location heroLoc = location;
        int startX = heroLoc.getX();
        int startY = heroLoc.getY();
        int endX = startY + heroLength;
        int endY = startY + heroHeight;
        int incrementX = x * multiplier;
        int incrementY = y; //jumping multiplier?
        int check = 0;
        //C0de below is for out of room bounds
        if(x>0){
            check = endX + incrementX;
            if(check>roomLength)
                heroLoc.setX(roomLength-heroLength);
            else
                heroLoc.setX(check);
        }
        else if(x<0){
            check = startX + incrementX;
            if(check<0)
                heroLoc.setX(0);
            else
                heroLoc.setX(check);
        }
        if(y<0){
            check = startY + y;
            if(check<0)
                heroLoc.setY(0);
            else
                heroLoc.setY(check);
        }
        else if (y>0){
            check = endY + y;
            if(check>roomHeight)
                heroLoc.setY(roomHeight-heroHeight);
            else
                heroLoc.setY(check);
        }
        //Check below cycles through the list and corrects placement
        int count = 0;
        List list = room.getList();
        RoomComponent obj = null;
        boolean found = false;
        while(list.get(count)!=null && !found){
            obj = (RoomComponent) list.get(count);
            int objStartX = obj.getLoc().getX();
            int objEndX = objStartX + obj.getWidth();
            if(x>0){
                check = endX + incrementX;
                if(check>objStartX && check<objEndX){
                    heroLoc.setX(objStartX-heroLength);
                    found = true;
                }
            }
            else if(x<0){
                check = startX + incrementX;
                if(check>objStartX && check<objEndX){
                    heroLoc.setX(objEndX);
                    found = true;
                }
            }
            count++;
        }
        found = false;
        count = 0;
        while(list.get(count)!=null && !found){
            int objStartY = obj.getLoc().getY();
            int objEndY = objStartY + obj.getHeight();
            if(y>0){
                check = endY + incrementY;
                if(check<objEndY && check>objStartY)
                {
                    heroLoc.setY(objStartY-heroHeight);
                    found = true;
                }
            }
            else if(y<0){
                check = startY + incrementY;
                if(check<objEndY && check>objStartY)
                {
                    heroLoc.setY(objEndY);
                    found = true;
                }
            }
            count++;
        }
        location = heroLoc;

    }

    public void changeRoom(Room room){
        this.room = room;
    }


    public void gravity(){
        move(0,-GRAVITY);
        //If the player is touching some kind of object then the gravity effect does not take effect on the player
        //Else it does and moves the player downward
    }

    /*
     *    The acceleration, might add topspeed later
     */
    public void accleration(){
        multiplier++;
        //Somehow have to see how long a key is being held down for, or how often a key is being registered
    }

    public void jump(int yValue){
        move(0,yValue);
        doubleJump = true;
    }

}