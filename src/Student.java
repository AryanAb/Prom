import java.util.ArrayList;

public class Student {

    private String name;
    private String  id;
    private ArrayList<Student> partners;
    private ArrayList<String> restrictions;
    private boolean paid;

    Student(String name, String  id, ArrayList<Student> partners, ArrayList<String> restrictions) {
        this.name = name;
        this.id = id;
        this.partners = partners;
        this.restrictions = restrictions;
    }

    Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean hasPaid() {
        return paid;
    }

    public ArrayList<Student> getPartners() {
        return partners;
    }

    public void setPartners(ArrayList<Student> partners) {
        this.partners = partners;
    }

    public void setPaid(boolean hasPaid) {
        this.paid = hasPaid;
    }

}
