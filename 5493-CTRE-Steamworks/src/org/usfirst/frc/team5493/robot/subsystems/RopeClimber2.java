package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber2 extends Subsystem {
    
    public SpeedController ropeMotor;
    
    public RopeClimber2(){
    	super();
    	ropeMotor = new CANTalon(RobotMap.ropeMotorRight);
    	//ropeMotor.setInverted(true);
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

