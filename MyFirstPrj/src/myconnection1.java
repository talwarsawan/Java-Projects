
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class myconnection1 {
    Connection db;
    public myconnection1()
    {
        try
        {
           
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
            db=DriverManager.getConnection("jdbc:odbc:mydata");
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
