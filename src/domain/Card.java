package domain;

import visitor.CardVisitor;

/**Provides the base for all Card objects
 * 
 * @author Felipe Olivares
 * @since 0.1
 */

public abstract class Card {
	private String cardName;
	private int rarity;
	private String type;
	
	private static String cardImagePath;
	
	public Card(String cardName, int rarity, String type) {
		this.cardName = cardName;
		this.rarity = rarity;
		this.type = type;
		
		cardImagePath =  "./data/images/{defaultImage}.png";
	
	}
	
	public abstract void accept(CardVisitor visitor);
	

	public String getCardName() {
		return cardName;
	}



	public int getRarity() {
		return rarity;
	}

	public String getType() {
		return type;
	}
	
    /**
     * Sets the image path used to display this card.
     *
     * @param filePath the path to the card image
     */
	
	public void setCardImagePath(String filePath) 
	{
		this.cardImagePath = filePath;
	}
	
	

    /**
     * Calculates the power of this card.
     * Subclasses may override this method to provide
     * their own power calculation.
     *
     * @return the power value of the card; returns 1 by default
     */
	
	public int getPower() 
	{
		return 1;
	}


	@Override
	public String toString() {
		return "Card " + cardName + ", Rarity: " + rarity + ", Type " + type;
	}
	
	

}
