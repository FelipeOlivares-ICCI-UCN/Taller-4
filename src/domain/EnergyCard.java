package domain;

import visitor.CardVisitor;

/**
 * Represents an energy card.
 * An energy card provides their energy type.
 *
 * @author Felipe Olivares
 */

public class EnergyCard extends Card {
	private String element;
	
    /**
     * Creates a new energy card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param element the type of energy provided by the card
     */
	public EnergyCard(String cardName, int rarity, String element) {
		super(cardName, rarity, "Energy");
		this.element = element;

	}

    /**
     * Accepts a visitor that performs an operation on this card.
     *
     * @param visitor the visitor to accept
     */
	@Override
	public void accept(CardVisitor visitor) {
		visitor.visit(this);
		
	}
	
    /**
     * Accepts a visitor that performs an operation on this card.
     *
     * @param visitor the visitor to accept
     */
	public String getElement() {
		return element;	}
	
    /**
     * Sets the energy element of this card.
     *
     * @param element the new energy element
     */
	public void setElement(String element) 
	{
		this.element = element;
	}
	
	
	
}
