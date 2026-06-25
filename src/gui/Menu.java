package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import domain.Card;
import factory.EditorPanelFactory;
import strategy.*;

public class Menu {
	private List<Card> collection;
	private JPanel collectionPanel;
	private JFrame main;
	private JPanel mainPanel;
	private JScrollPane scrollPane;
	
	
	public Menu(List<Card> collection) {
		this.collection = collection;
	}
	
	
	public void start() {
		main = new JFrame("Sistema");
		main.setSize(600, 700);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(false);

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
	}
	
	private JPanel createSortingPanel(JPanel collectionPanel) {
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
		
		sortingPanel.add(sortingSectionTitle);
		sortingPanel.add(Box.createHorizontalGlue());
		sortingPanel.add(sortByName);
		sortingPanel.add(sortByPower);
		sortingPanel.add(sortByRarity);

		return sortingPanel;
	}


	private JPanel createManagementPanel(JPanel collectionPanel) {
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
		
		
		return managementPanel;
	}


	private JPanel buildCollectionPanel(JFrame main) {
		
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
	               editor.createMenu(main, card);
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
	
	private void refresh() {
		
		main.getContentPane().removeAll();

		collectionPanel = buildCollectionPanel(main);

		JScrollPane scroll = new JScrollPane(collectionPanel);

		main.setContentPane(scroll);

		main.revalidate();
		main.repaint();
		}
}

