package com.astronuts.library;

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

    public static int teamColor = 0; //Default value; 0 is blue, 1 is red
    public static String blueTeam = "Current Team: Blue";
    public static String redTeam = "Current Team: Red";
    public static int teamPosition = 0; //Default value; 0 is right, 1 is left
    public static String rightPos = "Current Position: Right";
    public static String leftPos = "Current Position: Left";
    public static int timeDelay = 0; //Time value in seconds
    public static String timeDelay0 = "Current Time Delay: 0";
    public static String timeDelay5 = "Current Time Delay: 5";
    public static String timeDelay10 = "Current Time Delay: 10";
    public static String timeDelay15 = "Current Time Delay: 15";

    /*public void motorInit(DcMotor motorName, EncoderMotor encoderName, String motorNameString) {
        HardwareMap hardwareMap = new HardwareMap();
        motorName = hardwareMap.dcMotor.get(motorNameString);
        encoderName = new EncoderMotor(motorName, 5);
        motorTable.put(motorName, encoderName);
    }*/
}
