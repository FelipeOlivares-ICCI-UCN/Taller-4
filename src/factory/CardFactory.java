package factory;

import domain.Card;
import domain.EnergyCard;
import domain.ItemCard;
import domain.PokemonCard;
import domain.SupporterCard;

/**
 * Factory class responsible for creating {@link Card} objects
 * from provided parameters or formatted text lines.
 */

public class CardFactory {
	/**
     * Creates a card of the specified type.
     *
     * @param cardName the name of the card
     * @param rarity the rarity level of the card
     * @param type the card type ("pokemon", "energy", "item", or "supporter")
     * @param data the type-specific data required to create the card
     * @return the created card, or {@code null} if the type is not recognized
     */
	
	public static Card createCard(String cardName, int rarity, String type, String data[]) {
		if (type.equals("energy")) return new EnergyCard(cardName, rarity, data[0]);
		
		if (type.equals("pokemon")) return new PokemonCard(cardName, rarity, Integer.parseInt(data [0]), Integer.parseInt(data [1]));
		
		if (type.equals("item")) return new ItemCard(cardName, rarity, Integer.parseInt(data [0]));
		
		if (type.equals("supporter")) return new SupporterCard(cardName, rarity, Integer.parseInt(data [0]));
		
		return null;
		
		
	}
	

	/**
	 * Creates a {@link Card} object from a semicolon-separated data line.
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
     * @return the created card, or {@code null} if the card type is not recognized
     * @throws NumberFormatException if a numeric field cannot be parsed
     * @throws ArrayIndexOutOfBoundsException if the input line is incomplete
     */
	public static Card createFromLine(String dataLine) 
	{
		String[] p = dataLine.split(";");
		
		String cardName = p[0];
		int rarity = Integer.parseInt(p[1]);
		String type = p[2].toLowerCase();
		
		String[] data = new String[2];
		
		if (p.length > 4) 
		{
			data[0] = p[3];
			data[1] = p[4];
		}
		
		else {
			data[0] = p[3];
		}
		
		return createCard(cardName, rarity, type, data);
		
		
	}
	


}
