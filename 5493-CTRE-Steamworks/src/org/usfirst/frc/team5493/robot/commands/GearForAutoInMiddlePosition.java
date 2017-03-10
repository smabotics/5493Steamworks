package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class GearForAutoInMiddlePosition extends CommandGroup {

    public GearForAutoInMiddlePosition() {
    	double driveTime = 3.00;
    	addSequential(new DriveStraightForTime(-0.3, driveTime));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new ReleaseGear());
    	addSequential(new WaitCommand(2.5));
    	addSequential(new DriveStraightForTime(0.25, 0.75));
    	addSequential(new WaitCommand(1.25));
    	addSequential(new CloseGear());
    	
    }
}
