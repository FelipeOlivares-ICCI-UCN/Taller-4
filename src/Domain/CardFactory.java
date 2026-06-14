package domain;

/**
 * Factory class responsible for creating Card objects
 * from provided parameters or formatted text lines.
 */

public class CardFactory {
    /**
     * Creates a card of the specified type.
     *
     * @param cardName the name of the card
     * @param rarity the rarity value of the card
     * @param type the card type ("Pokemon", "Energy", "Item", or "Supporter")
     * @param data type-specific card data
     * @return the created Card object
     */
	
	public static Card createCard(String cardName, int rarity, String type, int data[]) {
		if (type.equals("energy")) return new EnergyCard(cardName, rarity, data[0]);
		
		if (type.equals("pokemon")) return new PokemonCard(cardName, rarity, data[0], data[1]);
		
		if (type.equals("item")) return new ItemCard(cardName, rarity, data[0]);
		
		if (type.equals("supporter")) return new SupporterCard(cardName, rarity, data[0]);
		
		return null;
		
		
	}
	

	/**
	 * Creates a Card object from a semicolon-separated data line.
	 *
	 * The data line must follow the format:
	 *
	 * <pre>
	 * Name;Rarity;Type;Data1[;Data2]
	 * </pre>
	 *
	 * where the third field specifies the card type:
	 * <ul>
	 *   <li>pokemon → Name;Rarity;pokemon;Damage;Energy</li>
	 *   <li>energy → Name;Rarity;energy;EnergyValue</li>
	 *   <li>item → Name;Rarity;item;Bonus</li>
	 *   <li>supporter → Name;Rarity;supporter;EffectValue</li>
	 * </ul>
	 *
	 * @param dataLine the semicolon-separated card data
	 * @return the Card object created from the supplied data
	 */
	public static Card createFromLine(String dataLine) 
	{
		String[] p = dataLine.split(";");
		
		String cardName = p[0];
		int rarity = Integer.parseInt(p[1]);
		String type = p[2].toLowerCase();
		
		int data[] = new int[2];
		
		if (p.length > 4) 
		{
			data[0] = Integer.parseInt(p[3]);
			data[1] = Integer.parseInt(p[4]);
		}
		
		else {
			data[0] = Integer.parseInt(p[3]);
		}
		
		return createCard(cardName, rarity, type, data);
		
		
	}
	


}
