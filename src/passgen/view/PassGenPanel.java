package passgen.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import passgen.controller.PassGenController;

public class PassGenPanel extends JPanel {
	private PassGenController baseController;
	private SpringLayout baseLayout;
	private JTextArea passwordDisplay;
	private JSlider lengthSlider;

	public PassGenPanel(PassGenController baseController) {
		super();
		this.baseController = baseController;
		baseLayout= new SpringLayout();
		passwordDisplay = new JTextArea(5,40);
		this.lengthSlider = new JSlider();
		
		setupPanel();
		setupLayout();
		setupListners();
		
	}

	private void setupLayout() {
		this.setLayout(baseLayout);
		this.setBackground(new Color (70, 137,102));
		this.add(lengthSlider);
		this.add(passwordDisplay);
		
	}

	private void setupPanel() 
	{

	}
	
	private void setupListners() {

	}

}
