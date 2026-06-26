package visitor;

import domain.EnergyCard;
import domain.ItemCard;
import domain.PokemonCard;
import domain.SupporterCard;
/**
 * Visitor interface for performing operations on different types of {@link domain.Card}.
 *
 * <p>This interface is part of the Visitor design pattern, allowing new operations
 * to be added without modifying card classes.</p>
 */

public interface CardVisitor {
	/**
     * Performs an operation on a {@link PokemonCard}.
     *
     * @param card the pokemon card being visited
     */
	void visit(PokemonCard card);
	/**
     * Performs an operation on a {@link SupporterCard}.
     *
     * @param card the supporter card being visited
     */
	void visit(SupporterCard card);
	/**
     * Performs an operation on a {@link EnergyCard}.
     *
     * @param card the energy card being visited
     */
	void visit(EnergyCard card);
	/**
     * Performs an operation on a {@link ItemCard}.
     *
     * @param card the item card being visited
     */
	void visit(ItemCard card);
	
}
