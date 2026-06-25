package domain;

import visitor.CardVisitor;

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
     * @return the bonus multiplied by 20
     */
	@Override
	public int getPower() {
		return bonus * 20;
	}


	@Override
	public void accept(CardVisitor visitor) {
		visitor.visit(this);
	}
	
	public int getBonus() {
		return this.bonus;
	}
	
	public void setBonus(int bonus) 
	{
		this.bonus = bonus;
	}
	

}
