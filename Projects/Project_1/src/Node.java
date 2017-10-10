/**
 * Created by ellie on 2/18/2017.
 */
public class Node {
    private Person value;
    private Node next;

    public Node(Person p, Node n){
        this.value = p;
        this.next = n;
    }

    //Get and Set methods
    public Node getNext(){
        return next;
    }

    public Person getValue(){
        return value;
    }

    public void setNext(Node n){
        next = n;
    }

    public void setValue(Person p){
        value = p;
    }

    public void insertAfter(Person p){
        //inserts a node after the node that is accessing the method
        next = new Node(p, next);
    }


    public void removeAfter(){
        //removes a node after the node that is accessing the method
        next = next.getNext();
    }
}
