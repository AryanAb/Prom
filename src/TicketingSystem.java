import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TicketingSystem extends JPanel implements ActionListener {

    //Max number of partners
    final int MAX_PARTNER = 3;

    //layout
    private JPanel column;
    private JPanel fields;
    private JPanel buttonRow;
    private JPanel partnerBtnRow;

    private GroupLayout layout;

    private final String imgPath = "Richmond_Hill_HS_COA.jpg";

    //Formatting Group Layout
    GroupLayout.SequentialGroup hGroup;
    GroupLayout.SequentialGroup vGroup;
    GroupLayout.ParallelGroup pGroupLabel;
    GroupLayout.ParallelGroup pGroupField;
    //-------------------------------------------------

    // buttons
    private JButton submit;
    private JButton clear;
    private JButton cancel;
    private JButton addPartner;
    private JButton removePartner;

    // text fields
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField studentNumField;
    private ArrayList<JTextField> partnerFields;
    private ArrayList<JTextField> partnerNums;

    // labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel studentNumLabel;
    private ArrayList<JLabel> partnerLabels;
    private ArrayList<JLabel> partnerNumLabels;
    private JLabel invalid;

    public ArrayList<Student> students;

    TicketingSystem(ArrayList<Student> students) {

        this.students = students;

        ImageIcon icon = new ImageIcon(imgPath);
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

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        /*fields.setBackground(Color.CYAN);
        buttonRow.setBackground(Color.CYAN);
        partnerBtnRow.setBackground(Color.CYAN);*/
        column.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 5), "Sign Up Form"));


        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(300, 25));

        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(300, 25));

        studentNumLabel = new JLabel("Student Num:");
        studentNumField = new JTextField();
        studentNumField.setPreferredSize(new Dimension(300, 25));

        // at least one partner
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
        hGroup.addGroup(pGroupLabel.addComponent(firstNameLabel).addComponent(lastNameLabel).addComponent(studentNumLabel).addComponent(partnerLabels.get(0)).addComponent(partnerNumLabels.get(0)));
        hGroup.addGroup(pGroupField.addComponent(firstNameField).addComponent(lastNameField).addComponent(studentNumField).addComponent(partnerFields.get(0)).addComponent(partnerNums.get(0)));

        layout.setHorizontalGroup(hGroup);

        vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstNameLabel).addComponent(firstNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastNameLabel).addComponent(lastNameField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(studentNumLabel).addComponent(studentNumField));
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

    void clear() {
        firstNameField.setText("");
        lastNameField.setText("");
        studentNumField.setText("");

        for (int i = 0; i < partnerFields.size(); i++) {
            partnerFields.get(i).setText("");
            partnerNums.get(i).setText("");
        }

    }

    void partnerAdded() {
        JTextField partner = new JTextField();
        partner.setPreferredSize(new Dimension(300, 25));
        partnerFields.add(partner);

        JTextField num = new JTextField();
        num.setPreferredSize(new Dimension(300, 25));
        partnerNums.add(num);

        //partnerLabels.add(new JLabel("Partner " + (partnerLabels.size() + 1) + ": "));
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
        }*/

       /*for (int i = 0; i < partnerFields.size(); i++) {
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerLabels.get(i)).addComponent(partnerFields.get(i)));
        }*/

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerLabels.get(partnerLabels.size() - 1)).addComponent(partnerFields.get(partnerFields.size() - 1)));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(partnerNumLabels.get(partnerNumLabels.size() - 1)).addComponent(partnerNums.get(partnerNums.size() - 1)));

        column.revalidate();
        column.repaint();

    }

    void partnerRemoved() {
        partnerFields.get(partnerFields.size()-1).setVisible(false);
        partnerNums.get(partnerNums.size() - 1).setVisible(false);
        partnerLabels.get(partnerLabels.size()-1).setVisible(false);
        partnerNumLabels.get(partnerNumLabels.size() - 1).setVisible(false);

        partnerLabels.remove(partnerLabels.size() - 1);
        partnerFields.remove(partnerFields.size() - 1);
        partnerNums.remove(partnerNums.size() - 1);
        partnerNumLabels.remove(partnerNumLabels.size() - 1);

        column.revalidate();
        column.repaint();
    }

    boolean areFieldsFilled() {
        if(firstNameField.getText().equals("")) {return false;}
        else if(lastNameField.getText().equals("")) {return false;}
        else if(studentNumField.getText().equals("")) {return false;}

        for (int i = 0; i < partnerFields.size(); i++) {
            if(partnerFields.get(i).getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    boolean isParseable(JTextField number) {
        try{
            Integer.parseInt(number.getText().trim());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }


     boolean submitted() {
        if (!isParseable(studentNumField)) {
            invalid.setText("Student Number not appropriate. Please input properly.");
            invalid.setVisible(true);

            return false;
        }

        /*for (int i = 0; i < partnerNums.size(); i++) {
            if(!isParseable((partnerNums.get(i)))) {
                System.out.println("Partner Number " + (i+1) + " is not acceptable. Please input properly");
                return false;
            }
        }*/

            Student user = new Student(firstNameField.getText() + lastNameField.getText(), studentNumField.getText(), createPartnersList());
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

//    void submit() {
//        if (areFieldsFilled() && submitted()) {
//            System.out.println("Submitted");
//        } else {
//            invalid.setText("Error: One or more field was not filled.");
//            invalid.setVisible(true);
//        }
//    }

    void addStudent() {}
    void removeStudent() {}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                if (areFieldsFilled() && submitted()) {
                    invalid.setText("Profile submitted successfully!");
                    invalid.setForeground(Color.BLUE);
                    invalid.setVisible(true);

                    clear();

                    //isVisible = false;

                } else if (!areFieldsFilled()){
                    System.out.println("All fields are not filled");
                    invalid.setText("Error: One or more fields are not filled");
                    invalid.setVisible(true);
                }
            } else if (e.getSource() == clear) {
                clear();
            } else if (e.getSource() == cancel) {
                System.exit(0);
            } else if (e.getSource() == addPartner) {
                if (partnerFields.size() < MAX_PARTNER) {
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
