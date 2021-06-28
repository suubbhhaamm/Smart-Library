/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.text.*;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.event.*;

public class ReturnBook extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTextField textField, textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9;
    private JButton bSearch, bReturn, bBack, bCalFine, bFineDue;
    private JDateChooser dateChooser;
    
    public static void main(String args[])
    {
        new ReturnBook().setVisible(true);
    }
    
    public void delete()
    {
        try
        {
            conn con = new conn();
            String sql = "Delete from issueBook where book_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField.getText());
            int i = st.executeUpdate();
            if(i > 0)
                JOptionPane.showMessageDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "Error in Deleting");
            
            st.close();
            con.c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public void insertIntoAvailableBook()
    {
        try
        {
            conn con = new conn();
            String sql = "Insert into availableBook(BOOK_ID, NAME, PUBLISHER) values(?,?,?)";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField.getText());
            st.setString(2, textField2.getText());
            st.setString(3, textField4.getText());
            
            st.executeUpdate();
            st.close();
            con.c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public ReturnBook()
    {
        super("Return Book");
        setBounds(400, 90, 1100, 800);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 235, 204));
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("Book_id");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l1.setBounds(60,80,150,30);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Student_id");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l2.setBounds(435,80,150,30);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("Book");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l3.setBounds(60,160,150,30);
        contentPane.add(l3);
        
        JLabel pub = new JLabel("Publisher");
        pub.setForeground(Color.BLACK);
        pub.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        pub.setBounds(60,240,150,30);
        contentPane.add(pub);
        
        JLabel l4 = new JLabel("Name");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l4.setBounds(575,160,150,30);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("Course");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l5.setBounds(575,240,150,30);
        contentPane.add(l5);
        
        JLabel l6 = new JLabel("Branch");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l6.setBounds(575,320,150,30);
        contentPane.add(l6);
        
        JLabel l7 = new JLabel("Date of Issue");
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l7.setBounds(60,320,150,30);
        contentPane.add(l7);
        
        JLabel l8 = new JLabel("Date of Return");
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l8.setBounds(60,400,150,30);
        contentPane.add(l8);
        
        JLabel l9 = new JLabel("Date of Submit");
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        l9.setBounds(575,400,150,30);
        contentPane.add(l9);
        
        textField = new JTextField();
        textField.setForeground(new Color(105,105,105));
        textField.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField.setColumns(10);
        textField.setBounds(170,80,200,30);
        contentPane.add(textField);
        
        textField1 = new JTextField();
        textField1.setForeground(new Color(105,105,105));
        textField1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField1.setColumns(10);
        textField1.setBounds(580,80,200,30);
        contentPane.add(textField1);
        
        bSearch = new JButton("Search");
        bSearch.addActionListener(this);
        bSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        bSearch.setForeground(Color.WHITE);
        bSearch.setBackground(Color.BLACK);
        bSearch.setBounds(840,77,160,36);
        contentPane.add(bSearch);
        
        textField2 = new JTextField();
        textField2.setEditable(false);
        textField2.setForeground(new Color(105,105,105));
        textField2.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField2.setColumns(10);
        textField2.setBounds(210,160,250,30);
        contentPane.add(textField2);
        
        textField3 = new JTextField();
        textField3.setEditable(false);
        textField3.setForeground(new Color(105,105,105));
        textField3.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField3.setColumns(10);
        textField3.setBounds(740,160,250,30);
        contentPane.add(textField3);
        
        textField4 = new JTextField();
        textField4.setEditable(false);
        textField4.setForeground(new Color(105,105,105));
        textField4.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField4.setColumns(10);
        textField4.setBounds(210,240,250,30);
        contentPane.add(textField4);
        
        textField5 = new JTextField();
        textField5.setEditable(false);
        textField5.setForeground(new Color(105,105,105));
        textField5.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField5.setColumns(10);
        textField5.setBounds(740,240,250,30);
        contentPane.add(textField5);
        
        textField6 = new JTextField();
        textField6.setEditable(false);
        textField6.setForeground(new Color(105,105,105));
        textField6.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField6.setColumns(10);
        textField6.setBounds(210,320,250,30);
        contentPane.add(textField6);
        
        textField7 = new JTextField();
        textField7.setEditable(false);
        textField7.setForeground(new Color(105,105,105));
        textField7.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField7.setColumns(10);
        textField7.setBounds(210,400,250,30);
        contentPane.add(textField7);
        
        textField8 = new JTextField();
        textField8.setEditable(false);
        textField8.setForeground(new Color(105,105,105));
        textField8.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField8.setColumns(10);
        textField8.setBounds(740,320,250,30);
        contentPane.add(textField8);
        
        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(Color.BLACK, 1, true));
        dateChooser.setBounds(740,400,250,30);
        dateChooser.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        dateChooser.setDateFormatString("yyyy-MM-dd");
        contentPane.add(dateChooser);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(255,69,0), 2, true), "Return-Panel",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220,20,60)));
        panel.setBackground(new Color(255, 235, 204));
        panel.setBounds(28,40,1025,470);
        contentPane.add(panel);
        
        JLabel fine = new JLabel("Fine");
        fine.setForeground(Color.BLACK);
        fine.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
        fine.setBounds(110,570,150,30);
        contentPane.add(fine);
        
        textField9 = new JTextField();
        textField9.setForeground(Color.BLACK);
        textField9.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        textField9.setEditable(false);
        textField9.setColumns(10);
        textField9.setBounds(200,570,220,30);
        contentPane.add(textField9);
        
        bCalFine = new JButton("Calculate Fine");
        bCalFine.addActionListener(this);
        bCalFine.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        bCalFine.setForeground(Color.BLACK);
        bCalFine.setBackground(new Color(153, 214, 255));
        bCalFine.setBounds(480,570,180,36);
        contentPane.add(bCalFine);
        
        bFineDue = new JButton("Add to Pay Later");
        bFineDue.addActionListener(this);
        bFineDue.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        bFineDue.setForeground(Color.BLACK);
        bFineDue.setBackground(new Color(179, 255, 179));
        bFineDue.setBounds(710,570,260,37);
        contentPane.add(bFineDue);
        
        bReturn = new JButton("Return");
        bReturn.addActionListener(this);
        bReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        bReturn.setForeground(Color.WHITE);
        bReturn.setBackground(Color.BLACK);
        bReturn.setBounds(275,650,185,38);
        contentPane.add(bReturn);
        
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
        bBack.setForeground(Color.WHITE);
        bBack.setBackground(Color.BLACK);
        bBack.setBounds(610,650,185,38);
        contentPane.add(bBack);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource() == bSearch)
            {
                String sql = "Select * from issueBook where student_id = ? and book_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField1.getText());
                st.setString(2, textField.getText());
                ResultSet rs = st.executeQuery();
                
                while(rs.next())
                {
                    textField2.setText(rs.getString("BOOK_NAME"));
                    textField3.setText(rs.getString("STUDENT_NAME"));
                    textField4.setText(rs.getString("PUBLISHER"));
                    textField5.setText(rs.getString("COURSE"));
                    textField6.setText(rs.getString("ISSUE_DATE"));
                    textField7.setText(rs.getString("RETURN_DATE"));
                    textField8.setText(rs.getString("BRANCH"));
                }
                
                if(textField2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! No Issue with this id");
                }
                
                st.close();
                rs.close();
            }
            con.c.close();
            
            if(ae.getSource() == bCalFine)
            {
                String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                if(date.equals("") || textField7.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! Please fill date of return and submit");
                }
                else
                {
                    try{
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date firstDate = sdf.parse(textField7.getText());
                        Date secondDate = sdf.parse(date);
 
                        long diff = secondDate.getTime() - firstDate.getTime();
                        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                        if(diffDays > 0)
                            textField9.setText("Rs." + Integer.toString(diffDays*2));
                        else
                            textField9.setText("Rs.0");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    
                }
            }
            
            if(ae.getSource() == bFineDue)
            {
                conn con1 = new conn();
                String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                
                if(textField.getText().equals("") || date.equals("") || textField2.getText().equals("") || textField9.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! First fill the details");
                }
                else
                {
                    String sql = "Insert into pendingFine(STUDENT_ID, BOOK_NAME, STUDENT_NAME, COURSE, BRANCH, ISSUE_DATE, RETURN_DATE, SUBMIT_DATE, FINE) values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con1.c.prepareStatement(sql);
                    st.setString(1,textField1.getText());
                    st.setString(2,textField2.getText());
                    st.setString(3,textField3.getText());
                    st.setString(4,textField5.getText());
                    st.setString(5,textField8.getText());
                    st.setString(6,textField6.getText());
                    st.setString(7,textField7.getText());
                    st.setString(8, date);
                    st.setString(9,textField9.getText());
                
                    int i = st.executeUpdate();
                    if(i > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Added to the list of pending fine payment.");
                    }
                
                    st.close();
                }
                con1.c.close();
            }
            
            if(ae.getSource() == bReturn)
            {
                String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                
                if(textField.getText().equals("") || date.equals("") || textField2.getText().equals("") || textField9.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! Fill all the fields");
                }
                else
                {
                
                conn con2 = new conn();
                String sql = "Insert into returnBook(BOOK_ID, STUDENT_ID, BOOK_NAME, STUDENT_NAME, COURSE, BRANCH, ISSUE_DATE, RETURN_DATE, SUBMIT_DATE, FINE) values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement st = con2.c.prepareStatement(sql);
                st.setString(1,textField.getText());
                st.setString(2,textField1.getText());
                st.setString(3,textField2.getText());
                st.setString(4,textField3.getText());
                st.setString(5,textField5.getText());
                st.setString(6,textField8.getText());
                st.setString(7,textField6.getText());
                st.setString(8,textField7.getText());
                st.setString(9, date);
                st.setString(10,textField9.getText());
                
                int i = st.executeUpdate();
                if(i > 0)
                {
                    delete();
                    insertIntoAvailableBook();
                    textField.setText("");
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    textField6.setText("");
                    textField7.setText("");
                    textField8.setText("");
                    textField9.setText("");
                }
                
                st.close();
                con2.c.close();
                }
            }
            
            if(ae.getSource() == bBack)
            {
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }
        
        catch(Exception e)
        {}
    }
}
