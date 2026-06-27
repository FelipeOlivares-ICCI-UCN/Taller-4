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

import domain.EnergyCard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * GUI editor for {@link EnergyCard} objects.
 */
public class EditorPanelEnergyCard implements EditorPanel<EnergyCard>{
	@Override
	public boolean buildEditorMenu(JFrame main, EnergyCard c) {
		

		/**
	     * Opens a dialog to edit an {@link EnergyCard}.
	     *
	     * @param main parent window
	     * @param c the energy card to edit
	     * @return true if changes were saved, false otherwise
	     */
		final boolean[] wasDataSaved = {false}; 
		
	    JDialog dialogRegister = new JDialog(main, "Edit Energy Card information", true);
	    dialogRegister.setSize(350, 300);
	    dialogRegister.setLocationRelativeTo(main);

	    JPanel questionaryPanel = new JPanel(new GridLayout(3, 2, 10, 10));
	    questionaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    JLabel labelName = new JLabel("NAME:");
	    JTextField name = new JTextField(10);

	    JLabel labelRarity = new JLabel("RARITY:");
	    JTextField rarity = new JTextField(10);
	    
	    JLabel labelElement = new JLabel("ELEMENT: ");
	    JTextField element = new JTextField(10);
	    
	    name.setText(c.getCardName());
    	element.setText(c.getElement());
    	rarity.setText(String.valueOf(c.getRarity()));

	   	questionaryPanel.add(labelName);
	    questionaryPanel.add(name);
	    questionaryPanel.add(labelRarity);
	    questionaryPanel.add(rarity);
	    questionaryPanel.add(labelElement);
	    questionaryPanel.add(element);
	    
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
	            !element.getText().trim().isEmpty()) {
	            
	            try {
	                int rarityNum = Integer.parseInt(rarity.getText());
	                	                
	                c.setCardName(name.getText());
	                c.setRarity(rarityNum);
	                c.setElement(element.getText());
	                	                
	                wasDataSaved[0] = true;
	                
	                	                
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Information succefully edited", 
	                    "Sucess", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                
	                
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
        	element.setText(c.getElement());
        	rarity.setText(String.valueOf(c.getRarity()));

		});
        
        cancelButton.addActionListener(e -> {
        	
        	dialogRegister.dispose();

}		);
        
        deleteButton.addActionListener(e -> {
        	c.markAsDeleted();
        	dialogRegister.dispose();

}		);
        
        
        
        dialogRegister.setVisible(true);
        return wasDataSaved[0];
	}

}
