package models;

import javax.swing.*;
import java.awt.*;

public class LabFacility {
    private String facility;
    private int cost;

    public LabFacility() {}

    // Getters and setters
    public String getFacility() { return facility; }
    public void setFacility(String facility) { this.facility = facility; }
    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }

    public void createDialog() {
        JFrame frame = new JFrame("New Lab Facility Entry");
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField facilityField = new JTextField();
        JTextField costField = new JTextField();

        frame.add(new JLabel("Facility:"));
        frame.add(facilityField);
        frame.add(new JLabel("Cost:"));
        frame.add(costField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // filler
        frame.add(new JLabel()); // filler

        submitButton.addActionListener(e -> {
            try {
                setFacility(facilityField.getText());
                setCost(Integer.parseInt(costField.getText()));
                JOptionPane.showMessageDialog(frame, "Lab facility added successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid cost. Please enter a number.");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getFacility() + "\t" + getCost();
    }
}

