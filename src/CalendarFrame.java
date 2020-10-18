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

public class CalendarFrame extends JFrame {
   // private CalendarSystem calendarPanel; // Visual 2D Calendar

    private Block[][] time;
    private ArrayList<Block> goals;
    private Schedule schedule;
    private User user;
    private Dimension screen;

    //Background Color
    public static Color athleticGold = new Color(194, 142, 12);

    CalendarFrame() {
        super("GOAL SETTING");
        //Init
        goals = new ArrayList<>();
        time = new Block[7][23];
        schedule = new Schedule();
        this.user = user;
        this.add(schedule);

        //Layout
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(((int)screen.getWidth()), ((int)screen.getHeight()));
        //this.setSize
        this.setLocationRelativeTo(null);
        schedule.setBackground(athleticGold);


        //Scroll Bar
//        JScrollPane scrollPane = new JScrollPane(ticketingPanel);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_UNIT);
//        scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
//        this.add(scrollPane);
        this.setVisible(true);
    }






    public void setUser(User c) {
        this.user = c;
    }

    public ArrayList<Block> getGoals() {
        return this.goals;
    }

    public void addToGoals(Block b) {
        this.goals.add(b);
    }

    public Block[][] getTime() {
        return time;
    }
}