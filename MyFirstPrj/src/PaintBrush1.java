
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class PaintBrush1  implements ActionListener,MouseListener,MouseMotionListener{

    
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
        
        public PaintBrush1()
        {
            f=new JFrame("Paint Brush");
		ftext=new JFrame("Enter Text");
		ftext.setSize(300,200);
		textp=new JPanel();
		ok=new JButton("OK");
		ok.addActionListener(this);
		ftext.add(textp);
		mbar=new JMenuBar();
		f.setJMenuBar(mbar);
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
		textp.setLayout(null);
		textf.setBounds(0,0,285,30);
		textp.add(textf);
				GraphicsEnvironment ge = GraphicsEnvironment.
                getLocalGraphicsEnvironment();
                String[] fonts = ge.getAvailableFontFamilyNames();
				textfont = new JComboBox(fonts);
				textfont.setBounds(0,30,284,30);
				textp.add(textfont);
		size.setBounds(114,60,30,30);
		textp.add(size);
		textsize.setBounds(142,65,30,20);
		textp.add(textsize);
		ok.setBounds(114,90,58,30);
		textp.add(ok);
		textf.setEditable(false);
		f.add(status);
		drawpanel=new JPanel();
		drawpanel.setBounds(48,0,800,600);
		drawpanel.setBackground(Color.white);
		drawpanel.addMouseMotionListener(this);
		drawpanel.addMouseListener(this);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		colchoose=new JColorChooser();
		fcolor=new JFrame("Pick Color");
		fcolor.add(colchoose);
		fcolor.setSize(650,400);
		pencil=new JButton(new ImageIcon("pencil.jpg"));
		fill=new JButton(new ImageIcon("fill.jpg"));
		line=new JButton(new ImageIcon("line.jpg"));
		rect=new JButton(new ImageIcon("rectangle.jpg"));
		frect=new JButton(new ImageIcon("frect.jpg"));
		oval=new JButton(new ImageIcon("oval.jpg"));
		foval=new JButton(new ImageIcon("foval.jpg"));
		pick=new JButton(new ImageIcon("pick.jpg"));
		eraser=new JButton(new ImageIcon("eraser.jpg"));
		text=new JButton(new ImageIcon("text.jpg"));
		pencil.setBounds(0,0,24,24);
		fill.setBounds(24,0,24,24);
		fill.addActionListener(this);
		line.setBounds(0,24,24,24);
		rect.setBounds(24,24,24,24);
		oval.setBounds(0,48,24,24);
		pick.setBounds(24,48,24,24);
		eraser.setBounds(0,72,24,24);
		frect.setBounds(24,72,24,24);
		foval.setBounds(0,96,24,24);
		text.setBounds(24,96,24,24);
		pick.addActionListener(this);
		pencil.addActionListener(this);
		rect.addActionListener(this);
		frect.addActionListener(this);
		oval.addActionListener(this);
		foval.addActionListener(this);
		line.addActionListener(this);
		eraser.addActionListener(this);
		text.addActionListener(this);
		f.add(drawpanel);
		f.add(pencil);
		f.add(fill);
		f.add(line);
		f.add(rect);
		f.add(oval);
		f.add(pick);
		f.add(eraser);
		f.add(frect);
		f.add(foval);
		f.add(text);
		
		f.setSize(864,690);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
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
			else if(be==text)
			{
				ftext.setVisible(true);
				textf.setEditable(true);
				pencilop=false;
				fillop=false;
				rectop=false;
				ovalop=false;
				lineop=false;
				eraserop=false;
				frectop=false;
				fovalop=false;
				textop=true;
			}
			
    
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
    
    public static void  main(String args[])
    {
        PaintBrush1 p=new PaintBrush1();
    }
    
}
