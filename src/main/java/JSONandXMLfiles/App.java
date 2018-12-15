package JSONandXMLfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
//        saveObjectToXML();
//        readXmlToObject();

        saveObjectToJson();
//        readJsonToObject();

    }

    private static void readJsonToObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        People people = objectMapper.readValue(new FileInputStream("readJsonToObject.json"), People.class);
        System.out.println(people);
    }

    private static void saveObjectToJson() throws IOException {
        Person firstPerson = new Person("Person1", 25);
        Person secondPerson = new Person("Person2", 29);

        People people = new People(Arrays.asList(firstPerson, secondPerson));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("output.json"), people);
    }

    private static void readXmlToObject() throws IOException {
        ObjectMapper objectMapper = new XmlMapper();
        People people = objectMapper.readValue(new FileInputStream("outputByGetValueFromXML.xml"), People.class);
        System.out.println(people);
    }

    private static void saveObjectToXML() throws IOException {
        Person firstPerson = new Person("Person1", 25);
        Person secondPerson = new Person("Person2", 29);

        People people = new People(Arrays.asList(firstPerson, secondPerson));

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(new FileOutputStream("output.xml"), people);
    }
}
