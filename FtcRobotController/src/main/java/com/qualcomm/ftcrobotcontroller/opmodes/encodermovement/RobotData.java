package com.qualcomm.ftcrobotcontroller.opmodes.encodermovement;

import struct.StructClass;
import struct.StructField;

/**
 * This program was originally written in C# as a proof of concept.
 * Struct classes exist natively in C#, but not Java, which is why this class exists.
 * Also, the simple form of { get; set; } doesn't exist here, which is why the code is so long.
 */
@StructClass
public class RobotData {
    @StructField(order = 0)
    public static double leftMotorRPM; //Revolutions per minute (152)
    //public static double getLeftMotorRPM() { return leftMotorRPM; }
    //public static void setLeftMotorRPM(double leftMotorRPM) { RobotData.leftMotorRPM = leftMotorRPM; }

    @StructField(order = 1)
    public static double rightMotorRPM; //Revolutions per minute (152)
    //public static double getRightMotorRPM() { return rightMotorRPM; }
    //public static void setRightMotorRPM(double rightMotorRPM) { RobotData.rightMotorRPM = rightMotorRPM; }

    @StructField(order = 2)
    public static double leftWheelRadius; //Centimeters (4.971)
    //public static double getLeftWheelRadius() { return leftWheelRadius; }
    //public static void setLeftWheelRadius(double leftWheelRadius) { RobotData.leftWheelRadius = leftWheelRadius; }

    @StructField(order = 3)
    public static double rightWheelRadius; //Centimeters (4.971
    //public static double getRightWheelRadius() { return rightWheelRadius; }
    //public static void setRightWheelRadius(double rightWheelRadius) { RobotData.rightWheelRadius = rightWheelRadius; }

    @StructField(order = 4)
    public static double desiredPowerValue; //Percentage value (0.00 - 1)
    //public static double getDesiredPowerValue() { return desiredPowerValue; }
    //public static void setDesiredPowerValue(double desiredPowerValue) { RobotData.desiredPowerValue = desiredPowerValue; }

    @StructField(order = 5)
    public static double angularVelocity; //Radians per second
    //public static double getAngularVelocity() { return angularVelocity; }
    //public static void setAngularVelocity(double angularVelocity) { RobotData.angularVelocity = angularVelocity; }

    @StructField(order = 6)
    public static double forwardVelocity; //Centimeters per second
    //public static double getForwardVelocity() { return forwardVelocity; }
    //public static void setForwardVelocity(double forwardVelocity) { RobotData.forwardVelocity = forwardVelocity; }
}
