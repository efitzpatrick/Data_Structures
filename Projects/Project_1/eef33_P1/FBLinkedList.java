/**
 * Created by ellie on 2/15/2017.
 */

public class FBLinkedList implements FBList {
    //Instance variables are the head node, the last node and the counter
    Node head;
    int counter;
    Node last;

    public FBLinkedList(Person p) {
        head = new Node(p, null);
        last = head;
        counter = 1;
    }

    @Override
    public int size() {
        counter = 0;
        Node cursor;
        for (cursor = head; cursor != null; cursor = cursor.getNext()) counter++;
        return counter;
    }

    @Override
    public void insert(int i, Person p) {
        //"i" is the index that I want, not the number in the sequence
        if (i > counter) insertLast(p);
        else if (i==0){
            head = new Node(p, head);
        }
        else {
            Node cursor = head;
            //Finds element before the one wanted to be inserted
            for (int j = 1; (j < i) && (cursor != null); j++) {
                cursor = cursor.getNext();
            }
            cursor.insertAfter(p);

        }
        counter++;
    }

    @Override
    public Person remove(int i) {
        Person removed;
        if (i >= counter) removed = null;
        else if(i == 0){
            removed = head.getValue();
            head = head.getNext();
        }
        else {
            Node cursor = head;
            //Finds element before the one wanted to be removed
            for (int j = 0; (j < i - 1) && (cursor != null); j++) {
                cursor = cursor.getNext();
            }
            Node removedNode = cursor.getNext();
            cursor.removeAfter();
            removed = removedNode.getValue();
            //if removed the last node, sets the node before it equal to last
            if (removedNode.getNext().equals(null)) last = cursor;
            counter--;
        }
        return removed;
    }

    @Override
    public Person lookup(int i) {
        //Loops through linked list until it finds the element and returns it. If not found, returns null
        Person found;
        size();
        if (i > 0 || i < counter) {
            Node cursor = head;
            for (int j = 0; (j < i) && cursor != null; j++) {
                cursor = cursor.getNext();
            }
            found = cursor.getValue();

        } else found = null;
        return found;
    }

    private void insertLast(Person p) {
        Node n = new Node(p, null);
        last.setNext(n);
        last = n;
    }

    @Override
    public String toString() {
        String result = counter +"- ";
        for (Node cursor = head; cursor!=null; cursor = cursor.getNext()){
            result += cursor.getValue().getPersonID() + ", ";
        }
        return "List: " + result;
    }

}
