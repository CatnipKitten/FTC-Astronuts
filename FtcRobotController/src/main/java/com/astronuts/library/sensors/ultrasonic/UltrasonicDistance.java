package com.astronuts.library.sensors.ultrasonic;

import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * This Class is responsible for reading the Ultrasonic Sensor and Computing corrected distances
 * in centimeters and inches. The corrected values are returned in the "centimeters" and "inches"
 * fields.
 *
 * Created by Prescott on 10/14/15.
 * Last edited by Prescott on 10/21/15.
 */
public class UltrasonicDistance {
    //Makes a variable that will be able to store the value for centimeters.
    public static double centimeters;
    //Makes a variable that will be able to store the value for inches.
    public static double inches;

    //Creates Method for converting Ultrasonic Value to Centimeters and Inches.
    public double getcentimeters(UltrasonicSensor ultrasonicSensor, char unit) {
        //Gets the raw value from the sensor.
        double raw = ultrasonicSensor.getUltrasonicLevel();

        //Converts raw data into Centimeters.
        centimeters = raw - 3;

        //Converts raw data into Inches.
        inches = centimeters / 2.54;

        switch(unit) {
            case'c':
                return centimeters;
            break;
            case'i'
                return inches;
            break;
        }
    }
}
