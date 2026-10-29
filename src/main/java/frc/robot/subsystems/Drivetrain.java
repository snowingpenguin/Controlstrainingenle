package frc.robot.subsystems;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
public class Drivetrain extends SubsystemBase{
private final SparkMax m_leftLeader = new SparkMax(DriveConstants.kLeftMotor1Port, MotorType.kBrushless);  
  private final SparkMax m_rightLeader = new SparkMax(DriveConstants.kRightMotor1Port, MotorType.kBrushless);
     private final SparkMax m_leftFollower = new SparkMax(DriveConstants.kLeftMotor2Port, MotorType.kBrushless);
    private final SparkMax m_rightFollower = new SparkMax(DriveConstants.kRightMotor2Port, MotorType.kBrushless);
    
    private final DifferentialDrive m_robotDrive =
        new DifferentialDrive(m_leftLeader::set, m_rightLeader::set);
    
    public Drivetrain(){
        SendableRegistry.addChild(m_robotDrive, m_leftLeader);
        SendableRegistry.addChild(m_robotDrive, m_rightLeader);
        SparkMaxConfig followerConfig = new SparkMaxConfig();
        followerConfig.follow(m_leftLeader);
        SparkMaxConfig followerConfig2 = new SparkMaxConfig();
        followerConfig.follow(m_rightLeader);


        // m_leftLeader.Follower(m_leftFollower);
       // m_rightLeader.addFollower(m_rightFollower);
        m_rightLeader.setInverted(true);
    }
    public void TankDrive(double leftspeed, double rightspeed){
        m_robotDrive.tankDrive(leftspeed, rightspeed);

    }
    public void stop(){
        m_robotDrive.stopMotor();
    }
    

}
