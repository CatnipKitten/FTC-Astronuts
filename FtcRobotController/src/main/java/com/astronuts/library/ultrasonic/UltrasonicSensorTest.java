package com.astronuts.library.ultrasonic;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * This OpMode is responsible for converting the ultrasonic value and displaying it on the Android
 * phones. It calls all
 * Created by Prescott on 10/7/15.
 * Meow
 */
public class UltrasonicSensorTest extends OpMode {
    //Stores values from the Ultrasonic Sensor.
    UltrasonicSensor ultrasonicsensor;

    @Override
    public void init () {
        //Maps the Ultrasonic Sensor.
        ultrasonicsensor = hardwareMap.ultrasonicSensor.get("ultrasonic_sensor");
    }
    public void loop () {
        //Gets Ultrasonic Value.
        double ultrasonic = ultrasonicsensor.getUltrasonicLevel();
        //Corrects Ultrasonic Values into Centimeters.
        double ultracorrected = ultrasonic - 3;
        //Correct the Ultrasonic Values into Inches.
        double ultrainches = ultracorrected / 2.54;

        //Displays all the Data.
        telemetry.addData("Raw Data", ultrasonic);
        telemetry.addData("Centimeters", ultracorrected);
        telemetry.addData("Inches", ultrainches);
    }
}
