// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Imu extends SubsystemBase implements Reportable 
{
    public AHRS ahrs;
    private int numResets = 0;
    
    /**
     * Attempt to instantiate a new NavX IMU.
     * 
     * If an exception is thrown, it is caught and reported to the drivetrain.
     */
    public Imu() 
    {
        this.numResets = 0;
        
        try 
        { 
            // SPI is the protocol on the MXP connector that 
            // the NavX is plugged into
            ahrs = new AHRS(SPI.Port.kMXP); 
        } 
        catch (RuntimeException ex) 
        {
            DriverStation.reportError("Error instantiating navX2 MXP:  " + ex.getMessage(), true);
        }
    }
    
    /**
     * Set the current gyro direction to north
     */
    public void zeroHeading() 
    {
        ahrs.reset();
        numResets += 1;
        SmartDashboard.putNumber("Gyro resets", numResets);
    }

    /**
     * Gets angle robot is facing
     * @return Angle of the robot (degrees)
     */
    public double getHeading() 
    {
        double heading = Math.IEEEremainder(ahrs.getAngle(), 360);
        SmartDashboard.putNumber("Heading degrees", heading);
        return heading;
    }

    /**
     * Gets a rotation2d representing rotation of the drivetrain
     * @return A rotation2d representing rotation of the drivetrain
     */
    public Rotation2d getRotation2d() 
    {
        return Rotation2d.fromDegrees(getHeading());
    }

    public Rotation3d getRotation3d() 
    {
        return new Rotation3d(
            ahrs.getRoll() * Math.PI / 180, 
            ahrs.getPitch()* Math.PI / 180, 
            ahrs.getYaw() * Math.PI / 180) ;
    }

    public Rotation3d getRotation3dRaw() 
    {
        
        return new Rotation3d
        (
            Math.toRadians(ahrs.getRawGyroX()),
            Math.toRadians(ahrs.getRawGyroY()),
            Math.toRadians(ahrs.getRawGyroZ())
        );
    }

    public void reportToSmartDashboard() 
    {
        SmartDashboard.putNumber("Gyro", getHeading());
    }
}