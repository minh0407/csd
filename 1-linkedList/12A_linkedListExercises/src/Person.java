
public class Person {

    String name;
    int age;

    Person() { //tạo constructor không tham số
    }

    Person(String xName, int xAge) {
        name = xName; //truyền tham số cho name và age
        age = xAge;
    }

    public String toString() {
        return ("(" + name + ", " + age + ") ");
    }
}
