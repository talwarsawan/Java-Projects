
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class Amouse extends Applet implements MouseListener,MouseMotionListener{

    
    String msg="";
    public void init()
    {
        
        
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        msg="mouse clicked "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
               msg="mouse Pressed "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
              msg="mouse released "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
           msg="mouse entered "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
   msg="mouse exited "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
           msg="mouse dragged "+e.getX()+" y  s "+e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
           msg="mouse moved "+e.getX()+" y  s "+e.getY();
        repaint();
    }
    
    
    public void paint(Graphics g)
    {
        g.drawString(msg, 40 ,60);
    }
    
}
