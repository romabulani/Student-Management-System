import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class DeleteFrame extends JFrame{
		
	Container c;
	JLabel lblRno,lblHead;
	JTextField txtRno;
	JButton btnBack,btnSave;
	
	DeleteFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(191,239,255));
		
		lblRno=new JLabel("Roll no ");
		txtRno=new JTextField(4);
		lblHead=new JLabel("Welcome to KAMAL CLASSES");
		
		lblRno.setBounds(190,150,80,100);
		txtRno.setBounds(245,190,80,20);
		lblHead.setBounds(150,50,300,30);
		
		lblHead.setFont(new Font("Serif",Font.BOLD,20));
		lblHead.setForeground(Color.RED);
		lblRno.setFont(new Font("Serif",Font.BOLD,15));
		lblRno.setForeground(Color.BLUE);
		
		c.add(lblHead);
		c.add(lblRno);
		c.add(txtRno);
		
		btnBack=new JButton("BACK");
		btnBack.setBounds(150,350,100,40);
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Serif",Font.BOLD,15));
		
		btnSave=new JButton("SAVE");
		btnSave.setBounds(350,350,100,40);
		btnSave.setBackground(new Color(58,129,53));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Serif",Font.BOLD,15));
		
		c.add(btnSave);
		c.add(btnBack);
		
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{	
			try{
				int rno=Integer.parseInt(txtRno.getText());
				
					DbHandler db=new DbHandler();
					db.deleteStudent(rno);
					txtRno.setText("");
					txtRno.requestFocus();
						
				}
				
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Please enter valid details");
					txtRno.setText("");
					txtRno.requestFocus();
				
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Error.Try Again!");
					txtRno.setText("");
					txtRno.requestFocus();
				}
			}
		});
		btnSave.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					
			try{
				int rno=Integer.parseInt(txtRno.getText());
				
					DbHandler db=new DbHandler();
					db.deleteStudent(rno);
					txtRno.setText("");
					txtRno.requestFocus();
						
				}
				
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Please enter valid details");
					txtRno.setText("");
					txtRno.requestFocus();
				
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Error.Try Again!");
					txtRno.setText("");
					txtRno.requestFocus();
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
		setTitle("Delete Record");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
}