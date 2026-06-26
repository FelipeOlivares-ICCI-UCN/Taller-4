package domain;

import visitor.CardVisitor;

/**
 * Represents an item card.
 * An item card provides a bonus value that determines its power.
 *
 * @author Felipe Olivares
 */

public class ItemCard extends Card {
	private int bonus;
	
    /**
     * Creates a new item card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param bonus the bonus value provided by the item
     */

	public ItemCard(String cardName, int rarity, int bonus) {
		super(cardName, rarity, "Item");
		this.bonus = bonus;
	}

	
    /**
     * Calculates the power of this item card.
     *
     * @return the bonus multiplied by {@code 20}
     */
	@Override
	public int getPower() {
		return bonus * 20;
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
     * Returns the bonus value of this item.
     *
     * @return the item's bonus value
     */
	public int getBonus() {
		return bonus;
	}
	


    /**
     * Sets the bonus value of this item.
     *
     * @param bonus the new bonus value
     */
	public void setBonus(int bonus) 
	{
		this.bonus = bonus;
	}
	

}
