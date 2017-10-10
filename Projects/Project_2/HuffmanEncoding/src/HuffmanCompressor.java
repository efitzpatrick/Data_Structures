import java.io.IOException;
import java.util.Hashtable;

/**
 * Ellie Fitzpatrick (eef33)
 * Huffman encodings
 *
 * Note: I realize I did this a bit differently by using a utilities class instead of having all of the mehtods in
 * the huffman compressor class. This has several benefits including it hides a lot of the information, so the encoding
 * algorithm is not within the class that uses the encoding algorithm. It also abstracts and modulates the code making
 * it easier to read.
 */
public class HuffmanCompressor {
    public static void main(String[] args) throws IOException {
        String in = args[0];
        String out = args[1];
        int inputValues = 0, outputValues = 0, savings;
        Hashtable<Character, Integer>[] returnValues = null;
        Hashtable<Character, Integer> frequency = null;
        try {
            returnValues = Utilities.scanList(in);
            //Gets frequency table
            frequency = returnValues[0];
            //Gets number of characters in original document
            inputValues = returnValues[1].get('b');
            //Gets encodings by building a huffman table, and then storing the data in a hashmap
            Hashtable<Character, String> encodings = Utilities.encodeChars(frequency);
            //Ouputs frequency table
            System.out.println("The frequency table");
            for (Character key : frequency.keySet()) {
                System.out.println(key + ":" + frequency.get(key) + ":" + encodings.get(key));
            }
            System.out.println("End of table\n");
            //Encodes and stores the resulting document in the designated location, returns number of chars in file
            outputValues = Utilities.encodeDocument(in, out, encodings, frequency);
            System.out.println("The output is stored at " + out);
            //Calculate and print the space savings
            inputValues = inputValues * 8;
            savings = inputValues - outputValues;
            System.out.println("You saved " + savings + " bytes!");

        } catch (IOException e) {
            System.out.println("Can not find " + in);
            e.printStackTrace();
        }

    }
}