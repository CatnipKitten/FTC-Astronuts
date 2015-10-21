package com.qualcomm.ftcrobotcontroller.opmodes;
//import com.qualcomm.robotcore.hardware.LightSensor;
//import com.qualcomm.robotcore.hardware.TouchSensor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Zayle on 10/03/15.
 */

public class Auto  extends LinearOpMode {

    DcMotor motorRight;
    DcMotor motorLeft;

    @Override
    public void runOpMode() throws InterruptedException{
        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        motorLeft.setPower(0.2);
        motorRight.setPower(0.2);
        sleep(2000);

        motorLeft.setPower(-0.2);
        motorRight.setPower(0.2);
        sleep(1000);

        motorLeft.setPower(0.2);
        motorRight.setPower(0.2);
        sleep(1000);

        motorLeft.setPower(0.2);
        motorRight.setPower(-0.2);
        sleep(1000);

        motorLeft.setPower(0.0);
        motorRight.setPower(0.0);

        waitOneHardwareCycle();


    }
}
