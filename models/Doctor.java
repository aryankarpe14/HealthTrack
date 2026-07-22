package models;

import javax.swing.*;
import java.awt.*;

public class Doctor {
    private String id;
    private String name;
    private String specialist;
    private String appointment;
    private String qualification;
    private int roomNo;

    public Doctor() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialist() { return specialist; }
    public void setSpecialist(String specialist) { this.specialist = specialist; }
    public String getAppointment() { return appointment; }
    public void setAppointment(String appointment) { this.appointment = appointment; }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public int getRoomNo() { return roomNo; }
    public void setRoomNo(int roomNo) { this.roomNo = roomNo; }

    public void createDialog() {
        JFrame frame = new JFrame("New Doctor Entry");
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(7, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField specialistField = new JTextField();
        JTextField appointmentField = new JTextField();
        JTextField qualField = new JTextField();
        JTextField roomField = new JTextField();

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Specialization:"));
        frame.add(specialistField);
        frame.add(new JLabel("Appointment:"));
        frame.add(appointmentField);
        frame.add(new JLabel("Qualification:"));
        frame.add(qualField);
        frame.add(new JLabel("Room No.:"));
        frame.add(roomField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // filler

        submitButton.addActionListener(e -> {
            try {
                setId(idField.getText());
                setName(nameField.getText());
                setSpecialist(specialistField.getText());
                setAppointment(appointmentField.getText());
                setQualification(qualField.getText());
                setRoomNo(Integer.parseInt(roomField.getText()));
                JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid room number. Please enter a number.");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getSpecialist() + "\t" + getAppointment() + "\t" + 
               getQualification() + "\t" + getRoomNo();
    }
}

