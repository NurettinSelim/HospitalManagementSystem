
package controller;

import model.Doctor;
import model.Patient;


public class DoctorController {
    private PatientController patientController;
    private Doctor doctor = new Doctor();

    public DoctorController(PatientController patientController) {
        this.patientController = patientController;
    }

    public Patient getPatient(int patientId) {
        return patientController.getPatient(patientId);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void addPrescription(int patientId, String prescription) {
        doctor.addPrescription(patientId, prescription);
    }

    public void addComment(int patientId, String comment) {
        doctor.addComment(patientId, comment);
    }

    public void addNextCheckupDate(int patientId, String nextCheckupDate) {
        doctor.addNextCheckupDate(patientId, nextCheckupDate);
    }

}
