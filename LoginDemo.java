import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;


public class LoginDemo implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	
	public LoginDemo() 
	{
		f = new JFrame("Login Form");
		p = new JPanel();
		p.setLayout(null);
		
		lab1 = new JLabel("ssn");
		lab1.setBounds(50, 60, 60, 20);
		lab2 = new JLabel("name");
		lab2.setBounds(50, 100, 100, 20);
		lab3 = new JLabel("address");
		lab3.setBounds(50, 140, 140, 20);
		lab4 = new JLabel("sex");
		lab4.setBounds(50, 180, 180, 20);
		lab5 = new JLabel("salary");
		lab5.setBounds(50, 220, 220, 20);
		lab6 = new JLabel("superssn");
		lab6.setBounds(50, 260, 260, 20);
		lab7 = new JLabel("dno");
		lab7.setBounds(50, 300, 300, 20);
		
		
		t1 = new JTextField();
		t1.setBounds(130, 60, 140, 20);
		t2 = new JTextField();
		t2.setBounds(130, 100, 140, 20);
		t3 = new JTextField();
		t3.setBounds(130, 140, 140, 20);
		t4 = new JTextField();
		t4.setBounds(130, 180, 140, 20);
		t5 = new JTextField();
		t5.setBounds(130, 220, 140, 20);
		t6 = new JTextField();
		t6.setBounds(130,260, 140, 20);
		t7 = new JTextField();
		t7.setBounds(130,300, 140, 20);
		
		
		b1 = new JButton("Submit");
		b1.setBounds(90, 340, 80, 25);
		b2 = new JButton("Reset");
		b2.setBounds(180, 340, 80, 25);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p.add(lab1);
		p.add(lab2);
		p.add(lab3);
		p.add(lab4);
		p.add(lab5);
		p.add(lab6);
		p.add(lab7);
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(t4);
		p.add(t5);
		p.add(t6);
		p.add(t7);
		p.add(b1);
		p.add(b2);
		
		f.add(p);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new LoginDemo();
	}


	public void actionPerformed(ActionEvent e) 
	{
		
		String ssn= t1.getText();
		String name= t2.getText();
		String address= t3.getText();
		String sex= t4.getText();
		String salary= t5.getText();
		String superssn= t6.getText();
		String dno= t7.getText();
		
		if(e.getSource()==b1)
		{
		

			try{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/company","root",""); 
			
			 
			System.out.println("connected");
			String sql = "insert into employee values("+ssn+",'"+name+"','"+address+"','"+sex+"',"+salary+","+superssn+","+dno+")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Login is Successfull!!!");
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		if(e.getSource()==b2)
		{
			
			
		}
	}


	
}






