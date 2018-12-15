package JSONandXMLfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        Person firstPerson = new Person("Person1", 25);
        Person secondPerson = new Person("Person2", 29);

        People people = new People(Arrays.asList(firstPerson,secondPerson));

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(new FileOutputStream("output.xml"),people);
    }
}
