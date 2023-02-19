// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Baseline robot infrastructure
package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.RunCommand;

// Joysticks
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// Drive System
import frc.robot.subsystems.DriveSubsystem;

// Claw
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.commands.CloseClawCommand;
import frc.robot.commands.OpenClawCommand;

// Arm
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.commands.ExtendArmCommand;
import frc.robot.commands.RetractArmCommand;
import frc.robot.commands.RaiseArmCommand;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here

  // Joysticks
  public static XboxController xbox_drive = new XboxController(0);
  public static XboxController xbox_operator = new XboxController(1);

  // Drive system
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  // Claw system
  private final ClawSubsystem claw = new ClawSubsystem();
  private final CloseClawCommand grab = new CloseClawCommand(claw);
  private final OpenClawCommand release = new OpenClawCommand(claw);

  // Arm system
  private final ArmSubsystem arm = new ArmSubsystem();
  private final ExtendArmCommand extend = new ExtendArmCommand(arm);
  private final RetractArmCommand retract = new RetractArmCommand(arm);
  private final RaiseArmCommand raise = new RaiseArmCommand(arm);
  private final RaiseArmCommand lower = new RaiseArmCommand(arm);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    driveSubsystem.setDefaultCommand(
        new RunCommand(() -> driveSubsystem.mecanumDrive(xbox_drive.getLeftY(), xbox_drive.getLeftX(), xbox_drive.getRightX()),
            driveSubsystem));
    // ^ Setting the Default Command to m_robotDrive, meaning it will drive as long
    // as nothing else is scheduled
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    // Claw
    new JoystickButton(xbox_operator, Constants.Controls.X_BUTTON_XBOX)
      .whileTrue(grab);

    new JoystickButton(xbox_operator, Constants.Controls.Y_BUTTON_XBOX)
      .whileTrue(release);

    // Arm extend/retract
    new JoystickButton(xbox_operator, Constants.Controls.B_BUTTON_XBOX)
      .whileTrue(extend);

    new JoystickButton(xbox_operator, Constants.Controls.A_BUTTON_XBOX)
      .whileTrue(retract);

    // Arm raise/lower
    new JoystickButton(xbox_operator, Constants.Controls.RIGHT_BUMPER_XBOX)
    .whileTrue(raise);

    new JoystickButton(xbox_operator, Constants.Controls.LEFT_BUMPER_XBOX)
    .whileTrue(lower);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //m_driveSubsystem.resetEncoders();
    //return m_autoCommand;
  //}
}