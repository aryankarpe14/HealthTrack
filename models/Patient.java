package models;

import javax.swing.*;
import java.awt.*;

public class Patient {
    private String id;
    private String name;
    private String disease;
    private String sex;
    private String admissionStatus;
    private int age;

    public Patient() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getAdmissionStatus() { return admissionStatus; }
    public void setAdmissionStatus(String admissionStatus) { this.admissionStatus = admissionStatus; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void createDialog() {
        JFrame frame = new JFrame("New Patient Entry");
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(7, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField diseaseField = new JTextField();
        JTextField sexField = new JTextField();
        JTextField statusField = new JTextField();
        JTextField ageField = new JTextField();

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Disease:"));
        frame.add(diseaseField);
        frame.add(new JLabel("Sex:"));
        frame.add(sexField);
        frame.add(new JLabel("Admission Status:"));
        frame.add(statusField);
        frame.add(new JLabel("Age:"));
        frame.add(ageField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // filler

        submitButton.addActionListener(e -> {
            try {
                setId(idField.getText());
                setName(nameField.getText());
                setDisease(diseaseField.getText());
                setSex(sexField.getText());
                setAdmissionStatus(statusField.getText());
                setAge(Integer.parseInt(ageField.getText()));
                JOptionPane.showMessageDialog(frame, "Patient added successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getDisease() + "\t" + getSex() + "\t" + 
               getAdmissionStatus() + "\t" + getAge();
    }
}

