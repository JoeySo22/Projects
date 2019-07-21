
/*
    The main idea is to have different algorithms that perform the best under the 
    given circumstances. First we "diagnose" the array to see what kind of order it 
    is already in (if any). So we have nearly sorted, random, and common-value arrays.
 */

/**
 * @author      Jose Eduardo Soto <gamereg911@gmail.com>
 * @version     1.1
 */

public class JoeSort
{
	
	//For non-instantiability
	private JoeSort()
	{
		throw new AssertionError();
	}
	
    // Helper method for each sort.
    private static void swap(Comparable[] array, int x, int y) {
	    if (debug)
        //System.out.println("Swapping: " + array[x].toString() + " & " + array[y].toString());
        Comparable temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // We use insertion sort for arrays that are already close to being sorted least to great.
    public static class Insertion
	{
		//For non-instantiability
		private Insertion()
		{
			throws new AssertionError();
		}
		
        public static void sort(Comparable[] a) 
		{
            for (int x = 1; x < a.length; x++) 
			{
                for (int y = x; y > 0; y--) 
				{
                    if (a[y].compareTo(a[y-1]) < 0)
                        swap(a, y, y-1);
                }
            } 
        }
        
    }

    // We use this quicksort for arrays that have few unique values
    /*public static class Quick
    {
		//For non-instantiability
		private Quick()
		{
			throws new AssertionError();
		}
		
        public static void sort(Comparable[] common_array){
            sort(common_array, 0, -1);
        }
		private static void sort(Comparable[] a, int l, int h) {
			
		}
		private static int partition(Comparable[] a, int l, int h) {
			
		}
    }*/

    //We use this heapsort for arrays that are random values
    public static class Heap
    {
		//For non-instantiablity
		private Heap()
		{
			throws new AssertionError();
		}
		
        public static void sort(Comparable[] random_array) {
            for (int x = random_array.length / 2 - 1; x >= 0; x--)
                heapify(random_array, x, x*2+1, x*2+2, random_array.length);
            for (int x = random_array.length-1; x >= 0; x--) {
                swap(random_array, 0, x);
                heapify(random_array, 0, 1, 2, x);
            }
        }

        private static void heapify(Comparable[] a, int p, int l, int r, int s) {
            if (l < s && a[p].compareTo(a[l]) < 0) {
                swap(a, p, l);
                heapify(a, l, l*2+1, l*2+2, s);
            }
            if (r < s && a[p].compareTo(a[r]) < 0) {
                swap(a, p, r);
                heapify(a, r, r*2+1, r*2+2, s);
            }
        }
    }
}
