package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	private DoubleSolenoid solenoid;
	private boolean opened = false;

	public Pneumatics() {
		solenoid = new DoubleSolenoid(RobotMap.pneumaticsPort1, RobotMap.pneumaticsPort2);
	}

	public void initDefaultCommand() {

	}

	public void release(String commandName) {

		// solenoid.set(DoubleSolenoid.Value.kReverse);
		if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pneumatics Release: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pneumatics Release: Reverse", false);
			solenoid.set(DoubleSolenoid.Value.kOff);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pneumatics Release: Off", false);
		}
		solenoid.set(DoubleSolenoid.Value.kReverse);
		/*
		 * if (!opened) { DriverStation.reportError("Releasing Gear: " +
		 * commandName, false); solenoid.set(DoubleSolenoid.Value.kReverse);
		 * opened = true; } else { DriverStation.reportError("RE OPENING Gear: "
		 * + commandName, false); solenoid.set(DoubleSolenoid.Value.kForward);
		 * opened = true; }
		 */
		// complete();
	}

	public void close(String commandName) {
		if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pneumatics Close: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pneumatics Close: Reverse", false);
			solenoid.set(DoubleSolenoid.Value.kOff);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pneumatics Close: Off", false);
		}
		solenoid.set(DoubleSolenoid.Value.kForward);
		/*
		 * if (opened) { DriverStation.reportError("Closing Gear: " +
		 * commandName, false); solenoid.set(DoubleSolenoid.Value.kForward);
		 * opened = false; } else {
		 * DriverStation.reportError("RE CLOSING Gear:", false);
		 * solenoid.set(DoubleSolenoid.Value.kReverse); opened = false; }
		 */
		// complete();
	}

	public void complete() {
		DriverStation.reportError("Pneumatics Complete", false);
		if (solenoid.get() != DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pneumatics Complete: Off", false);
		}
	}

	public void log() {

	}
}
