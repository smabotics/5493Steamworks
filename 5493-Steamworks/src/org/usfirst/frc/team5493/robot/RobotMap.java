package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.controllers.LWTalon;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {

	public final static int JOYBTN_A = 1;
	public final static int JOYBTN_B = 2;
	public final static int JOYBTN_X = 3;
	public final static int JOYBTN_Y = 4;
	public final static int JOYBTN_LB = 5;
	public final static int JOYBTN_RB = 6;
	public final static int JOYAXS_LEFT_Y = 1;
	public final static int JOYAXS_RIGHT_Y = 5;
	public final static int JOYBTN_TRIGGER = 1;
	
	//Talon #'s from the web dashboard
	//BKE -- Are these drive motors or ropeMotors - better comments and names help in a pinch.
    public static int leftFront = 5;
    public static int rightFront = 3;
    public static int leftBack = 1;
    public static int rightBack = 8;
    //BKE - Rope Motor is two right?
    public static int ropeMotor = 9;
    public static int gearMotor = 2;
	
    //BKE - Better names would allow you or anyone new to the code to know what the pneumatics1 and pneumatics2 do?
	public static int pneumatics1 = 0;
	public static int pneumatics2 = 1;
	public static int compressorNum = 0;
	
	public static SpeedController SpeedController(int port) {
		//BKE - You only need this if you have TalonSR (LWTalon) AND TalonSRX (CANTalon) mixes on your bot or a practice bot with TalonSR and a comp bot with TalonSRX.
		if (Timings.USE_CAN) {
			return new CANTalon(port);
		}
		else {             
			return new LWTalon(port);
		}
	}

}
