/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trading_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Gamerz
 */

interface RoleSelectionListener {
    void openLogin(String selectedRole);
}

class RoleSelectionPanel extends JPanel {
    private JComboBox<String> roleComboBox;
    private JButton selectButton;
    private RoleSelectionListener listener;

     public RoleSelectionPanel(RoleSelectionListener listener) {
        this.listener = listener;

        setLayout(null);
   

        JLabel roleSelectionLabel = new JLabel("Role Selection");
        roleSelectionLabel.setForeground(Color.DARK_GRAY);
        roleSelectionLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        roleSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        roleSelectionLabel.setBounds(0, 20, 600, 40); 
        add(roleSelectionLabel);

        JLabel instructionLabel = new JLabel("Select the Role to proceed");
        instructionLabel.setForeground(Color.RED);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        instructionLabel.setBounds(175, 150, 800, 25);
        add(instructionLabel);

        JLabel selectLabel = new JLabel("Select Role:");
        selectLabel.setForeground(Color.DARK_GRAY);
        selectLabel.setFont(new Font("Arial", Font.BOLD, 20));
        selectLabel.setBounds(120, 200, 300, 25);
        add(selectLabel);

     
        roleComboBox = new JComboBox<>(new String[]{"User", "Project Owner"});
        roleComboBox.setBounds(260, 200, 150, 25);
        add(roleComboBox);
        
  
        JLabel sideText = new JLabel("Either select one of them.");
        sideText.setForeground(Color.DARK_GRAY);
        sideText.setFont(new Font("Arial", Font.BOLD, 15));
        sideText.setBounds(20, 400, 600, 25);
        add(sideText);

     
        selectButton = new JButton("Next");
        selectButton.setFont(new Font("Arial", Font.BOLD, 15));
        selectButton.setBackground(new Color(30, 144, 255));
        selectButton.setForeground(Color.WHITE);
        selectButton.setBounds(440, 400, 120, 30);
        selectButton.addActionListener(e -> {
            String selectedRole = (String) roleComboBox.getSelectedItem();
            if (listener != null) {
                listener.openLogin(selectedRole);
            }
        });
        add(selectButton);
        
        
        JPanel designPanel = Design.createDiagonalSplitPanel();
        designPanel.setBounds(0, 0, 600, 500); 
        add(designPanel);
    }
}
public class RoleSelection extends JFrame implements RoleSelectionListener {

    public RoleSelection() {
        setTitle("Role Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        RoleSelectionPanel roleSelectionPanel = new RoleSelectionPanel(this);
        add(roleSelectionPanel);

        setVisible(true);
    }

    public void openLogin(String selectedRole) {
        dispose();
        Login login = new Login(selectedRole);
        login.runLogin();
    }

  
}
