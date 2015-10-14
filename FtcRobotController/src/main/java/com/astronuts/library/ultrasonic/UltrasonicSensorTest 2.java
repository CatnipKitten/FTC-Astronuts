package com.qualcomm.ftcrobotcontroller.opmodes;

import com.astronuts.library.ultrasonic.UltrasonicDistance;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * This OpMode is responsible for converting the ultrasonic value and displaying it on the Android
 * phones. It calls the method from the Ultrasonic Distance class to convert the data into
 * Centimeters and Inches.
 *
 * Created by Prescott on 10/7/15.
 */
public class UltrasonicSensorTest extends OpMode {
    //Stores values from the Ultrasonic Sensor.
    UltrasonicSensor ultrasonicsensor;
    //Creates a variable that makes a new instance of the Ultrasonic Distance Class.
    UltrasonicDistance test;

    @Override
    public void init () {
        //Maps the Ultrasonic Sensor.
        ultrasonicsensor = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
        //Creates the new instance of the class.
        test = new UltrasonicDistance();
    }
    public void loop () {
        //Starts the Method from the class.
        test.getcentimeters(ultrasonicsensor);

        //Shows data from the sensor that has been converted through the method in the class.
        telemetry.addData("Centimeters", test.centimeters);
        telemetry.addData("Inches", test.inches);
    }
}
