/**
 *Class that listens to mouse,keyboard, and buttons and tells the 
 *	controller what is going on with the user
 *
 *@author Lauren Hibbs
 *@version File Name: GodAbility.java
 *@version Date: 12/16/15
 *@version Program: GameProject
 *@version description : Defines and implements methods for subclasses of GodAbility.
 *	Subclasses will each define (static final var) the cooldown time which is passed to superclass.
 *	Declared abstract so that no instances of this class can be made. 
 */
public abstract class GodAbility implements Ability
{
	private boolean isShrineAbility;
	private boolean isShrinePresent;
	//The number after using the ability that it can be used again.
	private int totalCooldownTime;
	//the time since the ability was last activated
	private int runningCooldownTime; // cooldown is measured in seconds
	
	
	public GodAbility(boolean isShrine, int cooldown)
	{	
		isShrineAbility = isShrine;
		if(isShrineAbility)
			isShrinePresent = false;
		else
			isShrinePresent = true;
		// subclasses will define cooldown time
		totalCooldownTime = cooldown; 
		runningCooldownTime=0;
				
	}
	
	/*
	 * If the ability is a shrine ability, return both
	 * 	isShrine present and if runningCooldownTime >= totalCooldownTime. If the ability is 
	 *	not a shrine ability, return only (runningCooldownTime >= totalCooldownTime)
	 *
	 */
	public boolean CanBeActivated()
	{	
		if(isShrineAbility)
			return (isShrinePresent && runningCooldownTime>=totalCooldownTime);
		else//not a shrine ability
			return runningCooldownTime>=totalCooldownTime;
			
	}
	
	/*
	 * Called after the ability has been used. Resets running cooldownTime to zero.
	 *
	 */
	public void hasBeenUsed()
	{
		runningCooldownTime = 0; 
	}
	
	public int totalCooldownTime()
	{
		return totalCooldownTime; 
	}
	
	public int runningCooldownTime()
	{
		return runningCooldownTime; 
	}
	
	
}