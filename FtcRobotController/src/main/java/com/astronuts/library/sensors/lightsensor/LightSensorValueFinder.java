package com.astronuts.library.sensors.lightsensor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.LightSensor;

/**
 * This is a basic light value reading programming for finding the light value of an object
 * (a line).
 *
 * Created by Prescott on 10/28/15.
 * Last Edited by Prescott on 11/4/15.
 */
public class LightSensorValueFinder extends OpMode {
     LightSensor lightSensor;

    public void init () {
        lightSensor = hardwareMap.lightSensor.get("light_sensor");

        lightSensor.enableLed(true);
    }

    @Override
    public void loop () {
        int light = lightSensor.getLightDetectedRaw();

        telemetry.addData("5-LightSensor", light);
    }
}
