// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  CANSparkMax frontRight = null;
  CANSparkMax frontLeft = null;
  CANSparkMax rearRight = null;
  CANSparkMax rearLeft = null;

  MotorControllerGroup leftMotors = null;
  MotorControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public Drivetrain() {

    frontRight = new CANSparkMax(Constants.FRONT_RIGHT_SPARK_ID, MotorType.kBrushed);
    frontLeft = new CANSparkMax(Constants.FRONT_LEFT_SPARK_ID, MotorType.kBrushed);
    rearRight = new CANSparkMax(Constants.REAR_RIGHT_SPARK_ID, MotorType.kBrushed);
    rearLeft = new CANSparkMax(Constants.REAR_LEFT_SPARK_ID, MotorType.kBrushed);

    leftMotors = new MotorControllerGroup(frontLeft, rearLeft);
    rightMotors = new MotorControllerGroup(frontRight, rearRight);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {

    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
