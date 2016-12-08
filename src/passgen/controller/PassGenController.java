package passgen.controller;

import passgen.model.PassGen;
import passgen.view.PassGenFrame;
import passgen.view.PassGenView;

public class PassGenController 
{
	private PassGen passGen;
	private String password;
	private PassGenView passView;
	private PassGenFrame passFrame;
	
	public PassGenController()
	{
		passGen = new PassGen();
		passView = new PassGenView();
		passFrame = new PassGenFrame(this);
				
	}
	
	public void start() 
	{
		
	}

}
