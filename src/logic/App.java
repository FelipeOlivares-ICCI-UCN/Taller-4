package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	private static AppSystem sys = AppSystemImpl.getInstance();
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		readFile();
	}
	
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
