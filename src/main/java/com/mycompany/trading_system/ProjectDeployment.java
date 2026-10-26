/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trading_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gamerz
 */
public class ProjectDeployment extends JFrame {

    private int deployedProjectsCount = 0;
    private JLabel messageLabel;
    private JButton deployButton;
    private JButton showProjectsButton;
    private JTextArea deployedProjectsArea; 
    private List<String> deployedProjectNames;

    public ProjectDeployment() {
        
        setTitle("Project Deployment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        deployedProjectNames = new ArrayList<>();
        

        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 500);
            }
        };
        panel.setLayout(null);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Project Deployment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setBounds(150, 20, 300, 40);
        panel.add(titleLabel);

        JLabel projectNameLabel = new JLabel("Name");
        projectNameLabel.setBounds(80, 100, 400, 25);
        projectNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(projectNameLabel);

        JTextField projectNameField = new JTextField();
        projectNameField.setBounds(150, 100, 300, 30);
        panel.add(projectNameField);


        deployButton = new JButton("DEPLOY");
        deployButton.setBounds(250, 150, 100, 30);
        deployButton.setForeground(Color.WHITE);
        deployButton.setBackground(new Color(230, 76, 76));
        deployButton.setFocusPainted(false);
        deployButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deployedProjectsCount < 5) {
                    String projectName = projectNameField.getText();
                    System.out.println("Deploying project: " + projectName);
                    deployedProjectsCount++;
                    deployedProjectNames.add(projectName);
                    showMessage("PROJECT " + deployedProjectsCount + " DEPLOYED!", Color.RED);

                    if (deployedProjectsCount >= 5) {
                        deployButton.setEnabled(false);
                        showProjectsButton.setEnabled(true);
                    }
                } 
            }
        });
        panel.add(deployButton);

        
        JButton loginButton = new JButton("Login As User");
        loginButton.setBounds(430, 430, 120, 30);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(76, 134, 230));
        loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Login login = new Login("User"); 
        login.runLogin(); 
        dispose();
            }
        });
        panel.add(loginButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(235, 190, 300, 25);
        panel.add(messageLabel);

        showProjectsButton = new JButton("Show Deployed Projects");
        showProjectsButton.setBounds(200, 250, 200, 30);
        showProjectsButton.setBackground(new Color(230, 76, 76));
        showProjectsButton.setForeground(Color.WHITE);
        showProjectsButton.setFocusPainted(false);
        showProjectsButton.setEnabled(false);
        showProjectsButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                displayDeployedProjects();
            }
        });
        panel.add(showProjectsButton);

        deployedProjectsArea = new JTextArea();
        deployedProjectsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(deployedProjectsArea);
        scrollPane.setBounds(50, 300, 500, 100);
        panel.add(scrollPane);

        add(panel);
        pack();
        setVisible(true);
        
        JPanel designPanel = Design.createDiagonalSplitPanel();
        designPanel.setBounds(0, 0, 600, 500); 
        panel.add(designPanel); 
        }

        private void showMessage(String message, Color color) {
        messageLabel.setText(message);
        messageLabel.setForeground(color);
        }

        private void displayDeployedProjects() {
        String projects = "Deployed Projects:\n";
        for (int i = 0; i < deployedProjectNames.size(); i++) {
            String projectName = deployedProjectNames.get(i);
            projects += (i + 1) + ". " + projectName + "\n";
        }
        deployedProjectsArea.setText(projects);
       }
}

 
