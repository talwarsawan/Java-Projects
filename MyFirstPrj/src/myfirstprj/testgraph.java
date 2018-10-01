/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprj;
import java.io.*; 
import java.sql.*; 
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author VCI
 */
public class testgraph {
    
    public static void main(String[] args) throws Exception{
      String mobilebrands[] = {
      "IPhone 5s",   
      "SamSung Grand",   
      "MotoG",            
      "Nokia Lumia" 
      };
      /* Create MySQL Database Connection */
     myconnection obj=new myconnection();
     Statement st;
     st=obj.db.createStatement();
      ResultSet resultSet = st.executeQuery("select * from tbtest" );
      DefaultPieDataset dataset = new DefaultPieDataset( );
      while(resultSet.next() ) 
      {
         dataset.setValue(resultSet.getString( "name" ) ,Double.parseDouble( resultSet.getString( "marks" )));
      }
        JFreeChart chart = ChartFactory.createPieChart(
         "Mobile Sales",  // chart title           
         dataset,         // data           
         true,            // include legend          
         true,           
         false );
      int width = 560; /* Width of the image */
      int height = 370; /* Height of the image */ 
      File pieChart = new File( "Pie_Chart.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
   }
    
}
    
   
