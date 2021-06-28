/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1, t2, t3;
    private JComboBox comboBox, comboBox1, comboBox2, comboBox3;
    private JButton bAdd, bBack;
    
    public static void main(String args[])
    {
        new AddStudent().setVisible(true);
    }
    
    public AddStudent()
    {
        super("Add Student");
        setBounds(500,200,800,500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(230, 230, 255));
        contentPane.setLayout(null);
        
        
        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 17));
        l1.setBounds(90,75,150,35);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 17));
        l2.setBounds(90,115,150,35);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("Father's Name");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 17));
        l3.setBounds(90,155,150,35);
        contentPane.add(l3);
        
        JLabel l7 = new JLabel("Course");
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma", Font.BOLD, 17));
        l7.setBounds(90,195,150,35);
        contentPane.add(l7);
        
        JLabel l4 = new JLabel("Branch");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 17));
        l4.setBounds(90,235,150,35);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("Year");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 17));
        l5.setBounds(90,275,150,35);
        contentPane.add(l5);
        
        JLabel l6 = new JLabel("Semester");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma", Font.BOLD, 17));
        l6.setBounds(90,315,150,35);
        contentPane.add(l6);
        
        t1 = new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t1.setColumns(10);
        t1.setBounds(270,75,230,30);
        contentPane.add(t1);
        
        t2 = new JTextField();
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t2.setColumns(10);
        t2.setBounds(270,115,230,30);
        contentPane.add(t2);
        
        t3 = new JTextField();
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t3.setColumns(10);
        t3.setBounds(270,155,230,30);
        contentPane.add(t3);
        
        comboBox3 = new JComboBox();
        comboBox3.setModel(new DefaultComboBoxModel(new String[] { "B.Tech", "B.Sc", "BCA", "M.Tech", "M.Sc", "MCA", "MBA"}));
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        comboBox3.setBounds(270,195,230,30);
        contentPane.add(comboBox3);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Mechanical", "CSE", "IT", "ECE", "EEE", "CE", "Other"}));
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        comboBox.setBounds(270,235,230,30);
        contentPane.add(comboBox);
        
        comboBox1 = new JComboBox();
        comboBox1.setModel(new DefaultComboBoxModel(new String[] { "First", "Second", "Third", "Fourth"}));
        comboBox1.setForeground(Color.BLACK);
        comboBox1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        comboBox1.setBounds(270,275,230,30);
        contentPane.add(comboBox1);
        
        comboBox2 = new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        comboBox2.setBounds(270,315,230,30);
        contentPane.add(comboBox2);
        
        bAdd = new JButton("Add");
        bAdd.addActionListener(this);
        bAdd.setFont(new Font("Trebuchet", Font.BOLD, 18));
        bAdd.setForeground(Color.WHITE);
        bAdd.setBackground(Color.BLACK);
        bAdd.setBounds(200,370,150,40);
        contentPane.add(bAdd);
        
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setFont(new Font("Trebuchet", Font.BOLD, 18));
        bBack.setForeground(Color.WHITE);
        bBack.setBackground(Color.BLACK);
        bBack.setBounds(400,370,150,40);
        contentPane.add(bBack);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(68,153,123), 2, true), "Add-Student",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,77)));
        panel.setBackground(new Color(230, 230, 255));
        panel.setBounds(42,45,708,385);
        contentPane.add(panel);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(ae.getSource() == bAdd)
            {
                if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! Please fill all the fields");
                }
                else
                {
                try
                {
                    conn con = new conn();
                    String sql = "Insert into student(student_id, name, father,course, branch, year, semester) values(?,?,?,?,?,?,?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t3.getText());
                    st.setString(4, (String) comboBox3.getSelectedItem());
                    st.setString(5, (String) comboBox.getSelectedItem());
                    st.setString(6, (String) comboBox1.getSelectedItem());
                    st.setString(7, (String) comboBox2.getSelectedItem());
                    
                    int i = st.executeUpdate();
                    if(i > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                    }
                    
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    st.close();
                    con.c.close();
                }
                
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                }
            }
            
            if(ae.getSource() == bBack)
            {
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }
        catch(Exception e)
        {
        }
    }
}
