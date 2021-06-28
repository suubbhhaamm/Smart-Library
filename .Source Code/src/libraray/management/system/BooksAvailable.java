/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class BooksAvailable extends JFrame implements ActionListener
{
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1, b2;
    
    public static void main(String args[])
    {
        new BooksAvailable().setVisible(true);
    }
    
    public void availableBook()
    {
        try
        {
            conn con = new conn();
            String sql = "Select * from availableBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }
        catch(Exception e)
        {
        }
    }
    
    public BooksAvailable()
    {
        setBounds(400, 90, 1100, 800);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(55,133,971,580);
        contentPane.add(scrollPane);
        
        table = new JTable()
        {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) 
            {
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if(evt.getClickCount() == 1)
                {
                    int row = table.getSelectedRow();
                    search.setText(table.getModel().getValueAt(row, 1).toString());
                }
                else if(evt.getClickCount() == 2)
                {
                    JTable target = (JTable)evt.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "Value : " + table.getModel().getValueAt(row, column).toString());
                }
            }
        });
        table.setBackground(new Color(240,248,255));
        table.setForeground(Color.DARK_GRAY);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );
        table.setRowHeight(35);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        scrollPane.setViewportView(table);
        
        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,47), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        b1.setIcon(new ImageIcon(i2));
        b1.setForeground(new Color(199,21,133));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        b1.setBounds(610, 88, 160, 35);
        contentPane.add(b1);
        
        JLabel l1 = new JLabel("Books in Library");
        l1.setForeground(new Color(107,142,35));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
        l1.setBounds(320,15,350,47);
        contentPane.add(l1);
        
        search = new JTextField();
        search.setBackground(new Color(255,240,245));
        search.setForeground(new Color(47,79,79));
        search.setBorder(new LineBorder(new Color(255,105,180), 2, true));
        search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
        search.setColumns(10);
        search.setBounds(197,89,375,33);
        contentPane.add(search);
        
        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/tenth.png")); 
        Image i6 = i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        l3.setIcon(new ImageIcon(i6));
        l3.setBounds(97,89,72,33);
        contentPane.add(l3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,128,128), 3, true), "Available-Books",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,128,0)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(40,54,1002,670);
        contentPane.add(panel);
        
        availableBook();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn con = new conn();
            if(ae.getSource() == b1)
            {
                String sql = "Select * from availableBook where name || book_id like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, "%" + search.getText() + "%");
                ResultSet rs = st.executeQuery();
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }
            con.c.close();
            
        }
        catch(Exception e)
        {
        }
    }
}
