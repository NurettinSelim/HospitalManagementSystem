package model;

import java.util.HashMap;

public class Doctor {
    private HashMap<Integer, String> prescriptions;
    private HashMap<Integer, String> comments;
    private HashMap<Integer, String> nextCheckups;

    public Doctor() {
        prescriptions = new HashMap<>();
        comments = new HashMap<>();
        nextCheckups = new HashMap<>();
    }

    public String getPrescriptions() {
        StringBuilder sb = new StringBuilder();
        for (int patientId : prescriptions.keySet()) {
            sb.append("Patient ID: ").append(patientId).append(" - Prescriptions: ");
            sb.append(prescriptions.get(patientId)).append("\n");
        }
        return sb.toString();
    }

    public String getComments() {
        StringBuilder sb = new StringBuilder();
        for (int patientId : comments.keySet()) {
            sb.append("Patient ID: ").append(patientId).append(" - Comments: ");
            sb.append(comments.get(patientId)).append("\n");
        }
        return sb.toString();
    }

    public String getNextCheckups() {
        StringBuilder sb = new StringBuilder();
        for (int patientId : nextCheckups.keySet()) {
            sb.append("Patient ID: ").append(patientId).append(" - Next Checkup: ");
            sb.append(nextCheckups.get(patientId)).append("\n");
        }
        return sb.toString();
    }

    public void addPrescription(int patientId, String prescription) {
        prescriptions.put(patientId, prescription);
    }

    public void addComment(int patientId, String comment) {
        comments.put(patientId, comment);
    }

    public void addNextCheckupDate(int patientId, String nextCheckupDate) {
        nextCheckups.put(patientId, nextCheckupDate);
    }
}
