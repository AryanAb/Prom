import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JButton addPartner;

    // text fields
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField studentNumField;
    private ArrayList<JTextField> partnerFields;

    // labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel studentNumLabel;
    private ArrayList<JLabel> partnerLabels;

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

        addPartner = new JButton("Add Partner");
        addPartner.addActionListener(new ButtonListener());

        // at least one partner
        partnerFields = new ArrayList<>();
        partnerLabels = new ArrayList<>();

        partnerFields.add(new JTextField());
        partnerLabels.add(new JLabel("Partner 1"));

        for (int i = 0; i < partnerFields.size(); i++) {
            partnerFields.get(i).setPreferredSize(new Dimension(300, 25));
            column.add(partnerLabels.get(i));
            column.add(partnerFields.get(i));

            if (i == partnerFields.size() - 1) {
                column.add(addPartner);
            }

        }

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

    void partnerAdded() {
        partnerFields.add(new JTextField());
        partnerLabels.add(new JLabel("Partner" + (partnerLabels.size() + 1)));

        for (int i = 0; i < partnerFields.size(); i++) {
            partnerFields.get(i).setPreferredSize(new Dimension(300, 25));
            column.add(partnerLabels.get(i));
            column.add(partnerFields.get(i));

            if (i == partnerFields.size() - 1) {
                column.add(addPartner);
            }

        }

        column.revalidate();
        column.repaint();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                System.out.println("submitted");
            } else if (e.getSource() == clear) {
                clear();
            } else if (e.getSource() == cancel) {
                System.exit(0); //TODO: Replace this later on with .dispose()
            } else if (e.getSource() == addPartner) {
                partnerAdded();

            }
        }

    }


}
