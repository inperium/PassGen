package passgen.view;

import javax.swing.JFrame;
import passgen.controller.PassGenController;

public class PassGenFrame extends JFrame
{
	private PassGenController baseController;
	private PassGenPanel passPanel;

	public PassGenFrame(PassGenController passGenController) 
	{
			super();
			this.baseController = passGenController;
			this.passPanel = new PassGenPanel(baseController);
			
			this.setupFrame();
	}

	private void setupFrame() 
	{
		this.setContentPane(passPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PassGen");
		this.setSize(650, 400);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public PassGenPanel getPassPanel()
	{
		return this.passPanel;
	}

}
