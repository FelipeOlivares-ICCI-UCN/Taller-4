package domain;

import visitor.CardVisitor;

/**
 * Represents a supporter card.
 * A supporter card provides one or more effects that can be used each turn.
 *
 * @author Felipe Olivares
 */

public class SupporterCard extends Card {
	private int effectsByTurn;
	
    /**
     * Creates a new supporter card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param effectsByTurn the number of effects applied per turn
     */
	
	/**
     * Calculates the power of this supporter card.
     *
     * @return the number of effects per turn multiplied by {@code 50}
     */
	public SupporterCard(String cardName, int rarity, int effectsByTurn) {
		super(cardName, rarity, "Supporter");
		this.effectsByTurn = effectsByTurn;
	}
	
    /**
     * Calculates the power of this supporter card.
     *
     * @return the number of effects per turn multiplied by {@code 50}
     */
	
	@Override
	public int getPower() {
		return effectsByTurn * 50;
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
     * Returns the number of effects this card applies per turn.
     *
     * @return the number of effects per turn
     */
	public int getEffectsByTurn() {
		return this.effectsByTurn;
	}
	
    /**
     * Sets the number of effects this card applies per turn.
     *
     * @param effectsByTurn the new number of effects per turn
     */
	public void setEffectsByTurn(int effectsByTurn) 
	{
		this.effectsByTurn = effectsByTurn;
	}
}
