package com.qualcomm.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Prescott on 10/14/15.
 * Meow
 */
public class CentimetersCorrection {
    public double centimeters;
    public double inches;

    public void getcentimeters(UltrasonicSensor ultrasonicSensor) {
        double raw = ultrasonicSensor.getUltrasonicLevel();
        centimeters = raw - 3;
        inches = centimeters / 2.54;
    }
}
