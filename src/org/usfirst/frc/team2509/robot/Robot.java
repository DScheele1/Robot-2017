/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public Joystick OPSTICK;
	public Joystick COOPSTICK;
	public static WPI_TalonSRX Leftfront;
	public static WPI_TalonSRX Rightfront;
	public static WPI_TalonSRX Leftback;
	public static WPI_TalonSRX Rightback;
	public static WPI_TalonSRX Sweeper;
	public static MecanumDrive RobotDrive;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		OPSTICK= new Joystick(0);
		COOPSTICK=  new Joystick(1);
		Rightback = new WPI_TalonSRX(3);
		Rightfront = new WPI_TalonSRX(1);
		Leftback = new WPI_TalonSRX(0);
		Leftfront = new WPI_TalonSRX(2);
		Sweeper = new WPI_TalonSRX(5);
		RobotDrive = new MecanumDrive(Leftfront, Leftback, Rightfront, Rightback);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Leftback.setInverted(true);
		Leftfront.setInverted(true);
		Rightback.setInverted(true);
		Rightfront.setInverted(true);
		RobotDrive.driveCartesian(OPSTICK.getX()*1,OPSTICK.getY()*1,OPSTICK.getZ()*1);
		if(COOPSTICK.getRawButton(1)) {
			Sweeper.set(0.5);
		}else {
			Sweeper.set(0);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	public double getScaledDrive(double input) {
		return (input*((OPSTICK.getRawAxis(3)+3)*0.25));
    }
}
