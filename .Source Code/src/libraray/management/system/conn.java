/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraray.management.system;
import java .sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn()
    {
    try
    {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:librarydata.db");
        s = c.createStatement();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
    }
}
