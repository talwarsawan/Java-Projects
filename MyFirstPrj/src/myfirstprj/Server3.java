/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author VCI
 */
public class Server3 {
 
    double area;
    Server3()
    {
        try
        {
            Socket s2=null;
            ServerSocket s1=new ServerSocket(4010);
            System.out.println("Server started");
              int cont=1;
              DataInputStream d=null;
                  DataOutputStream o=null; 
            while(cont==1)
            {
             
                    s2 =s1.accept();
                System.out.println("Local port number of socket"+s2.getLocalPort());
              d =new DataInputStream(s2.getInputStream());
             o=new DataOutputStream(s2.getOutputStream());
              // cont=d.readInt();
                //System.out.println(cont);
               
                   
                
              double radius=0;
                
                do
                {
                  radius =d.readDouble();
                area=3.14*radius*radius;
                o.writeDouble(area);
               
//              radius=d.readDouble();
//                area=3.14*radius*radius;1
//                 o.writeDouble(area);
                }
                while(radius>0);
               
            }
              d.close();
                o.close();
                s2.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    public static  void main(String[] a)
    {
        new Server3();
    }
}
