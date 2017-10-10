import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import javax.xml.soap.Node;

/**
 * Created by ellie on 2/23/2017.
 */
public class BinaryInsert {
    public void insert(int key, String data) {

    }

    public Node bMethod(Node current, int key, Node add) {
         if (key > current.key) {
             else{
                 return bMethod(current.right(), key, add);
             }
            return bMethod(current.right());
        } else if (key < current.key) {
            if (current.left == null) {
                current.setLeft(add);
            }else{
                return bMethod(current.left(), key, add);
            }
        }
    }
}