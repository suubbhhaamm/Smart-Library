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
import java.util.*;

public class AddBook extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6;
    private JButton bAdd, bBack;
    private JComboBox comboBox;
    
    public static void main(String args[])
    {
        new AddBook().setVisible(true);
    }
    
    public void random()
    {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }
    
    public AddBook()
    {
        super("Add New Book");
        setBounds(500,200,800,500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel l6 = new JLabel("Book_id");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma", Font.BOLD, 17));
        l6.setBounds(90,75,150,35);
        contentPane.add(l6);
        
        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 17));
        l1.setBounds(90,115,150,35);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("ISBN");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 17));
        l2.setBounds(90,155,150,35);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("Pulisher");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 17));
        l3.setBounds(90,195,150,35);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("Edition");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 17));
        l4.setBounds(90,235,150,35);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("Price");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 17));
        l5.setBounds(90,275,150,35);
        contentPane.add(l5);
        
        JLabel l7 = new JLabel("Pages");
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma", Font.BOLD, 17));
        l7.setBounds(90,315,150,35);
        contentPane.add(l7);
        
        t1 = new JTextField();
        t1.setForeground(new Color(47,79,79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t1.setColumns(10);
        t1.setBounds(270,75,230,30);
        contentPane.add(t1);
        
        t2 = new JTextField();
        t2.setForeground(new Color(47,79,79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t2.setColumns(10);
        t2.setBounds(270,115,230,30);
        contentPane.add(t2);
        
        t3 = new JTextField();
        t3.setForeground(new Color(47,79,79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t3.setColumns(10);
        t3.setBounds(270,155,230,30);
        contentPane.add(t3);
        
        t4 = new JTextField();
        t4.setForeground(new Color(47,79,79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t4.setColumns(10);
        t4.setBounds(270,195,230,30);
        contentPane.add(t4);
        
        t5 = new JTextField();
        t5.setForeground(new Color(47,79,79));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t5.setColumns(10);
        t5.setBounds(270,275,230,30);
        contentPane.add(t5);
        
        t6 = new JTextField();
        t6.setForeground(new Color(47,79,79));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t6.setColumns(10);
        t6.setBounds(270,315,230,30);
        contentPane.add(t6);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        comboBox.setBounds(270,235,230,30);
        contentPane.add(comboBox);
        
        bAdd = new JButton("Add");
        bAdd.addActionListener(this);
        bAdd.setBorder(new CompoundBorder(new LineBorder(new Color(105,105,105)), null));
        bAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bAdd.setBounds(200,370,150,40);
        bAdd.setBackground(Color.BLACK);
        bAdd.setForeground(Color.WHITE);
        contentPane.add(bAdd);
        
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setBorder(new CompoundBorder(new LineBorder(new Color(105,105,105)), null));
        bBack.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bBack.setBounds(400,370,150,40);
        bBack.setBackground(Color.BLACK);
        bBack.setForeground(Color.WHITE);
        contentPane.add(bBack);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(138,43,226), 2), "Add Books", TitledBorder.LEADING,
        TitledBorder.TOP, null, new Color(0,0,255)));
        panel.setBackground(new Color(230, 230, 255));
        panel.setBounds(42,45,708,385);
        contentPane.add(panel);
        
        contentPane.setBackground(new Color(230, 230, 255));
        random();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(ae.getSource() == bAdd)
            {
                if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! Please fill all the fields");
                }
                else
                {
                conn con = new conn();
                String sql = "Insert into book(book_id, name, isbn, publisher, edition, price, pages) values(?,?,?,?,?,?,?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());
                st.setString(5, (String) comboBox.getSelectedItem());
                st.setString(6, t5.getText());
                st.setString(7, t6.getText());
                int rs = st.executeUpdate();
                
                if(rs > 0)
                    JOptionPane.showMessageDialog(null, "Succesfully Added");
                
                st.close();
                con.c.close();
                
                conn connect = new conn();
                String sql1 = "Insert into availableBook(book_id, name, publisher) values(?,?,?)";
                PreparedStatement st1 = connect.c.prepareStatement(sql1);
                
                st1.setString(1, t1.getText());
                st1.setString(2, t2.getText());
                st1.setString(3, t4.getText());
                st1.executeUpdate();
                
                st1.close();
                connect.c.close();
                
                t1.setText("");
                random();
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
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
