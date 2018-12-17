package JsonAndXmlTasks;

public class Person {

    String firstName;
    String seconName;
    int pesel;

    public Person() {
    }

    public Person(String firstName, String seconName, int pesel) {
        this.firstName = firstName;
        this.seconName = seconName;
        this.pesel = pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSeconName(String seconName) {
        this.seconName = seconName;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSeconName() {
        return seconName;
    }

    public int getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", seconName='" + seconName + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
