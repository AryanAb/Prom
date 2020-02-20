import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//TODO: FIX LAYOUTS AND ADD IMAGES/GIFS TO LIVEN THINGS UP
//
public class TicketingSystem extends JPanel {
    //Max number of partners
    final int MAX_PARTNER = 3;

    //------------------------------------------------------------ DONT MODIFY OR ADD ANY PROPERTIES HERE. WASTE OF TIME
    //layout
    private JPanel column;
    private JPanel fields;
    private JPanel buttonRow;
    private JPanel partnerBtnRow;

    private GroupLayout layout;

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

    //Input isValid

    TicketingSystem() {

        fields = new JPanel();
        layout = new GroupLayout(fields);
        fields.setLayout(layout);

        buttonRow = new JPanel();
        partnerBtnRow = new JPanel();

        column = new JPanel();
        column.setLayout(new BoxLayout(column, BoxLayout.PAGE_AXIS));

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        fields.setBackground(Color.CYAN);
        buttonRow.setBackground(Color.CYAN);
        partnerBtnRow.setBackground(Color.CYAN);


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
        addPartner.addActionListener(new ButtonListener());
        partnerBtnRow.add(addPartner);

        removePartner = new JButton("Remove Partner");
        removePartner.addActionListener(new ButtonListener());
        partnerBtnRow.add(removePartner);

        submit = new JButton("Submit");
        submit.addActionListener(new ButtonListener());
        buttonRow.add(submit);

        clear = new JButton("Clear");
        clear.addActionListener(new ButtonListener());
        buttonRow.add(clear);

        cancel = new JButton("Cancel & Exit");
        cancel.addActionListener(new ButtonListener());
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

    void partnerRemoved() { //TODO this is broken, fix it


        partnerLabels.remove(partnerLabels.size() - 1);
        partnerFields.remove(partnerFields.size() - 1);
        partnerNums.remove(partnerNums.size() - 1);
        partnerNumLabels.remove(partnerNumLabels.size() - 1);

//        partnerFields.get(partnerFields.size()-1).setVisible(false);
//        partnerLabels.get(partnerLabels.size()-1).setVisible(false);

        partnerFields.get(partnerFields.size()-1).setVisible(false); //Setting PartnerField to false

        column.revalidate();
        column.repaint();

    }

    boolean isParseable(JTextField number) {
        try{
            Integer.parseInt(number.getText());
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
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

     boolean submitted() {
        boolean NumIsOk = true;

        if (!isParseable(studentNumField)) {
            System.out.println("Student Number not appropriate. Please input properly.");
            NumIsOk = false;
//            return false;
        }
        for (int i = 0; i < partnerNums.size(); i++) {
            if(!isParseable((partnerNums.get(i)))) {
                System.out.println("Partner Number " + (i+1) + " is not acceptable. Please input properly");
                return false;
            }
        }
        if(!NumIsOk) {
            Student user = new Student(firstNameField.getText() + lastNameField.getText(), studentNumField.getText(), createPartnersList());
            return true;
        }
       return false;
    }

    ArrayList<Student> createPartnersList() {

        ArrayList<Student> partners = new ArrayList<>();

        for (int i = 0; i < partnerFields.size(); i++) {
            Student partner = new Student(partnerFields.get(i).getText(), partnerNums.get(i).getText());
            partners.add(partner);
        }

        return partners;

    }

    void addStudent() {}

    void removeStudent() {}

    boolean isVisible = true;

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                if (areFieldsFilled() && submitted()) {
                    System.out.println("The document was submitted");
                    isVisible = false;
                } else if (!areFieldsFilled()){
                    System.out.println("All fields are not filled");
                }
            } else if (e.getSource() == clear) {
                clear();
            } else if (e.getSource() == cancel) {
                System.out.println("Exiting in 1 second...");
                isVisible = false;
            } else if (e.getSource() == addPartner) {
                if (partnerFields.size() < MAX_PARTNER) {
                    partnerAdded();
                } else {
                    System.out.println("Unable to add more partners");
                }
            } else if (e.getSource() == removePartner) {
                partnerRemoved();
            }
        }
    }
}