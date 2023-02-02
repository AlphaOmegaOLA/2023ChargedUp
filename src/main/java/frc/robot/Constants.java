/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Add a class for each subsystem

package frc.robot;

public final class Constants 
{
    public static class DriveSystemConstants
    {
        public static double k = 0.8;// in DriveSubsystem, changes speed for some reason
        public static final double K_TURN = 0.25;
        public static final double MAX_SPEED = 0.25;
        public static final int SMART_LIMIT = 80;

        // Motor PWM Ports
        public static final int FRONT_LEFT_MOTOR_PWM_PORT = 2;
        public static final int REAR_LEFT_MOTOR_PWM_PORT = 3;
        public static final int FRONT_RIGHT_MOTOR_PWM_PORT = 1;
        public static final int REAR_RIGHT_MOTOR_PWM_PORT = 0;

        // Motor inversion
        public static final boolean RIGHT_SIDE_MOTORS_INVERTED = true;
        public static final boolean LEFT_SIDE_MOTORS_INVERTED = false;
    }

    public static class OperatorConstants
    {        
        // Xbox Controller Buttons
        public static final int A_BUTTON_XBOX = 1;
        public static final int B_BUTTON_XBOX = 2;
        public static final int X_BUTTON_XBOX = 3;
        public static final int Y_BUTTON_XBOX = 4;
        public static final int LEFT_BUMPER_XBOX = 5;
        public static final int RIGHT_BUMPER_XBOX = 6;
        public static final int BACK_ARROW = 7;
        public static final int START_ARROW = 8;
        public static final int JOYSTICK_RIGHT_CLICK = 10;
        public static final int JOYSTICK_LEFT_CLICK = 9;
    }
}