package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class GearForAutoInLeftPosition extends CommandGroup {

    public GearForAutoInLeftPosition() {
    	double driveTime = 0.75;
    	addSequential(new DriveStraightForTime(0.5, driveTime));
    	addSequential(new WaitCommand(driveTime + 1));
    	addSequential(new TurnRightForTime(1));
    	addSequential(new ReleaseGear());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightForTime(0.8, 1));
    	addSequential(new WaitCommand(2.5));
    	addSequential(new CloseGear());
    	
    }
}
