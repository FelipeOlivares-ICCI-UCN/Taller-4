package logic;

import java.util.ArrayList;
import domain.Card;
import domain.CardFactory;

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
	

}
