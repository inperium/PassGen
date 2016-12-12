package passgen.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import passgen.controller.PassGenController;

public class PassGenPanel extends JPanel {
	private PassGenController baseController;
	private SpringLayout baseLayout;
	private JTextPane passwordDisplay;
	private JSlider lengthSlider;

	public PassGenPanel(PassGenController baseController) {
		super();
		this.baseController = baseController;
		baseLayout= new SpringLayout();
		passwordDisplay = new JTextPane();
		this.lengthSlider = new JSlider();
		
		setupPanel();
		setupLayout();
		setupListners();
		
	}

	private void setupPanel() 
	{
		this.setLayout(baseLayout);
		this.setBackground(new Color (70, 137,102));
		this.add(lengthSlider);
		passwordDisplay.setEditable(false);
		this.add(passwordDisplay);
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/passgen/model/assets/ElegantLux-Mager.ttf"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			SimpleAttributeSet attribute = new SimpleAttributeSet();
			StyleConstants.setAlignment(attribute, StyleConstants.ALIGN_CENTER);
			passwordDisplay.setParagraphAttributes(attribute, false);
			passwordDisplay.setFont(new Font("Elegant Lux Mager", Font.BOLD, 30));
			passwordDisplay.setText("elegantrandompassword");
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.NORTH, passwordDisplay, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, passwordDisplay, 125, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, passwordDisplay, 140, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, passwordDisplay, -125, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, lengthSlider, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lengthSlider, -46, SpringLayout.SOUTH, this);
	}
	
	private void setupListners() {

	}

}
