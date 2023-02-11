package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase 
{
  private CANSparkMax liftMotor;
  private CANSparkMax extendArmMotor;

  RelativeEncoder liftMotorEncoder = liftMotor.getEncoder();
  RelativeEncoder extendArmMotorEncoder = extendArmMotor.getEncoder();

  public ArmSubsystem() 
  {
    liftMotor = new CANSparkMax(Constants.ArmSystem.LIFT_ARM_MOTOR_CAN_ID, MotorType.kBrushless);
    liftMotor.setIdleMode(IdleMode.kBrake);
    liftMotor.setSmartCurrentLimit(Constants.ArmSystem.LIFT_ARM_MOTOR_CURRENT_LIMIT);

    extendArmMotor = new CANSparkMax(Constants.ArmSystem.EXTEND_ARM_MOTOR_CAN_ID, MotorType.kBrushless);
    extendArmMotor.setIdleMode(IdleMode.kBrake);
    extendArmMotor.setSmartCurrentLimit(Constants.ArmSystem.EXTEND_ARM_MOTOR_CURRENT_LIMIT);
  }

  public double getLiftArmMotorEncoderDistance() 
  {
    return liftMotorEncoder.getPosition();
  }

  public double getExtendArmMotorEncoderDistance()
  {
    return extendArmMotorEncoder.getPosition();
  }

  public void setLiftArmMotor(double speed) 
  {
    liftMotor.set(speed);
  }

  public void setExtendArmMotor(double speed) 
  {
    extendArmMotor.set(speed);
  }

  public void extend() 
  {
    extendArmMotor.set(Constants.ArmSystem.LIFT_ARM_MOTOR_POWER);
  }

  public void retract() 
  {
    extendArmMotor.set(-1 * Constants.ArmSystem.LIFT_ARM_MOTOR_POWER);
  }

  public void raise() 
  {
    liftMotor.set(Constants.ArmSystem.EXTEND_ARM_MOTOR_POWER);
  }

  public void lower() 
  {
    liftMotor.set(-1 * Constants.ArmSystem.EXTEND_ARM_MOTOR_POWER);
  }

  public void stop() 
  {
    liftMotor.set(0);
    extendArmMotor.set(0);
  }
}