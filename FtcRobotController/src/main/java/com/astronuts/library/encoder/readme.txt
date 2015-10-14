****************************
***How to use the program***
****************************

Step 1
============================
Set the motor RPMs, wheel radii, and desired power level
Wheel RPMs are in revolutions per minute, wheel radii are in centimeters, and desired power level should be in percentage format (0.00 - 1.00)
ex. RobotData.rightMotorRPM = 152; RobotData.leftMotorRPM = 152; RobotData.leftWheelRadius = 4.971; RobotData.rightWheelRadius = 4.971; RobotData.desiredPowerLevel = 0.2;

Step 2
============================
Calculate the velocities by calling the program (no other interaction needed)
Angular velocity is in radians per second, forward velocity is in centimeters per second
ex. RobotData.velocityCalculator();

Step 3
============================
Calculate the encoder values for movement
Will output the amount of encoder ticks to move each motor
First parameter is degree value, second is time to move in seconds, and third is the differentiation of the two wheel's velocities (0.85 is recommended).
The list is zero-indexed, so the right-wheel value is velocity.get(0), and the left-wheel value is velocity.get(1)
ex. encoderMove(45, 5, 0.85)

I'd recommend adding telemetry. I have no clue if this will work and I wanna know what kind of values are being outputted.