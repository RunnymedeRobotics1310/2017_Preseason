package robot.oi;

public class GameController_F310 extends GameController {

	public GameController_F310(int port) {
		super(port);
	}

	public double getAxis_LeftX() 	{ return   super.joystick.getRawAxis(0); }
	public double getAxis_LeftY() 	{ return - super.joystick.getRawAxis(1); }
	public double getAxis_RightX()  { return   super.joystick.getRawAxis(4); }
	public double getAxis_RightY()  { return - super.joystick.getRawAxis(5); }
	
	public double getAxis_LeftTrigger()  { return super.joystick.getRawAxis(2); }
	public double getAxis_RightTrigger() { return super.joystick.getRawAxis(3); }
	
	public boolean getButton_A()              { return super.joystick.getRawButton(1); }
	public boolean getButton_B()              { return super.joystick.getRawButton(2); }
	public boolean getButton_X()              { return super.joystick.getRawButton(3); }
	public boolean getButton_Y()              { return super.joystick.getRawButton(4); }
	public boolean getButton_Back()           { return super.joystick.getRawButton(7); }
	public boolean getButton_Start()          { return super.joystick.getRawButton(8); }
	public boolean getButton_LeftBumper()     { return super.joystick.getRawButton(5); }
	public boolean getButton_RightBumper()    { return super.joystick.getRawButton(6); }
	public boolean getButton_LeftStickPush()  { return super.joystick.getRawButton(9); }
	public boolean getButton_RightStickPush() { return super.joystick.getRawButton(10); }
	
}
