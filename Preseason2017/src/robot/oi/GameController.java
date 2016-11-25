package robot.oi;

import edu.wpi.first.wpilibj.Joystick;

public class GameController {

	protected Joystick joystick;
	private int port;
	
	public GameController(int port) {
		this.port = port;
		joystick = new Joystick(port);
	}

	public Joystick getJoystick()   { return joystick; }
	public int      getPort()       { return port; }
	
	public double getAxis_LeftX()    { return 0.0; }
	public double getAxis_LeftY()    { return 0.0; }
	public double getAxis_RightX()   { return 0.0; }
	public double getAxis_RightY()   { return 0.0; }
	
	public double getAxis_LeftTrigger()  { return 0.0; }
	public double getAxis_RightTrigger() { return 0.0; }
	
	public boolean getButton_A()              { return getButton_Cross(); }
	public boolean getButton_B()              { return getButton_Circle(); }
	public boolean getButton_X()              { return getButton_Square(); }
	public boolean getButton_Y()              { return getButton_Triangle(); }
	public boolean getButton_Cross()          { return getButton_A(); }
	public boolean getButton_Circle()         { return getButton_B(); }
	public boolean getButton_Square()         { return getButton_X(); }
	public boolean getButton_Triangle()       { return getButton_Y(); }
	public boolean getButton_Back()           { return false; }
	public boolean getButton_Start()          { return false; }
	public boolean getButton_LeftBumper()     { return false; }
	public boolean getButton_RightBumper()    { return false; }
	public boolean getButton_LeftStickPush()  { return false; }
	public boolean getButton_RightStickPush() { return false; }
	
	public boolean getButton_LeftTrigger() {
		return getAxis_LeftTrigger() > .3;
	}
	
	public boolean getButton_RightTrigger() {
		return getAxis_RightTrigger() > .3;
	}
	
	public int getPov() { return -1; }
	
	@Override
	public String toString() {
		return 
				"(" + getAxis_LeftX() + "," + getAxis_LeftY() + ")"
				+ 
				"(" + getAxis_RightX() + "," + getAxis_RightY() + ")";
	}

}
