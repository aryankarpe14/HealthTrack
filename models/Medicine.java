package models;

import javax.swing.*;
import java.awt.*;

public class Medicine {
    private String name;
    private String company;
    private String expiryDate;
    private int cost;
    private int quantity;

    public Medicine() {}

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public int getCost() { return cost; }
    public void setCost(int cost) { this.cost = cost; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void createDialog() {
        JFrame frame = new JFrame("New Medicine Entry");
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(7, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JTextField nameField = new JTextField();
        JTextField companyField = new JTextField();
        JTextField expiryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField quantityField = new JTextField();

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Company:"));
        frame.add(companyField);
        frame.add(new JLabel("Expiry Date:"));
        frame.add(expiryField);
        frame.add(new JLabel("Cost:"));
        frame.add(costField);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        frame.add(new JLabel()); // filler

        submitButton.addActionListener(e -> {
            try {
                setName(nameField.getText());
                setCompany(companyField.getText());
                setExpiryDate(expiryField.getText());
                setCost(Integer.parseInt(costField.getText()));
                setQuantity(Integer.parseInt(quantityField.getText()));
                JOptionPane.showMessageDialog(frame, "Medicine added successfully!");
                frame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid cost or quantity. Please enter numbers.");
            }
        });

        frame.setVisible(true);
    }

    @Override
    public String toString() {
        return getName() + "\t" + getCompany() + "\t" + getExpiryDate() + "\t" + getCost();
    }
}

