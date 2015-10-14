package com.astronuts.library.ultrasonic;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Prescott on 10/7/15.
 */
public class UltrasonicSensorTest extends OpMode {
    UltrasonicSensor ultrasonicsensor;

    @Override
    public void init () {
        ultrasonicsensor = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
    }
    public void loop () {
        double ultrasonic = ultrasonicsensor.getUltrasonicLevel();
        double ultracorrected = ultrasonic - 3;

        telemetry.addData("4-ultrasonic_sensor", ultrasonic);
        telemetry.addData("Ultrasonic Corrected", ultracorrected);
    }
}
