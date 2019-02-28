import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
	Container c;
	TextArea ta;
	JButton btnBack;
	JLabel lblHead;

	ViewFrame()
	{
		c=getContentPane();
		c.setBackground(new Color(191,239,255));
		
		c.setLayout(null);
		lblHead=new JLabel("Welcome to KAMAL CLASSES");
		lblHead.setBounds(150,50,300,30);
		lblHead.setFont(new Font("Serif",Font.BOLD,20));
		lblHead.setForeground(Color.RED);
		c.add(lblHead);
		
		
		ta = new TextArea(50, 50);
		ta.setBounds(80,100,420,350);
		c.add(ta);
		ta.setEditable(false);

		
		btnBack=new JButton("BACK");
		btnBack.setBounds(250,475,100,40);
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Serif",Font.BOLD,15));
		
		c.add(btnBack);
		DbHandler db=new DbHandler();
		String data=db.viewStudent();
		ta.setForeground(Color.BLUE);
		ta.setFont(new Font("Serif",Font.BOLD,15));
		
		ta.setText("   Roll No\t Name\t\t     Gender\t  CGPI\n"+data);
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

		
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				PasswordFrame a=new PasswordFrame();
				dispose();
			}
		});
		btnBack.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					PasswordFrame a=new PasswordFrame();
					dispose();
				}
				
			}
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
			
			
			
		});
		
		setTitle("View Student");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		}
	
	
	
}