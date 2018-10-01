
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class mydata1 {
    public static void main(String[] args) {
        try
        {
            
            String dname="e:/datasend/dbproj";
           String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + dname + ";DriverID=22;READONLY=true";
         //   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c=DriverManager.getConnection(url);
            String q="insert into tbemp(fname,lname,salary)values('hh','dd',9000)";
            PreparedStatement pst=c.prepareStatement(q);
            pst.executeUpdate();


        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
