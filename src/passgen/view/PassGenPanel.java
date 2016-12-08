package passgen.view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import passgen.controller.PassGenController;

public class PassGenPanel extends JPanel
{
	private PassGenController baseController;
	private SpringLayout baseLayout;
	private JTextArea passwordDisplay;
	private JSlider lengthSlider;

	public PassGenPanel(PassGenController baseController) 
	{
		super();
		this.baseController = baseController;
		baseLayout= new SpringLayout();
		passwordDisplay = new JTextArea(5,40);

		setupPanel();
		setupLayout();
		setupListners();
		
	}

	private void setupListners() {
		this.setLayout(baseLayout);
		this.setBackground(new Color ());

		
	}

	private void setupLayout() {
		// TODO Auto-generated method stub
		
	}

	private void setupPanel() {
		// TODO Auto-generated method stub
		
	}

}
