package com.astronuts.library.movement;

import com.astronuts.library.chudsCode.Exceptions;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

public class InitEncoder {
    private EncoderMotor encoderMotorLeft;
    private EncoderMotor encoderMotorRight;
    private double power;

    public InitEncoder(EncoderMotor encoderMotorLeft, EncoderMotor encoderMotorRight, double power) {
        this.encoderMotorLeft = encoderMotorLeft;
        this.encoderMotorRight = encoderMotorRight;
        this.power = power;
    }

    public void move(double distance, char unit) throws Exceptions{
        Drive.driveByDistance(distance, unit, power, encoderMotorLeft, encoderMotorRight);
    }
}
