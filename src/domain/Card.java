package domain;

import java.io.File;

import visitor.CardVisitor;

/**Provides the base for all Card objects.
 * 
 * @author Felipe Olivares
 */

public abstract class Card {
	private String cardName;
	private int rarity;
	private final String type;

    /**
     * Creates a new card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param type the type/category of the card
     */
	
    public Card(String cardName, int rarity, String type) {
		this.cardName = cardName;
		this.rarity = rarity;
		this.type = type;	
	}
	
    /**
     * Accepts a visitor that performs an operation on this card.
     *
     * @param visitor the visitor to accept
     */
	public abstract void accept(CardVisitor visitor);
	

	/**
     * Returns the card's name.
     *
     * @return the name of the card
     */
	public String getCardName() {
		return cardName;
	}

	
	/**
     * Returns the rarity of the card.
     *
     * @return the card rarity
     */
	public int getRarity() {
		return rarity;
	}

    /**
     * Returns the type of the card.
     *
     * @return the card type
     */
	
	public String getType() {
		return type;
	}
	
	

    /**
     * Calculates the power of this card.
     * Subclasses may override this method to provide
     * their own power calculation.
     *
     * @return the power value of the card; returns {@code 1} by default
     */
	
	public int getPower() 
	{
		return 1;
	}


	/**
     * Returns a string representation of the card.
     *
     * @return a string containing the card's information
     */
	@Override
	public String toString() {
		return "Card " + cardName + ", Rarity: " + rarity + ", Type " + type;
	}
	
	/**
     * Returns the path to the image associated with this card.
     * If no image exists for the card, the default image path is returned.
     *
     * @return the path to the card image or the default image
     */
	public String getCardPath() {

	    String imagePath = "./data/" + cardName + ".jpeg";

	    File file = new File(imagePath);

	    if (file.exists()) {
	        return imagePath;
	    }

	    return "./data/defaultImage.jpeg";
	}

	/**
     * Sets the card's name.
     *
     * @param cardName the new card name
     */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}



    /**
     * Sets the card's rarity.
     *
     * @param rarity the new rarity value
     */
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

}
