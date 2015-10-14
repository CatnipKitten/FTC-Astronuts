package com.astronuts.library.encoder;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class test extends OpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    EncoderMotor left;
    EncoderMotor right;
    @Override
    public void init(){
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorRight = hardwareMap.dcMotor.get("motor_right");
        left = new EncoderMotor(motorLeft);
        right = new EncoderMotor(motorRight);
        motorRight.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop(){
        left.move(1442, 0.2);
        right.move(1442, 0.2);
    }
}
