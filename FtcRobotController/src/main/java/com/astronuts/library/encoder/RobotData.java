package com.astronuts.library.encoder;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Hashtable;

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

    /*public void motorInit(DcMotor motorName, EncoderMotor encoderName, String motorNameString) {
        HardwareMap hardwareMap = new HardwareMap();
        motorName = hardwareMap.dcMotor.get(motorNameString);
        encoderName = new EncoderMotor(motorName, 5);
        motorTable.put(motorName, encoderName);
    }*/
}
