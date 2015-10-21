package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.UltrasonicSensor;
//import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
//import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;


/**
 * Created by Zayle on 10/14/15.
 */
public class Sensors extends OpMode {

    LightSensor lightSensor;

    TouchSensor touchSensor;

    @Override
    public void init () {

        lightSensor = hardwareMap.lightSensor.get("light_sensor");
        lightSensor.enableLed(true);


        touchSensor = hardwareMap.touchSensor.get("touch_sensor");
    }
    @Override
    public void loop () {

        int light =lightSensor.getLightDetectedRaw();

        boolean touch = touchSensor.isPressed();

        telemetry.addData("5-LightSensor", light);
        telemetry.addData("6-TouchSensor", touch);

    }
}
