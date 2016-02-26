/**
 *Class that all HeroAbilities extend
 *
 *@author Lauren Hibbs
 *@version File Name: HeroAbility.java
 *@version Date: 12/16/15
 *@version Program: GameProject
 *@version description : defines methods and variables that all HeroAbility classes must have.
 *	Each subclass will define its own cooldown time. Declared abstract so that no instances of
 *	this class can be made. 
 */
public abstract class HeroAbility implements Ability
{
	
	//The number after using the ability that it can be used again.
	private int totalCooldownTime;
	//the time since the ability was last activated
	private int runningCooldownTime;
	
	public HeroAbility(int cooldown)
	{	
		//subclasses will each define (static final var) the cooldown time which is passed to superclass.
		totalCooldownTime = cooldown;
		runningCooldownTime =0;
	}
	
	/*Checks if runningCooldown>TotalCooldown
	 * 
	 */
	 
	public boolean CanBeActivated()
	{
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