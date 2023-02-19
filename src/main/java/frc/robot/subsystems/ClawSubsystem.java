package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase
{
    public DoubleSolenoid clawSolenoid;
    private final int extend = Constants.ClawSubsystem.CLAW_SOLENOID_EXTEND_CAN_ID;
    private final int retract = Constants.ClawSubsystem.CLAW_SOLENOID_RETRACT_CAN_ID;

    public ClawSubsystem()
    {
        clawSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, extend, retract); 
    }
    
    public void grab()
    {
        clawSolenoid.set(kForward);
    }

    public void release()
    {
        clawSolenoid.set(kReverse);
    }
}
