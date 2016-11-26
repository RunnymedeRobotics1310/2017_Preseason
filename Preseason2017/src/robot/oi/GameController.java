package robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;

public class GameController {

	protected Joystick joystick;
	private int port;
	
	public GameController(int port) {
		this.port = port;
		joystick = new Joystick(port) {
			// Override the getRawAxis method to return a double rounded to 
			// only 2 decimal places.
			@Override
			public double getRawAxis(int axis) {
				return Math.round(super.getRawAxis(axis) *100.0) / 100.0;
			}
		};
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
	
	public int getPov() { return joystick.getPOV(); }
	
	/**
	 *  Returns true if the user is pressing any buttons or moving any joysticks beyond the nominal range
	 * @return boolean {@code true} indicating if there is any user action on the controller.
	 */
	public boolean isControllerActive() {
		return isButtonPressed() || isJoystickMoved();
	}
	
	/**
	 *  Returns true if the user is moving any of the Joysticks on the controller or the triggers
	 * @return boolean {@code true} indicating if there is any Joystick action on the controller.
	 */
	public boolean isJoystickMoved() {
		return     Math.abs(getAxis_LeftX()) > .1   || Math.abs(getAxis_RightX()) > .1
				|| Math.abs(getAxis_LeftY()) > .1   || Math.abs(getAxis_RightY()) > .1
				
				|| getAxis_LeftTrigger()  > .1 
				|| getAxis_RightTrigger() > .1;
	}
	
	/**
	 *  Returns true if the user is pressing any buttons
	 * @return boolean {@code true} indicating if there is any button pressed on the controller.
	 */
	public boolean isButtonPressed() {
		return     getButton_A()     || getButton_B()      || getButton_X()      || getButton_Y()
				|| getButton_Cross() || getButton_Circle() || getButton_Square() || getButton_Triangle()
				
				|| getButton_Back()          || getButton_Start()  
				|| getButton_LeftBumper()    || getButton_RightBumper()
				|| getButton_LeftStickPush() || getButton_RightStickPush()
				
				|| getPov() >= 0;
	}
	
	public void setRumble_Left (double value)  { joystick.setRumble(RumbleType.kLeftRumble,  (float) value); }
	public void setRumble_Right(double value)  { joystick.setRumble(RumbleType.kRightRumble, (float) value); }

	public void setRumble(double value) {
		setRumble_Left (value);
		setRumble_Right(value);
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(128);
		
		sb.append("Type(" + joystick.getType() + "," + joystick.getButtonCount() + ")");
		sb.append((isControllerActive() ? "A " : "  "));
		
		sb.append("Left("  + getAxis_LeftX()  + "," + getAxis_LeftY()  + ")");
		sb.append("Right(" + getAxis_RightX() + "," + getAxis_RightY() + ") ");
		
		sb.append("Trigger(" + getAxis_LeftTrigger() + "," + getAxis_RightTrigger() + ") ");
				
		sb.append( (getButton_A()               ? "A"    : ""));
		sb.append( (getButton_Cross()           ? "*"    : ""));
		sb.append( (getButton_B()               ? "B"    : ""));
		sb.append( (getButton_Circle()          ? "O"    : ""));
		sb.append( (getButton_X()               ? "X"    : ""));
		sb.append( (getButton_Square()          ? "[]"   : ""));
		sb.append( (getButton_Y()               ? "Y"    : ""));
		sb.append( (getButton_Triangle()        ? "/\\"  : ""));
		sb.append( (getButton_Back()            ? "Back" : ""));
		sb.append( (getButton_Start()           ? "Start": ""));
		sb.append( (getButton_LeftBumper()      ? "Lb"   : ""));
		sb.append( (getButton_RightBumper()     ? "Rb"   : ""));
		sb.append( (getButton_LeftStickPush()   ? "Ls"   : ""));
		sb.append( (getButton_RightStickPush()  ? "Rs"   : ""));
				
		sb.append( (getPov() >= 0 ? " POV(" + getPov() + ")" : ""));
					
		return sb.toString();
	}

}
