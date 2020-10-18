import javax.swing.*;

public class PersonalInformation {
    private JPanel panel1;
    private JTextField UserNametextField;
    private JTextField GendertextField;
    private JTextField OccupationtextField;
    private JCheckBox checkIfYouWantCheckBox;
    private JTextField AgeTextField;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void UserInputs() {
        String Name = UserNametextField.getText();
        String Gender = GendertextField.getText();
        String Occupation = OccupationtextField.getText();
        String Age = AgeTextField.getText();
        Age = Age.trim();
        int value;
        if (Age.length() == 0) {
            value = 0;
        } else {
            try {
                value = Integer.parseInt(Age);
            } catch (NumberFormatException e) {
                value = 0;
            }
        }
    }

}
