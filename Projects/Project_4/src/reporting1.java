import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ellie on 4/20/2017.
 */
public class reporting1 {
    public static void main(String[] args) {
        heapSortTest();
        quickSortTest();
        //mergeSortTest();

    }

    private static void quickSortTest() {
        //Test heapsort
        long[] quickSortTimesSorted = new long[4];
        long[] quickSortVarSorted = new long[4];
        long[] quickSortMeanSorted = new long[4];
        long[] quickSortTimesReverse = new long[4];
        long[] quickSortVarReverse = new long[4];
        long[] quickSortMeanReverse = new long[4];
        long[] quickSortTimesRandom = new long[4];
        long[] quickSortVarRandom = new long[4];
        int[] sizes = {1000, 10000, 100000, 1000000};


        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = sortedList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.nanoTime();
                Sorting.quickSort(arr, 0, arr.length - 1);
                long total = System.nanoTime() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            quickSortMeanSorted[j] = mean(median);
            quickSortVarSorted[j] = variance(median, mean(median));
            quickSortTimesSorted[j] = median[1];
        }

        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = reverseList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.nanoTime();
                Sorting.quickSort(arr, 0, arr.length - 1);
                long total = System.nanoTime() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            quickSortMeanReverse[j] = mean(median);
            quickSortVarReverse[j] = variance(median, mean(median));
            quickSortTimesReverse[j] = median[1];
        }


        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] times = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] arr = randomList(size);
                long start = System.nanoTime();
                Sorting.quickSort(arr, 0, arr.length - 1);
                long total = System.nanoTime() - start;
                times[i] = total;
            }
            quickSortTimesRandom[j] = mean(times);
            quickSortVarRandom[j] = variance(times, quickSortTimesRandom[j]);
        }
        System.out.println("**** Quick Sort ****");
        System.out.println("Time in nanoseconds");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Sorted: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(quickSortTimesSorted) + ", " + Arrays.toString(quickSortMeanSorted) + ", " + Arrays.toString(quickSortVarSorted));
        System.out.println("Reverse: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(quickSortTimesReverse) + ", " + Arrays.toString(quickSortMeanReverse) + ", " + Arrays.toString(quickSortVarReverse));
        System.out.println("Random: Mean Times, Variance Time");
        System.out.println(Arrays.toString(quickSortTimesRandom) + ", " + Arrays.toString(quickSortVarRandom));


    }

    private static void heapSortTest() {
        //Test heapsort
        long[] timesSorted = new long[4];
        long[] varSorted = new long[4];
        long[] meanSorted = new long[4];
        long[] timesReverse = new long[4];
        long[] varReverse = new long[4];
        long[] meanReverse = new long[4];
        long[] timesRandom = new long[4];
        long[] varRandom = new long[4];
        int[] sizes = {1000, 10000, 100000, 1000000};


        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = sortedList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.nanoTime();
                Sorting.heapSort(arr);
                long total = System.nanoTime() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            meanSorted[j] = mean(median);
            varSorted[j] = variance(median, mean(median));
            timesSorted[j] = median[1];
        }

        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = reverseList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.nanoTime();
                Sorting.heapSort(arr);
                long total = System.nanoTime() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            meanReverse[j] = mean(median);
            varReverse[j] = variance(median, mean(median));
            timesReverse[j] = median[1];
        }

        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] times = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] arr = randomList(size);
                long start = System.nanoTime();
                Sorting.heapSort(arr);
                long total = System.nanoTime() - start;
                times[i] = total;
            }
            timesRandom[j] = mean(times);
            varRandom[j] = variance(times, timesRandom[j]);
        }

        System.out.println("**** Heap Sort ****");
        System.out.println("Time in nanoseconds");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Sorted: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(timesSorted) + ", " + Arrays.toString(meanSorted) + ", " + Arrays.toString(varSorted));
        System.out.println("Reverse: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(timesReverse) + ", " + Arrays.toString(meanReverse) + ", " + Arrays.toString(varReverse));
        System.out.println("Random: Mean Times, Variance Time");
        System.out.println(Arrays.toString(timesRandom) + ", " + Arrays.toString(varRandom));
    }

    private static void mergeSortTest() {
        //Test heapsort
        long[] timesSorted = new long[4];
        long[] varSorted = new long[4];
        long[] meanSorted = new long[4];
        long[] timesReverse = new long[4];
        long[] varReverse = new long[4];
        long[] meanReverse = new long[4];
        long[] timesRandom = new long[4];
        long[] varRandom = new long[4];
        int[] sizes = {1000, 10000, 100000, 1000000};


        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = sortedList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                Sorting.mergeSort(arr);
                long total = System.currentTimeMillis() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            meanSorted[j] = mean(median);
            varSorted[j] = variance(median, mean(median));
            timesSorted[j] = median[1];
        }

        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] median = new long[3];
            int[] arr = reverseList(size);
            for (int i = 0; i < 3; i++) {
                long start = System.currentTimeMillis();
                Sorting.mergeSort(arr);
                long total = System.currentTimeMillis() - start;
                median[i] = total;
            }
            Arrays.sort(median);
            meanReverse[j] = mean(median);
            varReverse[j] = variance(median, mean(median));
            timesReverse[j] = median[1];
        }

        for (int j = 0; j < sizes.length; j++) {
            int size = sizes[j];
            long[] times = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] arr = randomList(size);
                long start = System.currentTimeMillis();
                Sorting.mergeSort(arr);
                long total = System.currentTimeMillis() - start;
                times[i] = total;
            }
            timesRandom[j] = mean(times);
            varRandom[j] = variance(times, timesRandom[j]);
        }

        System.out.println("**** Merge Sort ****");
        System.out.println("Time in  milliseconds");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Sorted: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(timesSorted) + ", " + Arrays.toString(meanSorted) + ", " + Arrays.toString(varSorted));
        System.out.println("Reverse: Median Time, Mean Time, Variance Time");
        System.out.println(Arrays.toString(timesReverse) + ", " + Arrays.toString(meanReverse) + ", " + Arrays.toString(varReverse));
        System.out.println("Random: Mean Times, Variance Time");
        System.out.println(Arrays.toString(timesRandom) + ", " + Arrays.toString(varRandom));
    }

    public static int[] sortedList(int len) {
        int[] list = new int[len];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        return list;
    }

    public static int[] reverseList(int len) {
        int[] list = new int[len];
        for (int i = 0; i < list.length; i++) {
            list[i] = len - i;
        }
        return list;
    }

    public static int[] randomList(int len) {
        Random rand;
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = ThreadLocalRandom.current().nextInt(0, 1001);

        }
        return list;
    }

    public static long variance(long[] times, long mean) {
        long var = 0;
        long sum = 0;
        for (long i : times
                ) {
            sum = sum + ((i - mean) * (i - mean)); //TODO try to make '^' work

        }
        var = sum / (times.length - 1);
        return var;
    }

    public static long mean(long[] m) {
        long sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }
}
