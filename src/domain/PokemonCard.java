package domain;

import visitor.CardVisitor;

public class PokemonCard extends Card {
	private int damage, energy;
	
    /**
     * Creates a new Pokémon card.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param damage the damage dealt by the Pokémon
     * @param energy the energy required to use its attack
     */
	public PokemonCard(String cardName, int rarity, int damage, int energy) {
		super(cardName, rarity, "Pokemon");
		this.damage = damage;
		this.energy = energy;
	}
	

    /**
     * Calculates the power of this Pokémon card.
     * The power is determined by the ratio of damage to
     * energy cost, multiplied by 100.
     *
     * @return the calculated power value
     */

	@Override
	public int getPower() {
		return (damage / energy) * 100;
	}


	@Override
	public void accept(CardVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	

}
