package domain;

import visitor.CardVisitor;

/**
 * Represents a Pokémon card.
 * A Pokémon card has a damage value and an energy cost that determine its power.
 *
 * @author Felipe Olivares
 */

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
     * energy cost, multiplied by {@code 100}.
     *
     * @return the calculated power value
     */

	@Override
	public int getPower() {
		if (energy == 0) return 0;
		
		return damage * 100 / energy;
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
     * Returns the damage dealt by this Pokémon.
     *
     * @return the damage value
     */
	public int getDamage() {
		return damage;
	}
	
	/**
     * Returns the energy required to use this Pokémon's attack.
     *
     * @return the energy cost
     */
	public int getEnergy() {
		return energy;
	}
	
	/**
     * Sets the energy required to use this Pokémon's attack.
     *
     * @param energy the new energy cost
     */
	public void setEnergy(int energy) 
	{
		this.energy = energy;
	}
	
	/**
     * Sets the damage dealt by this Pokémon.
     *
     * @param damage the new damage value
     */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	

}
