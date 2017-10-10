package com.company;

import jdk.nashorn.internal.runtime.logging.DebugLogger;

/**
 * Ellie Fitzpatrick
 * eef33
 */

public class PhoneBook<E> {
    E[] id;
    long[] phoneNumbers;
    int counter;

    public PhoneBook(int numPeople) {
        // Create parallel arrays containing id and phone numbers

        id = (E[]) new Object[numPeople];
        phoneNumbers = new long[numPeople];
        counter = 0;
    }

    public boolean addPerson(E identification, long phoneNumber) {
        try {
            id[counter] = identification;
            phoneNumbers[counter] = phoneNumber;
            System.out.println(id[counter] + " has been added to to the phonebook with the number " + phoneNumbers[counter]);
            counter++;
            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The phonebook is full!");
            return false;
        }
    }


    public int findPerson(E identification) {
        //algorithm to find person
        for (int i = 0; i < counter; i++) {
            if (id[i].equals(identification)) {
                System.out.println(id[i] + "'s phone number is " + phoneNumbers[i] + ".");
                return i;
            }
        }
        //Returns -1 if id can not be found.
        System.out.println(identification + " can not be found in the phone book. Please try again.");
        return -1;
    }

    public boolean deletePerson(E identification) {
        int index = findPerson(identification);
        if (index == -1) {
            System.out.println(identification + " can not be found in the phone book. Please try again.");
            return false;
        } else {
            for (int i = index + 1; i < counter; i++) {
                id[i - 1] = id[i];
                phoneNumbers[i - 1] = phoneNumbers[i];
            }
            id[id.length-1]= null;
            phoneNumbers[phoneNumbers.length-1]= 0;
            counter--;
            return true;
        }
    }

    public String printId() {
        String elements = "";
        for (int i = 0; i < id.length; i++) {
            elements += id[i] + ", ";
        }

        return elements;
    }

    public String printNumbers() {
        String elements = "";
        for (int i = 0; i < phoneNumbers.length; i++) {
            elements += phoneNumbers[i] + ", ";
        }
        return elements;
    }
}

