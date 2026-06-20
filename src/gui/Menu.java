package gui;

import java.util.List;

import javax.swing.JFrame;

import domain.Card;

public class Menu {
	private List<Card> collection;
	
	public Menu(List<Card> collection) {
		this.collection = collection;
	}
	
	
	public void start() {
		JFrame main = new JFrame("Sistema");
		
		main.setSize(600, 800);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main.setVisible(true);
	}

}
