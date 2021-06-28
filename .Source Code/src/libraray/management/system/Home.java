/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener
{
    private JPanel contentPanel;
    private JButton b1, b2, b3, b4, b5, b6;
    
    public static void main(String args[])
    {
        new Home().setVisible(true);
    }
    
    public Home()
    {
        super("Index");
        setBounds(400, 90, 1100,900);
        contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel contentPane = new JLabel("");
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/homeCover.jpg"));
        contentPane = new JLabel(new ImageIcon(img.getImage().getScaledInstance(1100, 900, Image.SCALE_DEFAULT)));
        contentPane.setBounds(0,0,1100,900);
        contentPanel.add(contentPane);
        
        JMenuBar menuBar = new JMenuBar(); // makes object of menubar to add to panel
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0,120,0), new Color(128,128,128)));// adding border of Menubar 
        menuBar.setBackground(new Color(0,102,204));
        menuBar.setBounds(0,10,1100,35);
        contentPane.add(menuBar);
        
        JMenu mExit = new JMenu("Exit");
        mExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        
        JMenuItem mILogout = new JMenuItem("Logout");
        mILogout.setBackground(new Color(211,211,211));
        mILogout.setForeground(new Color(105,105,105));
        mILogout.addActionListener(this);
        mExit.add(mILogout);
        
        JMenuItem mIExit = new JMenuItem("Exit");
        mIExit.setBackground(new Color(211,211,211));
        mIExit.setForeground(new Color(105,105,105));
        mIExit.addActionListener(this);
        mExit.add(mIExit);
        
        JMenu mHelp = new JMenu("Help");
        mHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        
        JMenuItem mIReadMe = new JMenuItem("Read Me");
        mIReadMe.setBackground(new Color(211,211,211));
        mIReadMe.setForeground(new Color(105,105,105));
        mIReadMe.addActionListener(this);
        mHelp.add(mIReadMe);
        
        JMenuItem mIAboutUs = new JMenuItem("About Us");
        mIAboutUs.setBackground(new Color(211,211,211));
        mIAboutUs.setForeground(new Color(105,105,105));
        mIAboutUs.addActionListener(this);
        mHelp.add(mIAboutUs);
        
        JMenu mRecord = new JMenu("Record");
        mRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
        
        JMenuItem mIBookDetails = new JMenuItem("Book Details");
        mIBookDetails.setBackground(new Color(211,211,211));
        mIBookDetails.setForeground(new Color(105,105,105));
        mIBookDetails.addActionListener(this);
        mRecord.add(mIBookDetails);
        
        JMenuItem mIStudentDetails = new JMenuItem("Student Details");
        mIStudentDetails.setBackground(new Color(211,211,211));
        mIStudentDetails.setForeground(new Color(105,105,105));
        mIStudentDetails.addActionListener(this);
        mRecord.add(mIStudentDetails);
        
        JMenuItem mIAvailabelBook = new JMenuItem("Books Available");
        mIAvailabelBook.setBackground(new Color(211,211,211));
        mIAvailabelBook.setForeground(new Color(105,105,105));
        mIAvailabelBook.addActionListener(this);
        mRecord.add(mIAvailabelBook);
        
        JMenuItem mIPendingFine = new JMenuItem("Pending Fines");
        mIPendingFine.setBackground(new Color(211,211,211));
        mIPendingFine.setForeground(new Color(105,105,105));
        mIPendingFine.addActionListener(this);
        mRecord.add(mIPendingFine);
        
        menuBar.add(mRecord);
        menuBar.add(mHelp);
        menuBar.add(mExit);
        
        JLabel l1 = new JLabel("Books Zone");
        l1.setForeground(new Color(204,51,102));
        l1.setFont(new Font("Algerian", Font.BOLD, 50));
        l1.setBounds(330,30,701,100);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(175, 175, Image.SCALE_DEFAULT);
        l2 = new JLabel(new ImageIcon(i2));
        l2.setBounds(70,140,180,180);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("");
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/third.png"));
        Image i4 = i3.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(i4));
        l3.setBounds(337,148,175,175);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("");
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/fourth.png"));
        Image i6 = i5.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        l4 = new JLabel(new ImageIcon(i6));
        l4.setBounds(585,150,200,168);
        contentPane.add(l4);
        
        b1 = new JButton("Add Books");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(80,320,159,44);
        contentPane.add(b1);
        
        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b2.setBounds(343,320,159,44);
        contentPane.add(b2);
        
        b3 = new JButton("Add Student");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b3.setBounds(595,320,167,44);
        contentPane.add(b3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(250,128,114), 2), "Operation", TitledBorder.LEADING,
        TitledBorder.TOP, null, new Color(220,20,60)));
        panel.setBounds(20,120,850,270);
        panel.setBackground(new Color(255,229,204));
        contentPane.add(panel);
        
        b4 = new JButton("Issue Book");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b4.setBounds(80,696,162,44);
        contentPane.add(b4);
        
        b5 = new JButton("Return Book");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b5.setBounds(343,696,162,44);
        contentPane.add(b5);
        
        b6 = new JButton("About Us");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b6.setBounds(595,696,167,44);
        contentPane.add(b6);
        
        JLabel l5 = new JLabel("");
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/fifth.png"));
        Image i8 = i7.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        l5 = new JLabel(new ImageIcon(i8));
        l5.setBounds(80,535,170,163);
        contentPane.add(l5);
        
        JLabel l6 = new JLabel("");
        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/sixth.png"));
        Image i10 = i9.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        l6 = new JLabel(new ImageIcon(i10));
        l6.setBounds(353,537,139,152);
        contentPane.add(l6);
        
        JLabel l7 = new JLabel("");
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/seventh.png"));
        Image i12 = i11.getImage().getScaledInstance(155, 155, Image.SCALE_DEFAULT);
        l7 = new JLabel(new ImageIcon(i12));
        l7.setBounds(600,530,160,160);
        contentPane.add(l7);
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(205,133,63), 2), "Action", TitledBorder.LEADING,
        TitledBorder.TOP, null, new Color(255,0,0)));
        panel2.setBackground(new Color(255,229,204));
        panel2.setBounds(20,500,850,270);
        contentPane.add(panel2);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        
        if(msg.equals("Logout"))
        {
            setVisible(false);
            new Login_user().setVisible(true);
        }
        else if(msg.equals("Exit"))
        {
            System.exit(0);
        }
        else if(msg.equals("Read Me"))
        {
            new ReadMe().setVisible(true);
        }
        else if(msg.equals("About Us"))
        {
            new aboutUs().setVisible(true);
        }
        else if(msg.equals("Book Details"))
        {
            setVisible(false);
            new BookDetails().setVisible(true);
        }
        else if(msg.equals("Student Details"))
        {
            setVisible(false);
            new StudentDetails().setVisible(true);
        }
        else if(msg.equals("Books Available"))
        {
            setVisible(false);
            new BooksAvailable().setVisible(true);
        }
        else if(msg.equals("Pending Fines"))
        {
            setVisible(false);
            new PendingFine().setVisible(true);
        }
        
        if(ae.getSource() == b1)
        {
            this.setVisible(false);
            new AddBook().setVisible(true);
        }
        if(ae.getSource() == b2)
        {
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        if(ae.getSource() == b3)
        {
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }
        if(ae.getSource() == b4)
        {
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if(ae.getSource() == b5)
        {
            this.setVisible(false);
            new ReturnBook().setVisible(true);
        }
        if(ae.getSource() == b6 && !(msg.equals("About Us")))
        {
            this.setVisible(true);
            new aboutUs().setVisible(true);
        }
    }
}
