package domain;

public class ItemCard extends Card {
	private int bonus;

	public ItemCard(String cardName, int rarity, String type, int bonus) {
		super(cardName, rarity, "Item");
		this.bonus = bonus;
	}

	@Override
	public int getPower() {
		return bonus * 20;
	}
	
	

}
