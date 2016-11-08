import java.awt.Color;
/**
 * This method takes an N value from the command line, forms an array of 
 * integers 1-N, shuffles it, then sorts it with the insertion sort.  It
 * also animates this process so the user can see the steps that occur in 
 * an insertion sort.  This method assumes the argument given for N is an 
 * integer.  The insertion sort used here is from the MyInsertion class provided
 * Bradley Ogilvie
 */
public class GraphicalInsertion {

    public GraphicalInsertion() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order. After
     * each step is performed, the
     *
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                show(a, i, j);
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        show(a, N - 1, N - 1);
        assert isSorted(a);
    }

    private static void show(int[] a, int i, int min) {//This show method shows
        StdDraw.clear();//the animation for the sort method
        int N = a.length;
        StdDraw.setYscale(0, N);
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        for (int k = 0; k <= i; k++) {
            StdDraw.filledRectangle(1.0*k/N, a[k]/2.0, 0.5/N, a[k]/2.0);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i + 1; k < N; k++) {
            StdDraw.filledRectangle(1.0*k/N, a[k]/2.0, 0.5/N, a[k]/2.0);
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(1.0*min/N, a[min]/2.0, 0.5/N, a[min]/2.0);
        StdDraw.show(500);
    }

    /**
     * *********************************************************************
     * Helper sorting functions
    **********************************************************************
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
    **********************************************************************
     */
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

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] list = fillArray(N);
        StdRandom.shuffle(list);
        GraphicalInsertion.sort(list);
    }

    private static int[] fillArray(int size) {//This is a helper method that
        int[] temp = new int[size];//fills an array with values 1 - N
        for (int i = 0; i < size; i++) {
            temp[i] = i + 1;
        }
        return temp;
    }
}
