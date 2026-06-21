package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import domain.Card;
import factory.CardFactory;
import gui.Menu;
import visitor.SaveVisitor;


public class AppSystemImpl implements AppSystem {
	public static AppSystemImpl s;
	private static ArrayList<Card> cardData;
	private CardFactory factory;
	
	private AppSystemImpl() {
		cardData = new ArrayList<>();
	}


	@Override
	public void loadData(String data) {
		Card c = factory.createFromLine(data);
		if (c != null) 
		{
			cardData.add(c);
		}
		
		
	}

	public static AppSystemImpl getInstance() {
		if (s == null) 
		{
			s = new AppSystemImpl();
		}
		return s;
		
	}


	@Override
	public void startMenu() {
		Menu menu = new Menu(cardData);
		menu.start();
		
	}


	@Override
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
