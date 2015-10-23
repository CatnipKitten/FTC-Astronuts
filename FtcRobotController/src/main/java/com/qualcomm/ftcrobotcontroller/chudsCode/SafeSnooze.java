/**
 * SafeSnooze class: making the ability to sleep your threads not a death sentence.
 * Author: Marcus Eliason (Choooooooooooooooooooooooooooooooooooooooooooooooood)
 * Created 10/21/15
 */

package com.qualcomm.ftcrobotcontroller.chudsCode;
//Import
import android.util.Log;

import java.io.File;

//Main class
public class SafeSnooze {

    //sleep method
    public static void snooze(long num, char unit) throws Exceptions {

        switch(unit){
            case 'm':

                //num = num

                break;

            case 'M':

                //num = num

                break;

            case 's':

                num = num * 1000;

                break;

            case  'S':

                num = num * 1000;

                break;

            default:

                throw new Exceptions("Illegal unit type: " + unit);

        }

        try{

            Thread.sleep(num);

        } catch (InterruptedException e) {

            Log.i("Chud.Sleep","Sleep thread was interrupted. Ignoring...");

        }

    }

}
