import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
/*
  Ellie Fitzpatrick (eef33)
  Utilities.java
 */
public class Utilities {
    private static Hashtable<Character, String> encodings = new Hashtable<Character, String>();

    public static Hashtable[] scanList(String path) throws IOException {
        //Returnss the frequency hashtable and the hashtable of frequency as an array of hashtables
        // This is a bit unorthodox, but it is the only way I could figure out to return the frequency without a separate function
        Hashtable<Character, Integer> frequencies = new Hashtable<Character, Integer>(26);
        Hashtable<Character, Integer> originalBig = new Hashtable<Character, Integer>(1);
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Hashtable<Character, Integer>[] returnvalues = new Hashtable[2];

        Integer numChar = 0;
        int c;
        while ((c = reader.read()) != -1) {
            Character current = (char) c;
            if (frequencies.get(current) == null) {
                frequencies.put(current, 1);
            } else {
                int num = frequencies.get(current);
                frequencies.put(current, num + 1);
            }
            numChar += 1;
        }
        originalBig.put('b', numChar);
        returnvalues[0] = frequencies;
        returnvalues[1] = originalBig;
        return returnvalues;
    }


    public static HuffmanNode combine(HuffmanNode one, HuffmanNode two) {
        Integer frequency = one.getFrequency() + two.getFrequency();
        //This decides which node is more frequent and then stores the larger one in the .left spot and the other in .right
        if (one.getFrequency() >= two.getFrequency()) {
            HuffmanNode top = new HuffmanNode(frequency, two, one);
            return top;
        } else {
            HuffmanNode top = new HuffmanNode(frequency, one, two);
            return top;
        }
    }

    public static Hashtable encodeChars(Hashtable<Character, Integer> frequencies) {
        //Creates tree and then traverses it to produce a Hashtable of encoding values
        HuffmanNode head = createTree(frequencies);
        traverse(head, "");
        return encodings;
    }

    private static void traverse(HuffmanNode head, String code) {
        /*This is a recursive preorder transversal, everytime it retries the left or the right, it adds 1 or 0 to the encoding.
        * When the end is reached (the next char value is not null), it begins putting the encodings in a hashmap
        * that is a field.         *
        */

        if (head.getInChar() != null) {
            encodings.put(head.getInChar(), code);
            return;
        }
        traverse(head.getLeft(), code + "0");
        traverse(head.getRight(), code + "1");
    }

    public static HuffmanNode createTree(Hashtable<Character, Integer> frequency){
        //Creates the tree and returns the head
        ArrayList<HuffmanNode> huffList = new ArrayList<HuffmanNode>();
        //Loop through dictionary and create nodes in an arraylist
        for (Character key : frequency.keySet()) {
            HuffmanNode node = new HuffmanNode(key, frequency.get(key));
            huffList.add(node);
        }
        //Sort List lowest to highest, able to use Collections.sort because I added a compareTo to HuffmanNode class
        Collections.sort(huffList);
        //Start Combining

        while (huffList.size() > 1) {
            HuffmanNode node = combine(huffList.remove(0), huffList.remove(0));
            huffList.add(node);
            Collections.sort(huffList);
        }
        return huffList.get(0);
    }

    public static int encodeDocument(String input, Hashtable<Character, Integer> frequency) throws IOException {
        /*Encodes the document by using the hashtable with the encodings and then loads it into the document.
        * Returns the number of characters added for calculations
        */

        try {
            PrintWriter writer = new PrintWriter(output, "UTF-8");
            int c;
            while ((c = reader.read()) != -1) {
                Character current = (char) c;
                String code = encodings.get(current);
                writer.print(code);
                numChars += code.length();
            }
            writer.close();
        } catch (IOException e) {
            throw e;
        }
        return numChars;
    }
}
