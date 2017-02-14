package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeClimber extends Subsystem {
    
    public SpeedController ropeMotorLeft;
    public SpeedController ropeMotorRight;
    
    public RopeClimber(){
    	super();
    	ropeMotorLeft = new CANTalon(RobotMap.ropeMotorLeft);
    	ropeMotorRight = new CANTalon(RobotMap.ropeMotorRight);
    	ropeMotorRight.setInverted(true);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log(){
    	
    }
    
    public void reset(){
    	
    }
    
}

