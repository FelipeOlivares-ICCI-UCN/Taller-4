package domain;

/**Provides the base for all Card objects
 * 
 * @author Felipe Olivares
 * @since 0.1
 */

public abstract class Card {
	private String cardName;
	private int rarity;
	private String type;
	
	public Card(String cardName, int rarity, String type) {
		this.cardName = cardName;
		this.rarity = rarity;
		this.type = type;
	}
	

	public String getCardName() {
		return cardName;
	}



	public int getRarity() {
		return rarity;
	}

	public String getType() {
		return type;
	}


	/**Calculate the power of each Card class implementation as a integer.
	 * If not implemented, return 1 (default)
	 * 
	 * @return The total power of the class.
	 */
	
	public int getPower() 
	{
		return 1;
	}

}
