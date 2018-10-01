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
public class csUser {
    int id;
    String name;

    public csUser() {
    }

    public int getId() {
        return id;
    }

    public csUser(int id, String name) {
        this.id = id;
        this.name = name;
    }
@Override
    public String toString()
    {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
