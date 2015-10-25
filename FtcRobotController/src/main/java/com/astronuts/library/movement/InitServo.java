package com.astronuts.library.movement;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

public class InitServo{
    private Servo servo;
    private double servoMinimum;
    private double servoMaximum;
    private double delta;
    private double currentPosition;
    private char sign;
    Telemetry telemetry = new Telemetry();

    public InitServo(Servo servo, double servoMinimum, double servoMaximum, double delta)
    {
        this.servo = servo;
        this.servoMinimum = servoMinimum;
        this.servoMaximum = servoMaximum;
        this.delta = delta;
        sign = '+';
    }

    public void init()
    {
        currentPosition = servoMinimum;
        servo.setPosition(servoMinimum);
    }
    public void move(double desiredPosition)
    {
        desiredPosition = Range.clip(currentPosition, servoMinimum, servoMaximum);
        currentPosition = desiredPosition;
        servo.setPosition(currentPosition);
    }
    public void move(char sign)
    {
        this.sign = sign;
        switch(sign)
        {
            case'+':
                currentPosition+=delta;
                break;
            case'-':
                currentPosition-=delta;
                break;
            default:
                telemetry.addData("Invalid sign. Must be + or -.", servo);
                break;
        }
        servo.setPosition(currentPosition);
    }
}
