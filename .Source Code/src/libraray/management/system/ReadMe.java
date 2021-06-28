/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;

public class ReadMe extends JFrame
{
    private JPanel contentPane;
    
    public static void main(String args[])
    {
        new ReadMe().setVisible(true);
    }
    
    public ReadMe()
    {
        super("Read Me - Library Management System");
        setBounds(500, 250,700,500);
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("Library");
        l1.setForeground(new Color(0,250,154));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l1.setBounds(160,40,150,55);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Management System");
        l2.setForeground(new Color(90,255,0));
        l2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l2.setBounds(70,90,405,40);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("v2.5");
        l3.setForeground(new Color(30,144,255));
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l3.setBounds(185,140,100,21);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("Developed By: Subham Kumar");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Algerian", Font.BOLD, 30));
        l4.setBounds(70,198,550,35);
        contentPane.add(l4);
        
        JTextArea text = new JTextArea("Library Management System is an application that aims at\nproviding a digital platform to manage and maintain books\nof library. This application helps mostly the librarians to\nmaintain constant track of books available. With this the\nadmin can acknowledge which books are issued and which\nare returned providing a sophisticated management of books.");
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        text.setBounds(70,260,600,150);
        text.setBackground(Color.LIGHT_GRAY);
        contentPane.add(text);
    }
}
