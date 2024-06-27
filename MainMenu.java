/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramya_dbms;


import ramya_dbms.doctor;
import ramya_dbms.patient;
import ramya_dbms.counts;
import ramya_dbms.d_plist;
import ramya_dbms.medicine; 
import ramya_dbms.trigger;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{   JFrame jf;
	JMenuBar mbar;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem m1_1,m1_2,m1_3,m1_4,m1_5,m1_6;
	JLabel l1,l2,l3,l4,l5;
	

	public MainMenu()
	{
        jf=new JFrame();
        
		jf.setLayout(null);
		
		l4 = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        l4.setFont(new Font("Times New Roman",Font.BOLD,25));
        l4.setForeground(Color.BLACK);
        l4.setBounds(50,50,650,40);
		jf.add(l4);
		
		l2 = new JLabel("An easy management for hospital");
		l2.setFont(new Font("Gabriola",Font.PLAIN,30));
		l2.setBounds(200,240,700,80);
		l2.setForeground(Color.black);
		jf.add(l2);

		mbar = new JMenuBar();
		jf.setJMenuBar(mbar);

		m1=new JMenu("Menu");
		mbar.add(m1);
		m1_1 = new JMenuItem("Doctor details");
		m1.add(m1_1);
		m1_2 = new JMenuItem("Patient details");
		m1.add(m1_2);
		m1_3 = new JMenuItem("Number of patient count");
		m1.add(m1_3);
		m1_4 = new JMenuItem("Doctor patient details");
		m1.add(m1_4);
		m1_5 = new JMenuItem("Medicine list");
		m1.add(m1_5);
                m1_6 = new JMenuItem("Trigger");
		m1.add(m1_6);
                m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m1_3.addActionListener(this);
                m1_4.addActionListener(this);
                m1_5.addActionListener(this);
                m1_6.addActionListener(this);
		jf.setTitle("Main Menu");
		jf.setLocation(20,20);
        jf.setSize(700,550);
	    jf.setResizable(false);
	   
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{

	  if(ae.getSource()==m1_1)
		{
		  new doctor();
		}
		else if(ae.getSource()==m1_2)
		{
			new patient();
		}
		else if(ae.getSource()==m1_3)
		 {
		   new counts();
		 }

		  else if(ae.getSource()==m1_4)
		 {
		   new d_plist();
		 }

		else if(ae.getSource()==m1_5)
		{
	        new medicine();
		}

		else if(ae.getSource()==m1_6)
		{
		  new trigger();
		}

  }

	public static void main(String args[])
	{
		new MainMenu();
	}
}