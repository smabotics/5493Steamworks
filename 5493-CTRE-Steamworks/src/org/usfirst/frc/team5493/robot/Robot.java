package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5493.robot.commands.DriveStraightForDist;
import org.usfirst.frc.team5493.robot.commands.DriveStraightForTime;
import org.usfirst.frc.team5493.robot.commands.GearForAutoInMiddlePosition;
import org.usfirst.frc.team5493.robot.commands.SensitizeStickCommand;
import org.usfirst.frc.team5493.robot.subsystems.DistanceSensor;
import org.usfirst.frc.team5493.robot.subsystems.DriveBase;
import org.usfirst.frc.team5493.robot.subsystems.Pneumatics;
import org.usfirst.frc.team5493.robot.subsystems.RopeCatcher;
import org.usfirst.frc.team5493.robot.subsystems.RopeClimber;
import org.usfirst.frc.team5493.robot.subsystems.RopeClimber2;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static  DriveBase driveBase;
	public static RopeClimber ropeClimber;
	public static Pneumatics pneumatics;
	public static RopeCatcher ropeCatcher;
	public static DistanceSensor distance;
//	public static RopeClimber2 climber2;
	
	public static OI oi;
	
	public static AnalogGyro gyro;
	final int gyroChannel = 0;
	public final static double voltsPerDegreePerSecond = .0128;
	

    Command autonomousCommand;
    SendableChooser autonomousMode = new SendableChooser();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	ropeClimber = new RopeClimber();
    	ropeCatcher = new RopeCatcher();
    	pneumatics = new Pneumatics();
        driveBase = new DriveBase();
        distance = new DistanceSensor();
//      climber2 = new RopeClimber2();
        oi = new OI();
        
        CameraServer.getInstance().startAutomaticCapture();
        gyro = new AnalogGyro(gyroChannel);
        gyro.reset();
        Robot.driveBase.toggleSensitivity(true);
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	//if(RobotMap.climbedRope == 1)
    		
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
    	//MIDDLE POSITION TO GEAR PEG
    	//autonomousCommand = new DriveStraightForTime(-0.25, 3.4);
    	//SIDE POSITION PASSING BASELINE
    	autonomousCommand = new DriveStraightForTime(-0.3, 6);
    	//SETTING GEAR IN THE MIDDLE POSITION
    	//autonomousCommand = new GearForAutoInMiddlePosition();
    	//autonomousCommand = new DriveStraightForDist(-0.25, true);
    	
        //autonomousCommand = (Command)autonomousMode.getSelected();
        if(autonomousCommand != null)
        	autonomousCommand.start();
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
        //if (autonomousCommand != null) 
        	//autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if (autonomousCommand != null && autonomousCommand.isRunning() == true){
        	((DriveStraightForTime)autonomousCommand).setAngle(gyro.getAngle());
        }
    	
//        autonomousCommand.start();
        //new CalculateDistance(); //DOESNT WORK
        //new GearForAutoInMiddlePosition(); //DOESNT WORK
        //new MecanumDriveForAuto(); //DOESNTWORK
        //distance.printDistance();
        //while(distance.dist > 0.5 && distance.dist < 1.0){
        	//driveBase.drive(-0.1, -0.1, 0.0, 0.0);
        //}
        //pneumatics.release();
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
		driveBase.log();
//		ropeClimber.log();
		pneumatics.log();
	}
	
	private void choosingAutonomous(){
		autonomousMode.addObject("Gear", new GearForAutoInMiddlePosition());
		SmartDashboard.putData("Autonomous Selection", autonomousMode);
	}

}
