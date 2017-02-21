package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceSensor extends Subsystem{
	
	AnalogInput distanceSensor = new AnalogInput(RobotMap.distanceSensor);
	double multiplier = 0.0023;
	public double dist = distanceSensor.getValue() * multiplier;
	
	
	public DistanceSensor(){
	}

    public void initDefaultCommand(){
    }
    
    public void printDistance(){
    	DriverStation.reportError("Distance is: " + dist + " meters", false);
    	//SmartDashboard.putData("Distance: " + dist, false);
		//System.out.printf("%.2f", dist);
    }
}

