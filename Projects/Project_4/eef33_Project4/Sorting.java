import java.util.Arrays;

/**
 * Created by ellie on 4/16/2017.
 */
public class Sorting {

    public static void heapSort(int[] arr) {
        // Turn the array into a max-at-top heap.
        int numItems = arr.length;
        buildHeap(arr, numItems);

        int endUnsorted = numItems - 1;
        while (endUnsorted > 0) {
            // Get the largest remaining item and put it to the end
            int largestRemaining = removeMax(arr, endUnsorted);
            arr[endUnsorted] = largestRemaining;
            endUnsorted--;
        }
    }

    public static void buildHeap(int[] arr, int numItems) {
        for (int i = (numItems - 2) / 2; i >= 0; i--) //to start from second level and then sift down
            siftDown(arr, i, numItems);
    }

    private static void siftDown(int[] items, int i, int numItems) { // Input: the node to sift
        int toSift = items[i];
        int parent = i;
        int child = 2 * parent + 1; // Child to compare with; start with left child
        while (child < numItems) {
            // If the right child is bigger than the left one, use the right child instead.
            if (child + 1 < numItems && // if the right child exists
                    items[child] < items[child + 1])  // … and is bigger than the left child
                child = child + 1; // take the right child
            if (toSift >= items[child]) //TODO double check this inequality and others in this function for correctness
                break; // we’re done
            // Sift down one level in the tree.
            items[parent] = items[child];
            items[child] = toSift;
            parent = child;
            child = 2 * parent + 1;
        }
        items[parent] = toSift;
    }

    public static int removeMax(int[] items, int numItems) {
        int toRemove = items[0];
        items[0] = items[numItems];
        numItems--;
        siftDown(items, 0, numItems);
        return toRemove;
    }


    public static void quickSort(int[] arr, int first, int last) {
        //Works!
        if (first >= last) return;
        else {
            int split = partition(arr, first, last);
            quickSort(arr,first,split);
            quickSort(arr, split+1, last);
        }
    }

    static int partition(int[] arr, int first, int last) {
        //This pivot value is simple to read, easier to determine right now
        int pivot = arr[(first + last) / 2];
        int i = first - 1;    // index going from left to right
        int j = last + 1;    // index going from right to left
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j)
                arr = swap(arr, i, j);
            else
                return j;    // arr[j] = end of left array
        }
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        //loop that goes down CHANGE FOR TA
        int i;
        for (i = 0; i < Math.ceil((double) arr.length / 2); i++) {
            if (i % 2 == 0) indexFunction(arr, temp, (int) Math.pow(2, i));
            else indexFunction(temp, arr, (int) Math.pow(2, i));
        }
        if (i % 2 != 0) {
            for (int j = 0; j < temp.length; j++) {
                arr[j] = temp[j];
            }
        }
    }

    private static void indexFunction(int[] start, int[] copy, int blocksize) {
        //going across and setting indexes function
        int beg1 = 0;
        int end1 = blocksize - 1;
        int beg2 = blocksize;
        int end2 = 2 * blocksize - 1;
        int copyIndex = 0;
        while (copyIndex < start.length) {
            if (beg2 >= start.length) {
                //reached end of array, single block
                while (copyIndex < copy.length) {
                    copy[copyIndex] = start[copyIndex];
                    copyIndex++;
                }
            } else if (beg2 < start.length && end2 >= start.length) {
                //1 block and partial block
                copyIndex = compare(beg1, end1, beg2, start.length - 1, start, copy, copyIndex);

            } else {
                //2 full blocks
                copyIndex = compare(beg1, end1, beg2, end2, start, copy, copyIndex);
            }
            beg1 += 2 * blocksize;
            end1 += 2 * blocksize;
            beg2 += 2 * blocksize;
            end2 += 2 * blocksize;
        }
    }

    private static int compare(int beg1, int end1, int beg2, int end2, int[] startArray, int[] copyArray, int copyIndex) {
        while (beg1 <= end1 && beg2 <= end2) {
            if (startArray[beg1] < startArray[beg2]) {
                copyArray[copyIndex] = startArray[beg1];
                beg1++;
                copyIndex++;
            } else {
                copyArray[copyIndex] = startArray[beg2];
                beg2++;
                copyIndex++;
            }


        }

        while (beg1 <= end1) {
            copyArray[copyIndex] = startArray[beg1];
            beg1++;
            copyIndex++;
        }

        while (beg2 <= end2) {
            copyArray[copyIndex] = startArray[beg2];
            beg2++;
            copyIndex++;
        }
        return copyIndex;
    }

    public static String printArray(int[] arr) {
        String output = Arrays.toString(arr);
        System.out.println(output);
        return output;
    }
}
