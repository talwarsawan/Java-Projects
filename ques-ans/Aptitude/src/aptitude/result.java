/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptitude;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author saumyasinghal
 */
public class result extends javax.swing.JFrame {
        int cid,lid;
    String rn,level,category;

    /**
     * Creates new form result
     */
    
    
    /*
    public result(int cid,int lid, String rn,String level, String category) {
        initComponents();
        this.cid=cid;
        this.lid=lid;
        this.rn=rn;
        this.category=category;
        this.level=level;
        display();
        this.setTitle("AptiForYou");
    }*/

    public result()
    {
        initComponents();
        display();
        pn.setPreferredSize(new Dimension(1900, 4900));
    }
    void display(){
        try
        {
            ct.setText(category);
            lv.setText(level);
            rno.setText(rn);
            
             myconnection ob=new myconnection();
            String q="select * from tbscore order by id desc";
            PreparedStatement pst=ob.db.prepareStatement(q);
            ResultSet rs;
            rs=pst.executeQuery();
            rs.next();
            double net=rs.getDouble("net");
            ns.setText(String.valueOf(net));
            if(net<7.5){
              pr.setText("NEED IMPROVEMENT");
            }
            else if(net<10.5){
                pr.setText("AVERAGE");
       
            }
            else 
                pr.setText("GOOD");
       
            DefaultCategoryDataset d= new DefaultCategoryDataset();
      double percentage,accuracy,pattempt;
          rn=rs.getString("rno");
          percentage=rs.getDouble("percentage");
          accuracy=rs.getDouble("accuracy");
          pattempt=rs.getDouble("pattempt");
          
          d.setValue(percentage, rn, "Marks");
          d.setValue(accuracy, rn, "Accuracy");
          d.setValue(pattempt, rn, "Attempt");
            
     
      JFreeChart bchart = ChartFactory.createBarChart(      //chart fact predefined clas
         "TEST ANALYSIS", 
         "", "PERCENTAGE", 
         d,PlotOrientation.HORIZONTAL, 
         true, true, false);  //legend tooltil path
         
      
      int width = 500; /* Width of the image */
      int height = 200; /* Height of the image */ 
      File fpath = new File( "BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( fpath , bchart , width , height );    //img generated wid help f ds clas
      barc.setIcon(new ImageIcon("BarChart.jpeg"));
        
                
      DefaultPieDataset ds= new DefaultPieDataset();
     
        //DefaultPieDataset dataset = new DefaultPieDataset();
        ds.setValue("CORRECT", new Integer(rs.getInt("correct")));
        ds.setValue("INCORRECT", new Integer(rs.getInt("incorrect")));
        ds.setValue("UNATTEMPTED", new Integer(rs.getInt("unattempted")));
        
        
        
        JFreeChart chart = ChartFactory.createPieChart(
            "QUESTION ANALYSIS",  // chart title
            ds,             // data
            true,               // include legend
            true,
            false
        );

        int wid=500;
        int ht=200;
        File f1path=new File("pie.jpeg");
        
        ChartUtilities.saveChartAsJPEG(f1path, chart, wid, ht);
    
        piec.setIcon(new ImageIcon("pie.jpeg"));
   
      
      
      
            int x=20,y=350,w=1500,h=40;
            
            
          // String s="select q.qname,q.a,q.b,q.c,q.d,q.correct,r.answer,q.solution from tbques q, tbresult r where q.id=r.qid";
            String s="select q.qname,q.a,q.b,q.c,q.d,q.correct,q.correct,q.solution from tbques q where id>=5";
            PreparedStatement st=ob.db.prepareStatement(s);
                ResultSet r;
                r=st.executeQuery();
                while(r.next()){
                    
               
                JLabel qnm=new JLabel();
                qnm.setText("Ques: "+r.getString(1));
                JLabel op1=new JLabel();
                op1.setText("a) "+r.getString(2));
                JLabel op2=new JLabel();
                op2.setText("b) "+r.getString(3));
                JLabel op3=new JLabel();
                op3.setText("c) "+r.getString(4));
                JLabel op4=new JLabel();
                op4.setText("d) "+r.getString(5));
                
                
                JLabel ua=new JLabel();
                JLabel userans=new JLabel();
                userans.setText("Your answer: ");
                ua.setText(r.getString(7));
                JLabel ca=new JLabel();
                JLabel cor=new JLabel();
                cor.setText("Correct answer: ");
                ca.setText(r.getString(6));
                    
                JTextArea ta=new JTextArea();
                ta.setText(r.getString(8));
                
                ta.setEditable(false);
                  JScrollPane jj1=new JScrollPane(ta);
                  
                qnm.setBounds(x,y,w, h);
                y=y+20;
                op1.setBounds(x,y,w, h);
                y=y+20;
                op2.setBounds(x,y,w, h);
                y=y+20;
                op3.setBounds(x,y,w, h);
                y=y+20;
                op4.setBounds(x,y,w, h);
                y=y+20;
                
                
                userans.setBounds(x,y ,w ,h );
                y=y+20;
                ua.setBounds(x, y,w ,h);
                y=y+20;
                //x=x-50;
                cor.setBounds(x, y, w,h);
                y=y+20;
                ca.setBounds(x,y ,w ,h );
                y=y+40;
               // x=x-50;
                
                jj1.setBounds(x, y, w-900, h);
                y=y+40;
                
                pn.add(qnm);
                pn.add(op1);
                pn.add(op2);
                pn.add(op3);
                pn.add(op4);
                
                pn.add(userans);
                pn.add(ua);
                pn.add(cor);
                pn.add(ca);
                pn.add(jj1);
            }
                    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ct = new javax.swing.JLabel();
        lv = new javax.swing.JLabel();
        rno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barc = new javax.swing.JLabel();
        piec = new javax.swing.JLabel();
        ns = new javax.swing.JTextField();
        pr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pn.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aptitude/150px-CcetLogo.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("CHANDIGARH  COLLEGE  OF  ENGINEERING  AND  TECHNOLOGY");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Aptitude  Test");

        jLabel4.setText("CATEGORY:");

        jLabel5.setText("LEVEL:");

        jLabel6.setText("ROLL NO:");

        ct.setText("jLabel7");

        lv.setText("jLabel8");

        rno.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(ct)
                        .addGap(354, 354, 354)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(rno)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(549, 549, 549)
                                .addComponent(jLabel3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(ct)
                    .addComponent(lv)
                    .addComponent(rno))
                .addGap(17, 17, 17))
        );

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("REPORT  CARD");

        jLabel8.setText("NET  SCORE:");

        jLabel9.setText("PERFROMANCE:");

        ns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLayout = new javax.swing.GroupLayout(pn);
        pn.setLayout(pnLayout);
        pnLayout.setHorizontalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayout.createSequentialGroup()
                .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel7))
                    .addGroup(pnLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(barc, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(piec, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLayout.setVerticalGroup(
            pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(35, 35, 35)
                        .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(piec, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barc, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(555, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            try{
    myconnection ob=new myconnection();
          String z="truncate tbresult";
            PreparedStatement u=ob.db.prepareStatement(z);
            u.executeQuery();
            
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
    }
        
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void nsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nsActionPerformed

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
            java.util.logging.Logger.getLogger(result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barc;
    private javax.swing.JLabel ct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lv;
    private javax.swing.JTextField ns;
    private javax.swing.JLabel piec;
    private javax.swing.JPanel pn;
    private javax.swing.JTextField pr;
    private javax.swing.JLabel rno;
    // End of variables declaration//GEN-END:variables
}
