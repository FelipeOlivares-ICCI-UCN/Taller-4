package visitor;

import domain.Card;
import domain.EnergyCard;
import domain.ItemCard;
import domain.PokemonCard;
import domain.SupporterCard;
import java.io.BufferedWriter ;
import java.io.IOException;
/**
 * Visitor implementation responsible for saving Card objects
 * to a text file in a semicolon-separated format.
 *
 * <p>This class is part of the Visitor design pattern and converts
 * each concrete card type into a persistable string representation.</p>
 */
public class SaveVisitor implements CardVisitor {
    /**
     * Writer used to output card data to file.
     */
	BufferedWriter writer;
    /**
     * Indicates whether the current line is the first written line.
     * Used to control newline formatting.
     */
	boolean isFirstLine = true;
	
    /**
     * Creates a new SaveVisitor using the given writer.
     *
     * @param writer the BufferedWriter used to persist card data
     */
	public SaveVisitor(BufferedWriter writer) {
		this.writer = writer;
	}



    /**
     * Saves a {@link PokemonCard}. into a semicolon-separated string format.
     *
     * @param card the pokemon card to save
     */
	@Override
	public void visit(PokemonCard card) {
		String data = getBasicData(card) + card.getDamage() + ";" + card.getEnergy();
		
		writeData(data);
		
	}

    /**
     * Saves a {@link SupporterCard}. into a semicolon-separated string format.
     *
     * @param card the supporter card to save
     */
	@Override
	public void visit(SupporterCard card) {
		String data = getBasicData(card) + card.getEffectsByTurn();
		
		writeData(data);
	}
	
	
	/**
     * Saves a {@link EnergyCard}. into a semicolon-separated string format.
     *
     * @param card the energy card to save
     */

	@Override
	public void visit(EnergyCard card) {
		String data = getBasicData(card) + card.getElement();
		
		writeData(data);
		
	}

	/**
     * Saves a {@link ItemCard}. into a semicolon-separated string format.
     *
     * @param card the supporter card to save
     */
	@Override
	public void visit(ItemCard card) {
		String data = getBasicData(card) + card.getBonus();
		
		writeData(data);
		
	}
	
	
	private void writeData(String data) {
		try {
			if (!isFirstLine) {
				writer.newLine();
			}
			else {
				isFirstLine = false;
			}
			
			writer.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getBasicData(Card card) {
		return card.getCardName() + ";" + card.getRarity() + ";"
				+ card.getType() + ";";
	}

}
