/*Elaborado por Rafael Guevara
Ejemplo pestañas swing
*/
package com.rd.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;

public class Formulario_I extends JPanel {
  private static String cadenas[] = {"LastName", "FirstName", "Address", "TelNo", "Age"};
  private GridBagConstraints constraints = new GridBagConstraints();	
    
  private JPanel crearPanel(int campos){
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
	int k = 0,l = 0;
    for ( int i = 0; i< campos; i++ ){
      JLabel etiqueta = new JLabel(cadenas[i]+":");  
      setNewConstraints(k, l, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
	  constraints.insets = new Insets(5,5,0,25);	
      panel.add(etiqueta, constraints);
      setNewConstraints(k+1, l, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
      panel.add(new JTextField(), constraints);
      l++;  		  
    }
	return panel;	
  }
  
  private JPanel crearPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    panel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
    panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	JButton button_1 = new JButton("Close");
	JButton button_2 = new JButton("Cancel");
	JButton button_3 = new JButton("Save");
	button_1.setPreferredSize(new Dimension(100, 25));
	button_2.setPreferredSize(new Dimension(100, 25));
	button_3.setPreferredSize(new Dimension(100, 25));
	panel.add(button_1);   
	panel.add(button_2);	
	panel.add(button_3);
	return panel;	
  }

  private JPanel crearPanelSup(){
    JPanel panel = new JPanel();
	panel.setBorder(BorderFactory.createEmptyBorder(5,0,0,25));
    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	JButton button_1 = new JButton("Connect");
	button_1.setPreferredSize(new Dimension(100, 25));
	panel.add(button_1);   
	return panel;	
  }  
 
  private void setNewConstraints(int gridx, int gridy, int gridwidth,
                           int gridheight, int weightx, int anchor, 
				           int fill){
    constraints.gridx = gridx;				
    constraints.gridy = gridy;
    constraints.gridwidth = gridwidth;
    constraints.gridheight = gridheight;
    constraints.weightx = (double) weightx;
    constraints.anchor = anchor;
    constraints.fill = fill; 
    constraints.insets = new Insets(5,5,0,0);	
  }
  
  public Formulario_I() {
    setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
	setBorder(BorderFactory.createEmptyBorder(0,5,25,25));
	add(crearPanelSup());
    add(crearPanel(cadenas.length));
	add(crearPanel());
  }

  public static void main( String args[] ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Formulario_I(), BorderLayout.CENTER);
    frame.setSize(460,290);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
} 
