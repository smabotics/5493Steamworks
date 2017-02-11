package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;


public class DriveBase extends Subsystem {
	
	private SpeedController leftBackMotor, rightBackMotor, leftFrontMotor, rightFrontMotor;
	private RobotDrive drive;
	private final String DRIVE_SYSTEM = "Mecanum Drive System";
	private final String LEFT_FRONT = "Left Front Motor";
	
	public DriveBase(){
		super();
		
		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		
		//leftBackMotor = (assigning a port on the joystick for controlling the left back motor)
		//BKE - These motors are being passed by wrong order... front left, rear left, front right, rear right.
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor);
		
		LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);
		
	}

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void drive(Joystick j){
    	drive(j.getX(), j.getY(), j.getTwist(), 0);
    }
    
    public void drive(double x, double y, double twist, double gyro){
    	drive.mecanumDrive_Cartesian(x, y, twist, gyro);
    }
    
    public void log(){
    	
    }
    
    public void reset(){
    	drive(0.0, 0.0, 0.0, 0.0);
    }
}

