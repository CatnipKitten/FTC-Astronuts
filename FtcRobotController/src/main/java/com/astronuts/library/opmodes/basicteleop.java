package com.astronuts.library.opmodes;

import com.astronuts.library.movement.InitServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class basicteleop extends OpMode{
    Servo leftServo;
    Servo rightServo;
    InitServo servoLeft = new InitServo(leftServo, 0.1, 0.65, 0.01);
    InitServo servoRight = new InitServo(rightServo, 0.0, 0.7, 0.1);

    DcMotor motorRight;
    DcMotor motorLeft;
    final static double motorMaxPower = 0.2;

    @Override
    public void init() {
        leftServo = hardwareMap.servo.get("servo_left");
        rightServo = hardwareMap.servo.get("servo_right");
        servoRight.init();
        servoLeft.init();

        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorRight.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            servoLeft.move('+');
        }
        if(gamepad1.y){
            servoLeft.move('-');
        }
        if(gamepad1.x){
            servoRight.move('+');
        }
        if(gamepad1.b){
            servoRight.move('-');
        }

        double leftMotorPower = Range.clip(gamepad1.left_stick_y*motorMaxPower, -0.2, 0.2);
        double rightMotorPower = Range.clip(gamepad1.right_stick_y*motorMaxPower, -0.2, 0.2);

        motorLeft.setPower(leftMotorPower);
        motorRight.setPower(rightMotorPower);
    }
}
