import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Prom extends JFrame {

    private TicketingSystem ticketingPanel;
    private boolean isVisible = true;
    //private FloorPlanSystem floorPlanPanel;    not our's
    private ArrayList<Student> students;
    private ArrayList<Table> tables;         // not our's, but I still made one

    Prom() {
        super("PROM 2021 SIGN UP");

        ticketingPanel = new TicketingSystem();
        this.add(ticketingPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 400);

        this.setVisible(isVisible);
        ticketingPanel.setBackground(Color.RED);
    }

    void redraw() {
        ticketingPanel.repaint();
        //User presses Cancel
    }

    boolean getVisibility() {
        return ticketingPanel.isVisible;
    }
}
