package com.astronuts.library.move;

import com.astronuts.library.chudsCode.Exceptions;
import com.astronuts.library.encoder.EncoderMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Zach on 10/24/2015.
 */
public class move {
    public void moveMotor(EncoderMotor encoder, int amount) throws Exceptions{
        encoder.move(amount, 0.2);
    }
    public void moveServo(HardwareMap servo){

    }
}
