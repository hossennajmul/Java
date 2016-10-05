import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SearchPatientFrame extends JFrame implements ActionListener {
	private JPanel panel;
	
	private JLabel LabelId,labelsearch,labelName,labelgender,labeladdress,labelappointement,labelward;
	private JTextField textid,textname,textsearch,textgender,textaddress,textappointment,textward;
	private JButton buttonSearch;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	public SearchPatientFrame()
	{
		this.initialize();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		try
		{
			
			String str = textsearch.getText();
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
			
			PreparedStatement st = con.prepareStatement("Select * from patient where name =?");
			st.setString(1,str);
			rs=st.executeQuery();
			if(rs.next())
			{
				String a = rs.getString(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				String d = rs.getString(4);
				String e = rs.getString(5);
				String f = rs.getString(6);
				
				textid.setText(a);
				textname.setText(b);
				textgender.setText(c);
				textaddress.setText(d);
				textappointment.setText(e);
				textward.setText(f);
				
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Name Not Found");
			}
		}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
	
	}
	
	private void initialize()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.labelsearch = new JLabel("Enter patient Name");
		this.labelsearch.setBounds(20,30,200,20);
		this.panel.add(this.labelsearch);
		
		this.textsearch = new JTextField();
		this.textsearch.setBounds(240,30,150,20);
		this.panel.add(this.textsearch);
		
		this.buttonSearch = new JButton("Search");
		this.buttonSearch.setBounds(240,60,100,20);
		this.buttonSearch.addActionListener(this);
		this.panel.add(this.buttonSearch);
		
		
		this.LabelId = new JLabel("Id");
		this.LabelId.setBounds(20,90,70,20);
		this.panel.add(this.LabelId);
		
		this.textid = new JTextField();
		this.textid.setBounds(110,90,150,20);
		this.panel.add(this.textid);
		this.textid.setEditable(false);
		
		this.labelName = new JLabel("Name");
		this.labelName.setBounds(20,120,70,20);
		this.panel.add(this.labelName);
		
		this.textname = new JTextField();
		this.textname.setBounds(110,120,150,20);
		this.panel.add(this.textname);
		this.textname.setEditable(false);
		
		this.labelgender = new JLabel("Gender");
		this.labelgender.setBounds(20,150,70,20);
		this.panel.add(this.labelgender);
		
		this.textgender = new JTextField();
		this.textgender.setBounds(110,150,150,20);
		this.panel.add(this.textgender);
		this.textgender.setEditable(false);
		
		this.labeladdress = new JLabel("Address");
		this.labeladdress.setBounds(20,180,70,20);
		this.panel.add(this.labeladdress);
		
		this.textaddress = new JTextField();
		this.textaddress.setBounds(110,180,150,20);
		this.panel.add(this.textaddress);
		this.textaddress.setEditable(false);
		
		
		this.labelappointement = new JLabel("Appointment");
		this.labelappointement.setBounds(15,210,100,20);
		this.panel.add(this.labelappointement);
		
		this.textappointment = new JTextField();
		this.textappointment.setBounds(120,210,150,20);
		this.panel.add(this.textappointment);
		this.textappointment.setEditable(false);
		
		this.labelward = new JLabel("Ward");
		this.labelward.setBounds(20,240,150,20);
		this.panel.add(this.labelward);
		
		this.textward = new JTextField();
		this.textward.setBounds(110,240,150,20);
		this.panel.add(this.textward);
		this.textward.setEditable(false);
		
		this.add(this.panel);
		this.setTitle("Search Patient");
		this.setSize(500,500);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	

}
