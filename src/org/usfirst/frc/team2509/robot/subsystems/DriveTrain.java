package org.usfirst.frc.team2509.robot.subsystems;


import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private WPI_TalonSRX LeftFront = RobotMap.Leftfront;
	private  WPI_TalonSRX RightFront = RobotMap.Rightfront;
	private  WPI_TalonSRX LeftBack = RobotMap.Leftback;
	private  WPI_TalonSRX RightBack = RobotMap.Rightback;
	private  MecanumDrive Drive = RobotMap.RobotDrive;
	private  OI oi = Robot.oi;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
    }
    public void Drive(Joystick stick) {
    	Drive.driveCartesian(getScaledDrive(-stick.getY()), getScaledDrive(-stick.getZ()), 0.5);
    }
    public double getScaledDrive(double input) {
    	return input*((Robot.oi.OPSTICK.getRawAxis(3)+3)*0.25);
    }
}

