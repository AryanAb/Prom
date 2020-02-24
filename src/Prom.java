import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Prom extends JFrame {

    private TicketingSystem ticketingPanel;
    private boolean isVisible = true;
    //TODO change to private and set getters and setters
    public static ArrayList<Student> students;
    public static ArrayList<Table> tables;

    Prom() {
        super("PROM 2021 SIGN UP");

        students = new ArrayList<>();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Font font1 = new Font("Crystal",Font.BOLD,12); //TODO: CHANGE THE FONTS, Font's aren't loading up
        //Font font2 = new Font("Verdana",Font.PLAIN,14);
        this.setFont(font1);
        ticketingPanel = new TicketingSystem();
        this.add(ticketingPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Open in center of screen
        this.setSize(((int)screen.getWidth())/2, ((int)screen.getHeight()) * 2/3);
        this.setLocationRelativeTo(null);

        this.setVisible(isVisible);
        //ticketingPanel.setBackground(Color.GREEN);
    }

    void redraw() { ticketingPanel.repaint(); }

    boolean getVisibility() {
        return ticketingPanel.isVisible;
    }
}
