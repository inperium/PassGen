package passgen.controller;

import passgen.model.PassGen;
import passgen.view.PassGenFrame;

public class PassGenController 
{
	private PassGen passGen;
	private String password;
	private PassGenFrame passFrame;
	
	public PassGenController()
	{
		passGen = new PassGen();
		passFrame = new PassGenFrame(this);			
	}
	
	public void start() 
	{
		
	}
	
	public PassGen getPassGen()
	{
		return passGen;
	}

	public String getPassword() {
		return password;
	}

	public PassGenFrame getPassFrame() {
		return passFrame;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
