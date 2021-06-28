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

public class Login_user extends JFrame implements ActionListener
{
private JPanel panel;
private JTextField textField;
private JPasswordField passwordField;
private JButton bLogin, bForgotpass;

public Login_user()
{
    super("Welcome!!");
   setBounds(500,200,958,542);
   
   panel = new JPanel();
   setContentPane(panel);
   panel.setLayout(null);
 
   JLabel label = new JLabel("");
        
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/first.png"));
   Image i2 = i1.getImage().getScaledInstance(958,542,Image.SCALE_DEFAULT);
   label = new JLabel(new ImageIcon(i2));
   label.setBounds(0,0,958,542);
   panel.add(label);
   
   JLabel l1 = new JLabel("Username :");
   l1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
   l1.setBounds(40, 330, 100, 30);
   label.add(l1);
   
   JLabel l2 = new JLabel("Password :");
   l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
   l2.setBounds(40, 370, 100, 30);
   label.add(l2);
   
   textField = new JTextField();
   textField.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
   textField.setBounds(160, 330, 160, 26);
   label.add(textField);
   
   passwordField = new JPasswordField();
   passwordField.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
   passwordField.setBounds(160,371,160,26);
   label.add(passwordField);
   
   bLogin = new JButton("Login");
   bLogin.addActionListener(this);
   
   bLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
   bLogin.setForeground(new Color(51, 102, 0));
   bLogin.setBackground(new Color(204, 255, 153));
   bLogin.setBounds(60,420,110,32);
   label.add(bLogin);
   
   bForgotpass = new JButton("Forgot Password");
   bForgotpass.addActionListener(this);
   
   bForgotpass.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
   bForgotpass.setForeground(new Color(153,76,0));
   bForgotpass.setBackground(new Color(255,204,153));
   bForgotpass.setBounds(180, 420, 168, 32);
   label.add(bForgotpass);
   
   JLabel lSignUp = new JLabel("Sign Up");
        lSignUp.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Signup().setVisible(true);
            }
        });
        lSignUp.setForeground(Color.BLACK);
        lSignUp.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/signup.jpg")); 
        Image i6 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        lSignUp.setIcon(new ImageIcon(i6));
        lSignUp.setBounds(620,12,200,50);
        label.add(lSignUp);
}

@Override
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource() == bLogin)
    {
        boolean status  = false;
        try
        {
            conn con = new conn();
            String sql = "Select * from account where username=? and password=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            st.setString(1, textField.getText());
            st.setString(2, passwordField.getText());
            
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                this.setVisible(false);
                new Loading().setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid login!");
            
            rs.close();
            st.close();
            con.c.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
    }
    if(ae.getSource() == bForgotpass)
    {
        setVisible(false);
        new Forgot().setVisible(true);
    }
}


}
