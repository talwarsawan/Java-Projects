/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptitude;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author VCI Panchkula
 */
public class testscroll2 extends JFrame{
       ArrayList<csques> cArray=new ArrayList<>();
    int cid, lid;
    String category,level,rn;
    Toolkit toolkit;
    Timer time;
    int interval;
    String formatted="";
    String date,tym;
      JPanel pn=new JPanel();
      
                   private		JScrollPane scrollPane;

   public testscroll2()
    { setTitle( "Scrolling Pane Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

        this.setVisible(true);
        display();
    }
   
   public static void main(String args[])
   {
       testscroll2 o=new testscroll2();
   }
       void display(){
        try{
            String s=String.valueOf(Calendar.getInstance().getTime());
   
           //* String q="select * from tbques where cid=? and lid=? order by rand() limit 5";
            String q="select * from tbques";
            myconnection ob=new myconnection();
            PreparedStatement pst=ob.db.prepareStatement(q);
            ResultSet rs;
            
           //* pst.setInt(1, lid);
            
           //* pst.setInt(2,cid);
            
            rs=pst.executeQuery();
            JRadioButton op1=null,op2=null,op3=null,op4=null;
            JLabel lop1=null;
            int x=20,y=150,w=1500,h=40;
            ButtonGroup b=null;
            while(rs.next()){
                b=new ButtonGroup();
                final csques ap=new csques();
                ap.setId(rs.getInt("id"));
                ap.setQname(rs.getString("qname"));
                ap.setA(rs.getString("a"));
                ap.setB(rs.getString("b"));
                ap.setC(rs.getString("c"));
                ap.setD(rs.getString("d"));
                ap.setAnswer(rs.getString("correct"));
                ap.userans="null";

                op1=new JRadioButton(ap.getA());
                op2=new JRadioButton(ap.getB());
                op3=new JRadioButton(ap.getC());
                op4=new JRadioButton(ap.getD());
                lop1=new JLabel();
                lop1.setText(ap.getQname());
                lop1.setBounds(x, y, w, h);
                y=y+20;
                op1.setBounds(x, y, w, h);
                y=y+20;
                
                op2.setBounds(x, y, w, h);
                y=y+20;
                op3.setBounds(x, y, w, h);
                y=y+20;
                op4.setBounds(x, y, w, h);
                y=y+40;
                b.add(op1);
                b.add(op2);
                b.add(op3);
                b.add(op4);
                cArray.add(ap);
                add(lop1);
                add(op1);
                add(op2);
                add(op3);
                add(op4);
                
                op1.addActionListener(new ActionListener() {
                    
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ap.setUserans("a");
                    }
                    
                });
                
                   op2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       ap.setUserans("b");
                         }
                });
                   op3.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                     ap.setUserans("c");
                         }
                });
                   
                   op4.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ap.setUserans("d");
                         }
                });
                   
                 
                 pn.add(lop1);
                    pn.add(op1);
                    pn.add(op2);
                    pn.add(op3);
                    pn.add(op4);
                   /*
                    JScrollPane myJScrollPane = new JScrollPane(pn,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
         JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    */
                   }
            
            JButton bsubmit=new JButton("SUBMIT");
            bsubmit.setBounds(x+20, y, 200, h);
            pn.add(bsubmit);
            
            JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		

		// Create a tabbed pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( pn );
		topPanel.add( scrollPane, BorderLayout.CENTER );
            bsubmit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   try{
                       data1();
                   }
                    catch(ArithmeticException ae){
                        System.out.println(ae.getMessage());
                        JOptionPane.showMessageDialog(null,"Attempt atleast one question");
                        data1();
                    }
                   
                   result fr=new result(cid, lid, rn, level,category);
                    fr.setVisible(true);
                }
                   
                    void data1(){
                    int cq=0, iq=0, uq=0;
                   
                   
                    for(int i=0; i<5;i++)
                    {
                        //JLabel l=new JLabel();
                        //l.setText("Q"+(i+1));
                        //add(l);
                        csques apt=null;
                       apt=(csques)cArray.get(i);
                        System.out.println("qname   "  + apt.getQname()+ "Answer  "+apt.getAnswer() );
                        
                        if(apt.userans.equals(apt.answer)){
                            cq=cq+1;
                        }
                        else if(apt.userans.equals("null")){
                            uq=uq+1;
                        }
                        else if(!apt.userans.equals(apt.answer))
                                {
                            iq=iq+1;
                        }  
                        
                        try{
                            
                        
                        String r="insert into tbresult (qid,answer)values (?,?)";
                   PreparedStatement x=ob.db.prepareStatement(r);
                   x.setInt(1, apt.getId());
                   x.setString(2, apt.getUserans());
                   
                   x.executeUpdate();
                        }
                        catch(SQLException y){
                            System.out.println(y.getMessage());
                        }
                    }
                    
                    try{
                    System.out.println("correct ques: "+cq);
                    System.out.println("incorrect: "+iq);
                    System.out.println("unattempted: "+uq);
                    
                    double net=cq-(0.25*iq);
                    double percentage= (net*100)/5;
                    double accuracy=(cq*100)/(5-uq);
                    double pattempt=((5-uq)*100)/5;
                    
                    
                    System.out.println("net: "+net);
                    System.out.println("percentage: "+percentage);
                    System.out.println("accuracy: "+accuracy);
                    System.out.println("percent atmpt: "+pattempt);
                    
                    
                    
                    myconnection o=new myconnection();
                    String s="insert into tbscore(rno,net,correct,incorrect,percentage,unattempted,accuracy,pattempt,date,time,cid,lid)values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement p=o.db.prepareStatement(s);
                    p.setString(1, rn);
                    p.setDouble(2, net);
                    p.setInt(3, cq);
                    p.setInt(4, iq);
                    p.setDouble(5, percentage);
                    p.setInt(6,uq);
                    p.setDouble(7, accuracy);
                    p.setDouble(8, pattempt);
                    p.setString(9, date);
                    p.setString(10, tym);
                    p.setInt(11,cid );
                    p.setInt(12,lid );
                    p.executeUpdate();
                    
                    }
                    
                
                    catch(SQLException s){
                        System.out.println(s.getMessage());
                    }
                    
                    
                    
                     }
            });
                   
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        for(int i=0;i<cArray.size();i++)
        {
            System.out.println(cArray.get(i).getQname());
        }
        
    }
}
