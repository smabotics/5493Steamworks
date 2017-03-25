package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightForTime extends Command {
	
	private double speed;
	private double time;

    public DriveStraightForTime(double s, double t) {
        requires(Robot.driveBase);
        speed = s;
        time = t;
        Robot.gyro.reset();
    	DriverStation.reportError("RESET GYRO " + Robot.gyro.getAngle(), false);
    	Robot.gyro.setSensitivity(Robot.voltsPerDegreePerSecond);
    }

    public void setAngle(double gyroAngle) {
    	double angle = gyroAngle  * 100;
    	DriverStation.reportError("SET ANGLE " + angle, false);
    	//Robot.driveBase.drive(speed * 1.09, speed * .995, 0, angle);
    	Robot.driveBase.drive(speed, speed, 0, angle);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.gyro.getAngle() * 100;
    	DriverStation.reportError("GYRO ANGLE " + angle, false);
    	DriverStation.reportError("Executing Straight " + speed + " for " + time, false);
    	//Robot.driveBase.drive(speed, speed, 0.02, 0); //drives straight but angled to the right
    	//Robot.driveBase.drive(speed * .965, speed, 0, 0); //drives to the left but not angled
    	//Robot.driveBase.drive(speed * 1.08, speed * .995, 0, Robot.gyro.getAngle());
    	//Robot.driveBase.drive(speed * 1.09, speed * .995, 0, angle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(){
        return(this.timeSinceInitialized() >= time);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	DriverStation.reportError("Interrupted", false);
    	end();
    }
}
