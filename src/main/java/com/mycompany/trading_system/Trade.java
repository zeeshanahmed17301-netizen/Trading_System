/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trading_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Gamerz
 */
public class Trade extends JFrame {

    private double balance = 100; 
    private double investment;
    private double buyPrice;
    private double sellPrice;

    
    public Trade() {
        setTitle("Trade Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(null);
                
        
        JLabel titleLabel = new JLabel("Trade");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(270, 10, 300, 30);
        mainPanel.add(titleLabel);

        JLabel selectProjectLabel = new JLabel("Select Project");
        selectProjectLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        selectProjectLabel.setBounds(20, 82, 150, 30);
        mainPanel.add(selectProjectLabel);

        String[] names = {"A", "B", "C", "D", "E"};
        JComboBox<String> comboBox = new JComboBox<>(names);
        comboBox.setBounds(160, 84, 100, 20);
        mainPanel.add(comboBox);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        priceLabel.setBounds(400, 130, 150, 30);
        mainPanel.add(priceLabel);

        JLabel balanceLabel = new JLabel("Balance: $" + balance);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setBounds(400, 170, 150, 30);
        mainPanel.add(balanceLabel);

        JLabel investmentLabel = new JLabel("Investment");
        investmentLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        investmentLabel.setBounds(20, 210, 300, 30);
        mainPanel.add(investmentLabel);

        JTextField investmentTextField = new JTextField();
        investmentTextField.setBounds(160, 215, 100, 22);
        mainPanel.add(investmentTextField);

        JLabel validityLabel = new JLabel();
        validityLabel.setFont(new Font("Arial", Font.BOLD, 15));
        validityLabel.setBounds(280, 212, 300, 30);
        mainPanel.add(validityLabel);

        JLabel buyLabel = new JLabel("Buying Price");
        buyLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        buyLabel.setBounds(20, 240, 300, 30);
        mainPanel.add(buyLabel);

        JTextField buyTextField = new JTextField();
        buyTextField.setBounds(160, 245, 100, 22);
        mainPanel.add(buyTextField);

        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        quantityLabel.setBounds(400, 210, 100, 30);
        mainPanel.add(quantityLabel);

        JLabel calculatedQuantityLabel = new JLabel();
        calculatedQuantityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        calculatedQuantityLabel.setBounds(465, 210, 300, 30);
        mainPanel.add(calculatedQuantityLabel);

        JLabel sellLabel = new JLabel("Selling Price");
        sellLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        sellLabel.setBounds(20, 270, 100, 30);
        mainPanel.add(sellLabel);

        JTextField sellTextField = new JTextField();
        sellTextField.setBounds(160, 275, 100, 22);
        mainPanel.add(sellTextField);

        JLabel profitLabel = new JLabel("PNL:");
        profitLabel.setFont(new Font("Arial", Font.BOLD, 16));
        profitLabel.setBounds(400, 250, 300, 40);
        mainPanel.add(profitLabel);

        JLabel calculatedProfitLabel = new JLabel();
        calculatedProfitLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        calculatedProfitLabel.setBounds(475, 250, 300, 40);
        mainPanel.add(calculatedProfitLabel);

      
        investmentTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    investment = Double.parseDouble(investmentTextField.getText());
                    if (investment > balance) {
                        validityLabel.setText("INVALID!");
                        validityLabel.setForeground(Color.RED);

                    } else {
                        validityLabel.setText("VALID!");
                        validityLabel.setForeground(Color.GREEN);

                    }
                } catch (NumberFormatException ex) {
                    validityLabel.setText("INVALID!");
                    validityLabel.setForeground(Color.RED);

                }
            }
        });


        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedProject = (String) comboBox.getSelectedItem();
                String price = getPrice(selectedProject);
                priceLabel.setText("Price: $" + price);


                calculateQuantity(selectedProject, buyTextField.getText(), calculatedQuantityLabel);
            }
        });

        buyTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedProject = (String) comboBox.getSelectedItem();
                calculateQuantity(selectedProject, buyTextField.getText(), calculatedQuantityLabel);
            }
        });


        sellTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    buyPrice = Double.parseDouble(buyTextField.getText());
                    sellPrice = Double.parseDouble(sellTextField.getText());
                    double profitPercentage = calculateProfitPercentage();
                    if (profitPercentage >= 0) {
                        calculatedProfitLabel.setForeground(Color.GREEN);
                    } else {
                        calculatedProfitLabel.setForeground(Color.RED);
                    }
                    calculatedProfitLabel.setText("" +String.format("%.2f", profitPercentage)+ "%");



                    updateBalance();
                    balanceLabel.setText("Balance: $" + balance);
                } catch (NumberFormatException ex) {
                    calculatedProfitLabel.setText("");
                }
            }
        });
        

        JPanel designPanel = Design.createDiagonalSplitPanel();
        designPanel.setBounds(0, 0, 600, 500);
        mainPanel.add(designPanel);


        add(mainPanel);
        setVisible(true);
    }

    private String getPrice(String project) {
        switch (project) {
            case "A":
                return "1";
            case "B":
                return "2";
            case "C":
                return "3";
            case "D":
                return "4";
            case "E":
                return "5";
            default:
                return "0";
        }
    }


    private void calculateQuantity(String selectedProject, String buyText, JLabel calculatedQuantityLabel) {
        try {
            buyPrice = Double.parseDouble(buyText);
            if (investment <= balance && buyPrice <= Double.parseDouble(getPrice(selectedProject))) {
                double quantity = investment / buyPrice;
                calculatedQuantityLabel.setText(": " +String.format("%.2f", quantity));
            } else {
                calculatedQuantityLabel.setText("");
            }
        } catch (NumberFormatException ex) {
            calculatedQuantityLabel.setText("");
        }
    }


    private double calculateProfitPercentage() {
        double profitOrLoss = sellPrice - buyPrice;
        double percentage = (profitOrLoss / buyPrice) * 100;
        return percentage;
    }


    private void updateBalance() {
        balance += calculateTotalAmount() - investment;
    }


    private double calculateTotalAmount() {
        double profit = (investment * calculateProfitPercentage()) / 100;
        return Math.round((investment + profit) * 100.0) / 100.0;
    }

    public double getBalance() {
        return balance;
    }

}

























