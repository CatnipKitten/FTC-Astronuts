package com.astronuts.library.opmodes;

import com.astronuts.library.movement.EncoderMotor;
import com.astronuts.library.movement.InitEncoder;
import com.astronuts.library.movement.InitServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Zach on 10/24/2015.
 */
public class basiclinearop extends LinearOpMode {
    DcMotor motorRight;
    DcMotor motorLeft;
    final static double motorMaxPower = 0.2;

    Servo leftServo;
    Servo rightServo;
    InitServo servoLeft = new InitServo(leftServo, 0.1, 0.65, 0.01);
    InitServo servoRight = new InitServo(rightServo, 0.0, 0.7, 0.01);

    EncoderMotor left = new EncoderMotor(motorLeft);
    EncoderMotor right = new EncoderMotor(motorRight);

    InitEncoder encoder = new InitEncoder(left, right, 20);

    @Override
    public void runOpMode() throws InterruptedException {
        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        leftServo = hardwareMap.servo.get("servo_left");
        rightServo = hardwareMap.servo.get("servo_right");
        servoLeft.init();
        servoRight.init();

        waitForStart();
    }
}
