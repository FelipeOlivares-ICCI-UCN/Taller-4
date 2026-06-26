package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import domain.*;

/**
 * Utility class responsible for letting the user select
 * the type of card to create.
 */
public class DropdownCardSelection {
	public Card createCardMenu(JFrame main) {
	
	
	String[] choices = {"Pokemon", "Supporter", "Energy", "Item"};
	
	String selected = (String) JOptionPane.showInputDialog(
			main,
			"Select the type of your new card",
			"Card Type",
			JOptionPane.QUESTION_MESSAGE,
			null,
			choices,
			choices[0]
		);
	if (selected.equals("Pokemon")) return new PokemonCard("", 0, 0, 0);  
	
	if (selected.equals("Supporter")) return new SupporterCard("", 0, 0);
	
	if (selected.equals("Energy")) return new EnergyCard("", 0, "");
	
	if (selected.equals("Item")) return new ItemCard("", 0, 0);
	
	return null;
	
	}
}
