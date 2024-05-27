package view;

import controller.DoctorController;
import controller.PatientController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JTabbedPane tabbedPane;
    private PatientView patientView;
    private DoctorView doctorView;

    public MainView() {
        setTitle("Hospital Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController(patientController);

        tabbedPane = new JTabbedPane();
        patientView = new PatientView(patientController);
        doctorView = new DoctorView(doctorController);

        tabbedPane.addTab("Patients", patientView);
        tabbedPane.addTab("Doctors", doctorView);

        tabbedPane.setSelectedIndex(1); // testing purposes
        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }
}
