package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeCatcher extends Subsystem{
	
	Servo servo1 = new Servo(RobotMap.servo1);
	Servo servo2 = new Servo(RobotMap.servo2);
	
	public RopeCatcher(){
		servo1.setAngle(0);
		servo2.setAngle(96);
	
	}
	
	public void captureRope(){
		servo1.setAngle(96);
		servo2.setAngle(0);
		
	}
	
	public void uncaptureRope(){
		servo1.setAngle(0);
		servo2.setAngle(96);
		
	}

    public void initDefaultCommand(){
    	
    }

}

