package gui;

import javax.swing.JFrame;

import domain.Card;


/**
 * Generic interface for editor panels that allow modification
 * of different types of cards.
 *
 * @param <T> the type of Card being edited
 */
public interface EditorPanel<T extends Card> {
    /**
     * Opens an editor dialog for the given card.
     *
     * @param main the parent JFrame
     * @param card the card to edit
     * @return {@code true} if the data was saved, {@code false} otherwise
     */
	public boolean buildEditorMenu(JFrame main, T card);
}
