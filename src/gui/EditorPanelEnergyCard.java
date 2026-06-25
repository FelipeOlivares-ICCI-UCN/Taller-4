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

public class EditorPanelEnergyCard implements EditorPanel<EnergyCard>{
	@Override
	public void createMenu(JFrame main, EnergyCard c) {
	    JDialog dialogRegister = new JDialog(main, "Edit information", true);
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

	    
	    // Agregar componentes al panel
	    questionaryPanel.add(labelName);
	    questionaryPanel.add(name);
	    questionaryPanel.add(labelRarity);
	    questionaryPanel.add(rarity);
	    questionaryPanel.add(labelElement);
	    questionaryPanel.add(element);
	    
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    JButton registerBotton = new JButton("Register");
	    JButton cleanButton = new JButton("Clean");
	    buttonPanel.add(registerBotton);
	    buttonPanel.add(cleanButton);
	    
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
	                
	                	                
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Information succefully edited", 
	                    "Sucess", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                
	                dialogRegister.dispose();
	                
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Error: Some of the information was not able to be parsed", 
	                    "PArsing Error", 
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
        
        
        dialogRegister.setVisible(true);
	}

}
