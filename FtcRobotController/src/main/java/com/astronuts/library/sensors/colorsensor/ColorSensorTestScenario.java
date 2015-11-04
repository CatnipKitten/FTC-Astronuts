package com.astronuts.library.sensors.colorsensor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.*;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * This is an autonomous program that makes the robot follow a white line that leads up to the red
 * and blue lights, finds out which color one side is, then uses logic to find the team's color,
 * and pushes one of the buttons based off of the team color.
 *
 * Created by Prescott on 10/28/15.
 * Last Edited by Prescott on 10/28/15.
 */
public class ColorSensorTestScenario extends LinearOpMode {
    //Creates a variable for
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
        cdim = hardwareMap.colorSensor.get("dim");

        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        cdim.setDigitalChannelMode(LED_CHANNEL, DigitalChannelController.Mode.OUTPUT);
        cdim.setDigitalChannelState(LED_CHANNEL, false);

        waitForStart();

        if (lightSensor )

    }
}
