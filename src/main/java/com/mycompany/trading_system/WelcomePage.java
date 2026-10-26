/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trading_system;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Gamerz
 */


public class WelcomePage extends JFrame {

    public WelcomePage() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);


        JPanel designPanel = Design.createDiagonalSplitPanel();
        setContentPane(designPanel); 

       
        WelcomePanel welcomePanel = new WelcomePanel(this);
        welcomePanel.setOpaque(false); 
        designPanel.setLayout(new BorderLayout());
        designPanel.add(welcomePanel);

        setVisible(true);
    }

    public void openRoleSelection() {
        RoleSelection roleSelection = new RoleSelection();
        roleSelection.setVisible(true);
        dispose();
    }
}

class WelcomePanel extends JPanel {
    private JButton continueButton;
    private WelcomePage welcomePage;

    public WelcomePanel(WelcomePage welcomePage) {
        this.welcomePage = welcomePage;

        setLayout(null);

        JLabel titleLabel = new JLabel("WELCOME TO SYSTEM");
        titleLabel.setBounds(50, 125, 500, 50);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);

        continueButton = new JButton("CONTINUE");
        continueButton.setBounds(200, 200, 200, 50);
        continueButton.setFont(new Font("Arial", Font.BOLD, 20));
        continueButton.setBackground(new Color(0,0,0));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(e -> welcomePage.openRoleSelection());
        add(continueButton);
    }
}

class Design {
    public static JPanel createDiagonalSplitPanel() {
        return new DiagonalSplitPanel();
    }

    private static class DiagonalSplitPanel extends JPanel {
        private Color upperColor = Color.decode("#fed053");
        private Color lowerColor = Color.decode("#3b3f46");

        public DiagonalSplitPanel() {
            setPreferredSize(new Dimension(600, 500));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(upperColor);
            int[] xUpper = {0, width, 0};
            int[] yUpper = {0, height, height};
            g2d.fillPolygon(xUpper, yUpper, 3);

            g2d.setColor(lowerColor);
            int[] xLower = {width, width, 0};
            int[] yLower = {height, height, height};
            g2d.fillPolygon(xLower, yLower, 3);

            g2d.dispose();
        }
    }
}

