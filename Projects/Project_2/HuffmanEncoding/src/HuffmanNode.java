/**
 * Created by ellie on 3/19/2017.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    private Character inChar;
    private Integer frequency;
    private HuffmanNode left, right;

    //Two different constructors allow for different configurations of the node for trees, the leaves and the connectors
    public HuffmanNode(Character ic, Integer f) {
        inChar = ic;
        frequency = f;
        left = null;
        right = null;

    }

    public HuffmanNode(Integer f, HuffmanNode l, HuffmanNode r) {
        inChar = null;
        frequency = f;
        left = l;
        right = r;

    }

    public Character getInChar() {
        return inChar;
    }

    public void setInChar(Character inChar) {
        this.inChar = inChar;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }


    public int compareTo(HuffmanNode n) {
        //This function allows for the Collections.sort(list of HuffmanNodes) function to be used
        return frequency.compareTo(n.frequency);
    }
}
