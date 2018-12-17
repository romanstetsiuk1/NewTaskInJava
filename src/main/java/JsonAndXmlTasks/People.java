package JsonAndXmlTasks;

import java.util.ArrayList;
import java.util.List;

public class People {

    private List<Person> people = new ArrayList<>();

    public void addToPeple(Person person) {
        people.add(person);
    }

    public People() {
    }

    public People(List<Person> people) {
        this.people = people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
