package strategy;

import java.util.List;

import domain.Card;


public class SortByNameStrategy  implements SortingStrategy {

	@Override
	public void sortCollection(List<Card> c) {
		if (c == null || c.size() <= 1) 
		{
			return;
		}
		
		quickSort(c, 0, c.size() - 1);
		
	}
	public static void quickSort(List<Card> c, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(c, low, high);
            quickSort(c, low, pivotIndex - 1);  
            quickSort(c, pivotIndex + 1, high); 
        }
    }

    private static int partition(List<Card> c, int low, int high) {
        String pivot = c.get(high).getCardName(); 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.get(j).getCardName().compareTo(pivot) <= 0) {
                i++;
                swap(c, i, j);
            }
        }
        swap(c, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Card> c, int i, int j) 
    {
    	Card temp = c.get(i);
    	c.set(i, c.get(j));
    	c.set(j, temp);
    	
    }   	
}
