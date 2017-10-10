import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ellie on 4/20/2017.
 */
public class reporting2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList();
        int size =0;
        Scanner sc = new Scanner(new File(args[0]));
        while(sc.hasNext()){
            sc.next();
            size++;
        }
        int[] arr = new int[size];
        int index = 0;
        Scanner sc1 = new Scanner(new File(args[0]));
        while(sc1.hasNext()){
            arr[index] = sc1.nextInt();
            index++;
        }

        int[] arrHS = copyArray(arr);
        int[] arrQS = copyArray(arr);
        int[] arrMS = copyArray(arr);

        Sorting.heapSort(arrHS);
        Sorting.heapSort(arrHS);
        arrayToFile(arrHS, "eef33HS.txt");
        Sorting.quickSort(arrQS, 0, arrQS.length-1);
        arrayToFile(arrQS, "eef33QS.txt");
        Sorting.mergeSort(arrMS);
        arrayToFile(arrMS, "eef33MS.txt");



    }

    private static int[] copyArray(int[] from){
        int[] to = new int[from.length];
        for (int i = 0; i<from.length; i++){
            to[i] = from[i];
        }
        return to;
    }

    private static void arrayToFile(int[] arr, String filename) throws IOException {
        BufferedWriter output = null;
        output = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < arr.length; i++){
            output.write(arr[i] + "");
            output.newLine();
        }
        output.flush();
        output.close();
    }
}
