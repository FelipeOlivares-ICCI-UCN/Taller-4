package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Card;

public class Menu {
	private List<Card> collection;
	
	public Menu(List<Card> collection) {
		this.collection = collection;
	}
	
	
	public void start() {
		JFrame main = new JFrame("Sistema");
		main.setSize(600, 700);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(false);
		
		JPanel managementPanel = createManagementPanel();
		
		JPanel sortingPanel = createSortingPanel();
				
		JPanel collectionPanel = createCardPanel();
		
		JScrollPane scrollPane = new JScrollPane(collectionPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(managementPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(sortingPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(scrollPane);

		main.add(mainPanel);
		main.setContentPane(mainPanel);
		
		main.setVisible(true);
	}
	
	private JPanel createSortingPanel() {
		JPanel sortingPanel = new JPanel();
		sortingPanel.setLayout(new BoxLayout(sortingPanel, BoxLayout.X_AXIS));
		sortingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton sortByName = new JButton("Sort by Name");
		JButton sortByPower = new JButton("Sort by Power");		
		JButton sortByRarity = new JButton("Sort by Rarity");
		
		JLabel sortingSectionTitle = new JLabel("Sort Collection");
		sortingSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		sortingSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		sortingPanel.add(sortingSectionTitle);
		sortingPanel.add(Box.createHorizontalGlue());
		sortingPanel.add(sortByName);
		sortingPanel.add(sortByPower);
		sortingPanel.add(sortByRarity);

		return sortingPanel;
	}


	private JPanel createManagementPanel() {
		JPanel managementPanel = new JPanel();
		managementPanel.setLayout(new BoxLayout(managementPanel, BoxLayout.X_AXIS));
		managementPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton addCard = new JButton("Add Card");
		JButton deleteCard = new JButton("Delete Card");
		JButton modifyCard = new JButton("Modify Card");
		
		JLabel managementSectionTitle = new JLabel("Manage Collection");
		managementSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		managementSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		managementPanel.add(managementSectionTitle);
		managementPanel.add(Box.createHorizontalGlue());
		managementPanel.add(addCard);
		managementPanel.add(deleteCard);
		managementPanel.add(modifyCard);	
		
		return managementPanel;
	}


	private File[] getCardImages() {
		File[] files = new File[collection.size()];
		
		int i = 0;
		for (Card c: collection) {
			files[i] = new File(c.getCardPath());
			i++;
		}
		
		return files;
		
	}
	
	private JPanel createCardPanel() {
		File[] files = getCardImages();
		
	    JPanel cardPanel = new JPanel(new GridLayout(0, 3, 10, 10));
		
		for (File file: files) {
	        ImageIcon icon = new ImageIcon(file.getAbsolutePath());

	        Image scaled = icon.getImage().getScaledInstance(
	                150, 200, Image.SCALE_SMOOTH);

	        JLabel label = new JLabel(new ImageIcon(scaled));
	        cardPanel.add(label);
	    }

	    return cardPanel;
	}
	
	private void refreshCollectionPanel(JPanel panel) {
		
	panel.removeAll();

    File[] files = getCardImages();

    panel.setLayout(new GridLayout(0, 3, 10, 10));

    for (File file : files) {
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());

        Image scaled = icon.getImage().getScaledInstance(
                150, 200, Image.SCALE_SMOOTH);

        JLabel label = new JLabel(new ImageIcon(scaled));
        panel.add(label);
    }

    panel.revalidate();
    panel.repaint();
}
}
