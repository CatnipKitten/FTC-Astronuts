package com.astronuts.library;

import android.os.Environment;

import java.io.File;

public class AppendLog {
    public static void appendLog(){
        String dir = "/sdcard/astronutslogs";
        File fileDir = new File(dir);

        if(!fileDir.exists()){
            fileDir.mkdir();
        }


    }
}
