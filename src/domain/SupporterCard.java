package domain;

public class SupporterCard extends Card {
	private int effectsByTurn;
	
    /**
     * Creates a new supporter card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param effectsByTurn the number of effects applied per turn
     */
	
	public SupporterCard(String cardName, int rarity, int effectsByTurn) {
		super(cardName, rarity, "Supporter");
		this.effectsByTurn = effectsByTurn;
	}
	
    /**
     * Calculates the power of this supporter card.
     *
     * @return the number of effects per turn multiplied by 50
     */
	
	@Override
	public int getPower() {
		return effectsByTurn * 50;
	}

}
