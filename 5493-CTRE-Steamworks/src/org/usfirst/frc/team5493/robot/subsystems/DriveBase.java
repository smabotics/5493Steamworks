package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {

	public SpeedController leftBackMotor;
	public SpeedController rightBackMotor;
	public SpeedController leftFrontMotor;
	public SpeedController rightFrontMotor;
	private RobotDrive drive;
	
	private final double sensitivity = -0.89;

	private boolean isSensitive = false;
	private final boolean isCANTalon = false;


	public DriveBase() {
		super();

		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		rightFrontMotor.setInverted(true);
		rightBackMotor.setInverted(true);

		drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
		drive.setExpiration(0.1);
		//LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);
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
		SmartDashboard.putNumber("Left Back Motor Speed", this.leftBackMotor.get());
		SmartDashboard.putNumber("Right Back Motor Speed", this.rightBackMotor.get());
		SmartDashboard.putNumber("Left Front Motor Speed", this.leftFrontMotor.get());
		SmartDashboard.putNumber("Right Front Motor Speed", this.rightFrontMotor.get());
	}

	public void stop() {
		drive(0.0, 0.0, 0.0, 0.0);
	}
	
	public boolean toggleSensitivity(boolean turnOnSensitivity) {
		if (turnOnSensitivity) {
			if (!this.isSensitive) {
				if (this.isCANTalon)
					if (this.leftBackMotor instanceof CANTalon) {
						((CANTalon) this.leftBackMotor).setVoltageRampRate(0.6);
					}
				if (this.rightBackMotor instanceof CANTalon) {
					((CANTalon) this.rightBackMotor).setVoltageRampRate(0.6);
				}
				if (this.rightFrontMotor instanceof CANTalon) {
					((CANTalon) this.rightFrontMotor).setVoltageRampRate(0.6);
				}
				if (this.leftFrontMotor instanceof CANTalon) {
					((CANTalon) this.leftFrontMotor).setVoltageRampRate(0.6);
				}
				this.isSensitive = true;
				DriverStation.reportError("Setting Adjustment OI " + this.isSensitive, false);
				return true;
			}
			return false;
		} else {
			if (this.isSensitive) {
				if (this.isCANTalon) {
					if (this.leftBackMotor instanceof CANTalon) {
						((CANTalon) this.leftBackMotor).setVoltageRampRate(0);
					}
					if (this.rightBackMotor instanceof CANTalon) {
						((CANTalon) this.rightBackMotor).setVoltageRampRate(0);
					}
					if (this.rightFrontMotor instanceof CANTalon) {
						((CANTalon) this.rightFrontMotor).setVoltageRampRate(0);
					}
					if (this.leftFrontMotor instanceof CANTalon) {
						((CANTalon) this.leftFrontMotor).setVoltageRampRate(0);
					}

				}
				this.isSensitive = false;
				DriverStation.reportError("Setting Adjustment OI " + this.isSensitive, false);
				return true;
			}
			return false;
		}
	}

	private boolean sensitiveDrive(double x, double y, double twist, double gyro) {
		if (isCANTalon || !this.isSensitive) {
			drive(x, y, twist, gyro);
			return true;
		} else if (!isCANTalon && this.isSensitive) {
			DriverStation.reportError("Adjusting OI " + this.isSensitive, false);

			double adjustedX = x;
			double adjustedY = y;
			double adjustedTwist = twist;

			// x' = ax^3 + (1-a)x
			adjustedX = sensitivity * Math.pow(x, 3) + (1 - sensitivity) * x;
			adjustedY = sensitivity * Math.pow(y, 3) + (1 - sensitivity) * y;
			adjustedTwist = sensitivity * Math.pow(twist, 3) + (1 - sensitivity) * twist;
			drive(adjustedX, adjustedY, adjustedTwist, gyro);
			return true;
		}
		return false;
	}
}
