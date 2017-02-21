package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MecanumDriveForAuto extends Command {
	
	private static double forwardSpeed = -0.2;
	private static double forwardTime = 2;
	
	private static double turnLeftSpeed = -0.2;
	private static double turnRightSpeed = 0.2;
	private static double turnTime = 1;

    public MecanumDriveForAuto() {
        requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveBase.drive(forwardSpeed, forwardSpeed, 0.0, 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.drive(0.0, 0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
