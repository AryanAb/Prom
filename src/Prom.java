import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.MouseInfo.getPointerInfo;

class Prom extends JFrame {

    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    private TicketingSystem panel;

    //buttons;
    private JButton button;
    private JButton button1;

    private boolean aKeyPressed = false;
    private boolean clicked = true;

    public void clicked() {
        System.out.println("Hello World");
    }

    Prom() {
        super("Prom Sign Up");

        //Creates our panel
        panel = new TicketingSystem();
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set size of the frame
        this.setSize(600, 400);

        //Create mouse listener
        this.addMouseListener(new MyMouseListener());

        //Create key listener
        this.addKeyListener(new MyKeyListener());

        /*
        //Sets to fullscreen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        */

        //Sets visibility to true
        this.setVisible(true);

    }

    void redraw () {
        panel.repaint();
    }

    private class TicketingSystem extends JPanel {

        private JTextField firstName;
        private JTextField lastName;

        TicketingSystem () {
            // Create panel
            JPanel fieldsPanel = new JPanel();
            fieldsPanel.setLayout(new BoxLayout(fieldsPanel,BoxLayout.PAGE_AXIS));

            //Create textfield
            JLabel firstNameLabel = new JLabel("First Name: ");

            firstName = new JTextField();
            firstName.setPreferredSize(new Dimension(200, 20));
            fieldsPanel.add(firstNameLabel);
            fieldsPanel.add(firstName);

            JLabel lastNameLabel = new JLabel("Last Name: ");

            lastName = new JTextField();
            lastName.setPreferredSize(new Dimension(200, 20));
            fieldsPanel.add(lastNameLabel);
            fieldsPanel.add(lastName);

            this.add(fieldsPanel);




            button = new JButton("OK");
            button.addActionListener(new MyButtonListener());
            this.add(button, BorderLayout.CENTER);

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Draw Stuff Here

            //draw string
           // g.drawString(tf.getText(), 100, 300);
        }
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

    private class MyButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("OK");
        } else {
            System.out.println("Not OK");
        }
    }

    }

    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            if (button.contains((panel.getMousePosition()))) {
                clicked = !clicked;
            }
        }
    }
}
