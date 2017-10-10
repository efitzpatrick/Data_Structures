import java.util.Arrays;

/**
 * Created by ellie on 2/14/2017.
 */
public class FBArrayList implements FBList {

    //Startsize, which the size of the array will never dip beneath,
    final int STARTSIZE = 20;
    //Instance Variables are phonebook and person counter
    Person[] phoneBook;
    private int personCounter;

    public FBArrayList() {
        //Creates an array of people with the size STARTSIZE
        phoneBook = new Person[STARTSIZE];
        personCounter = 0;
    }

    @Override
    public int size() {
        //returns the number of people in the array
        return personCounter;
    }

    @Override
    public void insert(int i, Person p) {
        //resizes array then inserts if there are more people than spots
        if (phoneBook.length <= (personCounter)) {
            resize();
            insertElement(i, p);

        } else { //otherwise inserts the element as normal
            insertElement(i, p);
        }
    }

    public void insert(Person p) {
        // inserts into next empty spot
        insert(personCounter, p);
    }

    @Override
    public Person remove(int i) {
        Person removed;
        if (i < phoneBook.length) {
            Person[] temp;
            //creates a temporary array of elements that need to be shifted forward
            temp = Arrays.copyOfRange(phoneBook, i + 1, personCounter);
            //creates a temporary variable so the removed element can be returned
            removed = phoneBook[i];
            //shifts the array back with the removed element gone
            for (int j = 0; j < temp.length; j++) {
                phoneBook[i + j] = temp[j];
            }
            //set the previous last person object of the array equal to null so there are no duplicates
            phoneBook[i + temp.length] = null;
            personCounter--;
        } else {
            // if there is not an element i, the method returns null
            removed = null;
        }
        //resizes the array if it is two times the number of people in the array, as long as the array is greater than the original size
        if ((personCounter * 2 <= phoneBook.length) && (phoneBook.length >STARTSIZE)) resize();
        return removed;
    }

    @Override
    public Person lookup(int i) {
        Person found;
        try {
            //sets found equal to the element
            found = phoneBook[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            //If the array index is out of bounds, found is set equal to null
            found = null;
        }
        return found;
    }

    private void insertElement(int i, Person p) {
        //checks to see if the element that is desired is empty
        if (phoneBook[i] != null) {
            //runs if the desired spot in the array is occupied
            //creates a temporary array containing the elements that need to be shifted back
            Person[] temp = Arrays.copyOfRange(phoneBook, i, personCounter);
            //sets the desiered spot equal to the person in the arguments
            phoneBook[i] = p;
            //defines the place that the temporary array being copied over should start inserting elements
            int startIndex = 1 + i;
            //shifts everything down
            for (int k = 0; k < temp.length; k++) {
                int index = startIndex + k;
                phoneBook[index] = temp[k];
            }
        } else {
            //if the desired spot is empty, it simply sets it equal to
            phoneBook[i] = p;
        }
        //adds person to the person counter
        personCounter++;
    }

    private void resize() {
        if (phoneBook.length >= STARTSIZE) {
            //sets the newsize equal to 3/2 times the number of people in the phonebook/list
            int newSize = (int) (personCounter * 1.5);
            //ensures size never drops below the start size
            if (newSize <STARTSIZE) newSize=STARTSIZE;
            //creates an array with the designated new size
            Person[] temp = new Person[newSize];
            //copies list over
            for (int j = 0; j < personCounter; j++) {
                temp[j] = phoneBook[j];
            }
            //sets phonebook equal to the reized phonebook
            phoneBook = temp;
        }
    }
}
