package com.astronuts.library.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class teleop extends OpMode{
    DcMotor motorLeft;
    DcMotor motorRight;
    final static double maxPower = 0.2;
    @Override
    public void init(){
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorRight = hardwareMap.dcMotor.get("motor_right");
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
