/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Statistics extends JFrame
{
    private JPanel contentPane, panel, panel1;
    private JTable table, table1;
    
    public static void main(String args[])
    {
        new Statistics().setVisible(true);
    }
    
    public void issueBook()
    {
        try
        {
            conn con = new conn();
            String sql = "Select * from issueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            st.close();
            con.c.close();
        }
        catch(Exception e)
        {}
    }
    
    public void returnBook()
    {
        try
        {
            conn con = new conn();
            String sql = "Select * from returnBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs.close();
            st.close();
            con.c.close();
        }
        catch(Exception e)
        {}
    }
    
    public Statistics()
    {
        super("Book's Issue-Return Details");
        setBounds(400, 90, 1100, 800);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35,65,1007,298);
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
                if(evt.getClickCount() == 2)
                {
                    JTable target = (JTable)evt.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "Value : " + table.getModel().getValueAt(row, column).toString());
                }
            }
        });
        table.setBackground(new Color(224,255,255));
        table.setForeground(new Color(128,128,0));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );
        table.setRowHeight(35);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane.setViewportView(table);
        
        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47,79,79), 2, true), "Issue-Book-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,128,128)));
        panel.setBounds(26,42,1025,330);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
        JLabel l1 = new JLabel("Back");
        l1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        l1.setForeground(new Color(204,0,102));
        l1.setFont(new Font("Tahoma", Font.BOLD, 22));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("libraray/management/system/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        l1.setIcon(new ImageIcon(i2));
        l1.setBounds(50,10,200,30);
        contentPane.add(l1);
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(35,413,1007,298);
        contentPane.add(scrollPane1);
        
        table1 = new JTable()
        {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) 
            {
                return false;
            }
        };
        table1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {if(evt.getClickCount() == 2)
                {
                    JTable target = (JTable)evt.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    JOptionPane.showMessageDialog(null, "Value : " + table1.getModel().getValueAt(row, column).toString());
                }
            }
        });
        table1.setBackground(new Color(204,255,255));
        table1.setForeground(new Color(153,51,0));
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
        renderer1.setHorizontalAlignment( SwingConstants.CENTER );
        table1.setRowHeight(35);
        table1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane1.setViewportView(table1);
        
        panel1 = new JPanel();
        panel1.setBorder(new TitledBorder(new LineBorder(new Color(0,204,153), 2, true), "Return-Book-Details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,102,51)));
        panel1.setBounds(26,390,1025,330);
        panel1.setBackground(Color.WHITE);
        contentPane.add(panel1);
        
        issueBook();
        returnBook();
    }
}
