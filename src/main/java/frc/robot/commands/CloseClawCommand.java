// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class CloseClawCommand extends CommandBase 
{
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClawSubsystem claw;

  public CloseClawCommand(ClawSubsystem subsystem) 
  {
    claw = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() 
  {
    // check if the power draw for the motor is over 2 amps -- if so, end the command
    // if (m_subsystem.get)
    claw.grab();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() 
  {
    return false;
  }
}