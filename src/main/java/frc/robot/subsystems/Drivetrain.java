package frc.robot.subsystems;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
public class Drivetrain extends SubsystemBase{
    private final PWMSparkMax m_leftLeader = new PWMSparkMax(DriveConstants.kLeftMotor1Port);
    private final PWMSparkMax m_rightLeader = new PWMSparkMax(DriveConstants.kRightMotor1Port);
     private final PWMSparkMax m_leftFollower = new PWMSparkMax(DriveConstants.kLeftMotor2Port);
    private final PWMSparkMax m_rightFollower = new PWMSparkMax(DriveConstants.kRightMotor2Port);
    
    private final DifferentialDrive m_robotDrive =
        new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);
    
    public Drivetrain(){
        SendableRegistry.addChild(m_robotDrive, m_leftLeader);
        SendableRegistry.addChild(m_robotDrive, m_rightLeader);
         m_leftLeader.addFollower(m_leftFollower);
        m_rightLeader.addFollower(m_rightFollower);
        m_rightLeader.setInverted(true);
    }
    public void TankDrive(double leftspeed, double rightspeed){
        m_robotDrive.tankDrive(leftspeed, rightspeed);

    }
    public void stop(){
        m_robotDrive.stopMotor();
    }
    

}
