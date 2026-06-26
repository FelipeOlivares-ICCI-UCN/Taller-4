package strategy;

import java.util.List;

import domain.Card;
/**
 * Strategy interface for sorting a collection of {@link Card} objects.
 *
 * <p>Different implementations define different sorting behaviors
 * (e.g., by name, power, or rarity).</p>
 */

public interface SortingStrategy {
	/**
     * Sorts the given list of cards according to a specific strategy.
     *
     * @param c the list of cards to be sorted (may be modified in-place)
     */
	void sortCollection(List<Card> c);

}
