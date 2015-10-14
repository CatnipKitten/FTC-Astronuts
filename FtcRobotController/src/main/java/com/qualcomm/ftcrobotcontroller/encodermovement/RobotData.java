package com.qualcomm.ftcrobotcontroller.encodermovement;

import com.qualcomm.ftcrobotcontroller.EncoderMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotData {
    public static double motorRPM = 152;
    public static double getMotorRPM() { return motorRPM; }
    protected static void setMotorRPM(double rpm) { motorRPM = rpm; }

    public static double wheelRadius = 4.971;
    public static double getWheelRadius() { return wheelRadius; }
    protected static void setWheelRadius(double radius) { wheelRadius = radius; }

    public static double angularVelocity;
    public static double getAngularVelocity() { return angularVelocity; }
    protected static void setAngularVelocity() { setAngularVelocity(20); }
    protected static void setAngularVelocity(int powerValue) { angularVelocity = (getMotorRPM() / 60) * powerValue * 6.28319; }

    public static double forwardVelocity;
    public static double getForwardVelocity() { return forwardVelocity; }
    protected static void setForwardVelocity() { forwardVelocity = (getWheelRadius() / 2) * (getAngularVelocity() * 2); }

    public EncoderMotor motorInit(DcMotor motorName, String motorNameString) {
        HardwareMap hardwareMap = new HardwareMap();
        motorName = hardwareMap.dcMotor.get(motorNameString);
        EncoderMotor encoderName;
        encoderName = new EncoderMotor(motorName, 5);
        return encoderName;
    }

    public EncoderMotor motorInit(DcMotor motorName, String motorNameString, int tolerance) {
        HardwareMap hardwareMap = new HardwareMap();
        motorName = hardwareMap.dcMotor.get(motorNameString);
        EncoderMotor encoderName;
        encoderName = new EncoderMotor(motorName, tolerance);
        return encoderName;
    }
}
