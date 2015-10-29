package com.astronuts.library.sensors.colorsensor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 *
 *
 * Created by Prescott on 10/28/15.
 * Last Edited by Prescott on 10/28/15.
 */
public class ColorSensorTestScenario extends LinearOpMode {
    //This is a note that will have stuff in it in the future :D
    DcMotor motorRight;
    DcMotor motorLeft;

    LightSensor lightSensor;
    UltrasonicSensor ultrasonic;
    ColorSensor color;
    DeviceInterfaceModule cdim;

    static final int LED_CHANNEL = 5;

    @Override
    public void  runOpMode () throws InterruptedException {
        ultrasonic = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
        lightSensor = hardwareMap.lightSensor.get("light_sensor");
        color = hardwareMap.colorSensor.get("color_sensor");
        //cdim = hardwareMap.colorSensor.get("dim");

        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        cdim.setDigitalChannelMode(LED_CHANNEL, DigitalChannelController.Mode.OUTPUT);
        cdim.setDigitalChannelState(LED_CHANNEL, false);

        waitForStart();
    }
}
