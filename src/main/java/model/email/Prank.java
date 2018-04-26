package model.email;

import java.util.ArrayList;

/**
 * Represent a Prank
 */
public class Prank {

    private Person sender;
    private ArrayList<Person> victims;
    private ArrayList<Person> witnessesToCC;
    private String message;

    /**
     * Create a Prank
     *
     * @param sender the person who will send email
     * @param victims people to be pranked
     * @param witnessesToCC
     * @param message the sent message
     */
    public Prank(Person sender, ArrayList<Person> victims, ArrayList<Person> witnessesToCC, String message){
        this.sender = sender;
        this.victims = new ArrayList<Person>(victims);
        this.witnessesToCC = new ArrayList<Person>(witnessesToCC);
        this.message = message;
    }

    /**
     * Return the sender
     * @return the sender
     */
    public Person getSender() {
        return sender;
    }

    /**
     * Return the list of victims
     * @return the list of victims
     */
    public ArrayList<Person> getVictims() {
        return new ArrayList<Person>(victims);
    }

    /**
     * Return the list oh witnessesToCC
     * @return the list oh witnessesToCC
     */
    public ArrayList<Person> getWitnessesToCC() {
        return new ArrayList<Person>(witnessesToCC);
    }

    /**
     * Return the message
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
