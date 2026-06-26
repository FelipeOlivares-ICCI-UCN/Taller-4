package logic;

/**
 * Defines operations for accessing and interacting with the system.
 */

public interface AppSystem {
	/**
     * Loads a single card entry from a formatted data string.
     *
     * @param data the raw string representation of a card
     */
	void loadData(String data);
	/**
     * Starts the main application menu and user interface.
     */
	void startMenu();
	/**
     * Saves all current application data to persistent storage.
     */
	void saveData();
	
}
