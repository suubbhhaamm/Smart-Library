/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Forgot extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;
    
    public static void main(String args[])
    {
        new Forgot().setVisible(true);
    }
    
    public Forgot()
    {
        super("Recover Password");
        setBounds(500, 200, 800, 500); //size of frame
        contentPane = new JPanel(); //work as a division
       setContentPane(contentPane); //adding to the frame
       contentPane.setBackground(new Color(255,255,204));
       contentPane.setLayout(null); // Border Layout (default), Flow Layout, Grid Layout and when no layout fro panel the setLayout(null)
       
       JLabel lUsername = new JLabel("Username :");
       lUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
       lUsername.setBounds(109, 88, 150, 30);
       contentPane.add(lUsername);
       
       JLabel lName = new JLabel("Name :");
       lName.setFont(new Font("Tahoma", Font.BOLD, 16));
       lName.setBounds(109, 138, 150, 30);
       contentPane.add(lName);
       
       JLabel lSecurityQuestion = new JLabel("Your Security Question :");
       lSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
       lSecurityQuestion.setBounds(109, 188, 400, 30);
       contentPane.add(lSecurityQuestion);
       
       JLabel lAnswer = new JLabel("Answer :");
       lAnswer.setFont(new Font("Tahoma", Font.BOLD, 16));
       lAnswer.setBounds(109, 238, 150, 30);
       contentPane.add(lAnswer);
       
       JLabel lPassword = new JLabel("Password :");
       lPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
       lPassword.setBounds(109, 288, 150, 30);
       contentPane.add(lPassword);
       
       t1 = new JTextField();
       t1.setFont(new Font("Tahoma", Font.BOLD, 16));
       t1.setForeground(new Color(105,105,105));
       t1.setBounds(337,88,175,30);
       t1.setColumns(10);
       contentPane.add(t1);
       
       t2 = new JTextField();
       t2.setEditable(false);
       t2.setFont(new Font("Tahoma", Font.BOLD, 16));
       t2.setForeground(new Color(165,42,42));
       t2.setBounds(337,138,175,30);
       t2.setColumns(10);
       contentPane.add(t2);
       
       t3 = new JTextField();
       t3.setEditable(false);
       t3.setFont(new Font("Tahoma", Font.BOLD, 16));
       t3.setForeground(new Color(72,61,139));
       t3.setBounds(337,188,310,30);
       t3.setColumns(10);
       contentPane.add(t3);
       
       t4 = new JTextField();
       t4.setFont(new Font("Tahoma", Font.BOLD, 16));
       t4.setForeground(new Color(205,92,92));
       t4.setBounds(337,238,175,30);
       t4.setColumns(10);
       contentPane.add(t4);
       
       t5 = new JTextField();
       t5.setEditable(false);
       t5.setFont(new Font("Tahoma", Font.BOLD, 16));
       t5.setForeground(new Color(50,205,50));
       t5.setBounds(337,288,175,30);
       t5.setColumns(10);
       contentPane.add(t5);
       
       b1 = new JButton("Search");
       b1.addActionListener(this);
       b1.setFont(new Font("Tahoma", Font.BOLD, 16));
       b1.setBounds(557,83,125,35);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       contentPane.add(b1);
       
       b2 = new JButton("Retrieve");
       b2.addActionListener(this);
       b2.setFont(new Font("Tahoma", Font.BOLD, 16));
       b2.setBounds(557,236,125,35);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       contentPane.add(b2);
       
       b3 = new JButton("Back");
       b3.addActionListener(this);
       b3.setFont(new Font("Tahoma", Font.BOLD, 16));
       b3.setBounds(280,370,125,35);
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       contentPane.add(b3);
       
       JPanel panel = new JPanel();
       panel.setBorder(new TitledBorder(new LineBorder(new Color(139,69,19), 2), "Forgot-Panel",
       TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178,34,34)));
       panel.setBounds(47,45,708,381);
       panel.setBackground(new Color(255,255,204));
       contentPane.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource() == b1)
            {
                String sql = "SELECT * from account WHERE username = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();
                if( rs.next())
                {
                String sql1 = "Select * from account where username = ?";
                PreparedStatement st1 = con.c.prepareStatement(sql1);
                st1.setString(1, t1.getText());
                ResultSet rs1 = st1.executeQuery();
                while(rs1.next())
                {
                    t2.setText(rs1.getString("name"));
                    t3.setText(rs1.getString("sec_q"));
                }
                
                }
                else
                    JOptionPane.showMessageDialog(null,"Error! No such username");
                st.close();
                rs.close();
            }
            if(ae.getSource() == b2)
            {
                String sql = "select * from account where sec_ans = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    t5.setText(rs.getString("password"));
                }
                if(t5.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Incorrect Answer!!");
                
                st.close();
                rs.close();
            }
            if(ae.getSource() == b3)
            {
                this.setVisible(false);
                new Login_user().setVisible(true);
            }
            
            con.c.close();
        }
        
        catch(Exception e)
        {
        }
    }
}
