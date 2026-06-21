package visitor;

import domain.Card;
import domain.EnergyCard;
import domain.ItemCard;
import domain.PokemonCard;
import domain.SupporterCard;
import java.io.BufferedWriter ;
import java.io.IOException;

public class SaveVisitor implements CardVisitor {
	
	BufferedWriter writer;
	
	public SaveVisitor(BufferedWriter writer) {
		this.writer = writer;
	}

	@Override
	public void visit(PokemonCard card) {
		String data = getBasicData(card) + card.getDamage() + ";" + card.getEnergy();
		
		writeData(data);
		
	}

	@Override
	public void visit(SupporterCard card) {
		String data = getBasicData(card) + card.getEffectsByTurn();
		
		writeData(data);
	}
	
	
	

	@Override
	public void visit(EnergyCard card) {
		String data = getBasicData(card) + card.getElement();
		
		writeData(data);
		
	}

	@Override
	public void visit(ItemCard card) {
		String data = getBasicData(card) + card.getBonus();
		
		writeData(data);
		
	}
	
	public void writeData(String data) {
		try {
			writer.write(data);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBasicData(Card card) {
		return card.getCardName() + ";" + card.getRarity() + ";"
				+ card.getType() + ";";
	}

}
