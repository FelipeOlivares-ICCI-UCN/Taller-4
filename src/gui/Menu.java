package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		main.setResizable(false);
		
		JButton addCard = new JButton("Add Card");
		JButton deleteCard = new JButton("Delete Card");
		JButton modifyCard = new JButton("Modify Card");
		
		JLabel managementSectionTitle = new JLabel("Manage Collection");
		managementSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		managementSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		JPanel managementPanel = new JPanel();
		managementPanel.setLayout(new BoxLayout(managementPanel, BoxLayout.X_AXIS));
		managementPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		managementPanel.add(managementSectionTitle);
		managementPanel.add(Box.createHorizontalGlue());
		managementPanel.add(addCard);
		managementPanel.add(deleteCard);
		managementPanel.add(modifyCard);
				
		JButton sortByName = new JButton("Sort by Name");
		JButton sortByPower = new JButton("Sort by Power");		
		JButton sortByRarity = new JButton("Sort by Rarity");
		
		JLabel sortingSectionTitle = new JLabel("Sort Collection");
		sortingSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		sortingSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JPanel sortingPanel = new JPanel();
		sortingPanel.setLayout(new BoxLayout(sortingPanel, BoxLayout.X_AXIS));
		sortingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		sortingPanel.add(sortingSectionTitle);
		sortingPanel.add(Box.createHorizontalGlue());
		sortingPanel.add(sortByName);
		sortingPanel.add(sortByPower);
		sortingPanel.add(sortByRarity);
		
		JPanel collectionPanel = new JPanel();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(managementPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(sortingPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(collectionPanel);

		main.add(mainPanel);
		
		main.setVisible(true);
	}

}
