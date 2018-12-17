package JsonAndXmlTasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AppMain {

    final static Logger logger = Logger.getLogger(AppMain.class);

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String continueAddPeople = "";

        People people = new People();

        do {
            System.out.println("person first name:");
            String scannerFirstName = scanner.nextLine();
            System.out.println("person second name:");
            String scannerSecondName = scanner.nextLine();
            System.out.println("person pesel number:");
            String scannerPesel = scanner.nextLine();
            logger.debug("convert pesel from String type to int");
            int peselNumber = Integer.valueOf(scannerPesel);

            Person person = new Person(scannerFirstName, scannerSecondName, peselNumber);

            people.addToPeple(person);

            System.out.println("If you want add new people type: new");
            continueAddPeople = scanner.nextLine();

        } while (continueAddPeople.equals("new"));

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(new FileOutputStream("peopleDataBase.xml"), people);


    }

}
