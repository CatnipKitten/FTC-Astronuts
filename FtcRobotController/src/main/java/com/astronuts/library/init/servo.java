package com.astronuts.library.init;

import com.astronuts.library.opmodes.teleop;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class servo {
     public static void moveServo(Servo servoHardware, char servoCase, double delta, double
             currentPos, double
             min, double max) {
         currentPos+=delta;
         switch (servoCase){
             case'a':
                 teleop.armPos = currentPos;
             case'c':
                 teleop.clawPos = currentPos;
             case'l':
                 teleop.leftPos = currentPos;
             case'r':
                 teleop.rightPos = currentPos;
         }
         currentPos = Range.clip(currentPos, min, max);
         servoHardware.setPosition(currentPos);
     }
    public static void moveServo(Servo servoHardware, double desiredPos, double min, double max){
        desiredPos = Range.clip(desiredPos, min, max);
        servoHardware.setPosition(desiredPos);
    }

}
