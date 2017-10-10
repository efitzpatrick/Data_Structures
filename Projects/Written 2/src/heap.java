/**
 * Created by ellie on 3/2/2017.
 */
public class heap {

    private void siftDown(int i) { // Input: the node to sift
        T toSift = items[i];
        int parent = i;
        int child = 2 * parent + 1; // Child to compare with; start with left child
        while (child < numItems) {
            // If the right child is bigger than the left one, use the right child instead.
            if (child +1 < numItems  && // if the right child exists
                    items[child].compareTo(items[child + 1]) < 0)  // … and is bigger than the left child
                child = child + 1; // take the right child
            if (toSift.compareTo(items[child]) >= 0)
                break; // we’re done
            // Sift down one level in the tree.
            items[parent] = items[child];
            items[child] = toSift;
            parent = child;
            child = 2 * parent + 1;
        }
        items[parent] = toSift;
    }

    public T removeMax() {
        T toRemove = items[0];
        if (items[numItems-1].equals(items[1])){
            items[0] = items[2];
            shiftUp(2);
        }
        else {
            items[0] = items[numItems - 1];
            numItems--;
            siftDown(0);
        }
        return toRemove;
    }

    public void insert(T item) {
        if (numItems == maxItems) {
// code to grow the array goes here…
        }
        Items[numItems] = item;
        numItems++;
        siftUp(numItems-1);
    }

    private void shiftUp(int i){
        T toSift = items[i];
        int parent = i;
        int child = 2 * parent + 1; // Child to compare with; start with left child
        while (child < numItems) {
            // If the right child is bigger than the left one, use the right child instead.
            if (child +1 > numItems  && // if the right child exists
                    items[child].compareTo(items[child + 1]) < 0)  // … and is bigger than the left child
                child = child + 1; // take the right child
            if (toSift.compareTo(items[child]) <= 0)
                break; // we’re done
            // Sift down one level in the tree.
            items[parent] = items[child];
            items[child] = toSift;
            parent = child;
            child = 2 * parent + 1;
        }
        items[parent] = toSift;
    }


}
