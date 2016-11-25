package robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	GameController driverController = new GameController_F310(0);
	
	public double getSpeed() {
		return driverController.getAxis_RightY();
	}
	
	public boolean getStartDriveStraightCommand() {
		return driverController.getButton_Y();
	}
	
	public double getTurn() {
		return driverController.getAxis_LeftX();
	}
	
	public boolean isJoystickMovement() {
		return
				   Math.abs(driverController.getAxis_LeftX()) >= .03
				|| Math.abs(driverController.getAxis_LeftY()) >= .03
				|| Math.abs(driverController.getAxis_RightX()) >= .03
				|| Math.abs(driverController.getAxis_RightY()) >= .03;
	}

	public void updateSmartDashboard() {
		SmartDashboard.putString("Driver Controller", 
				driverController.toString());
	}
}

