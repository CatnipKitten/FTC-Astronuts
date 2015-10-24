package com.astronuts.library.opmodes;

import com.astronuts.library.init.InitServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class newteleop extends OpMode{
    Servo leftServo;
    InitServo servoLeft = new InitServo(leftServo, 0.1, 0.65, 0.01);

    @Override
    public void init() {
        leftServo = hardwareMap.servo.get("servo_left");
        servoLeft.init();
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            servoLeft.move('+');
        }
        if(gamepad1.y){
            servoLeft.move('-');
        }
    }
}
