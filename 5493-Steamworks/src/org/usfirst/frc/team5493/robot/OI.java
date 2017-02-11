package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.ClimbRope;
import org.usfirst.frc.team5493.robot.commands.GetGear;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick joy = new Joystick(0);
    DriverStation ds = DriverStation.getInstance();
 
   
    public Joystick getJoystick(){
    	return joy;
    }
    
    public OI(){
    	JoystickButton button1 = new JoystickButton(joy, 0);
    	JoystickButton triggerButton = new JoystickButton(joy, RobotMap.JOYBTN_TRIGGER);
    	
    	SmartDashboard.putData(null);
    	
    	button1.whenPressed(new ClimbRope());
       
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

