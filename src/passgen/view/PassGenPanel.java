package passgen.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JButton;

import passgen.controller.PassGenController;

public class PassGenPanel extends JPanel {
	
	private PassGenController baseController;
	private JCheckBox lowerCaseCheck;
	private JCheckBox upperCaseCheck;
	private JCheckBox numberCheck;
	private JCheckBox specialCheck;
	private SpringLayout baseLayout;
	private JLabel passwordDisplay;
	private JSlider lengthSlider;
	private JButton generateButton;

	public PassGenPanel(PassGenController baseController) {
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		passwordDisplay = new JLabel();
		lengthSlider = new JSlider();
		lowerCaseCheck = new JCheckBox("Lowercase");
		upperCaseCheck = new JCheckBox("Uppercase");
		numberCheck = new JCheckBox("Numbers");
		specialCheck = new JCheckBox("Special Characters");
		generateButton = new JButton("Create a Password");

		setupPanel();
		setupLayout();
		setupListners();

	}

	private void setupPanel() {
		this.setLayout(baseLayout);
		this.setBackground(new Color(236, 240, 241));
		this.add(lengthSlider);
		this.add(passwordDisplay);
		this.add(lowerCaseCheck);
		this.add(upperCaseCheck);
		this.add(numberCheck);
		this.add(specialCheck);
		this.add(generateButton);
		this.lowerCaseCheck.setSelected(true);
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
			this.getClass().getResourceAsStream("/passgen/model/assets/ElegantLux-Mager.ttf"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			SimpleAttributeSet attribute = new SimpleAttributeSet();
			StyleConstants.setAlignment(attribute, StyleConstants.ALIGN_CENTER);
			passwordDisplay.setFont(new Font("Elegant Lux Mager", Font.BOLD, 25));
			passwordDisplay.setText(" ");
			passwordDisplay.setHorizontalAlignment(JLabel.CENTER);
			passwordDisplay.setVerticalAlignment(JLabel.CENTER);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private void setupLayout() {
		baseLayout.putConstraint(SpringLayout.NORTH, lowerCaseCheck, 108, SpringLayout.SOUTH, passwordDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, lowerCaseCheck, -493, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, upperCaseCheck, 0, SpringLayout.NORTH, lowerCaseCheck);
		baseLayout.putConstraint(SpringLayout.WEST, upperCaseCheck, 33, SpringLayout.EAST, lowerCaseCheck);
		baseLayout.putConstraint(SpringLayout.NORTH, numberCheck, 0, SpringLayout.NORTH, lowerCaseCheck);
		baseLayout.putConstraint(SpringLayout.WEST, numberCheck, 33, SpringLayout.EAST, upperCaseCheck);
		baseLayout.putConstraint(SpringLayout.NORTH, specialCheck, 0, SpringLayout.NORTH, lowerCaseCheck);
		baseLayout.putConstraint(SpringLayout.WEST, specialCheck, 30, SpringLayout.EAST, numberCheck);
		baseLayout.putConstraint(SpringLayout.NORTH, passwordDisplay, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, passwordDisplay, 125, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, passwordDisplay, 140, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, passwordDisplay, -125, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, lengthSlider, 230, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, lengthSlider, -46, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, generateButton, -22, SpringLayout.NORTH, upperCaseCheck);
		baseLayout.putConstraint(SpringLayout.EAST, generateButton, -245, SpringLayout.EAST, this);
	}

	private void setupListners() {
		this.lengthSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String password = baseController.getPassGen().getRandomPassword(lengthSlider.getValue()/4, lowerCaseCheck.isSelected(), upperCaseCheck.isSelected(), numberCheck.isSelected(), specialCheck.isSelected());
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						passwordDisplay.setText(password);
					}
				});
			
			}
		});
		
		this.passwordDisplay.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Color selectorColor = new Color(52, 152, 219);
				passwordDisplay.setBorder(BorderFactory.createLineBorder(selectorColor, 4));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				passwordDisplay.setBorder(BorderFactory.createEmptyBorder());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(passwordDisplay.getText());
				clpbrd.setContents(stringSelection, null);
			}
		});
		
		this.generateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = baseController.getPassGen().getRandomPassword(lengthSlider.getValue()/4, lowerCaseCheck.isSelected(), upperCaseCheck.isSelected(), numberCheck.isSelected(), specialCheck.isSelected());
				passwordDisplay.setText(password);
			}
		});
}
}
