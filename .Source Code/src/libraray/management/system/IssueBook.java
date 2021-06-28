/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.event.*;

public class IssueBook extends JFrame implements ActionListener
{
    private JPanel contentPane, panel1, panel2;
    private JDateChooser dateChooser, dateChooser1;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    private JButton bBSearch, bSSearch, bIssue, bBack;
    
    public static void main(String args[])
    {
        new IssueBook().setVisible(true);
    }
    
    public IssueBook()
    {
        super("Issue Book");
        setBounds(400, 90, 1100, 800);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(new Color(255, 235, 204));
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("Book_id");
        l1.setFont(new Font("Tahoma", Font.BOLD, 17));
        l1.setForeground(new Color(47,79,79));
        l1.setBounds(47,85,150,30);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 17));
        l2.setForeground(new Color(47,79,79));
        l2.setBounds(47,145,150,30);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("ISBN");
        l3.setFont(new Font("Tahoma", Font.BOLD, 17));
        l3.setForeground(new Color(47,79,79));
        l3.setBounds(47,205,150,30);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("Publisher");
        l4.setFont(new Font("Tahoma", Font.BOLD, 17));
        l4.setForeground(new Color(47,79,79));
        l4.setBounds(47,265,150,30);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("Edition");
        l5.setFont(new Font("Tahoma", Font.BOLD, 17));
        l5.setForeground(new Color(47,79,79));
        l5.setBounds(47,325,150,30);
        contentPane.add(l5);
        
        JLabel l6 = new JLabel("Price");
        l6.setFont(new Font("Tahoma", Font.BOLD, 17));
        l6.setForeground(new Color(47,79,79));
        l6.setBounds(47,385,150,30);
        contentPane.add(l6);
        
        JLabel l7 = new JLabel("Pages");
        l7.setFont(new Font("Tahoma", Font.BOLD, 17));
        l7.setForeground(new Color(47,79,79));
        l7.setBounds(47,445,150,30);
        contentPane.add(l7);
        
        t1 = new JTextField();
        t1.setForeground(new Color(47,79,79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t1.setBounds(170,85,175,30);
        contentPane.add(t1);
        
        bBSearch = new JButton("Search");
        bBSearch.addActionListener(this);
        bBSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bBSearch.setBorder(new LineBorder(new Color(192,192,192), 1, true));
        bBSearch.setForeground(Color.WHITE);
        bBSearch.setBackground(Color.BLACK);
        bBSearch.setBounds(370,82,150,36);
        contentPane.add(bBSearch);
        
        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(47,79,79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t2.setColumns(10);
        t2.setBounds(170,145,280,30);
        contentPane.add(t2);
        
        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(47,79,79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t3.setColumns(10);
        t3.setBounds(170,205,280,30);
        contentPane.add(t3);
        
        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(47,79,79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t4.setColumns(10);
        t4.setBounds(170,265,280,30);
        contentPane.add(t4);
        
        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(47,79,79));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t5.setColumns(10);
        t5.setBounds(170,325,280,30);
        contentPane.add(t5);
        
        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(47,79,79));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t6.setColumns(10);
        t6.setBounds(170,385,280,30);
        contentPane.add(t6);
        
        t7 = new JTextField();
        t7.setEditable(false);
        t7.setForeground(new Color(47,79,79));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t7.setColumns(10);
        t7.setBounds(170,445,280,30);
        contentPane.add(t7);
        
        panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new LineBorder(new Color(47,79,79), 2, true), "Book-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34,139,34)));
        panel1.setBackground(new Color(255, 235, 204));
        panel1.setBounds(28,40,505,500);
        contentPane.add(panel1);
        
        JLabel l8 = new JLabel("Student_id");
        l8.setForeground(new Color(47,79,79));
        l8.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l8.setBounds(566,85,150,30);
        contentPane.add(l8);
        
        JLabel l9 = new JLabel("Name");
        l9.setForeground(new Color(47,79,79));
        l9.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l9.setBounds(566,145,150,30);
        contentPane.add(l9);
        
        JLabel l10 = new JLabel("Father's Name");
        l10.setForeground(new Color(47,79,79));
        l10.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l10.setBounds(566,205,150,30);
        contentPane.add(l10);
        
        JLabel l11 = new JLabel("Course");
        l11.setForeground(new Color(47,79,79));
        l11.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l11.setBounds(566,265,150,30);
        contentPane.add(l11);
        
        JLabel l12 = new JLabel("Branch");
        l12.setForeground(new Color(47,79,79));
        l12.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l12.setBounds(566,325,150,30);
        contentPane.add(l12);
        
        JLabel l13 = new JLabel("Year");
        l13.setForeground(new Color(47,79,79));
        l13.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l13.setBounds(566,385,150,30);
        contentPane.add(l13);
        
        JLabel l14 = new JLabel("Semester");
        l14.setForeground(new Color(47,79,79));
        l14.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l14.setBounds(566,445,150,30);
        contentPane.add(l14);
        
        t8 = new JTextField();
        t8.setForeground(new Color(47,79,79));
        t8.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t8.setColumns(10);
        t8.setBounds(689,85,175,30);
        contentPane.add(t8);
        
        bSSearch = new JButton("Search");
        bSSearch.addActionListener(this);
        bSSearch.setForeground(Color.WHITE);
        bSSearch.setBackground(Color.BLACK);
        bSSearch.setBorder(new LineBorder(new Color(192,192,192), 1, true));
        bSSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bSSearch.setBounds(889,82,150,36);
        contentPane.add(bSSearch);
        
        t9 = new JTextField();
        t9.setEditable(false);
        t9.setForeground(new Color(47,79,79));
        t9.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t9.setColumns(10);
        t9.setBounds(689,145,280,30);
        contentPane.add(t9);
        
        t10 = new JTextField();
        t10.setEditable(false);
        t10.setForeground(new Color(47,79,79));
        t10.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t10.setColumns(10);
        t10.setBounds(689,205,280,30);
        contentPane.add(t10);
        
        t11 = new JTextField();
        t11.setEditable(false);
        t11.setForeground(new Color(47,79,79));
        t11.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t11.setColumns(10);
        t11.setBounds(689,265,280,30);
        contentPane.add(t11);
        
        t12 = new JTextField();
        t12.setEditable(false);
        t12.setForeground(new Color(47,79,79));
        t12.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t12.setColumns(10);
        t12.setBounds(689,325,280,30);
        contentPane.add(t12);
        
        t13 = new JTextField();
        t13.setEditable(false);
        t13.setForeground(new Color(47,79,79));
        t13.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t13.setColumns(10);
        t13.setBounds(689,385,280,30);
        contentPane.add(t13);
        
        t14 = new JTextField();
        t14.setEditable(false);
        t14.setForeground(new Color(47,79,79));
        t14.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        t14.setColumns(10);
        t14.setBounds(689,445,280,30);
        contentPane.add(t14);
        
        panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(70,130,180), 2,true), "Students-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100,149,237)));
        panel2.setBackground(new Color(255, 235, 204));
        panel2.setBounds(547,40,505,500);
        contentPane.add(panel2);
        
        JLabel l15 = new JLabel("Date of Issue:");
        l15.setForeground(new Color(0,195,0));
        l15.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l15.setBounds(47,570,150,30);
        contentPane.add(l15);
        
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        dateChooser.setBounds(170,572,280,30);
        dateChooser.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        dateChooser.setDateFormatString("yyyy-MM-dd");
        contentPane.add(dateChooser);
        
        JLabel l16 = new JLabel("Date of Return:");
        l16.setForeground(new Color(195,0,0));
        l16.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        l16.setBounds(566,570,150,30);
        contentPane.add(l16);
        
        dateChooser1 = new JDateChooser();
        dateChooser1.setForeground(new Color(105,105,105));
        dateChooser1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        dateChooser1.setBounds(696,570,280,30);
        dateChooser1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        dateChooser1.setDateFormatString("yyyy-MM-dd");
        contentPane.add(dateChooser1);
        
        bIssue = new JButton("Issue");
        bIssue.addActionListener(this);
        bIssue.setForeground(Color.WHITE);
        bIssue.setBackground(Color.BLACK);
        bIssue.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bIssue.setBorder(new LineBorder(new Color(192,192,192), 1, true));
        bIssue.setBounds(275,650,185,38);
        contentPane.add(bIssue);
        
        bBack = new JButton("Back");
        bBack.addActionListener(this);
        bBack.setForeground(Color.WHITE);
        bBack.setBackground(Color.BLACK);
        bBack.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        bBack.setBorder(new LineBorder(new Color(192,192,192), 1, true));
        bBack.setBounds(610,650,185,38);
        contentPane.add(bBack);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource() == bBSearch)
            {
                String sql = "Select * from book where book_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();
                
                
                if(rs.next())
                {
                    t2.setText(rs.getString("NAME"));
                    t3.setText(rs.getString("ISBN"));
                    t4.setText(rs.getString("PUBLISHER"));
                    t5.setText(rs.getString("EDITION"));
                    t6.setText(rs.getString("PRICE"));
                    t7.setText(rs.getString("PAGES"));
                }
                
                if(t2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! No book with this id");
                }
                rs.close();
                st.close();
                
            }
            
            if(ae.getSource() == bSSearch)
            {
                String sql = "Select * from student where student_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();
                
                if(rs.next())
                {
                    t9.setText(rs.getString("NAME"));
                    t10.setText(rs.getString("FATHER"));
                    t11.setText(rs.getString("COURSE"));
                    t12.setText(rs.getString("BRANCH"));
                    t13.setText(rs.getString("YEAR"));
                    t14.setText(rs.getString("SEMESTER"));
                }
                
                if(t9.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! No Student with this id");
                }
                
                rs.close();
                st.close();
            }
            con.c.close();
            
            if(ae.getSource() == bIssue)
            {
                String  issueDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String  returnDate = ((JTextField) dateChooser1.getDateEditor().getUiComponent()).getText();
                if(t1.getText().equals("") || t2.getText().equals("") || t8.getText().equals("") || t9.getText().equals("") || issueDate.equals("") || returnDate.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Error! Please fill all the field");
                }
                else
                {
                try
                {
                    conn con1 = new conn();
                    String sq = "Select * from availablebook where book_id = '" + t1.getText() + "'";
                    PreparedStatement stmt = con1.c.prepareStatement(sq);
                    ResultSet r = stmt.executeQuery();
                    
                    if(r.next())
                    {
                    String sql = "Insert into issueBook(BOOK_ID, STUDENT_ID, BOOK_NAME, PUBLISHER, STUDENT_NAME , COURSE, BRANCH, ISSUE_DATE, RETURN_DATE) values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = con1.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t8.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t4.getText());
                    st.setString(5, t9.getText());
                    st.setString(6, t11.getText());
                    st.setString(7, t12.getText());
                    st.setString(8, issueDate);
                    st.setString(9, returnDate);
                    int i = st.executeUpdate();
                    
                    if(i > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Book issued Successfully");
                    }
                    
                    
                    st.close();
                    r.close();
                    stmt.close();
                    con1.c.close();
                    
                    conn con3 = new conn();
                    String sql1 = "Delete from availablebook where book_id = '" + t1.getText() + "'";
                    PreparedStatement st1 = con3.c.prepareStatement(sql1);
                    st1.executeUpdate();
                    
                    st1.close();
                    con3.c.close();
                    
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                    t11.setText("");
                    t12.setText("");
                    t13.setText("");
                    t14.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Sorry! Book is already issued");
                    
                    
                    
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
