package .com.study.api.models;

public class Person {

    private String name;
    private int age;

    //Get e Set
    public String getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public String setAge(int age) {
        this.age = age;
    }
    public String setName(String name) {
        this.name = name;
    }

}
