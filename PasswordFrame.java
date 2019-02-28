import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PasswordFrame extends JFrame{
		
	Container c;
	JLabel lblName,lblHead,lblPwd;
	JTextField txtName;
	JButton btnEnter,btnBack;
	JPasswordField pwd;
	
	PasswordFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(191,239,255));
		
		lblName=new JLabel("Username ");
		lblPwd=new JLabel("Password");
		txtName=new JTextField(10);
		lblHead=new JLabel("Welcome to KAMAL CLASSES");
		pwd=new JPasswordField(10);
		
		lblName.setBounds(170,100,120,100);
		txtName.setBounds(270,140,200,20);
		lblPwd.setBounds(170,200,120,100);
		lblHead.setBounds(150,50,300,30);
		pwd.setBounds(270,240,200,20);
		lblHead.setFont(new Font("Serif",Font.BOLD,20));
		lblHead.setForeground(Color.RED);
		lblName.setFont(new Font("Serif",Font.BOLD,15));
		lblName.setForeground(Color.BLUE);
		lblPwd.setFont(new Font("Serif",Font.BOLD,15));
		lblPwd.setForeground(Color.BLUE);
		
		c.add(lblHead);
		c.add(lblName);
		c.add(lblPwd);
		c.add(txtName);
		c.add(pwd);
		
		btnBack=new JButton("BACK");
		btnBack.setBounds(150,350,100,40);
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Serif",Font.BOLD,15));
		
		btnEnter=new JButton("ENTER");
		btnEnter.setBounds(350,350,100,40);
		btnEnter.setBackground(new Color(58,129,53));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Serif",Font.BOLD,15));
		
		c.add(btnEnter);
		c.add(btnBack);
		
		btnEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{	
			if(txtName.getText().equals("Roma") && pwd.getText().equals("12345"))
			{
				ViewFrame a=new ViewFrame();
				dispose();
			}
				else{
					
					JOptionPane.showMessageDialog(new JDialog(),"Incorrect Details.Try Again!");
					txtName.setText("");
					txtName.requestFocus();
					pwd.setText("");					
				}	
			}
		});
		btnEnter.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					if(txtName.getText().equals("Roma") && pwd.getText().equals("12345"))
				{
					ViewFrame a=new ViewFrame();
					dispose();
				}
					else{
					
						JOptionPane.showMessageDialog(new JDialog(),"Incorrect Details.Try Again!");
						txtName.setText("");
						txtName.requestFocus();
						pwd.setText("");					
					}	
				}
					
			}
				
			
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
			
			
	});
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				MainFrame a=new MainFrame();
				dispose();
			}
		});
				btnBack.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					MainFrame a=new MainFrame();
				dispose();
			
					
				}
				
			}
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
			
			
			

});
this.addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent e){}
			public void windowDeactivated(WindowEvent e){}
			public void windowOpened(WindowEvent e){}
			public void windowClosing(WindowEvent e){
				int output=JOptionPane.showConfirmDialog(c,"Do you want to exit?");
				if(output==JOptionPane.YES_OPTION)
					System.exit(1);
			}
			public void windowClosed(WindowEvent e){}
			
			public void windowIconified(WindowEvent e){}
			public void windowDeiconified(WindowEvent e){}	
		});

		setTitle("Authentication");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);	
	}
	
}