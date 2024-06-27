/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramya_dbms;

/**
 *
 * @author mramy
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class patient extends JFrame implements ActionListener{
        JFrame jf;
	JLabel ln,lb;
    JButton b0,b1,b2;
    String s;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    patient(){
        jf=new JFrame();
		f = new Font("Times New Roman",Font.PLAIN,20);
		jf.setLayout(null);

	    ln=new JLabel("Patient details");
	    ln.setFont(new Font("Algerian",Font.PLAIN,25));
	    ln.setForeground(new java.awt.Color(0,0,0));
	    ln.setBounds(300,30,300,40);
	    jf.add(ln);
            b1=new JButton("Click here!!");
            b1.setBounds(450,330,110,35);
            jf.add(b1);
            b1.addActionListener(this);
            scrlPane.setBounds(0,380,900,600);
            jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));
            model.addColumn("Patient_name");
            model.addColumn("Disease_name");
            model.addColumn("Address");
            model.addColumn("Phone");
            model.addColumn("Expense");
             jf.setTitle("Patient_details");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.cyan);
	     jf.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            int r=0;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ramya";
         String user_name="root";
        String password="ladduhr@1021";
            con=DriverManager.getConnection(url,user_name,password);
            System.out.println("Connected");
            ps=con.prepareStatement("Select pname,problem,address,phone,expense from patient,medical_record where patient_id=p_id");
		  rs=ps.executeQuery();
		  while(rs.next())
	      {
		 model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
    
              }
            con.close();
            }
            catch(SQLException e){
                
            }
            catch(Exception e){
                
            }
        }
    }
    public static void main(String[] args){
        new patient();
    }
}

