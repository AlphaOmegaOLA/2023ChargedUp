// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClawCommand extends CommandBase 
{
  //@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClawSubsystem claw;

  public OpenClawCommand(ClawSubsystem subsystem) 
  {
    claw = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() 
  {
    claw.release();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() 
  {
    return false;
  }
}