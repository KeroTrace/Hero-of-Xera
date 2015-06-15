/* Name:        "Hero of Xera - Character"
 * Author:      Tim Nguyen
 * Version:     0.1 (June 15, 2015)
 * Description: This class is used to describe different features of a character, either
 *              the player, NPC, or a monster.
 */

public class Character {
  private int level;
  private String race;
  private int[] stats = {0, 0, 0, 0}; // Constitution, Dexterity, Intelligence, Strength
  private int[] health = {0, 0}; // Current, Max
  private int relationship;
  
  /**
   * Base constructor to create a new character with base stats.
   */
  public Character() {
	level = 1;
	race = "Default";
	
	for (int i = 0; i < stats.length; i++) {
      stats[i] = 5;
	}
	
	calculateHealth();
  }
  
  /**
   * Base constructor to create a new character with given stats.
   * @param con - The character's Constitution.
   * @param dex - The character's Dexterity.
   * @param intel - The character's Intelligence.
   * @param str - The character's Strength.
   */
  public Character(int con,int dex, int intel, int str) {
	level = 1;
	race = "Default";
	stats[0] = con;
	stats[1] = dex;
	stats[2] = intel;
	stats[3] = str;
	
	calculateHealth();
  }
  
  /**
   * Set-Method to set the character's level.
   * @param level - The character's Level.
   */
  public void setLevel(int level) {
	this.level = level;
  }
  
  /**
   * Set-Method to set the character's race.
   * @param race - The character's race.
   */
  public void setRace(String race) {
	this.race = race;
  }
  
  /**
   * Set-Method to set the character's stats.
   * @param con - The character's Constitution.
   * @param dex - The character's Dexterity.
   * @param intel - The character's Intelligence.
   * @param str - The character's Strength.
   */
  public void setStats(int con, int dex, int intel, int str) {
	stats[0] = con;
	stats[1] = dex;
	stats[2] = intel;
	stats[3] = str;
	
	for (int i = 0; i < stats.length; i++) {
	  if (stats[i] > 100) stats[i] = 100;
	}
	
	calculateHealth();
  }
  
  /**
   * Set-Method to set the character's health.
   * @param cur - The character's current health.
   * @param max - The character's maximum health.
   */
  public void setHealth(int cur, int max) {
	if (max > 1000) health[1] = 1000;
	else health[1] = max;
	
	if (cur > max) health[0] = max;
	else health[0] = cur;
  }
  
  /**
   * Set-Method to set the character's relationship level to the player.
   * @param relationship - The character's relationship level.
   */
  public void setRelationship(int relationship) {
	this.relationship = relationship;
	
	if (this.relationship < -100) this.relationship = -100;
	else if (this.relationship > 100) this.relationship = 100;
  }
  
  /**
   * Get-Method to return the character's level.
   * @return - The character's level.
   */
  public int getLevel() {
	return level;
  }
  
  /**
   * Get-Method to return the character's race.
   * @return - The character's race.
   */
  public String getRace() {
	return race;
  }
  
  /**
   * Get-Method to return all of the character's stats.
   * @return - All of the character's stats.
   */
  public int[] getStats() {
	return stats;
  }
  
  /**
   * Get-Method to return the character's constitution.
   * @return - The character's constitution.
   */
  public int getConstitution() {
	return stats[0];
  }
  
  /**
   * Get-Method to return the character's dexterity.
   * @return - The character's dexterity.
   */
  public int getDexterity() {
	return stats[1];
  }
  
  /**
   * Get-Method to return the character's intelligence.
   * @return - The character's intelligence.
   */
  public int getIntelligence() {
	return stats[2];
  }
  
  /**
   * Get-Method to return the character's strength.
   * @return - The character's strength.
   */
  public int getStrength() {
	return stats[3];
  }
  
  /**
   * Get-Method to return both characteristics of the character's health.
   * @return - The character's health.
   */
  public int[] getHealth() {
	return health;
  }
  
  /**
   * Get-Method to return the character's current health.
   * @return - The character's current health.
   */
  public int getCurrentHealth() {
	return health[0];
  }
  
  /**
   * Get-Method to return the character's maximum health.
   * @return - The character's maximum health.
   */
  public int getMaximumHealth() {
	return health[1];
  }
  
  /**
   * Get-Method to return the character's relationship level to the player.
   * @return
   */
  public int getRelationship() {
	return relationship;
  }
  
  /**
   * Method used to display the relevant stats of the character.
   */
  public void displayStats() {
	System.out.println("===================");
	System.out.println("  Character Stats  ");
	System.out.println("===================");
	System.out.println("Level:        " + spaceBuffer(level));
	System.out.println("Health:       " + spaceBuffer(health[0]) + " / " + spaceBuffer(health[1]));
	System.out.println("===================");
	System.out.println("Constitution: " + spaceBuffer(stats[0]));
	System.out.println("Dexterity:    " + spaceBuffer(stats[1]));
	System.out.println("Intelligence: " + spaceBuffer(stats[2]));
	System.out.println("Strength:     " + spaceBuffer(stats[3]));
	System.out.println("===================");
  }
  
  /**
   * Method used to add additional spaces before a value.
   * @param value - The value to be compared.
   * @return - A number of spaces based on the size of the value.
   */
  public String spaceBuffer(int value) {
	String space = "";
	
	if (value < 10) space = "   ";
	else if (value < 100) space = "  ";
	else if (value < 1000) space = " ";
	
	return space;
  }
  
  /**
   * Method used to calculate the character's health values.
   */
  public void calculateHealth() {
	health[1] = 50 + (stats[0] * 5);
	
	if (health[1] > 1000) health[1] = 1000;
	
	health[0] = health[1];
  }
  
  /**
   * Method used to adjust the character's relationship level to the player.
   * @param change - The change in the character's relationship.
   */
  public void adjustRelationship(int change) {
	relationship += change;
	
	if (relationship < -100) relationship = -100;
	else if (relationship > 100) relationship = 100;
  }
}