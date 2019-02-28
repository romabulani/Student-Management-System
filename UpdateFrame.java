import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class UpdateFrame extends JFrame{
	public boolean isAlpha(String str){
		int i;
			for( i=0;i<str.length();i++)
				if(str.charAt(i)>='a' && str.charAt(i)<='z' || str.charAt(i)>='A' && str.charAt(i)<='z'|| str.charAt(i)==' ')
					continue;
				else
					break;
			if(i==str.length()) return true;
			else return false;
		}
		
	Container c;
	JLabel lblRno,lblName,lblCgpi,lblHead;
	JTextField txtRno,txtName,txtCgpi;
	JButton btnBack,btnSave;
	JRadioButton rbMale,rbFemale;
	ButtonGroup bg;
	
	UpdateFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(191,239,255));
		
		lblRno=new JLabel("Roll no ");
		txtRno=new JTextField(4);
		lblName=new JLabel("New Name ");
		txtName=new JTextField(10);
		rbMale=new JRadioButton("Male");
		rbFemale=new JRadioButton("Female");
		lblHead=new JLabel("Welcome to KAMAL CLASSES");
		bg=new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbFemale);
		lblCgpi=new JLabel("Average CGPI  ");
		txtCgpi=new JTextField(5);
		
		lblRno.setBounds(80,100,80,100);
		txtRno.setBounds(135,140,80,20);
		lblName.setBounds(225,100,120,100);
		txtName.setBounds(300,140,200,20);
		rbMale.setBounds(150,200,80,20);
		rbFemale.setBounds(350,200,80,20);
		lblCgpi.setBounds(150,250,120,20);
		txtCgpi.setBounds(250,250,120,20);
		lblHead.setBounds(150,50,300,30);
		
		lblHead.setFont(new Font("Serif",Font.BOLD,20));
		lblHead.setForeground(Color.RED);
		lblRno.setFont(new Font("Serif",Font.BOLD,15));
		lblRno.setForeground(Color.BLUE);
		lblName.setFont(new Font("Serif",Font.BOLD,15));
		lblName.setForeground(Color.BLUE);
		rbMale.setFont(new Font("Serif",Font.BOLD,15));
		rbMale.setForeground(Color.BLUE);
		rbFemale.setFont(new Font("Serif",Font.BOLD,15));
		rbFemale.setForeground(Color.BLUE);
		rbFemale.setBackground(new Color(191,239,255));
		lblCgpi.setFont(new Font("Serif",Font.BOLD,15));
		lblCgpi.setForeground(Color.BLUE);
		rbMale.setBackground(new Color(191,239,255));
		
		c.add(lblHead);
		c.add(lblRno);
		c.add(txtRno);
		c.add(lblName);
		c.add(txtName);
		c.add(rbMale);
		c.add(rbFemale);
		c.add(lblCgpi);
		c.add(txtCgpi);
		
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
				String name=txtName.getText();
				double cgpi=Double.parseDouble(txtCgpi.getText());
				String gender=null;
				if(rbMale.isSelected())
					gender="Male";
				else if(rbFemale.isSelected())
					gender="Female";
				if(rno<=0 )
					{
						JOptionPane.showMessageDialog(new JDialog(),"Invalid roll no");
						txtRno.setText("");
						txtName.setText("");
						txtRno.requestFocus();
						txtCgpi.setText("");
						rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
					}
					if(name.length()==0 || !isAlpha(name) )
					{
						JOptionPane.showMessageDialog(new JDialog(),"Please enter valid name ");
						txtRno.setText("");
						txtName.setText("");
						txtRno.requestFocus();
						txtCgpi.setText("");
						rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
					}
					if(!rbMale.isSelected()&&!rbFemale.isSelected())
					{
						JOptionPane.showMessageDialog(new JDialog(),"Please enter gender details ");
						txtRno.setText("");
						txtName.setText("");
						txtRno.requestFocus();
						txtCgpi.setText("");
						rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
					}
			
				else{
					DbHandler db=new DbHandler();
					db.addStudent(rno,name,gender,String.valueOf(cgpi));
					txtRno.setText("");
						txtName.setText("");
						txtRno.requestFocus();
						txtCgpi.setText("");
						rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
						
				}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Please check details");
					txtRno.setText("");
					txtName.setText("");
					txtRno.requestFocus();
					txtCgpi.setText("");
					rbFemale.setSelected(false);
					rbMale.setSelected(false);
						
			
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Error.Try Again!");
					txtRno.setText("");
					txtName.setText("");
					txtRno.requestFocus();
					txtCgpi.setText("");
					rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
			
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
				String name=txtName.getText();
				double cgpi=Double.parseDouble(txtCgpi.getText());
				String gender=null;
				if(rbMale.isSelected())
					gender="Male";
				else if(rbFemale.isSelected())
					gender="Female";
				if(rno<0 || name.length()==0 || !isAlpha(name) || !rbMale.isSelected()&&!rbFemale.isSelected())
					{
						JOptionPane.showMessageDialog(new JDialog(),"Please enter valid details ");
						txtRno.setText("");
						txtName.setText("");
						txtRno.requestFocus();
						txtCgpi.setText("");
						rbFemale.setSelected(false);
						rbMale.setSelected(false);
						
						}
				else{
					DbHandler db=new DbHandler();
					db.updateStudent(rno,name,gender,String.valueOf(cgpi));
					txtRno.setText("");
					txtName.setText("");
					txtRno.requestFocus();
					txtCgpi.setText("");
					rbFemale.setSelected(false);
					rbMale.setSelected(false);
						
				}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Please enter valid details");
					txtRno.setText("");
					txtName.setText("");
					txtRno.requestFocus();
					txtCgpi.setText("");
					rbFemale.setSelected(false);
					rbMale.setSelected(false);
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Error.Try Again!");
					txtRno.setText("");
					txtName.setText("");
					txtRno.requestFocus();
					txtCgpi.setText("");
					rbFemale.setSelected(false);
					rbMale.setSelected(false);
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

		
		
		setTitle("Update Record");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
}