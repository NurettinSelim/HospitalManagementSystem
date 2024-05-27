package view;

import controller.DoctorController;
import model.Doctor;
import model.Patient;

import javax.swing.*;
import java.awt.*;

public class DoctorView extends JPanel {
    private JTextArea patientDetailsArea;
    private JButton fetchPatientDetailsButton;
    private JButton prescriptionButton;
    private JButton commentsButton;
    private JButton nextCheckupButton;
    private JTextArea prescriptionArea;
    private JTextArea commentsArea;
    private JTextArea nextCheckupArea;

    public DoctorView(DoctorController doctorController) {
        Doctor doctor = doctorController.getDoctor();

        setLayout(new GridLayout(3, 3, 4, 4));

        patientDetailsArea = new JTextArea();
        patientDetailsArea.setEditable(false);
        fetchPatientDetailsButton = new JButton("Fetch Patient Details");
        prescriptionButton = new JButton("Prescription");
        commentsButton = new JButton("Comments");
        nextCheckupButton = new JButton("Next Checkup");
        prescriptionArea = new JTextArea(doctor.getPrescriptions());
        prescriptionArea.setEditable(false);
        commentsArea = new JTextArea(doctor.getComments());
        commentsArea.setEditable(false);
        nextCheckupArea = new JTextArea(doctor.getNextCheckups());
        nextCheckupArea.setEditable(false);

        add(patientDetailsArea);
        add(fetchPatientDetailsButton);
        add(prescriptionButton);
        add(commentsButton);
        add(nextCheckupButton);
        add(prescriptionArea);
        add(commentsArea);
        add(nextCheckupArea);

        // Button listeners
        fetchPatientDetailsButton.addActionListener(e -> {
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid patient ID");
                return;
            }
            Patient patient = doctorController.getPatient(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Patient not found");
                return;
            }

            patientDetailsArea.setText(patient.toText("\n"));
        });

        prescriptionButton.addActionListener(e -> {
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid patient ID");
                return;
            }
            Patient patient = doctorController.getPatient(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Patient not found");
                return;
            }

            String prescription = JOptionPane.showInputDialog("Enter prescription:");
            doctor.addPrescription(patientId, prescription);
            prescriptionArea.setText(doctor.getPrescriptions());
        });

        commentsButton.addActionListener(e -> {
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid patient ID");
                return;
            }
            Patient patient = doctorController.getPatient(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Patient not found");
                return;
            }

            String comment = JOptionPane.showInputDialog("Enter comment:");
            doctor.addComment(patientId, comment);
            commentsArea.setText(doctor.getComments());
        });

        nextCheckupButton.addActionListener(e -> {
            int patientId;
            try {
                patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter patient ID:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid patient ID");
                return;
            }
            Patient patient = doctorController.getPatient(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(null, "Patient not found");
                return;
            }
            String nextCheckupDate = JOptionPane.showInputDialog("Enter next checkup date: (yyyy-MM-dd HH:mm)");
            if (!nextCheckupDate.matches("^\\d{4}-(0[1-9]|1[0-2])-([0-2][0-9]|3[0-1]) ([0-1][0-9]|2[0-3]):[0-5][0-9]$")) {
                JOptionPane.showMessageDialog(null, "Invalid date format");
                return;
            }

            doctor.addNextCheckupDate(patientId, nextCheckupDate);
            nextCheckupArea.setText(doctor.getNextCheckups());
        });
    }


}
