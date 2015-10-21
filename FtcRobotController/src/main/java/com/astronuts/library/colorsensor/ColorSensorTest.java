package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by baylee on 10/7/2015.
 */
public class ColorSensorTest extends OpMode {

    ColorSensor colorSensor;
    DeviceInterfaceModule cdim;
    static final int LED_CHANNEL=5;

    CScorrection cscore;





    @Override
    public void init(){

        colorSensor  = hardwareMap.colorSensor.get("color_sensor");

        cdim = hardwareMap.deviceInterfaceModule.get("dim");

        cdim.setDigitalChannelMode(LED_CHANNEL, DigitalChannelController.Mode.OUTPUT);
        cdim.setDigitalChannelState(LED_CHANNEL, false);

        cscore = new CScorrection();



    }
    @Override
    public void loop(){

        cscore.getColors(colorSensor);

        telemetry.addData("Red  ",cscore.redCorrected);
        telemetry.addData("Green", cscore.greenCorrected);
        telemetry.addData("Blue ", cscore.blueCorrected);









    }
}

