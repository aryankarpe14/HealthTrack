package models;

import javax.swing.*;
import java.awt.*;

public class Facility {
    private String name;

    public Facility() {}

    // Getter and setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void createDialog() {
        JFrame frame = new JFrame("New Facility Entry");
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField nameField = new JTextField();

        frame.add(new JLabel("Facility Name:"));
        frame.add(nameField);
        frame.add(new JLabel());
        frame.add(new JLabel());

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            setName(nameField.getText());
            JOptionPane.showMessageDialog(frame, "Facility added successfully!");
            frame.dispose();
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getName();
    }
}

