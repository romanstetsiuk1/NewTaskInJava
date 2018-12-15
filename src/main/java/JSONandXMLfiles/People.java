package JSONandXMLfiles;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class People {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "person")
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
