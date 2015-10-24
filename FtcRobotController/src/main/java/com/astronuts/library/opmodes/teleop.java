package com.astronuts.library.opmodes;

import com.astronuts.library.init.servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class teleop extends OpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    Servo servoArm;
    public static double armPos;
    final static double armMax = 0.85;
    final static double armMin = 0.4;
    Servo servoClaw;
    public static double clawPos;
    final static double clawMax = 0.45;
    final static double clawMin = 0.0;
    Servo servoLeft;
    public static double leftPos;
    final static double leftMax = 0.65;
    final static double leftMin = 0.1;
    Servo servoRight;
    public static double rightPos;
    final static double rightMax = 0.7;
    final static double rightMin = 0.0;

    final static double delta = 0.025;
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

        servoLeft.setPosition(leftMin);
        leftPos = leftMin;
        servoRight.setPosition(rightMax);
        rightPos = rightMax;
        servoArm.setPosition(armMin);
        armPos = armMin;
        servoClaw.setPosition(clawMin);
        clawPos = clawMin;
    }
    @Override
    public void loop(){
        double leftStick = gamepad1.left_stick_y;
        double rightStick = gamepad1.right_stick_y;

        leftStick *= maxPower;
        rightStick *= maxPower;

        motorLeft.setPower(leftStick);
        motorRight.setPower(rightStick);

        servoCode();

        telemetry.addData("Left Stick: ", leftStick);
        telemetry.addData("Right Stick: ", rightStick);
    }
    private void servoCode(){
        if(gamepad1.a){
            servo.moveServo(servoArm, 'a', -delta, armPos, armMin, armMax);
        }
        if(gamepad1.y){
            servo.moveServo(servoArm, 'a', delta, armPos, armMin, armMax);
        }
        if(gamepad1.x){
            servo.moveServo(servoClaw, 'c', -delta, clawPos, clawMin, clawMax);
        }
        if(gamepad1.b){
            servo.moveServo(servoClaw, 'c', delta, clawPos, clawMin, clawMax);
        }
        if(gamepad1.dpad_left){
            servo.moveServo(servoLeft, 'l', -delta, leftPos, leftMin, leftMax);
        }
        if(gamepad1.dpad_right){
            servo.moveServo(servoLeft, 'l', delta, leftPos, leftMin, leftMax);
        }
        if(gamepad1.dpad_up){
            servo.moveServo(servoRight, 'r', -delta, rightPos, rightMin, rightMax);
        }
        if(gamepad1.dpad_down){
            servo.moveServo(servoRight, 'r', delta, rightPos, rightMin, rightMax);
        }
    }
}
