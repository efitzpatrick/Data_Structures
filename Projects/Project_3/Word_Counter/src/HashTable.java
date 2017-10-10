import java.util.LinkedList;

import static java.lang.StrictMath.abs;

/**
 * Ellie Fitzpatrick
 * Data Structures Spring 2017
 * Michael Rabinovich
 */
public class HashTable {
    LinkedList<HashNode>[] table;

    public HashTable() {
        //This method is used at the beginning
        table = new LinkedList[2];
    }

    public HashTable(int initSize) {
        //This method is used when the hashtable is rehashed
        table = new LinkedList[initSize];
    }

    public int put(String word, int frequency) {
        //Allows for input of word and frequency
        HashNode node = new HashNode(word.toLowerCase(), frequency);
        return (put(node));
    }

    private int put(HashNode node) {
        //Allows for input of a node, for internal use only
        int hash = abs(node.getWord().hashCode() % table.length);
        HashNode found = this.find(node);
        if (found == null) {
            //Inserts new linked list if slot is null, otherwise adds node to the linked list
            if (table[hash] == null) {
                LinkedList<HashNode> list = new LinkedList<HashNode>();
                list.add(node);
                table[hash] = list;
            } else {
                //Rehashes is a linked list size is bigger than the length of the table
                table[hash].add(node);
                if (table[hash].size() > table.length) {
                    reHash();
                }
            }

            return (-1);
        } else {
            //Replaces old frequency value of the node if the key already exists in the hashtable
            int old = found.getFrequency();
            found.setFrequency(node.getFrequency());
            return old;
        }
    }

    public HashNode remove(String word) {
        //removes a node from the hashtable based on key or word
        int hash = abs(word.toLowerCase().hashCode() % table.length);
        LinkedList<HashNode> list = table[hash];
        for (int i = 0; i < list.size(); i++) {
            HashNode current = list.get(i);
            if (list.get(i).getWord().equals(word.toLowerCase())) {
                list.remove(i);
                return (current);
            }
        }
        return null;
    }

    public int get(String key) {
        //Returns the value based on the string or key, returns -1 if the value does not exist
        String word = key.toLowerCase();
        int hash = abs(word.hashCode() % table.length);
        LinkedList<HashNode> list = table[hash];
        if (list == null) return -1;
        else {
            for (int i = 0; i < list.size(); i++) {
                HashNode current = list.get(i);
                if (current.getWord().equals(word)) {
                    return current.getFrequency();
                }
            }
            return -1;
        }
    }

    private HashNode find(HashNode node) {
        //Loops through the linked list of corresponding hash of word, only used internally
        String word = node.getWord().toLowerCase();
        int hash = abs(word.hashCode() % table.length);
        LinkedList<HashNode> list = table[hash];
        if (list == null) return null;
        else {
            for (int i = 0; i < list.size(); i++) {
                HashNode current = list.get(i);
                if (current.getWord().equals(word)) {
                    return current;
                }
            }
            return null;
        }
    }

    public void reHash() {
        /*Creates a new table two times the size and then inserts all the nodes from the old hashtable into the new
        hashtable. Then sets the new hastable equal to the new hastable. Unfortunately has time O(n^2)*/
        LinkedList<HashNode>[] newTable = new LinkedList[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) ;
            else {
                for (int j = 0; j < table[i].size(); j++) {
                    HashNode current = table[i].get(j);
                    int hash = abs(current.getWord().hashCode() % newTable.length);
                    if (newTable[hash] == null) {
                        LinkedList<HashNode> list = new LinkedList<HashNode>();
                        list.add(current);
                        newTable[hash] = list;
                    } else {
                        newTable[hash].add(current);
                    }
                }
            }
        }
        table = newTable;

    }

    @Override
    public String toString() {
        //To string for Hashtable class.
        String output = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) ;
            else {
                for (int j = 0; j < table[i].size(); j++) {
                    HashNode current = table[i].get(j);
                    String word = current.getWord();
                    output += current.getWord() + ": " + current.getFrequency() + "\n";
                }
            }
        }
        return output;
    }

    public double computeCollisions() {
        //Adds up all of the lengths of the linked lists and then divides by the number of slots. Returns a double
        int slots = table.length;
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) ;
            else {
                sum += table[i].size();
            }
        }
        double average = sum / slots;
        return average;
    }

    private class HashNode {
        String word;
        int frequency;

        public HashNode(String value, int num) {
            word = value.toLowerCase();
            frequency = num;
        }


        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            String output = this.word + ": " + this.frequency;
            return output;
        }

    }
}
