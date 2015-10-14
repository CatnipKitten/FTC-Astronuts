package com.astronuts.library.encoder;

public class Drive {
    public static void driveByDistance(double distance, char unit, EncoderMotor left, EncoderMotor
            right) {
        driveByDistance(distance, unit, 0.2, left, right);
    }

    public static void driveByDistance(double distance, char unit, double power, EncoderMotor left,
                                 EncoderMotor right) {
        switch(unit){
            case'c':
                left.move(driveByDistanceCalculator(distance), power);
                right.move(driveByDistanceCalculator(distance), power);
            case'i':
                left.move(driveByDistanceCalculator(distance*0.393701), power);
                right.move(driveByDistanceCalculator(distance*0.393701), power);
        }

    }

    public static void turnByAngle(int angle, EncoderMotor left, EncoderMotor right) {
        turnByAngle(angle, 0.2, left, right);
    }

    public static void turnByAngle(int angle, double power, EncoderMotor left, EncoderMotor right) {
        left.move(turnByAngleCalculator(angle), power);
        right.move(turnByAngleCalculator(-angle), power);
    }

    public void driveTo(double x, double y, String unit) {
        driveTo(x, y, unit, 20);
    }

    public void driveTo(double x, double y, String unit, int power) {

    }
    private static double radianConversion(double degree){
        double radian; //Variable placeholder

        radian = degree * (Math.PI / 180); //Converts from degrees to radians
        radian = Math.atan2(Math.sin(radian), Math.cos(radian)); //Finds the arctan of the sine of the radians measure and the cosine of the radians measure

        return radian; //Returns the radians measure to the caller
    }
    private static int turnByAngleCalculator(int angle){
        return (angle * 1442) / (150);
    }
    private static int driveByDistanceCalculator(double distance){
        return (int) (distance * 1442) / 50;
    }
}
