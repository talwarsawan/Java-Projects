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
import java.util.Scanner;

/**
 *
 * @author VCI
 */
public class Server4 {
    String msg;
    Server4()
    {
        try
        {
        Socket s2=null;
        ServerSocket s1=new ServerSocket(4012);
            System.out.println("Server s started");
            DataInputStream d=null;
            DataOutputStream o=null;
            s2=s1.accept();
            System.out.println("Local port s "+s2.getLocalPort());
            d=new DataInputStream(s2.getInputStream());
            Scanner s11=new Scanner(System.in);
            String r;
            o=new DataOutputStream(s2.getOutputStream());
            do
            {
               
               msg=d.readUTF();
               System.out.println("Client Said :"+msg);
                System.out.println("Server :");
               
               r=s11.nextLine();
               o.writeUTF(r);
            }
            while(!msg.equals("stop"));
            
             d.close();
                o.close();
                s2.close(); 
        }
        
        catch(Exception e)
        {
           // System.out.println("dd"+e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        new Server4();
    }
}
