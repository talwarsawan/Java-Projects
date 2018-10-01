/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptitude;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


        
/**
 *
 * @author saumyasinghal
 */
public class myconnection {
  Connection db;
  public myconnection()
  {
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          db=DriverManager.getConnection("jdbc:mysql://localhost/dbapt","root","");
      }
      catch(ClassNotFoundException e)
      {
      System.out.println(e.getMessage());
      }
      catch(SQLException e)
      {
       System.out.println(e.getMessage());
      }
  }
  public static void main(String args[]){
      
  }
}
