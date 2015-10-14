package com.astronuts.library.ultrasonic;

import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Prescott on 10/14/15.
 * Meow
 */
public class CentimetersCorrection {
    // Makes doubles for the values.
    public double centimeters;
    public double inches;

    //Creates Method for converting Ultrasonic Value to Centimeters and Inches.
    public void getcentimeters(UltrasonicSensor ultrasonicSensor) {
        double raw = ultrasonicSensor.getUltrasonicLevel();
        centimeters = raw - 3;
        inches = centimeters / 2.54;
    }
}
