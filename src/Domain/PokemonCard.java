package domain;

public class PokemonCard extends Card {
	private int damage, energy;

	public PokemonCard(String cardName, int rarity, int damage, int energy) {
		super(cardName, rarity, "Pokemon");
		this.damage = damage;
		this.energy = energy;
	}

	@Override
	public int getPower() {
		return (damage / energy) * 100;
	}
	
	
	

}
