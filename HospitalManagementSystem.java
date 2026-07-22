import models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalManagementSystem {
    private Staff[] staffs = new Staff[100];
    private Doctor[] doctors = new Doctor[25];
    private LabFacility[] labs = new LabFacility[20];
    private Patient[] patients = new Patient[100];
    private Medicine[] medicines = new Medicine[100];
    private Facility[] facilities = new Facility[20];

    private int staffCount = 0;
    private int doctorCount = 0;
    private int labCount = 0;
    private int patientCount = 0;
    private int medicineCount = 0;
    private int facilityCount = 0;

    private JTextArea displayArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalManagementSystem().createGUI());
    }

    private void createGUI() {
        JFrame frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Add buttons panel
        JPanel addPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add New"));

        JButton addStaffBtn = new JButton("New Staff");
        addStaffBtn.addActionListener(e -> {
            Staff staff = new Staff();
            staff.createDialog();
            if (staff.getId() != null && !staff.getId().trim().isEmpty() && staffCount < staffs.length) {
                staffs[staffCount++] = staff;
            }
        });
        addPanel.add(addStaffBtn);

        JButton addDoctorBtn = new JButton("New Doctor");
        addDoctorBtn.addActionListener(e -> {
            Doctor doctor = new Doctor();
            doctor.createDialog();
            if (doctor.getId() != null && !doctor.getId().trim().isEmpty() && doctorCount < doctors.length) {
                doctors[doctorCount++] = doctor;
            }
        });
        addPanel.add(addDoctorBtn);

        JButton addLabBtn = new JButton("New Lab Facility");
        addLabBtn.addActionListener(e -> {
            LabFacility lab = new LabFacility();
            lab.createDialog();
            if (lab.getFacility() != null && !lab.getFacility().trim().isEmpty() && labCount < labs.length) {
                labs[labCount++] = lab;
            }
        });
        addPanel.add(addLabBtn);

        JButton addPatientBtn = new JButton("New Patient");
        addPatientBtn.addActionListener(e -> {
            Patient patient = new Patient();
            patient.createDialog();
            if (patient.getId() != null && !patient.getId().trim().isEmpty() && patientCount < patients.length) {
                patients[patientCount++] = patient;
            }
        });
        addPanel.add(addPatientBtn);

        JButton addMedicineBtn = new JButton("New Medicine");
        addMedicineBtn.addActionListener(e -> {
            Medicine medicine = new Medicine();
            medicine.createDialog();
            if (medicine.getName() != null && !medicine.getName().trim().isEmpty() && medicineCount < medicines.length) {
                medicines[medicineCount++] = medicine;
            }
        });
        addPanel.add(addMedicineBtn);

        JButton addFacilityBtn = new JButton("New Facility");
        addFacilityBtn.addActionListener(e -> {
            Facility facility = new Facility();
            facility.createDialog();
            if (facility.getName() != null && !facility.getName().trim().isEmpty() && facilityCount < facilities.length) {
                facilities[facilityCount++] = facility;
            }
        });
        addPanel.add(addFacilityBtn);

        // View buttons panel
        JPanel viewPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        viewPanel.setBorder(BorderFactory.createTitledBorder("View Data"));

        JButton viewStaffBtn = new JButton("View Staff");
        viewStaffBtn.addActionListener(e -> displayStaff());
        viewPanel.add(viewStaffBtn);

        JButton viewDoctorsBtn = new JButton("View Doctors");
        viewDoctorsBtn.addActionListener(e -> displayDoctors());
        viewPanel.add(viewDoctorsBtn);

        JButton viewLabsBtn = new JButton("View Labs");
        viewLabsBtn.addActionListener(e -> displayLabs());
        viewPanel.add(viewLabsBtn);

        JButton viewPatientsBtn = new JButton("View Patients");
        viewPatientsBtn.addActionListener(e -> displayPatients());
        viewPanel.add(viewPatientsBtn);

        JButton viewMedicinesBtn = new JButton("View Medicines");
        viewMedicinesBtn.addActionListener(e -> displayMedicines());
        viewPanel.add(viewMedicinesBtn);

        JButton viewFacilitiesBtn = new JButton("View Facilities");
        viewFacilitiesBtn.addActionListener(e -> displayFacilities());
        viewPanel.add(viewFacilitiesBtn);

        // Central display
        displayArea = new JTextArea(20, 60);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        mainPanel.add(addPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(viewPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Display methods
    private void displayStaff() {
        StringBuilder sb = new StringBuilder("=== STAFF ===\nID\tName\tDesignation\tSex\tSalary\n");
        sb.append("-------------------------------------------\n");
        for (int i = 0; i < staffCount; i++) {
            sb.append(staffs[i]).append("\n");
        }
        if (staffCount == 0) sb.append("No staff records.\n");
        displayArea.setText(sb.toString());
    }

    private void displayDoctors() {
        StringBuilder sb = new StringBuilder("=== DOCTORS ===\nID\tName\tSpecialist\tAppt\tQual\tRoom\n");
        sb.append("----------------------------------------------------\n");
        for (int i = 0; i < doctorCount; i++) {
            sb.append(doctors[i]).append("\n");
        }
        if (doctorCount == 0) sb.append("No doctor records.\n");
        displayArea.setText(sb.toString());
    }

    private void displayLabs() {
        StringBuilder sb = new StringBuilder("=== LAB FACILITIES ===\nFacility\tCost\n");
        sb.append("-------------\n");
        for (int i = 0; i < labCount; i++) {
            sb.append(labs[i]).append("\n");
        }
        if (labCount == 0) sb.append("No lab records.\n");
        displayArea.setText(sb.toString());
    }

    private void displayPatients() {
        StringBuilder sb = new StringBuilder("=== PATIENTS ===\nID\tName\tDisease\tSex\tStatus\tAge\n");
        sb.append("----------------------------------------\n");
        for (int i = 0; i < patientCount; i++) {
            sb.append(patients[i]).append("\n");
        }
        if (patientCount == 0) sb.append("No patient records.\n");
        displayArea.setText(sb.toString());
    }

    private void displayMedicines() {
        StringBuilder sb = new StringBuilder("=== MEDICINES ===\nName\tCompany\tExpiry\tCost\n");
        sb.append("------------------------\n");
        for (int i = 0; i < medicineCount; i++) {
            sb.append(medicines[i]).append("\n");
        }
        if (medicineCount == 0) sb.append("No medicine records.\n");
        displayArea.setText(sb.toString());
    }

    private void displayFacilities() {
        StringBuilder sb = new StringBuilder("=== FACILITIES ===\nFacility\n");
        sb.append("--------\n");
        for (int i = 0; i < facilityCount; i++) {
            sb.append(facilities[i]).append("\n");
        }
        if (facilityCount == 0) sb.append("No facility records.\n");
        displayArea.setText(sb.toString());
    }
}

