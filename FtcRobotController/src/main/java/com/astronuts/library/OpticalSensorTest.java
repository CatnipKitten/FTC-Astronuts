package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.LightSensor;
//import com.qualcomm.robotcore.hardware.TouchSensor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;

/**
 * Created by Zayle on 09/30/15.
 */
public class OpticalSensorTest extends OpMode {
    OpticalDistanceSensor opticalSensor;

    @Override
    public void init () {
        opticalSensor = hardwareMap.opticalDistanceSensor.get("Optical_Distance_Sensor");


    }
    @Override
    public  void loop() {

        double optical = opticalSensor.getLightDetected();

        telemetry.addData("OpticalSensor", optical);
    }
}
