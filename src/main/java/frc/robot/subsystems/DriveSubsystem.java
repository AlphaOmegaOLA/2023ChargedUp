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
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.SPI;

import com.revrobotics.RelativeEncoder;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase 
{

  public static MecanumDrive m_drive;

  public static AHRS gyro;

  private CANSparkMax frontLeftMotor = new CANSparkMax();
  private CANSparkMax frontRightMotor = new CANSparkMax();
  private CANSparkMax rearLeftMotor = new CANSparkMax();
  private CANSparkMax rearRightMotor = new CANSparkMax();

  private RelativeEncoder m_frontLeftEncoder = frontLeftMotor.getEncoder();
  private RelativeEncoder m_frontRightEncoder = frontRightMotor.getEncoder();
  private RelativeEncoder m_backRightEncoder = rearRightMotor.getEncoder();
  private RelativeEncoder m_backLeftEncoder = rearLeftMotor.getEncoder();

  public DriveSubsystem() 
  {
    frontLeftMotor.setInverted(Constants.DriveSystemConstants.LEFT_SIDE_MOTORS_INVERTED);
    frontRightMotor.setInverted(Constants.DriveSystemConstants.RIGHT_SIDE_MOTORS_INVERTED);
    rearLeftMotor.setInverted(Constants.DriveSystemConstants.LEFT_SIDE_MOTORS_INVERTED);
    rearRightMotor.setInverted(Constants.DriveSystemConstants.RIGHT_SIDE_MOTORS_INVERTED);

    m_drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

    m_drive.setMaxOutput(.80);

    gyro = new AHRS(SPI.Port.kMXP);

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