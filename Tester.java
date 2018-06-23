

public class Tester {
    public static void main(String[] args) 
    {
        
        Integer[] array = makeArray(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        for (Integer number:array)
            System.out.println(number);
		
		JoeSort.Heap.sort(array);

        for (Integer number:array)
            System.out.println(number);
        
        /*
        Integer x = new Integer(86);
        Integer y = new Integer(8);

        System.out.println(x.compareTo(y));
        */
    }

    
    private static Integer[] makeArray(int size, int magnitude)
    {
        Integer[] a = new Integer[size];
        for (int x = 0; x < a.length; x++)
            a[x] = new Integer((int)(Math.random() * magnitude));
        return a;
    }
    /*
    private static void printArray(Object[] array)
    {
        System.out.print("\n[ ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i].toString());
            else 
                System.out.print(array[i].toString() + ", ");
        }
        System.out.print(" ]\n");
    }*/
}