package model.email;

import java.util.ArrayList;

public class Group {

    private ArrayList<Person> personList;

    public Group(){

        personList = new ArrayList<Person>();
    }

    public Group(Person... persons) {

        personList = new ArrayList<Person>();

        for(Person person : persons) {
            personList.add(person);
        }
    }

    public void add(Person... persons){

        for (Person person : persons) {
            personList.add(person);
        }
    }

    public ArrayList<Person> getPersonList() {
        return new ArrayList<Person>(personList);
    }
}
