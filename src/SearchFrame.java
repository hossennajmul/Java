import java.awt.event.*;
import javax.swing.*;
public class SearchFrame extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JButton buttonSearchPatient,buttonSearchDoctorByName,buttonSearchDoctorBySpeciality;
	
	public SearchFrame()
	{
		this.initialize();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("Search Patient"))
		{
			SearchPatientFrame spf = new SearchPatientFrame();
			spf.setVisible(true);
			this.setVisible(false);
		}
		else if(event.getActionCommand().equals("Search Doctor By Name"))
		{
			SearchDoctorByNameFrame sdbn = new SearchDoctorByNameFrame();
			sdbn.setVisible(true);
			this.setVisible(false);
			
		}
		else if(event.getActionCommand().equals("Search Doctor By Speciality"))
		{
			SearchDoctorBySpecialityFrame sdbs = new SearchDoctorBySpecialityFrame();
			sdbs.setVisible(true);
			this.setVisible(false);
		}
			
	}
	
	private void initialize()
	{
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.buttonSearchPatient = new JButton("Search Patient");
		this.buttonSearchPatient.setBounds(50,30,300,20);
		this.buttonSearchPatient.addActionListener(this);
		this.panel.add(this.buttonSearchPatient);
		
		this.buttonSearchDoctorByName  = new JButton("Search Doctor By Name");
		this.buttonSearchDoctorByName.setBounds(50,60,300,20);
		this.buttonSearchDoctorByName.addActionListener(this);
		this.panel.add(this.buttonSearchDoctorByName);
		
		this.buttonSearchDoctorBySpeciality  = new JButton("Search Doctor By Speciality");
		this.buttonSearchDoctorBySpeciality.setBounds(50,90,300,20);
		this.buttonSearchDoctorBySpeciality.addActionListener(this);
		this.panel.add(this.buttonSearchDoctorBySpeciality);
		
		this.add(this.panel);
		this.setTitle("MAIN FRAME");
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
