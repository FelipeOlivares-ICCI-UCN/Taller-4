package visitor;

import domain.EnergyCard;
import domain.ItemCard;
import domain.PokemonCard;
import domain.SupporterCard;

public interface CardVisitor {
	void visit(PokemonCard card);
	void visit(SupporterCard card);
	void visit(EnergyCard card);
	void visit(ItemCard card);
	
}
