package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbRope extends Command {

    public ClimbRope() {
        requires(Robot.ropeClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ropeClimber.ropeMotorLeft.set(1.0);
    	Robot.ropeClimber.ropeMotorRight.set(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
     protected void end() {
    	Robot.ropeClimber.ropeMotorLeft.set(0.0);
    	Robot.ropeClimber.ropeMotorRight.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
