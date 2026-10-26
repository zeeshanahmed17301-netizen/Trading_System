/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trading_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Gamerz
 */
public class UserDashboard extends JFrame {
    
    private List<String> deployedProjectNames;

    public UserDashboard() {
        setTitle("User Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(null); 

      
        JPanel designPanel = Design.createDiagonalSplitPanel();
        designPanel.setBounds(0, 0, 600, 500);

       
        JLabel titleLabel = new JLabel("User Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(180, 10, 300, 50);
        mainPanel.add(titleLabel);

        
        JLabel sideText = new JLabel("Select any Account");
        sideText.setForeground(Color.DARK_GRAY);
        sideText.setFont(new Font("Arial", Font.BOLD, 18));
        sideText.setBounds(20, 80, 400, 40);
        mainPanel.add(sideText);

        
        Font radioButtonFont = new Font("Arial", Font.PLAIN, 18);

        TransparentRadioButton account1 = new TransparentRadioButton("Account 1");
        account1.setFont(radioButtonFont);
        account1.setFocusPainted(false);
        account1.setAlignmentX(Component.LEFT_ALIGNMENT);
        account1.setBounds(20, 140, 300, 40);

        TransparentRadioButton account2 = new TransparentRadioButton("Account 2");
        account2.setFont(radioButtonFont);
        account2.setFocusPainted(false);
        account2.setAlignmentX(Component.LEFT_ALIGNMENT);
        account2.setBounds(20, 190, 150, 40);

        TransparentRadioButton account3 = new TransparentRadioButton("Account 3");
        account3.setFont(radioButtonFont);
        account3.setFocusPainted(false);
        account3.setAlignmentX(Component.LEFT_ALIGNMENT);
        account3.setBounds(20, 240, 150, 40);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(account1);
        buttonGroup.add(account2);
        buttonGroup.add(account3);

        mainPanel.add(account1);
        mainPanel.add(account2);
        mainPanel.add(account3);
        
        JButton tradeButton = new JButton("Trade");
        tradeButton.setFocusPainted(false);
        tradeButton.setBackground(new Color(76, 134, 230));
        tradeButton.setForeground(Color.WHITE);

        tradeButton.setBounds(250, 290, 100, 30);
        tradeButton.setForeground(Color.WHITE);
      
        tradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (buttonGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(UserDashboard.this, "Please select an account first.");
            } else {
            Trade tradeFrame = new Trade(); 
            dispose();
            tradeFrame.setVisible(true);
            }
        }
    });

        mainPanel.add(tradeButton);
        mainPanel.add(designPanel); 

        add(mainPanel);
        setVisible(true);
    }
        public class TransparentRadioButton extends JRadioButton {
        public TransparentRadioButton(String text) {
            super(text);
            setOpaque(false);
        }
    }
}





