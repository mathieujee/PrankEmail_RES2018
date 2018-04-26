package model.email;

import java.util.ArrayList;

/**
 * Group for prank
 */
public class Group {

    private ArrayList<Person> personList;

    /**
     * Creat a empty Group
     */
    public Group(){

        personList = new ArrayList<Person>();
    }

    /**
     * Create a group with some persons
     *
     * @param persons
     */
    public Group(Person... persons) {

        personList = new ArrayList<Person>();

        for(Person person : persons) {
            personList.add(person);
        }
    }

    /**
     * Add one or several persons in the group
     *
     * @param persons
     */
    public void add(Person... persons){

        for (Person person : persons) {
            personList.add(person);
        }
    }

    /**
     * Return an ArrayList with person
     *
     * @return an ArrayList with person
     */
    public ArrayList<Person> getPersonList() {
        return new ArrayList<Person>(personList);
    }
}
