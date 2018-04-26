package model.email;

import java.util.ArrayList;

public class Prank {

    private Person sender;
    private ArrayList<Person> victims;
    private ArrayList<Person> witnessesToCC;
    private String message;

    public Prank(Person sender, ArrayList<Person> victims, ArrayList<Person> witnessesToCC, String message){
        this.sender = sender;
        this.victims = new ArrayList<Person>(victims);
        this.witnessesToCC = new ArrayList<Person>(witnessesToCC);
        this.message = message;
    }

    public Person getSender() {
        return sender;
    }

    public ArrayList<Person> getVictims() {
        return new ArrayList<Person>(victims);
    }

    public ArrayList<Person> getWitnessesToCC() {
        return new ArrayList<Person>(witnessesToCC);
    }

    public String getMessage() {
        return message;
    }
}
