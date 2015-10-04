package com.qualcomm.ftcrobotcontroller.opmodes.encodermovement;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static double degreesToRad(double degree)
    {
        double radian; //Initializes the radian value.
        radian = degree * (Math.PI / 180); //Converts the degree measure into radians since trig functions will only accept radians
        radian = Math.atan2(Math.sin(radian), Math.cos(radian));
        //(In layman's terms) Wraps the radians in terms of -pi to pi instead of 0 to 2pi
        //Finds the principal value of the arc tangent of the sin of rad / cosine of rad
        return radian; //Returns the radians value to the caller
    }

    public static void velocityCalculator()
    {
        double angVel = ((((RobotData.leftMotorRPM) + RobotData.rightMotorRPM) / 2) / 60) * RobotData.desiredPowerValue * 6.28319;
        //First calculates the average RPM of the wheels, then divides by 60 to get the units to be revolutions per second.
        //Next calculates how many revolutions it will do at the desired power value, and times the end result by 6.28319 to put it into units of radians per second.
        RobotData.angularVelocity = angVel; //Sets the angularVelocity variable in the struct
        RobotData.forwardVelocity = (((RobotData.leftWheelRadius + RobotData.rightWheelRadius) / 2) / 2) * (angVel + angVel);
        //First calculates the average radius to put the final units in distance, divides by 2, then multiplies by the angle velocity
    }

    public static List<Double> encoderMove(double degrees, double time, double constant)
    {
        List<Double> velocity = new ArrayList<Double>(); //Initializes a new list
        velocity.add((RobotData.forwardVelocity) * (Math.cos((degreesToRad(degrees) * time))) + constant * (Math.sin((degreesToRad(degrees) * time)))); //Adds the velocity values (in rad/sec) to the list (right wheel)
        velocity.add((RobotData.forwardVelocity) * (Math.cos((degreesToRad(degrees) * time))) - constant * (Math.sin((degreesToRad(degrees) * time))));//Adds the velocity values (in rad/sec) to the list (left wheel)
        velocity.set(0, velocity.get(0) * 0.159155 * 1442); //Converts the values into revolutions, and then encoder ticks
        velocity.set(1, velocity.get(1) * 0.159155 * 1442); //Converts the values into revolutions, and then encoder ticks
        return velocity;
    }
}
