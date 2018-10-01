/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprj;

/**
 *
 * @author VCI Panchkula
 */
public class csTest1 {
    int id;
    String qname;

    @Override
    public String toString() {
        return  qname ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }
    public static void main(String args[])
    {
        csTest1 obj1=new csTest1();
        obj1.id=99;
        obj1.qname="Programming";
        System.out.println(obj1);
    }
}
