import javax.swing.*;
import javax.swing.ImageIcon.*;
import java.awt.Image.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete;
	
	MainFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(191,239,255));
		JButton btnAdd,btnDelete,btnUpdate,btnView;
		JLabel lblAdd,lblDelete,lblView,lblUpdate;
		
		lblAdd=new JLabel("ADD A RECORD");
		lblDelete=new JLabel("DELETE A RECORD");
		lblView=new JLabel("VIEW RECORDS");
		lblUpdate=new JLabel("UPDATE A RECORD");
		
		ImageIcon imgAdd = new ImageIcon(getClass().getResource("add3.png"));
		btnAdd = new JButton (imgAdd);
		ImageIcon imgDelete = new ImageIcon(getClass().getResource("delete2.png"));
		btnDelete = new JButton (imgDelete);
		ImageIcon imgView = new ImageIcon(getClass().getResource("view1.jpg"));
		btnView = new JButton (imgView);
		ImageIcon imgUpdate = new ImageIcon(getClass().getResource("update1 (2).jpg"));
		btnUpdate = new JButton (imgUpdate);
		btnAdd.setBackground(Color.WHITE);
		btnDelete.setBackground(Color.WHITE);
		btnView.setBackground(Color.WHITE);
		btnUpdate.setBackground(Color.WHITE);
		
		btnAdd.setBounds(130,100,130,120);
		btnDelete.setBounds(310,100,130,120);
		btnUpdate.setBounds(130,300,130,120);
		btnView.setBounds(310,300,130,120);
		lblAdd.setBounds(150,180,100,100);
		lblDelete.setBounds(320,180,120,100);
		lblUpdate.setBounds(140,380,120,100);
		lblView.setBounds(330,380,120,100);
		
		
		lblAdd.setFont(new Font("Serif",Font.BOLD,12));
		lblAdd.setForeground(Color.BLUE);
		lblDelete.setFont(new Font("Serif",Font.BOLD,12));
		lblDelete.setForeground(Color.BLUE);
		lblUpdate.setFont(new Font("Serif",Font.BOLD,12));
		lblUpdate.setForeground(Color.BLUE);
		lblView.setFont(new Font("Serif",Font.BOLD,12));
		lblView.setForeground(Color.BLUE);
		
		
		c.add(btnAdd);
		c.add(btnDelete);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(lblAdd);
		c.add(lblDelete);
		c.add(lblUpdate);
		c.add(lblView);
		
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				AddFrame a=new AddFrame();
				dispose();
			}
		});
		
		btnAdd.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					AddFrame a=new AddFrame();
					dispose();
				}
				
			}
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
		});

		
		btnView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				PasswordFrame a=new PasswordFrame();
				dispose();
			}
		});
		btnView.addKeyListener(new KeyListener(){
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

		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				UpdateFrame a=new UpdateFrame();
				dispose();
			}
		});
		btnUpdate.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
				UpdateFrame a=new UpdateFrame();
					dispose();
			
				}
				
			}
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
			
			
			
		});

		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				DeleteFrame a=new DeleteFrame();
				dispose();
			}
		});
		btnDelete.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke)
			{
				if(ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					DeleteFrame a=new DeleteFrame();
					dispose();
			
				}
				
			}
			public void keyReleased(KeyEvent ke){}
			public void keyTyped(KeyEvent ke){}
			
			
			
		});
		this.addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent e){}
			public void windowDeactivated(WindowEvent e){}
			public void windowOpened(WindowEvent e){
				
			}
			public void windowClosing(WindowEvent e){
				int output=JOptionPane.showConfirmDialog(c,"Do you want to exit?");
				if(output==JOptionPane.YES_OPTION)
					System.exit(1);
			}
			public void windowClosed(WindowEvent e){}
			
			public void windowIconified(WindowEvent e){}
			public void windowDeiconified(WindowEvent e){}	
		});

		
		
		setTitle("Student Management System");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String args[])
	{
		MainFrame m=new MainFrame();
	}
	
}

class DbHandler
{
	public void addStudent(int rno,String name,String gender,String cgpi)
	{
		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql="insert into newstudent values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.setString(2,name);
			pst.setString(3,gender);
			pst.setString(4,cgpi);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records inserted");
			con.close();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(new JDialog(),"Insertion issue "+e);
			
		}
	}
	
	public String viewStudent()
	{
		StringBuffer sb=new StringBuffer();
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql="select * from newstudent";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int rno=rs.getInt(1);
				String name=rs.getString(2);
				String gender=rs.getString(3);
				String cgpi=rs.getString(4);
				
				sb.append("     "+rno+"\t\t"+name+"\t\t      "+gender+"\t    "+cgpi+"\n");
			}
			rs.close();	
			con.close();
		}
		catch(SQLException e){
			
		}
		return sb.toString();
	}
	public void updateStudent(int rno,String name,String gender,String cgpi)
	{
		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql="update newstudent set name=?,gender=?,cgpi=? where rno=?";
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(4,rno);
			pst.setString(1,name);
			pst.setString(2,gender);
			pst.setString(3,cgpi);
			
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records updated");
			con.close();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(new JDialog(),"Updation issue "+e);
			
		}
	}
	
	public void deleteStudent(int rno)
	{
		
		try{
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			String sql="delete from newstudent where rno=?";
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,rno);
			
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+" records deleted");
			
			con.close();
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(new JDialog(),"Deletion issue "+e);
			
		}
	}
	
	
}

