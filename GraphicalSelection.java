import java.awt.Color;
/**
 * This method takes an N value from the command line, forms an array of 
 * integers 1-N, shuffles it, then sorts it with the selection sort.  It
 * also animates this process so the user can see the steps that occur in 
 * a selection sort.  This method assumes the argument given for N is an 
 * integer.  The selection sort used here is from the MySelection class provided
 * Bradley Ogilvie
 */
public class GraphicalSelection {

    private GraphicalSelection() {
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            assert isSorted(a, 0, i - 1);
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            show(a, i, min);
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        StdDraw.show();
        assert isSorted(a);
    }

    /**
     * *********************************************************************
     * Helper sorting functions
     * *********************************************************************
     */
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * *********************************************************************
     * Check if array is sorted - useful for debugging
     * *********************************************************************
     */
    // is the array a[] sorted?
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    
    //This method shows the animation being performed in the sort method    
    private static void show(int[] a, int i, int min) {
        StdDraw.clear();
        int N = a.length;
        StdDraw.setYscale(0, N); 
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        for (int k = 0; k < i; k++) {
            StdDraw.filledRectangle(1.0 * k / N, a[k] / 2.0, 0.5 / N, a[k] / 2.0);
            //StdDraw.show();
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < N; k++) {
            StdDraw.filledRectangle(1.0 * k / N, a[k] / 2.0, 0.5 / N, a[k] / 2.0);
            //StdDraw.show();
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(1.0 * min / N, a[min] / 2.0, 0.5 / N, a[min] / 2.0);
        StdDraw.show(1000);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] list = fillArray(N);        
        StdRandom.shuffle(list);
        GraphicalSelection.sort(list);
    }
    /*
    This is a helper method that creates an array with values 1-N
    */
    private static int[] fillArray(int size) {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = i + 1;
        }
        return temp;
    }
}
