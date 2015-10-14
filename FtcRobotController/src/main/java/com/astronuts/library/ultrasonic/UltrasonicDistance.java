package com.astronuts.library.ultrasonic;

import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * This Class is responsible for reading the Ultrasonic Sensor and Computing corrected distances
 * in centimeters and inches. The corrected values are returned in the "centimeters" and "inches"
 * fields.
 *Meow
 * Created by Prescott on 10/14/15.
 *
 */
public class UltrasonicDistance {
    // Stores the corrected Distance in Centimeters.
    public double centimeters;
    //Stores the corrected Distance in Inches.
    public double inches;

    //Creates Method for converting Ultrasonic Value to Centimeters and Inches.
    public void getcentimeters(UltrasonicSensor ultrasonicSensor) {
        //Gets the raw value from the sensor
        double raw = ultrasonicSensor.getUltrasonicLevel();
        //Converts raw data into Centimeters.
        centimeters = raw - 3;
        //Converts raw data into Inches.
        inches = centimeters / 2.54;
    }
}
