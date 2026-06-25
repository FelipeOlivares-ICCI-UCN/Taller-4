package gui;

import javax.swing.JFrame;

import domain.Card;

public interface EditorPanel<T extends Card> {
	public void createMenu(JFrame main, T card);
}
