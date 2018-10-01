/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprj;

/**
 *
 * @author VCI
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class PaintBrush1 implements ActionListener,MouseListener,MouseMotionListener
{

int mousex=0,mousey=0;
	int prevx=0,prevy=0;
	int a,b,c,d;
	JFrame f;
JButton  
pencil,line,rect,oval,frect,foval,polygon,spline,fill,pick,eraser,text,ok;
	boolean  pencilop=false,fillop=false,rectop=false,ovalop=false,lineop=false,eraserop=false,frectop=false,fovalop=false;
        boolean pickop=false,textop=false;
	JPanel drawpanel,status;

	JColorChooser colchoose;
	JLabel xcor=new JLabel("X-Coordinate:");
	JLabel ycor=new JLabel("Y-Coordinate:");
	JTextField xtf=new JTextField(5);
	JTextField ytf=new JTextField(5);
	Color colpick=new Color(0,0,0);
	Color statuscol=new Color(0,200,200);
	String xCoor ="    ";
    String yCoor ="    ";
	JFrame fcolor,ftext;
JLabel size=new JLabel("Size");
	JTextField textsize=new JTextField("14",10);

JLabel sizee=new JLabel("Eraser Size");
	JTextField erasersize=new JTextField("10",5);



	public void actionPerformed(ActionEvent ae)
	{
	
		JButton be=(JButton)ae.getSource();
			if(be==pick)
			{
				fcolor.setVisible(true);
				pickop=true;
			}
			else if(be==pencil)
			{
				pencilop=true;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==fill)
			{
				pencilop=false;
				fillop=true;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==rect)
			{
				pencilop=false;
				fillop=false;
				rectop=true;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==oval)
			{
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=true;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==line)
			{
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=true;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==eraser)
			{
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=true;
				frectop=false;
				fovalop=false;
				textop=false;
			}
			else if(be==frect)
			{
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=true;
				fovalop=false;
				textop=false;
			}
			else if(be==foval)
			{
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=true;
				textop=false;
			}


	}

public void updateMouseCoordinates(MouseEvent e)
	{
		if (e.getX() < 0) xCoor = "0";
		else if (e.getX() > 800) xCoor = "800";
		else
		{
			xCoor = String.valueOf(e.getX());
		}

		if (e.getY() < 0) xCoor = "0";
		else if (e.getY() > 600) yCoor = "600";
		else
		{
			yCoor = String.valueOf(e.getY());
		}
		xtf.setText(xCoor);
		ytf.setText(yCoor);
	}
	public boolean mouseHasMoved(MouseEvent e)
	{
            System.out.println("mouse moved mousex s "+mousex+" mousey s "+mousey+" getx s "+e.getX()+ " y s"+e.getY());
		return (mousex != e.getX() || mousey !=  
e.getY());
	}
	public void mouseEntered(MouseEvent e)
	{
		updateMouseCoordinates(e);
	}
	public void mouseExited(MouseEvent e)
	{
		updateMouseCoordinates(e);
	}
	public void mouseMoved(MouseEvent e)
	{
		updateMouseCoordinates(e);
	}
	public void setMainColor()
	{
		if(pickop==true){
		colpick=colchoose.getColor();
		}
		else
		colpick=Color.black;
	}
	public void mousePressed(MouseEvent e)
	{
            System.out.println("Mouse pressed");
		prevx=e.getX();
		prevy=e.getY();
               
		updateMouseCoordinates(e);
		a=e.getX();
		b=e.getY();
                 System.out.println("a s "+a+" b s "+b);
	}
	public void mouseReleased(MouseEvent e)
	{
            System.out.println("Mouse Released");
		updateMouseCoordinates(e);
		rectoperation(e);
		fillrectoperation(e);
		ovaloperation(e);
		fillovaloperation(e);
		lineoperation(e);
	}
		/*
		for pencil operation mouse pressed is used  
for setting cuurent cursor location*/
	public void mouseClicked(MouseEvent e)
	{
		updateMouseCoordinates(e);
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		filloperation(e);
	//	textoperation(e);
	}
	public void mouseDragged(MouseEvent e)
	{
            System.out.println("Mouse Dragged c s "+c+" d s "+d);
		updateMouseCoordinates(e);
		penciloperation(e);
		eraseroperation(e);
                
		c=e.getX();
		d=e.getY();
           
	}
	public void penciloperation(MouseEvent e)
	{
		if(pencilop==true)
		{
			Graphics g  = drawpanel.getGraphics();
			g.setColor(colpick);
			setMainColor();
			g.setColor(colpick);
			if (mouseHasMoved(e))
			{
				mousex = e.getX();
				mousey = e.getY();
                                
                               
				g.drawLine 
(prevx,prevy,mousex,mousey);
				prevx = mousex;
				prevy = mousey;
                                
                                
			}
		}
	}
	public void lineoperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(lineop==true)
		{
			
			if (mouseHasMoved(e))
			{
                            System.out.println("line");
				mousex = e.getX();
				mousey = e.getY();
				g.drawLine 
(prevx,prevy,mousex,mousey);
			}
		}
	}
	public void rectoperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(rectop==true)
		{
				g.drawRect(a,b,c-a,d-b);
		}
	}
	public void fillrectoperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(frectop==true)
		{
				g.fillRect(a,b,c-a,d-b);
		}
	}
	public void ovaloperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(ovalop==true)
		{
				g.drawOval(a,b,c-a,d-b);
		}
	}
	public void fillovaloperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(fovalop==true)
		{
				g.fillOval(a,b,c-a,d-b);
		}
	}
	public void eraseroperation(MouseEvent e)
	{
		int erasers=Integer.parseInt 
(erasersize.getText());
		Graphics g  = drawpanel.getGraphics();
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
              
		g2.setStroke(new BasicStroke(erasers));
		if(eraserop==true)
		{
			
			if (mouseHasMoved(e))
			{
				mousex = e.getX();
				mousey = e.getY();
				g2.drawLine 
(prevx,prevy,mousex,mousey);
				prevx = mousex;
				prevy = mousey;
			}
		}
	}
	public void filloperation(MouseEvent e)
	{
		Graphics g  = drawpanel.getGraphics();
		g.setColor(colpick);
		setMainColor();
		g.setColor(colpick);
		if(fillop==true)
		{
			drawpanel.setBackground(colpick);
		}
	}



	public PaintBrush1()
	{
		f=new JFrame("Paint Brush");
	ok=new JButton("OK");
status=new JPanel();
		status.setBounds(48,600,800,30);
		status.setBackground(statuscol);
		status.add(sizee);
		status.add(erasersize);
		status.add(xcor);
		xtf.setEditable(false);
		status.add(xtf);
		status.add(ycor);
		ytf.setEditable(false);
		status.add(ytf);
	//size.setBounds(114,60,30,30);
		
f.add(status);
		drawpanel=new JPanel();
		drawpanel.setBounds(48,0,800,600);
		drawpanel.setBackground(Color.white);
	drawpanel.addMouseMotionListener(this);
		drawpanel.addMouseListener(this);
	colchoose=new JColorChooser();
		fcolor=new JFrame("Pick Color");
		fcolor.add(colchoose);
		fcolor.setSize(650,400);
		pencil=new JButton(new ImageIcon 
("pencil.jpg"));
		fill=new JButton(new ImageIcon("fill.jpg"));
		line=new JButton(new ImageIcon("line.jpg"));
		rect=new JButton(new ImageIcon 
("rectangle.jpg"));
		frect=new JButton(new ImageIcon 
("frect.jpg"));
		oval=new JButton(new ImageIcon("oval.jpg"));
		foval=new JButton(new ImageIcon 
("foval.jpg"));
		pick=new JButton(new ImageIcon("pick.jpg"));
		eraser=new JButton(new ImageIcon 
("eraser.jpg"));
pencil.setBounds(0,0,24,24);
		fill.setBounds(24,0,24,24);
		
		line.setBounds(0,24,24,24);
		rect.setBounds(24,24,24,24);
		oval.setBounds(0,48,24,24);
		pick.setBounds(24,48,24,24);
		eraser.setBounds(0,72,24,24);
		frect.setBounds(24,72,24,24);
		foval.setBounds(0,96,24,24);
	f.add(drawpanel);
		f.add(pencil);
		pencil.addActionListener(this);
                fill.addActionListener(this);
		f.add(fill);
		f.add(line);
                line.addActionListener(this);
                rect.addActionListener(this);
                oval.addActionListener(this);
                pick.addActionListener(this);
                eraser.addActionListener(this);
                frect.addActionListener(this);
                foval.addActionListener(this);
		f.add(rect);
		f.add(oval);
		f.add(pick);
		f.add(eraser);
		f.add(frect);
		f.add(foval);
f.setSize(864,690);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation 
(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new PaintBrush1();
	}



}