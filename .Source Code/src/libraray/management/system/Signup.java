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

public class Signup extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton bCreate, bBack;
    private JComboBox comboBox;
    
    public static void main(String[] args)
    {
        new Signup().setVisible(true);
    }
    
    public Signup()
    {
        super("Create an Account");
        setBounds(500, 200, 800, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(229,255,204));
        contentPane.setLayout(null);
        
        JLabel bUsername = new JLabel("Username :");
        bUsername.setForeground(Color.darkGray);
        bUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        bUsername.setBounds(109, 88, 150, 30);
        contentPane.add(bUsername);
        
        JLabel bName = new JLabel("Name :");
        bName.setForeground(Color.darkGray);
        bName.setFont(new Font("Tahoma", Font.BOLD, 16));
        bName.setBounds(109, 138, 150, 30);
        contentPane.add(bName);
        
        JLabel bPassword = new JLabel("Password :");
        bPassword.setForeground(Color.darkGray);
        bPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        bPassword.setBounds(109, 188, 150, 30);
        contentPane.add(bPassword);
        
        JLabel bAnswer = new JLabel("Answer :");
        bAnswer.setForeground(Color.darkGray);
        bAnswer.setFont(new Font("Tahoma", Font.BOLD, 16));
        bAnswer.setBounds(109, 288, 150, 30);
        contentPane.add(bAnswer);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Your NickName?","Your mother's age?","What was your first car?","What is name of oldest Friend?","Your favorite aunt's name?", "Your Lucky Number?", "Your childhood superHero?", "Your childhood name?"}));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboBox.setBounds(337, 238, 275, 30);
        contentPane.add(comboBox);
        
        JLabel bSecurityQuestion = new JLabel("Security Question :");
        bSecurityQuestion.setForeground(Color.darkGray);
        bSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
        bSecurityQuestion.setBounds(109,238,300,30);
        contentPane.add(bSecurityQuestion);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField.setBounds(337,88,175,30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField1 = new JTextField();
        textField1.setBounds(337,138,175,30);
        textField1.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(textField1);
        textField1.setColumns(10);
        
        textField2 = new JTextField();
        textField2.setBounds(337,188,175,30);
        textField2.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(textField2);
        textField2.setColumns(10);
        
        textField3 = new JTextField();
        textField3.setBounds(337,288,175,30);
        textField3.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(textField3);
        textField3.setColumns(10);
        
        bCreate = new JButton("Create");
        bCreate.addActionListener(this);
        bCreate.setFont(new Font("Tahoma", Font.BOLD, 17));
        bCreate.setBounds(200,348,125,35);
        bCreate.setBackground(Color.BLACK);
        bCreate.setForeground(Color.WHITE);
        contentPane.add(bCreate);
        
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setFont(new Font("Tahoma", Font.BOLD, 17));
        bBack.setBounds(400,348,125,35);
        bBack.setBackground(Color.BLACK);
        bBack.setForeground(Color.WHITE);
        contentPane.add(bBack);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34,139,34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51,102,0)));
        panel.setBounds(47,45,708,381);
        panel.setBackground(new Color(229,255,204));
        contentPane.add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            
            if(ae.getSource() == bCreate)
            {
                if(!textField.getText().equals("") && !textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals(""))
                {
                String sql = "Insert into account(username,name,password,sec_q,sec_ans) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, textField.getText());
                st.setString(2, textField1.getText());
                st.setString(3, textField2.getText());
                st.setString(4, (String)comboBox.getSelectedItem());
                st.setString(5, textField3.getText());
                
                int i = st.executeUpdate();
                if(i > 0)
                {
                    JOptionPane.showMessageDialog(null, "Successfully Created");
                }
                
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText(""); 
                
                this.setVisible(false);
                new Login_user().setVisible(true);
                
                st.close();
                }
                
                else
                    JOptionPane.showMessageDialog(null, "Error!! Please fill all the fields");
                
            }
            if(ae.getSource() == bBack)
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
