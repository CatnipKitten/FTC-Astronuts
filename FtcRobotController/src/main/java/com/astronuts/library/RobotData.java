package com.astronuts.library;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class RobotData {
    public String LOG_TAG = "RobotData";

    public static int teamColor = 0; //Default value; 0 is blue, 1 is red
    public static String blueTeam = "Current Team: Blue";
    public static String redTeam = "Current Team: Red";
    public static int teamPosition = 0; //Default value; 0 is right, 1 is left
    public static String rightPos = "Current Position: Right";
    public static String leftPos = "Current Position: Left";
    public static int timeDelay = 0; //Time value in seconds
    public static String timeDelay0 = "Current Time Delay: 0";
    public static String timeDelay5 = "Current Time Delay: 5";
    public static String timeDelay10 = "Current Time Delay: 10";
    public static String timeDelay15 = "Current Time Delay: 15";
}
