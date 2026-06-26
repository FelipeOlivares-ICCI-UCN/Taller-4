package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import domain.Card;
import factory.CardFactory;
import gui.Menu;
import visitor.SaveVisitor;

/**
 * Singleton implementation of the application system.
 */

public class AppSystemImpl implements AppSystem {
	/**
     * Singleton instance of the system.
     */
	public static AppSystemImpl s;
	/**
     * In-memory storage of all loaded cards.
     */
	private static ArrayList<Card> cardData;
    /**
     * Factory used to create Card objects from raw data.
     */
	private CardFactory factory;
	


    /**
     * Private constructor to enforce Singleton pattern.
     * Initializes the internal card storage.
     */
	private AppSystemImpl() {
		cardData = new ArrayList<>();
	}

    /**
     * Loads a card from a raw data string and stores it in memory.
     *
     * @param data semicolon-separated representation of a card
     */
	@Override
	public void loadData(String data) {
		Card c = factory.createFromLine(data);
		if (c != null) 
		{
			cardData.add(c);
		}
		
		
	}

	/**
     * Returns the singleton instance of the application system.
     *
     * @return the single AppSystemImpl instance
     */
	public static AppSystemImpl getInstance() {
		if (s == null) 
		{
			s = new AppSystemImpl();
		}
		return s;
		
	}

    /**
     * Starts the main application menu using the current card data.
     */
	@Override
	public void startMenu() {
		Menu menu = new Menu(cardData);
		menu.start();
		
	}
	
	/**
     * Saves all loaded cards to a file using the {@link SaveVisitor} pattern.
     *
     * <p>If there are no cards loaded, the method returns immediately.</p>
     * <p>Cards are written to: {@code ./data/Sobres.txt}</p>
     */
	public void saveData() {
		if (cardData.isEmpty()) {
			return;
		}
		
		
		try (BufferedWriter w = new BufferedWriter(new FileWriter("./data/Sobres.txt")))
		{
			SaveVisitor v = new SaveVisitor(w);
			
			for (Card c : cardData) c.accept(v);
		}
		catch(IOException e) {
			System.out.println("Failed saving data");
			return;
		};
		
		
	}
	
	


	
	

}
