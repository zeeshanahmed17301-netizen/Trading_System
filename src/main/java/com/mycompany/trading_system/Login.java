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
public class Login extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;
        private JCheckBox showPasswordCheckbox;
        private int loginAttempts = 0;

        private String selectedRole;

        public Login(String selectedRole) {
        this.selectedRole = selectedRole;
        }

        public void runLogin() {
        setTitle("Login - " + selectedRole);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

       
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(140, 190, 200, 25); 
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(usernameLabel);

    
        usernameField = new JTextField(20);
        usernameField.setBounds(280,190, 150, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(140, 230, 200, 25);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        passwordLabel.setForeground(Color.DARK_GRAY);
        panel.add(passwordLabel);

   
        passwordField = new JPasswordField(20);
        passwordField.setBounds(280, 230, 150, 25);
        panel.add(passwordField);
    
    
        JLabel text = new JLabel("ACCOUNT SIGN IN");
        text.setBounds(160, 50, 400, 25); 
        text.setFont(new Font("Arial", Font.BOLD, 30));
        text.setBackground(new Color(30, 144, 255));
        text.setForeground(Color.DARK_GRAY); 
        panel.add(text);


     
        loginButton = new JButton("Login");
        loginButton.setBounds(280, 290, 150, 25); 
        loginButton.setFocusPainted(false);
        loginButton.setBackground(new Color(30, 144, 255)); 
        loginButton.setForeground(Color.WHITE); 
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        boolean isValid = checkCredentials(username, password);

        if (isValid) {
        JOptionPane.showMessageDialog(null, "Login Successful!");
        if (selectedRole.equals("User")) {
            openUserDashboard(); 
        } else if (selectedRole.equals("Project Owner")) {
            openDeploymentProject(); 
        }
        } else {
        loginAttempts++;
        if (loginAttempts >= 3) {
            JOptionPane.showMessageDialog(null, "Maximum login attempts reached. Try again after 24 hours.");
            loginButton.setEnabled(false);
           } 
        else {
            int attemptsLeft = 3 - loginAttempts;
            JOptionPane.showMessageDialog(null, "Invalid username or password. Attempts left: " + attemptsLeft);
                }
            }
        }
    });
        
     panel.add(loginButton);
    add(panel);
    setVisible(true);

    JPanel designPanel = Design.createDiagonalSplitPanel();
    designPanel.setBounds(0, 0, 600, 500); 
    panel.add(designPanel);
    
    }
    private boolean checkCredentials(String username, String password) {
        if (selectedRole.equals("User")) {
           
            return (username.equals("user") && password.equals("password"));
        } else if (selectedRole.equals("Project Owner")) {
           
            return (username.equals("owner") && password.equals("password"));
        }
        return false;
    }
     private void openUserDashboard() {
    UserDashboard userDashboard = new UserDashboard();
    userDashboard.setVisible(true);
    dispose(); 
    }
        
     private void openDeploymentProject() {    //This is private coz this method is present within the login class so when someone login as project owner then only project deployment opens up.
    ProjectDeployment projectDeployment = new ProjectDeployment();
    projectDeployment.setVisible(true); 
    dispose();
    }
}
