/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable
{
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    Thread th;
    int s;
    
    public static void main(String args[])
    {
        new Loading().setVisible(true);
    }
    
    public void setUploading()
    {
        th.start();
    }
    
    @Override
    public void run()
    {
        try
        {
            for(int i = 0; i < 200; i++)
            {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if(v < m)
                {
                    progressBar.setValue(progressBar.getValue() + 1);
                }
                else
                {
                    i = 201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(30);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Loading()
    {
        super("Loading");
        th = new Thread((Runnable) this);
        setBounds(600,300,600,400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lb1 = new JLabel("Digital Library");
        lb1.setForeground(new Color(72, 209, 204));
        lb1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lb1.setBounds(130, 46, 500, 35);
        contentPane.add(lb1);
        
        JLabel lb2 = new JLabel("Management v2.5");
        lb2.setForeground(new Color(72, 209, 204));
        lb2.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lb2.setBounds(130, 86, 500, 35);
        contentPane.add(lb2);
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 160, 300, 25);
        contentPane.add(progressBar);
        
        JLabel lb3 = new JLabel("Please Wait....");
        lb3.setForeground(new Color(160, 82, 45));
        lb3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lb3.setBounds(200, 195, 150, 20);
        contentPane.add(lb3);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 590, 390);
        contentPane.add(panel);
        
        setUploading();
    }
}
