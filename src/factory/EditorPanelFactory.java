package factory;

import domain.*;
import gui.*;

public class EditorPanelFactory {
	
	public static EditorPanel getEditorPanel(Card c) 
	{
		if (c.getType().toLowerCase().equals("energy")) return new EditorPanelEnergyCard();
		
		if (c.getType().toLowerCase().equals("item")) return new EditorPanelItemCard();
		
		if (c.getType().toLowerCase().equals("pokemon")) return new EditorPanelPokemonCard();
		
		if (c.getType().toLowerCase().equals("supporter")) return new EditorPanelSupporterCard();
		
		return null;
	}
	
}
