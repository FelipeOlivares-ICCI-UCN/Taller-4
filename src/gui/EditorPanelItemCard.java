package gui;

import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.ItemCard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
/**
 * GUI editor for {@link ItemCard} objects.
 */
public class EditorPanelItemCard implements EditorPanel<ItemCard> {
	/**
     * Opens a dialog to edit a {@link ItemCard}.
     *
     * @param main parent window
     * @param c the item card to edit
     * @return true if changes were saved, false otherwise
     */
	@Override
	public boolean buildEditorMenu(JFrame main, ItemCard c) {
		final boolean[] wasDataSaved = {false}; 
		
	    JDialog dialogRegister = new JDialog(main, "Edit Item Card information", true);
	    dialogRegister.setSize(350, 300);
	    dialogRegister.setLocationRelativeTo(main);

	    JPanel questionaryPanel = new JPanel(new GridLayout(3, 2, 10, 10));
	    questionaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    JLabel labelName = new JLabel("NAME:");
	    JTextField name = new JTextField(10);

	    JLabel labelRarity = new JLabel("RARITY:");
	    JTextField rarity = new JTextField(10);
	    
	    JLabel labelBonus = new JLabel("BONUS");
	    JTextField bonus = new JTextField(10);
	    
	    questionaryPanel.add(labelName);
	    questionaryPanel.add(name);
	    questionaryPanel.add(labelRarity);
	    questionaryPanel.add(rarity);
	    questionaryPanel.add(labelBonus);
	    questionaryPanel.add(bonus);
	    
	    name.setText(c.getCardName());
    	bonus.setText(String.valueOf(c.getBonus()));
    	rarity.setText(String.valueOf(c.getRarity()));
	    
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    JButton registerBotton = new JButton("Register");
	    JButton cleanButton = new JButton("Clean");
	    JButton cancelButton = new JButton("Cancel");
	    JButton deleteButton = new JButton("Delete");
	    buttonPanel.add(registerBotton);
	    buttonPanel.add(cleanButton);
	    buttonPanel.add(cancelButton);
	    buttonPanel.add(deleteButton);
	    
	    dialogRegister.setLayout(new BorderLayout());
	    dialogRegister.add(questionaryPanel, BorderLayout.CENTER);
	    dialogRegister.add(buttonPanel, BorderLayout.SOUTH);
        
 
	    registerBotton.addActionListener(e -> {
	        if (!name.getText().trim().isEmpty() && 
	            !rarity.getText().trim().isEmpty() && 
	            !bonus.getText().trim().isEmpty()) {
	            
	            try {
	                int rarityNum = Integer.parseInt(rarity.getText());
	                int bonusNum = Integer.parseInt(bonus.getText());
	                	                
	                c.setCardName(name.getText());
	                c.setRarity(rarityNum);
	                c.setBonus(bonusNum);
	                
	                	                
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Information succefully edited", 
	                    "Sucess", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                	
	                wasDataSaved[0] = true;
	                dialogRegister.dispose();
	                
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Error: Some of the information was not able to be parsed", 
	                    "Parsing Error", 
	                    JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(dialogRegister, 
	                "Please fill all the camps", 
	                "Empty camps", 
	                JOptionPane.WARNING_MESSAGE);
	        }
	    });
        
        cleanButton.addActionListener(e -> {
        	name.setText(c.getCardName());
        	bonus.setText(String.valueOf(c.getBonus()));
        	rarity.setText(String.valueOf(c.getRarity()));
		});
        
        cancelButton.addActionListener(e -> {
        	
        	dialogRegister.dispose();

        });
        
        deleteButton.addActionListener(e -> {
        	c.markAsDeleted();
        	dialogRegister.dispose();

}		);
        
        
        dialogRegister.setVisible(true);
        
        return wasDataSaved[0];
	}

}
