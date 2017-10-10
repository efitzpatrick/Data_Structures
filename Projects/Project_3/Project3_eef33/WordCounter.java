import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Ellie Fitzpatrick
 * Data Structures Spring 2017
 * Michael Rabinovich
 */

public class WordCounter {

    public static void main(String[] args) throws IOException {
        HashTable table = wordCount(args[0]);
        String tableString = table.toString();
        double collisionRate = table.computeCollisions();
        toFile(args[1], tableString, collisionRate);

    }

    private static void test() {
        HashTable dict = new HashTable();
        dict.put("Ellie", 1);
        dict.put("Christian", 2);
        dict.put("Guiliana", 3);
        dict.put("Nsisong", 4);
        dict.put("Fernando", 5);
        dict.put("Marta", 6);
        dict.put("Lilly", 7);
        dict.put("Matthew", 8);
        dict.put("Joanne", 9);
        dict.put("Maddie", 10);
        dict.put("Sanjaly", 11);
        System.out.println(dict);
        dict.remove("Ellie");
        System.out.println(dict);
        System.out.println(dict.get("Lilly"));

    }

    public static HashTable wordCount(String inputPath) throws IOException {
        HashTable frequency = new HashTable();
        Scanner scanner = new Scanner(new File(inputPath));
        String myString = scanner.useDelimiter("\\A").next();
        scanner.close(); // Put this call in a finally block
        StringTokenizer st = new StringTokenizer(myString, " \',.\"()-@*\n\r;:/#?$");
        while (st.hasMoreTokens()) {
            String current = st.nextToken().toLowerCase();
            if (frequency.get(current) == -1) {
                frequency.put(current, 1);
            } else {
                int num = frequency.get(current);
                frequency.put(current, num + 1);
            }
        }
        return frequency;
    }

    public static void toFile(String outputPath, String output, double collisionRate) throws IOException {
        PrintWriter out = new PrintWriter(outputPath);
        out.write(output);
        out.write("\nThe collision rate is " + collisionRate);
        out.close();
    }
}
