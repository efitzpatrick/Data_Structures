import java.util.Arrays;

/**
 * Created by ellie on 4/16/2017.
 */
public class MyClass {
    public static void main(String[] args){
        int arr[] = {7, 1, 6, 2, 5, 3, 4};
        Sorting.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
