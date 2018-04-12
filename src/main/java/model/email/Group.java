package model.email;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Person> personList;

    public Group(Person... persons) {

        personList = new ArrayList<Person>();

        for(Person person : persons) {
            personList.add(person);
        }
    }

    public  Group(List<Person> personList) {
        this.personList = new ArrayList<Person>(personList);
    }

    public List<Person> getPersonList() {
        return new ArrayList<Person>(personList);
    }
}
