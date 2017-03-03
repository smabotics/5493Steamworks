package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {

	public SpeedController leftBackMotor;
	public SpeedController rightBackMotor;
	public SpeedController leftFrontMotor;
	public SpeedController rightFrontMotor;
	private RobotDrive drive;
	private final String DRIVE_SYSTEM = "Mecanum Drive System";
	private final String LEFT_FRONT = "Left Front Motor";

	public DriveBase() {
		super();

		/*leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		rightFrontMotor.setInverted(true);
		rightBackMotor.setInverted(true);
		*/
		this.leftFrontMotor = RobotMap.SpeedController(RobotMap.leftFront, RobotMap.USE_PWM_TALON);
		this.rightFrontMotor = RobotMap.SpeedController(4, 3);
		this.leftBackMotor = RobotMap.SpeedController(3, 3);
		this.rightBackMotor = RobotMap.SpeedController(5, 3);
		

		// leftBackMotor = (assigning a port on the joystick for controlling the
		// left back motor)
		// BKE - These motors are being passed by wrong order... front left,
		// rear left, front right, rear right.
		drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

//		robotDrive.setInvertedMotor(MotorType.kFrontLeft, true); // invert the
//		// left side
//		// motors
//		robotDrive.setInvertedMotor(MotorType.kRearLeft, true); // you may need
//		// to change or
//		// remove this
//		// to match your
//		// robot
		drive.setExpiration(0.1);

		LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	public void drive(Joystick j) {
		drive(j.getX(), j.getY(), j.getTwist(), 0);
	}

	public void drive(double x, double y, double twist, double gyro) {
		drive.mecanumDrive_Cartesian(x, y, twist, gyro);
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
//		SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
//		SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
//		SmartDashboard.putNumber("Left Speed", leftEncoder.getRate());
//		SmartDashboard.putNumber("Right Speed", rightEncoder.getRate());
//		SmartDashboard.putNumber("Gyro", gyro.getAngle());
		SmartDashboard.putNumber("Left Back Motor Speed", this.leftBackMotor.get());
		SmartDashboard.putNumber("Right Back Motor Speed", this.rightBackMotor.get());
		SmartDashboard.putNumber("Left Front Motor Speed", this.leftFrontMotor.get());
		SmartDashboard.putNumber("Right Front Motor Speed", this.rightFrontMotor.get());
	}

	public void stop() {
		drive(0.0, 0.0, 0.0, 0.0);
	}
}
