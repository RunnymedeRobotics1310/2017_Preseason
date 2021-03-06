package robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM Ports
    public static final int LEFT_MOTOR  = 0;
    public static final int RIGHT_MOTOR = 1;

    // Digital IO Ports
    public static final int LEFT_ENCODER_A = 0;
    public static final int LEFT_ENCODER_B = 1;
    public static final int RIGHT_ENCODER_A = 2;
    public static final int RIGHT_ENCODER_B = 3;
    
    // Analog Input Ports
    public static final int GYRO = 0;
    
    // Robot Properties
    public static final double MAX_DRIVE_SPEED = 1800;
    public static final double DRIVE_ENCODER_COUNTS_PER_FT = 300.0;
    
    public static final double GYRO_PROPORTIONAL_GAIN = .05; // % per degree.
    public static final double DRIVE_PID_PROPORTIONAL_GAIN = 1.0;
    
    public static final double GYRO_SENSITIVITY = .0011;
    
}
