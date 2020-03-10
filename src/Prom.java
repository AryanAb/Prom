/*Class Name: Main
 * @version: 1.0
 * @authors: Nischay Uppal & Aryan Abed
 * @date: February 25,2018
 * @description: Loads and contains Ticketing System
 */

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Prom extends JFrame {

    //TicketingSystem object
    private Menu menu;
    private TicketingSystem ticketingPanel;
    private FloorPlanSystem floorPanel;

    //Master List of Students
    private ArrayList<Student> students;

    //Scroll Bar increments
    private final int SCROLL_UNIT = 30;

    //Background Color
    Color darkGreen = new Color(0,128,0);

    Prom() {
        super("PROM 2021 SIGN UP");

        //Init
        students = new ArrayList<>();
        ticketingPanel = new TicketingSystem(this);
        floorPanel = new FloorPlanSystem(this);
        menu = new Menu(this);

        this.add(menu);

        //Layout
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(((int)screen.getWidth()), ((int)screen.getHeight()));
        //this.setSize
        this.setLocationRelativeTo(null);
        ticketingPanel.setBackground(darkGreen);

        //Scroll Bar
//        JScrollPane scrollPane = new JScrollPane(ticketingPanel);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_UNIT);
//        scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
//        this.add(scrollPane);
        this.setVisible(true);
    }

    /**
     getTicketingPanel()
     This method gets Ticketing Panel System
     @return TicketingSystem
     */
    public TicketingSystem getTicketingPanel() {
        return ticketingPanel;
    }

    /**
     getFloorPanel()
     This method gets Floor Panel System
     @return FloorPlanSystem
     */
    public FloorPlanSystem getFloorPanel() {
        return floorPanel;
    }

    /**
     getMenu()
     This method gets the menu of the Prom application
     @return Menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     getStudents()
     This method gets the masterlist of students
     @return ArrayList<Student>
     */
    public ArrayList<Student> getStudents() {
        return this.students;
    }
}