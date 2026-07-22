package models;

import javax.swing.*;
import java.awt.*;

public class Staff {
    private String id;
    private String name;
    private String designation;
    private String sex;
    private int salary;

    public Staff() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public void createDialog() {
        JFrame frame = new JFrame("New Staff Entry");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField desgField = new JTextField();
        JTextField sexField = new JTextField();
        JTextField salaryField = new JTextField();

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Designation:"));
        frame.add(desgField);
        frame.add(new JLabel("Sex:"));
        frame.add(sexField);
        frame.add(new JLabel("Salary:"));
        frame.add(salaryField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // filler

        submitButton.addActionListener(e -> {
            try {
                setId(idField.getText());
                setName(nameField.getText());
                setDesignation(desgField.getText());
                setSex(sexField.getText());
                setSalary(Integer.parseInt(salaryField.getText()));
                JOptionPane.showMessageDialog(frame, "Staff added successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid salary. Please enter a number.");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getDesignation() + "\t" + getSex() + "\t" + getSalary();
    }
}

