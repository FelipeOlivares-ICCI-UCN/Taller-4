package gui;

import javax.swing.JFrame;

import domain.Card;

public interface EditorPanel<T extends Card> {
	public boolean buildEditorMenu(JFrame main, T card);
}
