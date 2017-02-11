package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5493.robot.commands.JoystickDrive;
import org.usfirst.frc.team5493.robot.commands.ClimbRope;
import org.usfirst.frc.team5493.robot.commands.GetGear;
import org.usfirst.frc.team5493.robot.subsystems.DriveBase;
import org.usfirst.frc.team5493.robot.subsystems.GearSystem;
import org.usfirst.frc.team5493.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static final DriveBase driveBase = new DriveBase();
	public static GearSystem gearSystem;
	public static RopeClimber ropeClimber;
	
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	gearSystem = new GearSystem();
    	ropeClimber = new RopeClimber();
    	
		oi = new OI();
		
		//BKE - Try commenting this out this could be causing the issue
        chooser = new SendableChooser();
        chooser.addDefault("Mecanum Drive", new JoystickDrive());
        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData("Drive Base", driveBase);
		SmartDashboard.putData("Gear System", gearSystem);
		SmartDashboard.putData("Rope Climber", ropeClimber);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) 
        	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
        	autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	private void log() {
		this.gearSystem.log();
		this.driveBase.log();
		this.ropeClimber.log();
	}

}
