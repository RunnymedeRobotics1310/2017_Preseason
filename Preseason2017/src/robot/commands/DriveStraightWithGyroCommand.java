
package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.RobotMap;

/**
 *
 */
public class DriveStraightWithGyroCommand extends Command {

	private double encoderDistance;
	private double setSpeed;
	private double timeout;
	private double targetAngle = -1;
	
    public DriveStraightWithGyroCommand(double distance, double speed, double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassisSubsystem);
        this.encoderDistance = Math.abs(distance) 
        		* RobotMap.DRIVE_ENCODER_COUNTS_PER_FT - 200;
        this.setSpeed        = speed;
        this.timeout         = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.resetEncoders();
    	
    	targetAngle = Robot.chassisSubsystem.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double angleError = targetAngle - Robot.chassisSubsystem.getAngle();
    	
    	if (angleError > 180.0)  { angleError -= 360.0; }
    	if (angleError < -180.0) { angleError += 360.0; }
    	
		double leftSpeed  = setSpeed;
		double rightSpeed = setSpeed;

		// Slow down one motor based on the error.
		if (angleError > 0) {
    		rightSpeed -= angleError * RobotMap.GYRO_PROPORTIONAL_GAIN * setSpeed;
    		if (rightSpeed < -setSpeed) {
    			 rightSpeed = -setSpeed;
    		}
    	}
    	else {
    		leftSpeed -=  -angleError * RobotMap.GYRO_PROPORTIONAL_GAIN * setSpeed;
    		if (leftSpeed < -setSpeed) {
    			leftSpeed = -setSpeed;
    		}
    	}
    	
    	Robot.chassisSubsystem.setMotorSpeeds(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	// Check for a timeout before the distance
    	if (timeSinceInitialized() > timeout) { return true; }
    	
    	// Look for Joystick movement - and then end
    	if (Robot.oi.isDriverAction()) { return true; }
    	
    	return Math.abs(Robot.chassisSubsystem.getEncoderDistance()) >= encoderDistance;
    }

	@Override
	protected void end() {
		Robot.chassisSubsystem.setBothMotorSpeeds(0);
	}

	@Override
	protected void interrupted() {}
}
