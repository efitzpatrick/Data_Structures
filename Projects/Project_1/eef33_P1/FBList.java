/**
 * Created by ellie on 2/14/2017.
 */
public interface FBList {
    //This is an interface defining the functions to be used in FBArrayList and FBLinkedList
    public int size();
    public void insert(int i, Person p);
    public Person remove(int i);
    public Person lookup(int i);
}
