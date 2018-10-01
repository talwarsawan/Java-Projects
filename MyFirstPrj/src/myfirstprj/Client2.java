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
public class Client2 {
    double radius,result;

    public Client2() {
        try
        {
            Socket c=new Socket("127.0.0.1",4010);
            Scanner s1=new Scanner(System.in);
            System.out.println("enter radius");
            radius=s1.nextDouble();
            DataInputStream f=new DataInputStream(c.getInputStream());
            DataOutputStream to=new DataOutputStream(c.getOutputStream());
         
            to.writeDouble(radius);
          
            result=f.readDouble();
            System.out.println("Radius s "+radius+" and Area of circle s "+result);
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
        new Client2();
    }
    
}
