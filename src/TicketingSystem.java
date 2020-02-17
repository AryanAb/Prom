import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketingSystem extends JPanel {

    //layout
    private JPanel column;
    private JPanel fields;
    private JPanel buttonRow;

    private GroupLayout layout;

    // buttons
    private JButton submit;
    private JButton clear;
    private JButton cancel;

    // text fields
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField studentNumField;

    // labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel studentNumLabel;

    TicketingSystem() {

        fields = new JPanel();
        layout = new GroupLayout(fields);
        fields.setLayout(layout);

        buttonRow = new JPanel();

        column = new JPanel();
        column.setLayout(new BoxLayout(column, BoxLayout.PAGE_AXIS));

        layout.setAutoCreateGaps(true);

        layout.setAutoCreateContainerGaps(true);

        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 25));

        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 25));

        studentNumLabel = new JLabel("Student Number:");
        studentNumField = new JTextField();
        studentNumField.setPreferredSize(new Dimension(300, 25));

        submit = new JButton("Submit");
        submit.addActionListener(new ButtonListener());
        buttonRow.add(submit);

        clear = new JButton("Clear");
        clear.addActionListener(new ButtonListener());
        buttonRow.add(clear);

        cancel = new JButton("Cancel");
        cancel.addActionListener(new ButtonListener());
        buttonRow.add(cancel);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(firstNameLabel).addComponent(lastNameLabel).addComponent(studentNumLabel));
        hGroup.addGroup(layout.createParallelGroup().addComponent(firstNameField).addComponent(lastNameField).addComponent(studentNumField));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstNameLabel).addComponent(firstNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastNameLabel).addComponent(lastNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(studentNumLabel).addComponent(studentNumField));

        layout.setVerticalGroup(vGroup);


        column.add(fields);
        column.add(buttonRow);

        this.add(column);

    }

    void clear() {
        firstNameField.setText("");
        lastNameField.setText("");
        studentNumField.setText("");
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                System.out.println("submitted");
            } else if (e.getSource() == clear) {
                clear();
            }
        }

    }


}
