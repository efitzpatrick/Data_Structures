/**
 * Created by ellie on 2/11/2017.
 */
public class PhoneBook {
    public static void main(String[] args) {
        arraylistDemo();
        linkedListDemo();
    }

    public static void arraylistDemo() {
        System.out.println("*** Array List Demo***");
        //Create a new FBArrayList
        FBArrayList PhoneBook = new FBArrayList();
        //Insert 4 people at varying positions
        PhoneBook.insert(0, new Person("Ellie", 7168909));
        PhoneBook.insert(new Person("Franci", 8764654));
        PhoneBook.insert(new Person("Nsisong", 7168907));
        PhoneBook.insert(1, new Person("Fernando", 8176542));
        //Look for people with the area code 716
        int results = localsTotNum(PhoneBook, "716");
        System.out.println("Area Code 716: " + results);
        System.out.println("Finished Array List Demo");
    }

    private static void linkedListDemo() {
        System.out.println("\n*** Linked List Demo***");
        //Create a new FBLinkedList with the head being person a
        FBLinkedList ll = new FBLinkedList(new Person("a", 1769379));
        //Add person b, c, d, and e to the linked list
        ll.insert(0, new Person("b", 9380909));
        ll.insert(3, new Person("c", 201929));
        ll.insert(2, new Person("d", 938201));
        ll.insert(5, new Person("e", 9381920));
        //Run locals to num looking for prefix 938
        int results = localsTotNum(ll, "938");
        System.out.println("Area Code 938: " + results);
        System.out.println("Finished Linked List Demo");
    }

    public static int localsTotNum(FBList list, String prefix) {
        /**
         * Uses the lookup method from the lists to search for
         */
        int totalPrefix = 0;
        for (int i = 0; i < list.size(); i++) {
            Person p = list.lookup(i);
            //Converts the phone number to a string and then takes the first 3 characters
            String prefixPhoneNumber = Long.toString(p.getPhoneNum()).substring(0, 3);
            if (prefix.equals(prefixPhoneNumber)) totalPrefix++;
        }
        return totalPrefix;
    }

}

