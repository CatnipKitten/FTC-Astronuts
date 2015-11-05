package com.astronuts.library.opmodes;

import com.astronuts.library.RobotData;
import com.astronuts.library.chudsCode.SafeSnooze;
import com.astronuts.library.movement.EncoderMotor;
import com.astronuts.library.movement.InitEncoder;
import com.astronuts.library.movement.InitServo;
import com.astronuts.library.sensors.colorsensor.CScorrection;
import com.astronuts.library.sensors.ultrasonic.UltrasonicDistance;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.*;
import com.qualcomm.robotcore.hardware.Servo;
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
    final static double motorMaxPower = 20;

    Servo leftServo;
    Servo rightServo;
    InitServo servoLeft = new InitServo(leftServo, 0.1, 0.65, 0.01);
    InitServo servoRight = new InitServo(rightServo, 0.0, 0.7, 0.01);


    //Initializes the sensors.
    LightSensor lightSensor;
    UltrasonicSensor ultrasonic;
    ColorSensor color;
    DeviceInterfaceModule cdim;

    //Sets variable that is used for the color sensor channel.
    static final int LED_CHANNEL = 5;

    EncoderMotor left = new EncoderMotor(motorLeft);
    EncoderMotor right = new EncoderMotor(motorRight);

    InitEncoder encoder = new InitEncoder(left, right, motorMaxPower);

    @Override
    public void  runOpMode () throws InterruptedException {
        //Maps the sensors.
        ultrasonic = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
        lightSensor = hardwareMap.lightSensor.get("light_sensor");
        color = hardwareMap.colorSensor.get("color_sensor");

        leftServo = hardwareMap.servo.get("servo_left");
        rightServo = hardwareMap.servo.get("servo_right");
        servoLeft.init();
        servoRight.init();

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

        CScorrection cscorrection = new CScorrection();
        UltrasonicDistance ultrasonicDistance = new UltrasonicDistance(ultrasonic);

        waitForStart(); //Starts the actual program.
        SafeSnooze.snooze(RobotData.timeDelay, 's');

        while(ultrasonicDistance.getdistance('c')) {
            if (lightSensor < (light value of white tape)) {

            }
            if (lightSensor > (light value of black pads)) {

            }

    }
}
