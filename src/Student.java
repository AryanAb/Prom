/*Class Name: Student
 * @version: 1.0
 * @author: Nischay Uppal & Aryan Abed
 * @date: February 25,2018
 * @description: Initializing Student Object
 * */

import java.util.ArrayList;
import java.util.Objects;

public class Student {

    //Attributes
    private String name;
    private String  id;
    private ArrayList<Student> partners;
    private ArrayList<String> accommodations;
    private boolean paid;

    //Initializer
    Student(String name, String  id, ArrayList<Student> partners) {
        this.name = name;
        this.id = id;
        this.partners = partners;
        accommodations = new ArrayList<String>();
    }

    //Initializer
    Student(String name, String id) {
        this.name = name;
        this.id = id;
        partners = new ArrayList<>();
        accommodations = new ArrayList<String>();
    }

    /**
     getName()
     This method gets Student Name
     @return void
     */
    public String getName() {
        return name;
    }

    /**
     getId()
     This method gets Student Id
     @return String, id
     */
    public String getId() {
        return id;
    }

    /**
     getPartners()
     This method gets Student's arrayList of partners wanted
     @return ArrayList<String>, accommodations
     */
    public ArrayList<String> getAccommodations() {
        return accommodations;
    }

    /**
     hasPaid()
     This method returns whether student has paid
     @return boolean, paid
     */
    public boolean hasPaid() {
        return paid;
    }

    /**
     getPartners()
     This method gets Student's arrayList of partners wanted
     @return ArrayList<Student>, partners
     */
    public ArrayList<Student> getPartners() {
        return partners;
    }

    /**
     setPartners()
     This method sets Student's arrayList of partners wanted
     @param //ArrayList<Student>, partners
     @return void
     */
    public void setPartners(ArrayList<Student> partners) {
        this.partners = partners;
    }

    /**
     setPaid()
     This method sets whether student has paid
     @param //boolean, hasPaid
     @return void
     */
    public void setPaid(boolean hasPaid) {
        this.paid = hasPaid;
    }

    /**
     setAccommodations()
     This method sets Student's preferred accomodations
     @param //ArrayList<Student>, accommodations
     @return void
     */
    public void setAccommodations (ArrayList<String> accommodations) {
        this.accommodations = accommodations;
    }

    /**
     equals()
     This method compares attributes of an Object
     @param //Object
     @return boolean, whether names and id's equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  Objects.equals(name, student.name) &&
                Objects.equals(id, student.id);
    }
}
