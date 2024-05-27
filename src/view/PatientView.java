package view;

import controller.PatientController;
import model.Patient;

import javax.swing.*;
import java.awt.*;

public class PatientView extends JPanel {
    private PatientController patientController;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JTextField contactInfoField;
    private JTextField genderField;
    private JTextField doctorCategoryField;
    private JButton submitButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextArea patientListArea;

    public PatientView(PatientController patientController) {
        this.patientController = patientController;

        setLayout(new GridLayout(8, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Surname:"));
        surnameField = new JTextField();
        add(surnameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Contact Information:"));
        contactInfoField = new JTextField();
        add(contactInfoField);

        add(new JLabel("Gender:"));
        genderField = new JTextField();
        add(genderField);

        add(new JLabel("Doctor Category:"));
        doctorCategoryField = new JTextField();
        add(doctorCategoryField);

        submitButton = new JButton("Submit");
        add(submitButton);

        deleteButton = new JButton("Delete");
        add(deleteButton);

        updateButton = new JButton("Update");
        add(updateButton);


        // Patient list area
        patientListArea = new JTextArea();
        patientListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(patientListArea);
        add(scrollPane);

        // Button listeners
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Age must be a number");
                return;
            }
            int age = Integer.parseInt(ageField.getText());
            String contactInfo = contactInfoField.getText();
            String gender = genderField.getText();
            String doctorCategory = doctorCategoryField.getText();

            Patient patient = new Patient(0, name, surname, age, contactInfo, gender, doctorCategory);
            patientController.addPatient(patient);
            updatePatientList();
            clearForm();
            // show success message
            JOptionPane.showMessageDialog(null, "Patient added successfully");
        });

        deleteButton.addActionListener(e -> {
            // open a dialog to get the patient id
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Patient ID must be a number");
                return;
            }
            patientController.deletePatient(patientId);
            updatePatientList();
            // show success message
            JOptionPane.showMessageDialog(null, "Patient deleted successfully");
        });

        updateButton.addActionListener(e -> {
            // open a dialog to get the patient id
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Patient ID must be a number");
                return;
            }

            String name = nameField.getText();
            String surname = surnameField.getText();
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Age must be a number");
                return;
            }
            int age = Integer.parseInt(ageField.getText());
            String contactInfo = contactInfoField.getText();
            String gender = genderField.getText();
            String doctorCategory = doctorCategoryField.getText();

            Patient patient = new Patient(patientId, name, surname, age, contactInfo, gender, doctorCategory);
            patientController.updatePatient(patient);
            updatePatientList();
            clearForm();
            // show success message
            JOptionPane.showMessageDialog(null, "Patient updated successfully");
        });
    }

    private void updatePatientList() {
        patientListArea.setText("");
        for (Patient patient : patientController.getAllPatients()) {
            patientListArea.append(patient.toText(", ") + "\n");
        }
    }

    private void clearForm() {
        nameField.setText("");
        surnameField.setText("");
        ageField.setText("");
        contactInfoField.setText("");
        genderField.setText("");
        doctorCategoryField.setText("");
    }
}
