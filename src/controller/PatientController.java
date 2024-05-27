package controller;

import model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    private List<Patient> patients;
    private int currentId = 1;

    public PatientController() {
        patients = new ArrayList<>();
        // test data
        patients.add(new Patient(currentId++, "John", "Doe", 25, "123456789", "Male", "Cardiologist"));
        patients.add(new Patient(currentId++, "Jane", "Doe", 30, "987654", "Female", "Dermatologist"));
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatient(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        patient.setId(currentId++);
        patients.add(patient);
    }

    public void updatePatient(Patient updatedPatient) {
        for (Patient patient : patients) {
            if (patient.getId() == updatedPatient.getId()) {
                patient.setName(updatedPatient.getName());
                patient.setSurname(updatedPatient.getSurname());
                patient.setAge(updatedPatient.getAge());
                patient.setContactInformation(updatedPatient.getContactInformation());
                patient.setGender(updatedPatient.getGender());
                patient.setDoctorCategory(updatedPatient.getDoctorCategory());
                break;
            }
        }
    }

    public void deletePatient(int patientId) {
        patients.removeIf(patient -> patient.getId() == patientId);
    }
}
