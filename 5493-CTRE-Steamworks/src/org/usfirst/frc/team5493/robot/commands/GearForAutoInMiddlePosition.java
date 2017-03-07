package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class GearForAutoInMiddlePosition extends CommandGroup {

    public GearForAutoInMiddlePosition() {
    	double driveTime = 0.3;
    	addSequential(new DriveStraightForTime(0.2, driveTime));
    	addSequential(new WaitCommand(driveTime + 1));
    	addSequential(new ReleaseGear());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightForTime(-0.4, 0.3));
    	addSequential(new WaitCommand(2.5));
    	addSequential(new CloseGear());
    	
    }
}
