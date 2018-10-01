/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptitude;

import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author VCI Panchkula
 */
public class scrolltest extends javax.swing.JFrame {

    /**
     * Creates new form scrolltest
     */
      ArrayList<csques> cArray=new ArrayList<>();
    int cid, lid;
    String category,level,rn;
    Toolkit toolkit;
    Timer time;
    int interval;
    String formatted="";
    String date,tym;
    
    public scrolltest() {
        initComponents();
        display();
       pn.setPreferredSize(new Dimension(1900, 9900));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pn = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout pnLayout = new javax.swing.GroupLayout(pn);
        pn.setLayout(pnLayout);
        pnLayout.setHorizontalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        pnLayout.setVerticalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(scrolltest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scrolltest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scrolltest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrolltest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scrolltest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn;
    // End of variables declaration//GEN-END:variables
}
