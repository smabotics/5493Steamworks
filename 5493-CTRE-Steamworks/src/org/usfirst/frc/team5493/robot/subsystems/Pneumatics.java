package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	private DoubleSolenoid solenoid;
	private boolean chambered = false;
    
    public Pneumatics(){
    	solenoid = new DoubleSolenoid(RobotMap.pneumaticsPort1, RobotMap.pneumaticsPort2);
    }

    public void initDefaultCommand() {
   
    }
    
    public void chamber(){
    	if(!chambered){
    		solenoid.set(DoubleSolenoid.Value.kReverse);
    		chambered = true;
    	}
    }
    
    public void release(){
    	if(chambered){
    		DriverStation.reportError("Release", false);
    		solenoid.set(DoubleSolenoid.Value.kForward);
    		chambered = false;
    	} else {
    		DriverStation.reportError("Not Chambered", false);
    	}
    }
    
    public void complete(){
    	DriverStation.reportError("Pneumatics complete", false);
    	solenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public void log(){
    	
    }
}

