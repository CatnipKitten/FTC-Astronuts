package com.astronuts.library.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class teleop extends OpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    Servo servoArm;
    double armPos;
    double armMax = 0.94;
    double armMin = 0.4;
    Servo servoClaw;
    double clawPos;
    double clawMax = 0.5;
    double clawMin = 0.1;
    Servo servoLeft;
    double leftPos;
    double leftMax = 0.5;
    double leftMin = 0.0;
    Servo servoRight;
    double rightPos;
    double rightMax = 0.5;
    double rightMin = 0.0;

    double delta = 0.025;
    final static double maxPower = 0.2;
    @Override
    public void init(){
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorRight = hardwareMap.dcMotor.get("motor_right");
        servoArm = hardwareMap.servo.get("servo_arm");
        servoClaw = hardwareMap.servo.get("servo_claw");
        servoLeft = hardwareMap.servo.get("servo_left");
        servoRight = hardwareMap.servo.get("servo_right");
        motorRight.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop(){
        double leftStick = -gamepad1.left_stick_y;
        double rightStick = -gamepad1.right_stick_y;

        leftStick *= maxPower;
        rightStick *= maxPower;

        motorLeft.setPower(leftStick);
        motorRight.setPower(rightStick);

        telemetry.addData("Left Stick: ", leftStick);
        telemetry.addData("Right Stick: ", rightStick);
    }
}
