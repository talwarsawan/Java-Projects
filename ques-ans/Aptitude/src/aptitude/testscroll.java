/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptitude;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author VCI Panchkula
 */
public class testscroll extends JFrame {
    private		JScrollPane scrollPane;

    
    public testscroll()
    {
        setTitle( "Scrolling Pane Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		Icon image = new ImageIcon( "BarChart.jpeg" );
		JLabel label = new JLabel( image );

		// Create a tabbed pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( label );
		topPanel.add( scrollPane, BorderLayout.CENTER );
                this.setVisible(true);
    }
    
    
    public static void main(String args[])
    {
       testscroll s=new testscroll();
    }
}
