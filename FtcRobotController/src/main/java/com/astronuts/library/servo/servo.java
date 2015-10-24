package com.astronuts.library.servo;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Zach on 10/24/2015.
 */
public class servo {
     public static void moveServo(Servo servoHardware, double delta, double currentPos) {
         currentPos+=delta;
         servoHardware.setPosition(currentPos);
     }
    public static void moveServo(Servo servoHardware, double desiredPos){
        servoHardware.setPosition(desiredPos);
    }
}
