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

/**
 *
 * @author mramy
 */
public class trigger extends JFrame implements ActionListener{
        JFrame jf;
	JLabel ln,lb,l1,l2,l3;
    JButton b0,b1,b2;
    String s;
    JTextField t1,t2,t3;
	Font f;
    Connection con;
	PreparedStatement ps,ps1;
	Statement stmt;
	ResultSet rs;
    trigger(){
        jf=new JFrame();
		f = new Font("Times New Roman",Font.PLAIN,20);
		jf.setLayout(null);

	    ln=new JLabel("Trigger");
	    ln.setFont(new Font("Times New Roman",Font.PLAIN,25));
	    ln.setForeground(new java.awt.Color(0,0,0));
	    ln.setBounds(300,30,300,40);
	    jf.add(ln);
            l1=new JLabel("Patient ID: ");
            l1.setFont(f);
            l1.setBounds(50, 100, 200, 25);
            jf.add(l1);
            t1=new JTextField(20);
            t1.setBounds(250, 100, 100, 25);
            jf.add(t1);
            l2=new JLabel("Patient_bill: ");
            l2.setFont(f);
            l2.setBounds(50, 140, 200, 25);
            jf.add(l2);
            t2=new JTextField(20);
            t2.setBounds(250, 140, 100, 25);
            jf.add(t2);

            l3=new JLabel("Expense: ");
            l3.setFont(f);
            l3.setBounds(50, 180, 200, 25);
            jf.add(l3);
            t3=new JTextField(20);
            t3.setBounds(250, 180, 100, 25);
            jf.add(t3);

            b1=new JButton("Click here!!");
            b1.setBounds(400,330,110,35);
            jf.add(b1);
            b1.addActionListener(this);
          
             jf.setTitle("Trigger");
	     jf.setSize(900,700);
		 jf.setLocation(20,20);
		 jf.setResizable(false);
		 jf.getContentPane().setBackground(Color.cyan);
	     jf.setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            int r=0;
            String ex,bill,p_id;
                p_id=t1.getText();
                bill=t2.getText();
                ex=t3.getText();
            try{
                int expense=Integer.parseInt(ex);
                int p=Integer.parseInt(p_id);
                Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ramya";
         String user_name="root";
        String password="ladduhr@1021";
            con=DriverManager.getConnection(url,user_name,password);
            System.out.println("Connected");
            ps=con.prepareStatement("Update medical_record set patient_bill_paid=?,expense=? where p_id=?");
            ps.setString(1, bill);
            ps.setString(2, ex);
            ps.setInt(3,p );
            //rs=ps.executeQuery();
            int rowsaffected=ps.executeUpdate();
            System.out.println("Update successful");
            ps1=con.prepareStatement("Select flag from budget where for_name='Bandipur National Park'");
            rs=ps1.executeQuery();
            con.close();}
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Patient has dues. Pay it asap!!");
            }
            catch(Exception e){
                
            }
            
            
    }
    }
        
    public static void main(String[] args){
        new trigger();
    }
}

