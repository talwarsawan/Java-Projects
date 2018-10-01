
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class MouseTest implements MouseListener,MouseMotionListener{

    JFrame f;
    public MouseTest()
    {
        f=new JFrame("PaintBrush");
        f.setSize(900, 900);
        f.addMouseListener(this);
        f.addMouseMotionListener(this);
        JTextArea ja=new JTextArea();
        f.add(ja);
        ja.addMouseListener(this);
        ja.addMouseMotionListener(this);
        f.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse s clicked at mousex= "+e.getX()+" mousey = "+e.getY()); 
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
               System.out.println("Mouse s Presses at mousex= "+e.getX()+" mousey = "+e.getY()); 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse s released at mousex= "+e.getX()+" mousey = "+e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
        System.out.println("Mouse s entered at mousex= "+e.getX()+" mousey = "+e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
   
        System.out.println("Mouse s exited at mousex= "+e.getX()+" mousey = "+e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        System.out.println("Mouse s dragged at mousex= "+e.getX()+" mousey = "+e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse s moved at mousex= "+e.getX()+" mousey = "+e.getY());
    }
    
    /*
    mouse pressed
    released 
    clicked
    
    dragging
    
    Pressed
    Dragged
    released
    
    
    
    
    */
    
    public static void main(String[] args) {
        MouseTest o=new MouseTest();
    }
    
}
