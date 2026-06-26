package strategy;

import java.util.List;

import domain.Card;


public class SortByPowerStrategy  implements SortingStrategy {
	/* Sorts the given list of cards by power using the quicksort algorithm.
    *
    * <p>This method modifies the input list in-place. If the list is
    * {@code null} or contains one or fewer elements, it does nothing.</p>
    *
    * @param c the list of cards to be sorted (sorted in-place)
    */
	@Override
	public void sortCollection(List<Card> c) {
		if (c == null || c.size() <= 1 ) 
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
        int pivot = c.get(high).getPower(); 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.get(j).getPower() <= pivot) {
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
