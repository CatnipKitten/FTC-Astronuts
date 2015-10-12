package com.qualcomm.ftcrobotcontroller.encodermovement;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive {
    public void driveByDistance(double distance, String unit) {
        driveByDistance(distance, unit, 20);
    }

    public void driveByDistance(double distance, String unit, int power) {

    }

    public void turnByAngle(double angle, String unit, DcMotor motorLeft, DcMotor motorRight) {
        turnByAngle(angle, unit, 20, motorLeft, motorRight);
    }

    public void turnByAngle(double angle, String unit, int power, DcMotor motorLeft, DcMotor motorRight) {
        RobotData.setAngularVelocity(power);
        RobotData.setForwardVelocity();

    }

    public void driveTo(double x, double y, String unit) {
        driveTo(x, y, unit, 20);
    }

    public void driveTo(double x, double y, String unit, int power) {

    }

    private static double radianConversion(double degree){
        double radian; //Variable placeholder

        radian = degree * (Math.PI / 180); //Converts from degrees to radians
        radian = Math.atan2(Math.sin(radian), Math.cos(radian)); //Finds the arctan of the sine of the radians measure and the cosine of the radians measure

        return radian; //Returns the radians measure to the caller
    }
}
