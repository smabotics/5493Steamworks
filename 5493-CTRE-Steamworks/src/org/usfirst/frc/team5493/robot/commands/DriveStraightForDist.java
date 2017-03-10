package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightForDist extends Command {
	
	private double targetDist;
	private double speed;
	private boolean goForward;

    public DriveStraightForDist(double distance, boolean forward) {
        requires(Robot.driveBase);
        if(forward)
        	targetDist = distance;
        else
        	targetDist = -distance;
        goForward = forward;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.drive(speed, speed, 0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //if(goForward)
        	//return (Robot.distance.calculateDistance() >= targetDist);
        //else
        	//return (Robot.distance.calculateDistance() <= targetDist);
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
