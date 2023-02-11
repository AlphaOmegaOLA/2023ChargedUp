package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase
{
    public DoubleSolenoid clawSolenoid;
    private final int extend = Constants.ClawSubsystem.CLAW_SOLENOID_EXTEND_PWM;
    private final int retract = Constants.ClawSubsystem.CLAW_SOLENOID_RETRACT_PWM;

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
