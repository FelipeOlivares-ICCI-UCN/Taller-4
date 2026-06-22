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
		
	public Card(String cardName, int rarity, String type) {
		this.cardName = cardName;
		this.rarity = rarity;
		this.type = type;	
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
	
	
	public String getCardPath() {
		String imagePath = "./data/" + this.cardName + ".jpeg";
		
	    return new java.io.File(imagePath).exists()
	            ? imagePath
	            : "./data/defaultImage.jpeg";
	}
	
	

}
