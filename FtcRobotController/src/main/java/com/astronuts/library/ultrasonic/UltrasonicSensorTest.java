package com.astronuts.library.ultrasonic;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Prescott on 10/7/15.
 * Meow
 */
public class UltrasonicSensorTest extends OpMode {
    //Makes variable for the Ultrasonic Sensor.
    UltrasonicSensor ultrasonicsensor;

    @Override
    public void init () {
        //Maps the Ultrasonic Sensor.
        ultrasonicsensor = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
    }
    public void loop () {
        //Corrects the Raw data from the Ultrasonic Sensor.
        double ultrasonic = ultrasonicsensor.getUltrasonicLevel();
        double ultracorrected = ultrasonic - 3;

        //Displays the Data.
        telemetry.addData("4-ultrasonic_sensor", ultrasonic);
        telemetry.addData("Ultrasonic Corrected", ultracorrected);
    }
}
