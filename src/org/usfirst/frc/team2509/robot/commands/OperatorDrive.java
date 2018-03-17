package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class OperatorDrive extends Command {
	private DriveTrain drive = Robot.drivetrain;
	private Joystick OpStick = Robot.oi.OPSTICK;
	//private Joystick OpStick = Robot.oi.OPSTICK;
	/**
	 * Use requires() here to declare subsystem dependencies
	 * eg. requires(chassis);
	 */
    public OperatorDrive() {
    	requires(drive);
    }

    /**
     * Called just before OperatorDrive runs the first time
     */
    protected void initialize() {
    	drive.Drive(OpStick);
    }

    /**
     *  Called repeatedly when OperatorDrive is scheduled to run
     */
    protected void execute() {
    	drive.Drive(OpStick);
    }

    /**
     *  Make this return true when OperatorDrive no longer needs to run execute()
     */
    protected boolean isFinished() {
    	return false;
    }

    /**
     *  Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of 
     * the same subsystems is scheduled to run
     */
    protected void interrupted() {
    	end();
    }
}
