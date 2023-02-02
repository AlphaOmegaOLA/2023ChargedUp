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

//import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase 
{

  public static MecanumDrive m_drive;

  private PWMSparkMax frontLeftMotor = new PWMSparkMax(Constants.DriveSystemConstants.FRONT_LEFT_MOTOR_PWM_PORT);
  private PWMSparkMax frontRightMotor = new PWMSparkMax(Constants.DriveSystemConstants.FRONT_RIGHT_MOTOR_PWM_PORT);
  private PWMSparkMax rearLeftMotor = new PWMSparkMax(Constants.DriveSystemConstants.REAR_LEFT_MOTOR_PWM_PORT);
  private PWMSparkMax rearRightMotor = new PWMSparkMax(Constants.DriveSystemConstants.REAR_RIGHT_MOTOR_PWM_PORT);

  //private RelativeEncoder m_frontLeftEncoder = frontLeftMotor.getEncoder();
  //private RelativeEncoder m_frontRightEncoder = frontRightMotor.getEncoder();
  //private RelativeEncoder m_backRightEncoder = backRightMotor.getEncoder();
  //private RelativeEncoder m_backLeftEncoder = backLeftMotor.getEncoder();

  public DriveSubsystem() 
  {
    frontLeftMotor.setInverted(Constants.DriveSystemConstants.LEFT_SIDE_MOTORS_INVERTED);
    frontRightMotor.setInverted(Constants.DriveSystemConstants.RIGHT_SIDE_MOTORS_INVERTED);
    rearLeftMotor.setInverted(Constants.DriveSystemConstants.LEFT_SIDE_MOTORS_INVERTED);
    rearRightMotor.setInverted(Constants.DriveSystemConstants.RIGHT_SIDE_MOTORS_INVERTED);

    m_drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

    // ((Object) m_drive).setRightSideInverted(false);
    //m_drive.setMaxOutput(.80);
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