package JSONandXMLfiles;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class People {

    private List<Person> people;

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public People() {
    }

    public People(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
