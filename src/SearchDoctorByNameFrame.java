import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SearchDoctorByNameFrame extends JFrame implements ActionListener {
	private JPanel panel;
	
	private JLabel LabelId,labelsearch,labelName,labelsex,labeladdress,labelqualification,labelspeciality,labelcontactno,labelsalary;
	private JTextField textid,textname,textsearch,textsex,textaddress,textqualification,textspeciality,textcontactno,textsalary;
	private JButton buttonSearch;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	public SearchDoctorByNameFrame()
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
			
			PreparedStatement st = con.prepareStatement("Select * from Doctor where name =?");
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
				String g = rs.getString(7);
				String h = rs.getString(8);
				
				textid.setText(a);
				textname.setText(b);
				textsex.setText(c);
				textaddress.setText(d);
				textqualification.setText(e);
				textspeciality.setText(f);
				textcontactno.setText(g);
				textsalary.setText(h);
				
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Doctor's Not Found");
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
		
		this.labelsearch = new JLabel("Enter Doctor Name");
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
		
		this.labelsex = new JLabel("Sex");
		this.labelsex.setBounds(20,150,70,20);
		this.panel.add(this.labelsex);
		
		this.textsex = new JTextField();
		this.textsex.setBounds(110,150,150,20);
		this.panel.add(this.textsex);
		this.textsex.setEditable(false);
		
		this.labeladdress = new JLabel("Address");
		this.labeladdress.setBounds(20,180,70,20);
		this.panel.add(this.labeladdress);
		
		this.textaddress = new JTextField();
		this.textaddress.setBounds(110,180,150,20);
		this.panel.add(this.textaddress);
		this.textaddress.setEditable(false);
		
		
		this.labelqualification = new JLabel("Qualification");
		this.labelqualification.setBounds(15,210,100,20);
		this.panel.add(this.labelqualification);
		
		this.textqualification = new JTextField();
		this.textqualification.setBounds(120,210,150,20);
		this.panel.add(this.textqualification);
		this.textqualification.setEditable(false);
		
		this.labelspeciality = new JLabel("Speciality");
		this.labelspeciality.setBounds(20,240,150,20);
		this.panel.add(this.labelspeciality);
		
		this.textspeciality = new JTextField();
		this.textspeciality.setBounds(110,240,150,20);
		this.panel.add(this.textspeciality);
		this.textspeciality.setEditable(false);
		
		this.labelcontactno = new JLabel("Contact No");
		this.labelcontactno.setBounds(20,270,150,20);
		this.panel.add(this.labelcontactno);
		
		this.textcontactno = new JTextField();
		this.textcontactno.setBounds(110,270,250,20);
		this.panel.add(this.textcontactno);
		this.textcontactno.setEditable(false);
		
		this.labelsalary = new JLabel("Salary");
		this.labelsalary.setBounds(20,300,150,20);
		this.panel.add(this.labelsalary);
		
		this.textsalary = new JTextField();
		this.textsalary.setBounds(110,300,250,20);
		this.panel.add(this.textsalary);
		this.textsalary.setEditable(false);
		
		
		this.add(this.panel);
		this.setTitle("Search Doctor By Name");
		this.setSize(500,500);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	

}
