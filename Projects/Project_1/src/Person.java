/**
 * Created by ellie on 2/11/2017.
 */
public class Person {
    //Instance variables of identification (string) and phone number (long)
    String personID;
    long phoneNum;
    public Person(String personID, long phoneNum){
        this.personID = personID;
        this.phoneNum = phoneNum;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
}
