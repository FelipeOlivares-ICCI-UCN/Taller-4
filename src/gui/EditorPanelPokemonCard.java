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

import domain.PokemonCard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class EditorPanelPokemonCard implements EditorPanel<PokemonCard> {
	@Override
	public boolean buildEditorMenu(JFrame main, PokemonCard c) {
		final boolean[] wasDataSaved = {false};
	    JDialog dialogRegister = new JDialog(main, "Edit Pokemon card information", true);
	    dialogRegister.setSize(350, 300);
	    dialogRegister.setLocationRelativeTo(main);

	    JPanel questionaryPanel = new JPanel(new GridLayout(4, 2, 10, 10));
	    questionaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    JLabel labelName = new JLabel("NAME:");
	    JTextField name = new JTextField(10);
	   
	    JLabel labelRarity = new JLabel("RARITY:");
	    JTextField rarity = new JTextField(10);
	    
	    JLabel labelEnergy = new JLabel("ENERGY: ");
	    JTextField energy = new JTextField(10);
	    
	    JLabel labelDamage = new JLabel("DAMAGE: ");
	    JTextField damage = new JTextField(10);
	    
    	name.setText(c.getCardName());
    	energy.setText(String.valueOf(c.getEnergy()));
    	rarity.setText(String.valueOf(c.getRarity()));
    	damage.setText(String.valueOf(c.getDamage()));
	    	    
	    questionaryPanel.add(labelName);
	    questionaryPanel.add(name);
	    questionaryPanel.add(labelRarity);
	    questionaryPanel.add(rarity);
	    questionaryPanel.add(labelEnergy);
	    questionaryPanel.add(energy);
	    questionaryPanel.add(labelDamage);
	    questionaryPanel.add(damage);
	    
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    JButton registerBotton = new JButton("Register");
	    JButton cleanButton = new JButton("Clean");
	    JButton cancelButton = new JButton("Cancel");
	    buttonPanel.add(registerBotton);
	    buttonPanel.add(cancelButton);
	    buttonPanel.add(cleanButton);
	    
	    dialogRegister.setLayout(new BorderLayout());
	    dialogRegister.add(questionaryPanel, BorderLayout.CENTER);
	    dialogRegister.add(buttonPanel, BorderLayout.SOUTH);
        
 
	    registerBotton.addActionListener(e -> {
	        if (!name.getText().trim().isEmpty() && 
	            !rarity.getText().trim().isEmpty() && 
	            !energy.getText().trim().isEmpty() &&
	            !damage.getText().trim().isEmpty())
	        {
	            
	            try {
	                int rarityNum = Integer.parseInt(rarity.getText());
	                int energyNum = Integer.parseInt(energy.getText());
	                int damageNum = Integer.parseInt(damage.getText());
	                
	                c.setCardName(name.getText());
	                c.setRarity(rarityNum);
	                c.setEnergy(energyNum);
	                c.setDamage(damageNum);
	                
	                	                
	                JOptionPane.showMessageDialog(dialogRegister, 
	                    "Information succefully edited in", 
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
        	energy.setText(String.valueOf(c.getEnergy()));
        	rarity.setText(String.valueOf(c.getRarity()));
        	damage.setText(String.valueOf(c.getDamage()));
		});
        
        cancelButton.addActionListener(e -> {
        	
        	dialogRegister.dispose();

        });
        
        
        dialogRegister.setVisible(true);
        
        return wasDataSaved[0];
	}

}
