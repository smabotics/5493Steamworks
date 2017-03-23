package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceSensor extends Subsystem{
	
	Ultrasonic distanceLeft = new Ultrasonic(RobotMap.leftDistanceOutput, RobotMap.leftDistanceInput);
	Ultrasonic distanceRight = new Ultrasonic(RobotMap.rightDistanceOutput, RobotMap.rightDistanceInput);
	double leftDistance;
	double rightDistance;

	public DistanceSensor(){
		leftDistance = distanceLeft.getRangeInches();
		rightDistance = distanceRight.getRangeInches();
	}

    public void initDefaultCommand(){
    }
    
    public double calculateDistanceLeft(){
    	return leftDistance;
    }
    
    public double calculateDistanceRight(){
    	return rightDistance;
    }
    
    public void printDistance(){
    	DriverStation.reportError("DIST LEFT: " + calculateDistanceLeft() + " DIST RIGHT: " + calculateDistanceRight(), false);
    }
}

