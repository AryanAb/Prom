/*Class Name: TicketingSystem
 * Version: 1.0
 * Authors: Nischay Uppal & Aryan Abed
 * Date: February 25,2018
 * Description: Running Core Ticketing System for user
 * */

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;

public class TicketingSystem extends JPanel implements ActionListener {

    private final int MAX_PARTNERS = 7;
    private final String imagePath = "Richmond_Hill_HS_COA.jpg";
    private ArrayList<Student> students;

    //layout
    private JPanel column,fields,buttonRow,partnerBtnRow;

    //Formatted Layout
    private GroupLayout layout;
    GroupLayout.SequentialGroup hGroup,vGroup;
    GroupLayout.ParallelGroup pGroupLabel,pGroupField;

    //Buttons
    private JButton submit,clear,cancel,addPartner,removePartner;

    //Text Fields
    private JTextField firstNameField,lastNameField, restrictionsField, studentNumField;
    private ArrayList<JTextField> partnerFields,partnerNums;

    //Labels
    private JLabel firstNameLabel,lastNameLabel,restrictions, studentNumLabel,invalid;
    private ArrayList<JLabel> partnerLabels,partnerNumLabels;

    TicketingSystem(ArrayList<Student> students) {
        this.students = students;

        ImageIcon icon = new ImageIcon(imagePath);
        icon.getImage().flush();

        JLabel background = new JLabel();
        background.setIcon(icon);
        background.setLayout(new BorderLayout());

        invalid = new JLabel();
        invalid.setForeground(Color.red);
        invalid.setVisible(false);
        invalid.setHorizontalAlignment(SwingConstants.LEFT);
        invalid.setAlignmentX(Component.CENTER_ALIGNMENT);

        fields = new JPanel();
        layout = new GroupLayout(fields);
        fields.setLayout(layout);

        buttonRow = new JPanel();
        partnerBtnRow = new JPanel();
        column = new JPanel();

        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Sign Up Form"));

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 25));

        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 25));

        restrictions = new JLabel("Accommodations:");
        restrictionsField = new JTextField();
        restrictionsField.setPreferredSize(new Dimension(300, 25));

        studentNumLabel = new JLabel("Student Num:");
        studentNumField = new JTextField();
        studentNumField.setPreferredSize(new Dimension(300, 25));

        //Minimum 1 partner per student
        partnerFields = new ArrayList<>();
        partnerLabels = new ArrayList<>();
        partnerNums = new ArrayList<>();
        partnerNumLabels = new ArrayList<>();

        partnerFields.add(new JTextField());
        partnerFields.get(0).setPreferredSize(new Dimension(300, 25));
        partnerLabels.add(new JLabel("Partner 1 Name:"));

        partnerNums.add(new JTextField());
        partnerNums.get(0).setPreferredSize(new Dimension(300, 25));
        partnerNumLabels.add(new JLabel("Partner 1 Num:"));

        //Buttons
        addPartner = new JButton("Add Partner");
        addPartner.addActionListener(this);
        partnerBtnRow.add(addPartner);

        removePartner = new JButton("Remove Partner");
        removePartner.addActionListener(this);
        partnerBtnRow.add(removePartner);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        buttonRow.add(submit);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        buttonRow.add(clear);

        cancel = new JButton("Cancel & Exit");
        cancel.addActionListener(this);
        buttonRow.add(cancel);

        //Groupings
        pGroupLabel = layout.createParallelGroup();
        pGroupField = layout.createParallelGroup();

        hGroup = layout.createSequentialGroup();
        hGroup.addGroup(pGroupLabel.addComponent(firstNameLabel).addComponent(lastNameLabel).addComponent(studentNumLabel).addComponent(restrictions).addComponent(partnerLabels.get(0)).addComponent(partnerNumLabels.get(0)));
        hGroup.addGroup(pGroupField.addComponent(firstNameField).addComponent(lastNameField).addComponent(studentNumField).addComponent(restrictionsField).addComponent(partnerFields.get(0)).addComponent(partnerNums.get(0)));

        layout.setHorizontalGroup(hGroup);

        vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstNameLabel).addComponent(firstNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastNameLabel).addComponent(lastNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(studentNumLabel).addComponent(studentNumField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(restrictions).addComponent(restrictionsField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerLabels.get(0)).addComponent(partnerFields.get(0)));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerNumLabels.get(0)).addComponent(partnerNums.get(0)));
        layout.setVerticalGroup(vGroup);

        column.add(fields);
        column.add(partnerBtnRow);
        column.add(buttonRow);
        column.add(invalid);

        this.add(background);
        this.add(column);
    }

    private void clearPanel() {
        firstNameField.setText("");
        lastNameField.setText("");
        studentNumField.setText("");
        restrictionsField.setText("");

        for (int i = 0; i < partnerFields.size(); i++) {
            partnerFields.get(i).setText("");
            partnerNums.get(i).setText("");
        }
    }

    private void partnerAdded() {
        JTextField partner = new JTextField();
        partner.setPreferredSize(new Dimension(300, 25));
        partnerFields.add(partner);

        JTextField num = new JTextField();
        num.setPreferredSize(new Dimension(300, 25));
        partnerNums.add(num);

        JLabel label = new JLabel("Partner " + (partnerLabels.size() + 1) + " Name: ");
        partnerLabels.add(label);

        JLabel labelNum = new JLabel("Partner " + (partnerNumLabels.size() + 1) + " Num: ");
        partnerNumLabels.add(labelNum);

        pGroupLabel.addComponent(label);
        pGroupField.addComponent(partner);
        pGroupLabel.addComponent(labelNum);
        pGroupField.addComponent(num);

        /*for (int i = 0; i < partnerFields.size(); i++) {
            pGroupLabel.addComponent(partnerLabels.get(i));
            pGroupField.addComponent(partnerFields.get(i));
        }

        for (int i = 0; i < partnerFields.size(); i++) {
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerLabels.get(i)).addComponent(partnerFields.get(i)));
        }*/

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerLabels.get(partnerLabels.size() - 1)).addComponent(partnerFields.get(partnerFields.size() - 1)));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerNumLabels.get(partnerNumLabels.size() - 1)).addComponent(partnerNums.get(partnerNums.size() - 1)));

        column.revalidate();
        column.repaint();
    }

    private void partnerRemoved() {
        partnerFields.get(partnerFields.size() - 1).setVisible(false);
        partnerNums.get(partnerNums.size() - 1).setVisible(false);
        partnerLabels.get(partnerLabels.size() - 1).setVisible(false);
        partnerNumLabels.get(partnerNumLabels.size() - 1).setVisible(false);

        partnerLabels.remove(partnerLabels.size() - 1);
        partnerFields.remove(partnerFields.size() - 1);
        partnerNums.remove(partnerNums.size() - 1);
        partnerNumLabels.remove(partnerNumLabels.size() - 1);

        column.revalidate();
        column.repaint();
    }

    private boolean areFieldsFilled() {
        if (firstNameField.getText().equals("")) {
            return false;
        } else if (lastNameField.getText().equals("")) {
            return false;
        } else if (studentNumField.getText().equals("")) {
            return false;
        }

        for (int i = 0; i < partnerFields.size(); i++) {
            if (partnerFields.get(i).getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private boolean isParseable(JTextField number) {
        try {
            Integer.parseInt(number.getText().trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isSubmitted() {
        if (!isParseable(studentNumField)) {
            invalid.setText("Student Number not appropriate. Please input properly.");
            invalid.setVisible(true);
            return false;
        }

        for (int i = 0; i < partnerNums.size(); i++) {
            if (!isParseable((partnerNums.get(i)))) {
                invalid.setForeground(Color.red);
                invalid.setText("A Partner Number " + (i + 1) + " is invalid.");
                invalid.setVisible(true);
                return false;
            } else {
                invalid.setVisible(false);
            }
        }

        String[] accomm = new String[restrictionsField.getText().split(" ").length];
        ArrayList<String> rest = new ArrayList<>();
        for (String c: accomm) {
            rest.add(c);
        }
        Student user = new Student(firstNameField.getText() + lastNameField.getText(), studentNumField.getText(), createPartnersList(), rest);
        students.add(user);

        for (int i = 0; i < partnerFields.size(); i++) {
            Student partner = new Student(partnerFields.get(i).getText(), partnerNums.get(i).getText());
            students.add(partner);
        }
        return true;
    }

    ArrayList<Student> createPartnersList() {
        ArrayList<Student> partners = new ArrayList<>();
        for (int i = 0; i < partnerFields.size(); i++) {
            Student partner = new Student(partnerFields.get(i).getText(), partnerNums.get(i).getText());
            partners.add(partner);
        }
        return partners;
    }

    private void addStudent() {}

    private void removeStudent() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (areFieldsFilled() && isSubmitted()) {
                invalid.setText("Profile submitted successfully!");
                invalid.setForeground(Color.GREEN.darker());
                invalid.setVisible(true);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                clearPanel();
            } else if (!areFieldsFilled()) {
                System.out.println("All fields are not filled");
                invalid.setText("Error: One or more fields are not filled");
                invalid.setVisible(true);
            }
        } else if (e.getSource() == clear) {
            clearPanel();
        } else if (e.getSource() == cancel) {
            System.exit(0);
        } else if (e.getSource() == addPartner) {
            if (partnerFields.size() < MAX_PARTNERS) {
                partnerAdded();
            } else {
                invalid.setText("Unable to add more partners");
                invalid.setVisible(true);
            }
        } else if (e.getSource() == removePartner) {
            if (partnerFields.size() > 1) {
                partnerRemoved();
            } else {
                invalid.setText("You need at least one partner!");
                invalid.setVisible(true);
            }
        }
    }
}