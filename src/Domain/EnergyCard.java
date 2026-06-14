package domain;

public class EnergyCard extends Card {
	private int numElements;
	
    /**
     * Creates a new energy card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param numElements the number of energy elements provided by this card
     */
	public EnergyCard(String cardName, int rarity, int numElements) {
		super(cardName, rarity, "Energy");
		this.numElements = numElements;

	}
}
