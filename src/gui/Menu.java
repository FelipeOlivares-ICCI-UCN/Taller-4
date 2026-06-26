package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Card;
import factory.EditorPanelFactory;
import logic.AppSystemImpl;
import strategy.*;
import visitor.SaveVisitor;

/**
 * Main GUI menu for managing a card collection.
 * Handles displaying, sorting, adding, and editing cards.
 */
public class Menu {
	private List<Card> collection;
	private JPanel collectionPanel;
	private JFrame main;
	private JPanel mainPanel;
	private JScrollPane scrollPane;
	
    /**
     * Creates a menu tied to a given card collection.
     *
     * @param collection list of cards to display and manage
     */
	public Menu(List<Card> collection) {
		this.collection = collection;
	}
	
	/**
     * Starts and displays the main application window.
     */
	public void start() {
		main = new JFrame("COLLECTION");
		main.setSize(600, 700);
		main.setResizable(false);
		
		main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		main.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
		AppSystemImpl.getInstance().saveData();
		main.dispose();
		}
		});

		collectionPanel = buildCollectionPanel();
		
		JPanel managementPanel = buildManagementPanel();
		
		JPanel sortingPanel = buildSortingPanel();
				
		
		scrollPane = new JScrollPane(collectionPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		mainPanel.add(managementPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(sortingPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(scrollPane);

		main.add(mainPanel);
		main.setContentPane(mainPanel);
		
		main.setVisible(true);
		return;
	}
	
	private JPanel buildSortingPanel() {
		JPanel sortingPanel = new JPanel();
		sortingPanel.setLayout(new BoxLayout(sortingPanel, BoxLayout.X_AXIS));
		sortingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton sortByName = new JButton("Sort by Name");
		JButton sortByPower = new JButton("Sort by Power");		
		JButton sortByRarity = new JButton("Sort by Rarity");
		
		JLabel sortingSectionTitle = new JLabel("Sort Collection");
		sortingSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		sortingSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		sortByName.addActionListener(e ->{
			sortByName();
		});
		
		sortByPower.addActionListener(e->{
			sortByPower();
		});
		
		sortByRarity.addActionListener(e->{
			sortByRarity();
		});
		
		sortingPanel.add(sortingSectionTitle);
		sortingPanel.add(Box.createHorizontalGlue());
		sortingPanel.add(sortByName);
		sortingPanel.add(sortByPower);
		sortingPanel.add(sortByRarity);

		return sortingPanel;
	}


	private JPanel buildManagementPanel() {
		JPanel managementPanel = new JPanel();
		managementPanel.setLayout(new BoxLayout(managementPanel, BoxLayout.X_AXIS));
		managementPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton addCard = new JButton("Add Card");
		
		JLabel managementSectionTitle = new JLabel("Manage Collection");
		managementSectionTitle.setFont(new Font("Arial", Font.BOLD, 24));
		managementSectionTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
				
		managementPanel.add(managementSectionTitle);
		managementPanel.add(Box.createHorizontalGlue());
		managementPanel.add(addCard);
		
		addCard.addActionListener(e->{
			DropdownCardSelection selector = new DropdownCardSelection();
			
			
			Card newCard = selector.createCardMenu(main);
			
			if (newCard != null) 
			{
				EditorPanel editor = EditorPanelFactory.getEditorPanel(newCard);
				
				boolean wasSaved = editor.buildEditorMenu(main, newCard);
				
				if (wasSaved) {
				collection.add(newCard);
				refresh();
				}
			}
			
		});
		
		
		return managementPanel;
	}


	private JPanel buildCollectionPanel() {
		
	    JPanel cardPanel = new JPanel(new GridLayout(0, 3, 10, 10));
		
	    for (Card card : collection) {
	        File file = new File(card.getCardPath());

	        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
	        Image scaled = icon.getImage().getScaledInstance(
	                150, 200, Image.SCALE_SMOOTH);

	        JLabel label = new JLabel(new ImageIcon(scaled));
	        
	        EditorPanel editor = EditorPanelFactory.getEditorPanel(card);
	        
	        label.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	if (editor == null) return;
	               boolean wasSaved = editor.buildEditorMenu(main, card);
	               
	               if (wasSaved) {
	            	    refresh();
	            	}
	               
	            }
	        });

	        cardPanel.add(label);
	    }

	    return cardPanel;
	}

	
	private void sortByName() {
		
		SortingStrategy strategy = new SortByNameStrategy();
		strategy.sortCollection(collection);
		refresh();
	}
	
	private void sortByPower() {
		
		SortingStrategy strategy = new SortByPowerStrategy();
		strategy.sortCollection(collection);
		refresh();
	}
	
	private void sortByRarity() {
		SortingStrategy strategy = new SortByRarityStrategy();
		strategy.sortCollection(collection);
		refresh();
	}
	
	private void refresh() {
		
		JPanel newCollectionPanel = buildCollectionPanel();

	    scrollPane.setViewportView(newCollectionPanel);

	    collectionPanel = newCollectionPanel;

	    main.revalidate();
	    main.repaint();
		}
	
}


