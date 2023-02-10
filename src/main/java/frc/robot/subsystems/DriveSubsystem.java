/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
*limelight
*/
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase 
{

  public static MecanumDrive m_drive;

  private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.DriveSystem.FRONT_LEFT_MOTOR_CAN_ID, MotorType.kBrushless) ;
  private CANSparkMax frontRightMotor = new CANSparkMax(Constants.DriveSystem.FRONT_RIGHT_MOTOR_CAN_ID, MotorType.kBrushless);
  private CANSparkMax rearLeftMotor = new CANSparkMax(Constants.DriveSystem.REAR_LEFT_MOTOR_CAN_ID, MotorType.kBrushless);
  private CANSparkMax rearRightMotor = new CANSparkMax(Constants.DriveSystem.REAR_RIGHT_MOTOR_CAN_ID, MotorType.kBrushless);

  private RelativeEncoder m_frontLeftEncoder = frontLeftMotor.getEncoder();
  private RelativeEncoder m_frontRightEncoder = frontRightMotor.getEncoder();
  private RelativeEncoder m_backRightEncoder = rearRightMotor.getEncoder();
  private RelativeEncoder m_backLeftEncoder = rearLeftMotor.getEncoder();

  public DriveSubsystem() 
  {
    frontLeftMotor.setInverted(Constants.DriveSystem.LEFT_SIDE_MOTORS_INVERTED);
    frontRightMotor.setInverted(Constants.DriveSystem.RIGHT_SIDE_MOTORS_INVERTED);
    rearLeftMotor.setInverted(Constants.DriveSystem.LEFT_SIDE_MOTORS_INVERTED);
    rearRightMotor.setInverted(Constants.DriveSystem.RIGHT_SIDE_MOTORS_INVERTED);

    m_drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

    m_drive.setMaxOutput(Constants.DriveSystem.MAX_OUTPUT);

  }

  public void mecanumDrive(double leftY, double leftX, double rightX)
  {
    m_drive.driveCartesian(-1*leftY, leftX, rightX);
  }

  @Override
  public void periodic() 
  {
    m_drive.feedWatchdog(); // check this
  }

}