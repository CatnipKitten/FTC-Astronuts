package com.astronuts.library.opmodes;

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
 *
 * Created by Prescott on 10/28/15.
 * Last Edited by Prescott on 10/28/15.
 */
public class ColorSensorTestScenario extends LinearOpMode {
    //Initializes the motors
    DcMotor motorRight;
    DcMotor motorLeft;

    //Initializes the sensors.
    LightSensor lightSensor;
    UltrasonicSensor ultrasonic;
    ColorSensor color;
    DeviceInterfaceModule cdim;

    //Sets variable that is used for the color sensor channel.
    static final int LED_CHANNEL = 5;

    @Override
    public void  runOpMode () throws InterruptedException {
        //Maps the sensors.
        ultrasonic = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
        lightSensor = hardwareMap.lightSensor.get("light_sensor");
        color = hardwareMap.colorSensor.get("color_sensor");

        //Maps the Device Interface Module
        cdim = hardwareMap.deviceInterfaceModule.get("dim");
        //Sets the channel for the color sensor.
        cdim.setDigitalChannelMode(LED_CHANNEL, DigitalChannelController.Mode.OUTPUT);
        cdim.setDigitalChannelState(LED_CHANNEL, false);

        //Maps the motors.
        motorRight = hardwareMap.dcMotor.get("motor_right");
        motorLeft = hardwareMap.dcMotor.get("motor_left");
        //Reverses the Left Motor.
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        if (lightSensor < (light value of white tape)) {

        }

        if (lightSensor > (light value of black pads)) {

        }



    }
}
