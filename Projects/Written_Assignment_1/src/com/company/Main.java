package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // write your code here
        //II();
        //III();
        //testDelete();
        int[] array = {4,6,9,2,4,5};
        //reverse(array);
        foo(array);
    }
    public static int gcdRecursion (int m, int n){
        if (n == 0) return m;
        else{
            return gcdRecursion(n, m%n);
        }
    }
    public static int[] reverse(int[] array){
        int[] reverse = new int[array.length];
        for (int i =0; i < array.length; i++) {
            reverse[i] = array[array.length-1-i];
        }

        return(reverse);
    }

    public static void foo(int [] array){
        for (int i = 0; i<array.length-1; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        String printout = "";
        for(int i = 0; i < array.length; i++){
            printout += array[i];
        }
        System.out.println(printout);
    }

    public static void II(){
        // Create two phonebooks with area for 3 names
        PhoneBook<String> names = new PhoneBook<String>(3);
        PhoneBook<Integer> ssn = new PhoneBook<Integer>(3);

        // Add 1 person to each phonebook
        names.addPerson("Ellie Fitzpatrick", 7883341);
        ssn.addPerson(133970567, 7192847);

        //Find 1 person in each phonebook
        names.findPerson("Ellie Fitzpatrick");
        ssn.findPerson(133970876);
        ssn.findPerson(133970567);

    }

    public static void III(){
        PhoneBook<String> names = new PhoneBook<String>(3);
        PhoneBook<Integer> ssn = new PhoneBook<Integer>(3);
        //names.addPerson(112333333, 132124561);


    }

    public static void testDelete(){
        PhoneBook<String> names = new PhoneBook<String>(5);
        names.addPerson("Ellie", 5555555);
        names.addPerson("Nsisong", 14141414);
        names.addPerson("Kate", 111111111);
        names.addPerson("fernando", 66666666);
        names.addPerson("Baelin", 222222222);

        System.out.println();

        System.out.println(names.printId());
        System.out.println(names.printNumbers());

        names.deletePerson("Kate");

        System.out.println();

        System.out.println(names.printId());
        System.out.println(names.printNumbers());

        names.addPerson("Lillie", 5945645);

        System.out.println();

        System.out.println(names.printId());
        System.out.println(names.printNumbers());


    }
}
