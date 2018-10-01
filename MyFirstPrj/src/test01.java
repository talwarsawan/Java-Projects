
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class test01 implements ActionListener,MouseListener,MouseMotionListener
{
         int mousex=0,mousey=0;
	int prevx=0,prevy=0;
	int a,b,c,d;
	JFrame f;
	
	JButton pencil,line,rect,oval,frect,foval,polygon,spline,fill,pick,eraser,text,ok;
	boolean pencilop=false,fillop=false,rectop=false,ovalop=false,lineop=false,eraserop=false,frectop=false,fovalop=false,textop=false,pickop=false;
	
	JPanel drawpanel,status;
	JColorChooser colchoose;
	JLabel xcor=new JLabel("X-Coordinate:");
	JLabel ycor=new JLabel("Y-Coordinate:");
	JTextField textf=new JTextField("Enter your Text here!!!",20);
	JTextField xtf=new JTextField(5);
	JTextField ytf=new JTextField(5);
	Color colpick=new Color(0,0,0);
	Color statuscol=new Color(0,200,200);
	String xCoor ="    ";
     String yCoor ="    ";
	JFrame fcolor,ftext;
	JPanel textp;
	JComboBox textfont=new JComboBox();
	JLabel size=new JLabel("Size");
	JTextField textsize=new JTextField("14",10);
	JLabel sizee=new JLabel("Eraser Size");
	JTextField erasersize=new JTextField("10",5);
        
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      
    }
    
}
