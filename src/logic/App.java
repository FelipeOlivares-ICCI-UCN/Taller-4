package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	private static AppSystem sys = AppSystemImpl.getInstance();
	


	/**
 	* Entry point of the application.
 	*
 	* <p>This class is responsible for initializing the system,
 	* loading persisted data, and starting the main menu.</p>
 	*/
	public static void main(String[] args) throws FileNotFoundException 
	{
		readFile();
		sys.startMenu();
	}
	
    /**
     * Reads persisted card data from the file system and loads it into memory.
     *
     * <p>Each line in the file represents a serialized card.</p>
     *
     * @throws FileNotFoundException if the data file does not exist
     */
    private static void readFile() throws FileNotFoundException
    {
        File arch = new File("./data/Sobres.txt");
        Scanner lector = new Scanner(arch);
        while (lector.hasNextLine()) {
            String data = lector.nextLine();
            sys.loadData(data);

        }
        lector.close();
    }

}
