/*Class Name: Main
 * Version: 1.0
 * Authors: Nischay Uppal & Aryan Abed
 * Date: February 25,2018
 * Description: Loads and contains Ticketing System
 */

//TODO: CHANGE THE FONTS, Font's aren't loading up
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Prom extends JFrame {
    private TicketingSystem ticketingPanel;
    private ArrayList<Student> students;
    private final int SCROLL_UNIT = 30;
    //private ArrayList<Table> tables;
    Color darkGreen = new Color(0,128,0);

    Prom() {
        super("PROM 2021 SIGN UP");
        students = new ArrayList<>();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Font font1 = new Font("Crystal",Font.BOLD,12);
        this.setFont(font1);

        //Layout
        ticketingPanel = new TicketingSystem(students);
        this.add(ticketingPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize((((int)screen.getWidth())/2), (((int)screen.getHeight()) * 2/3));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ticketingPanel.setBackground(darkGreen);

        //Scroll Bar
        JScrollPane scrollPane = new JScrollPane(ticketingPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_UNIT);
        scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
        this.add(scrollPane);
    }
}