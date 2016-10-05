import java.awt.event.*;
import javax.swing.*;
public class StartFrame extends JFrame implements ActionListener {
	
	
	private JPanel panel;
	private JButton buttonLogin,buttonSearch;
	
	public StartFrame()
	{
		this.initialize();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("Login"))
		{
			//LoginFrame lf = new LoginFreame();
			//lf.setVisible(true);
			this.setVisible(false);
		}
		else if(event.getActionCommand().equals("Search"))
		{
			SearchFrame sf = new SearchFrame();
			sf.setVisible(true);
			this.setVisible(false);
		}
	}
	
	private void initialize()
	{
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.buttonLogin = new JButton("Login");
		this.buttonLogin.setBounds(50,30,100,20);
		this.buttonLogin.addActionListener(this);
		this.panel.add(this.buttonLogin);
		
		this.buttonSearch  = new JButton("Search");
		this.buttonSearch.setBounds(50,60,100,20);
		this.buttonSearch.addActionListener(this);
		this.panel.add(this.buttonSearch);
		
		this.add(this.panel);
		this.setTitle("MAIN FRAME");
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
