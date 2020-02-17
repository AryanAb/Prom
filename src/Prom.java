import javax.swing.*;

public class Prom extends JFrame {

    private TicketingSystem menuPanel;

    Prom() {
        super("Prom Sign Up");

        menuPanel = new TicketingSystem();
        this.add(menuPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600, 400);

        this.setVisible(true);
    }

    void redraw() {
        menuPanel.repaint();
    }

}
