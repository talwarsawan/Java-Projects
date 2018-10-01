/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author VCI
 */
public class Client4 {
    String result;

    public Client4() {
        try
        {
            Socket c=new Socket("127.0.0.1",4012);
            Scanner s1=new Scanner(System.in);
            int s=0;
              DataInputStream f;
                DataOutputStream to;
                String msg;
                System.out.println("enter Message");
            do
            {
       
            System.out.println("Client :"); 
            msg=s1.nextLine();
         f =new DataInputStream(c.getInputStream());
         to =new DataOutputStream(c.getOutputStream());
         
         //   to.writeInt(s);
            to.writeUTF(msg);
        //    to.flush();
            
            result=f.readUTF();
            System.out.println("Server Replied : "+result);
           
            }
            while(!result.equals("stop"));
            f.close();
            to.close();
            c.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Client4();
    }
    
}
