package myfirstprj;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import myfirstprj.csQuiz;
import myfirstprj.myconnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VCI Panchkula
 */
public class jradio3 extends javax.swing.JFrame {

    Toolkit   toolkit;
    Timer timer;
    int interval;String formatted="";
    /**
     * Creates new form jradio3
     */

     ArrayList<csQuiz> cArray=new ArrayList<>();
       
    public jradio3() {
          this(60);
       //
        //display();
      
    }
    public jradio3(int seconds)
    {
        
         initComponents();
         toolkit=Toolkit.getDefaultToolkit();
          display();
        timer=new Timer();
        interval=seconds;
        jLabel1.setText(String.valueOf(interval));
        timer.scheduleAtFixedRate(new TimerTask(){ public void  run(){
           
      long elapsedTime = setInterval()*1000;
            System.out.println("elapsed"+elapsedTime);
     String format = String.format("%%0%dd", 2);  
     elapsedTime = elapsedTime / 1000;  
     String seconds1 = String.format(format, elapsedTime % 60);  
     String minutes = String.format(format, (elapsedTime % 3600) / 60);  
     String hours = String.format(format, elapsedTime / 3600);  
     String time =  hours + ":" + minutes + ":" + seconds1;  
    
 jLabel1.setText(""+time);
        }}, 1000,1000);
        
        
    }
    
    
private  final int setInterval() {
    if (interval == 1)
    {
        
            toolkit.beep();
           jLabel1.setText("time out");
        timer.cancel();
    }
    return --interval;
}
    class RemindTask extends TimerTask
    {
        int nwarnings=3;

        @Override
        public void run() {
           /* 
            if(nwarnings>0)
            {
                toolkit.beep();
                nwarnings--;
            }
            else
            {
            toolkit.beep();
           jLabel1.setText("time out");
            timer.cancel();
           
             }*/
            
             if (interval == 1)
             {
   
            
            toolkit.beep();
           jLabel1.setText("time out");
            timer.cancel();
             }
             else
             {
                jLabel1.setText(--interval+"");
             }
        }
        
       
    }

    
    
     void display()
    {
        try
        {
            String q="select * from tbquiz";
            myconnection obj=new myconnection();
            PreparedStatement pst=obj.db.prepareStatement(q);
            ResultSet rs;
            rs=pst.executeQuery();
       
            JRadioButton op1=null,op2=null,op3=null,op4=null;
            JLabel lop1=null;
            int x=10,y=20,w=400,h=40;
            ButtonGroup b=null;
            while(rs.next())
            {
                b=new ButtonGroup();
                 final   csQuiz c=new csQuiz();
                c.setId(rs.getInt("id"));
                c.setQname(rs.getString("qname"));
                c.setOption1(rs.getString("option1"));
                c.setOption2(rs.getString("option2"));
                c.setOption3(rs.getString("option3"));
                c.setOption4(rs.getString("option4"));
                c.setAnswer(rs.getInt("answer"));
                op1=new JRadioButton(c.getOption1());
                op2=new JRadioButton(c.getOption2());
                op3=new JRadioButton(c.getOption3());
                op4=new JRadioButton(c.getOption4());
                lop1=new JLabel();
                lop1.setText(c.getQname());
                lop1.setBounds(x, y, h, h);
                y=y+20;
                op1.setBounds(x, y, w, h);
                y=y+20;
                 op2.setBounds(x, y, w, h);
                y=y+20;
                 op3.setBounds(x, y, w, h);
                y=y+20;
                 op4.setBounds(x, y, w, h);
                y=y+20;
                
                b.add(op1);
                b.add(op2);
                b.add(op3);
                b.add(op4);
              add(lop1);
              add(op1);
              add(op2);
              add(op3);
              add(op4);
                cArray.add(c);
                
                op1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       c.setAnswer(1);
                    }
                });
                
                
                  op2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       c.setAnswer(2);
                    }
                });
                  
                  
                  op3.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       c.setAnswer(3);
                    }
                });
                  
                  
                  
                  op4.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       c.setAnswer(4);
                    }
                });
                  
               
            }
            
            
            JButton bsubmit=new JButton("Submit");
           bsubmit.setBounds(x,y+40,w,h);
           add(bsubmit);
           bsubmit.addActionListener(new ActionListener()
{       
            
            
  
                @Override
                public void actionPerformed(ActionEvent e) {
                   for(int i=0;i<cArray.size();i++)
                   {
                       csQuiz ca=null;
                      ca =(csQuiz)cArray.get(i);
                       
                       System.out.println("Qname s "+ca.getQname()+" Answer s "+ca.getAnswer());
                   }
                }
            });
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
      /*  JRadioButton f1=new JRadioButton();
        f1.setText("radio1");
        f1.setBounds(10,20,90,20);
        add(f1);
        */
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(jradio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jradio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jradio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jradio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jradio3().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
