/**
 *Ability interface that the GodAbility and HeroAbility extend
 *
 *@author Lauren Hibbs
 *@version File Name: Ability.java
 *@version Date: 11/20/15
 *@version Program: GameProject
 *@version description : defines methods for the GodAbility and HeroAbility 
 */
public interface Ability
{	
	boolean CanBeActivated();
	
	//resets ability cooldown times
	void hasBeenUsed();

	int totalCooldownTime();
	
	int runningCooldownTime();
	
}