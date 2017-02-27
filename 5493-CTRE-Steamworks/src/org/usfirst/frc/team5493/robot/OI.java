package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.ClimbRope;
import org.usfirst.frc.team5493.robot.commands.ReleaseGear;
import org.usfirst.frc.team5493.robot.commands.CloseGear;
import org.usfirst.frc.team5493.robot.commands.UnClimb;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick driveJoystick = new Joystick(RobotMap.DRIVE_JOYSTICK_PORT);
    private Joystick joy2 = new Joystick(RobotMap.JOYSTICK2_PORT);
    DriverStation ds = DriverStation.getInstance();
 
   
    public Joystick getDriveJoystick(){
    	return driveJoystick;
    }
    
    public Joystick getJoystick2(){
    	return joy2;
    }
    
    public OI(){
    	JoystickButton climbRope = new JoystickButton(joy2, RobotMap.JOYBTN_Y);
    	JoystickButton unClimb = new JoystickButton(joy2, RobotMap.JOYBTN_A);
    	JoystickButton releaseGear = new JoystickButton(joy2, RobotMap.JOYBTN_B);
    	JoystickButton closeGear = new JoystickButton(joy2, RobotMap.JOYBTN_X);
    	
    	climbRope.whileHeld(new ClimbRope());
    	unClimb.whileHeld(new UnClimb());
    	releaseGear.whenPressed(new ReleaseGear());
    	closeGear.whenPressed(new CloseGear());
       
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    	
    }
    
}

