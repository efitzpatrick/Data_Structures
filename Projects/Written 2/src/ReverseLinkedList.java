import javax.xml.soap.Node;
import java.util.LinkedList;

/**
 * Created by ellie on 2/23/2017.
 */
public class ReverseLinkedList {


    public LinkedList reverse(){
        LinkedList list = new LinkedList();
        Node head;
        Node current =head;
        Node previous = null;
        Node next = current.getNext();
        while (next != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = current;
    }
}
