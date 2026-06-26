package factory;

import domain.*;

import gui.*;

/**
 * Factory class responsible for creating the appropriate {@link EditorPanel}
 * based on the type of a {@link Card}.
 *
 * This class follows the Factory design pattern to decouple card types
 * from their corresponding GUI editor panels.
 *
 * @author Felipe Olivares
*/

public class EditorPanelFactory {

    /**
     * Returns an editor panel corresponding to the given card type.
     *
     * <p>The mapping between card types and editor panels is:</p>
     * <ul>
     *   <li>energy -> {@link EditorPanelEnergyCard}</li>
     *   <li>item -> {@link EditorPanelItemCard}</li>
     *   <li>pokemon -> {@link EditorPanelPokemonCard}</li>
     *   <li>supporter -> {@link EditorPanelSupporterCard}</li>
     * </ul>
     *
     * @param c the card used to determine the editor panel type
     * @return an {@link EditorPanel} matching the card type
     * @throws IllegalArgumentException if the card type is not recognized
     */
	public static EditorPanel getEditorPanel(Card c) 
	{
		String type = c.getType().toLowerCase();
		if (type.equals("energy")) return new EditorPanelEnergyCard();
		
		if (type.equals("item")) return new EditorPanelItemCard();
		
		if (type.equals("pokemon")) return new EditorPanelPokemonCard();
		
		if (type.equals("supporter")) return new EditorPanelSupporterCard();
		
		throw new IllegalArgumentException("Unknown card type: " + c.getType());	}
	
}
