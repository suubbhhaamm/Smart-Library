/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;

public class aboutUs extends JFrame
{
    private JPanel contentPane;
    
    public static void main(String args[])
    {
        new aboutUs().setVisible(true);
    }
    
    public aboutUs()
    {
        super("About Us");
        setBounds(600,300,650,450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("Library");
        l1.setForeground(Color.CYAN);
        l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        l1.setBounds(100,20,150,60);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Management System");
        l2.setForeground(new Color(90,255,0));
        l2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        l2.setBounds(40,55,350,60);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("v2.5");
        l3.setForeground(Color.YELLOW);
        l3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        l3.setBounds(120,90,100,60);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 110, Image.SCALE_DEFAULT);
        l4 = new JLabel(new ImageIcon(i2));
        l4.setBounds(400,25,125,125);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("Developed By : Subham Kumar");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Algerian", Font.BOLD, 30));
        l5.setBounds(30,160,560,60);
        contentPane.add(l5);
        
        JTextArea text = new JTextArea("For any query related to application or\nfor more such application\nContact Us at : 11subhu@gmail.com\nFollow us on Instagram : subhu_arcane04");
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        text.setBackground(Color.LIGHT_GRAY);
        text.setForeground(Color.BLACK);
        text.setBounds(30,230,500,130);
        contentPane.add(text);
        
        JLabel l6 = new JLabel("**If you want more such software, drop a mail**");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
        l6.setBounds(50,347,500,60);
        contentPane.add(l6);
    }
}
