
public class Student {
    private String name;
    private int id;

    public Student() {
        this.name = "Unknown";
        this.id = 0;
    }

    //Set Name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }


}
