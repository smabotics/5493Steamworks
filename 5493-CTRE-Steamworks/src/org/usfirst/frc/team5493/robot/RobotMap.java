package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.controllers.LWTalon;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class RobotMap {
	
	public final static int DRIVE_JOYSTICK_PORT = 0;
	public final static int JOYSTICK2_PORT = 1;

	public final static int JOYBTN_A = 1;
	public final static int JOYBTN_B = 2;
	public final static int JOYBTN_X = 3;
	public final static int JOYBTN_Y = 4;
	public final static int JOYBTN_LB = 5;
	public final static int JOYBTN_RB = 6;
	public final static int JOYAXS_LEFT_Y = 1;
	public final static int JOYAXS_RIGHT_Y = 5;
	
	//Talon #'s from the web dashboard
	//BKE -- Are these drive motors or ropeMotors - better comments and names help in a pinch.
    public static int leftFront = 2;//5; (changed for baby bot)
    public static int rightFront = 4;//3; (changed for baby bot)
    public static int leftBack = 3;//1; (changed for baby bot)
    public static int rightBack = 5;//8; (changed for baby bot)
    public static int ropeMotorLeft = 2;
    public static int ropeMotorRight = 9;
    public int climbedRope = 0;
	
    //BKE - Better names would allow you or anyone new to the code to know what the pneumatics1 and pneumatics2 do?
	public static int pneumaticsPort1 = 0;
	public static int pneumaticsPort2 = 1;
	public static int compressorNum = 0;
	
	public static int distanceSensor = 3;
	
	public static final int USE_CAN_TALON = 1;
	public static final int USE_PWM_TALON = 2;
	public static final int USE_PWM_VICTOR = 3;
	public static final int USE_PWM_JAGUAR = 4;
	
	public static SpeedController SpeedController(int port, int controllerType) {
		
		switch (controllerType) {
		case USE_CAN_TALON:
			return new CANTalon(port);

		case USE_PWM_VICTOR:
			return new Victor(port);

		case USE_PWM_TALON:
			return new LWTalon(port);

		case USE_PWM_JAGUAR:
			return new Jaguar(port);
		}

		return null;
	}
		/*
		//BKE - You only need this if you have TalonSR (LWTalon) AND TalonSRX (CANTalon) mixes on your bot or a practice bot with TalonSR and a comp bot with TalonSRX.
		if (Timings.USE_CAN) {
			return new CANTalon(port);
		}
		else {             
			return new LWTalon(port);
		}
	}
	*/

}
