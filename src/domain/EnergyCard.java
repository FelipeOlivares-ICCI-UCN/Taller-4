package domain;

import visitor.CardVisitor;

public class EnergyCard extends Card {
	private String element;
	
    /**
     * Creates a new energy card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param elemtn the type of energy provided by the card
     */
	public EnergyCard(String cardName, int rarity, String element) {
		super(cardName, rarity, "Energy");
		this.element = element;

	}

	@Override
	public void accept(CardVisitor visitor) {
		visitor.visit(this);
		
	}
}
