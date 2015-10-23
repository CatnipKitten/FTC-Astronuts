/**
 * IMU Class: making your imu's manageable.
 * Author: Marcus Eliason (Choooooooooooooooooooooooooooooooooooooooooooooooood)
 * Created 10/21/15
 */

package com.qualcomm.ftcrobotcontroller.chudsCode;

//Imports
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cController;
import com.qualcomm.robotcore.hardware.I2cDevice;

import java.util.concurrent.locks.Lock;

import static com.qualcomm.ftcrobotcontroller.chudsCode.SafeSnooze.snooze;

//Main Class
public class Imu {

    /**Data Addresses*/

    //Page 0
    public static final int
    // Address_Reserved = 0x6B-0x7F,
    P0_Address_MAG_RADIUS_MSB = 0x6A,
    P0_Address_MAG_RADIUS_LSB = 0x69,
    P0_Address_ACC_RADIUS_MSB = 0x68,
    P0_Address_ACC_RADIUS_LSB = 0x67,
    P0_Address_GYR_OFFSET_Z_MSB = 0x66,
    P0_Address_GYR_OFFSET_Z_LSB = 0x65,
    P0_Address_GYR_OFFSET_Y_MSB = 0x64,
    P0_Address_GYR_OFFSET_Y_LSB = 0x63,
    P0_Address_GYR_OFFSET_X_MSB = 0x62,
    P0_Address_GYR_OFFSET_X_LSB = 0x61,
    P0_Address_MAG_OFFSET_Z_MSB = 0x60,
    P0_Address_MAG_OFFSET_Z_LSB = 0x5F,
    P0_Address_MAG_OFFSET_Y_MSB = 0x5E,
    P0_Address_MAG_OFFSET_Y_LSB = 0x5D,
    P0_Address_MAG_OFFSET_X_MSB = 0x5C,
    P0_Address_MAG_OFFSET_X_LSB = 0x5B,
    P0_Address_ACC_OFFSET_Z_MSB = 0x5A,
    P0_Address_ACC_OFFSET_Z_LSB = 0x59,
    P0_Address_ACC_OFFSET_Y_MSB = 0x58,
    P0_Address_ACC_OFFSET_Y_LSB = 0x57,
    P0_Address_ACC_OFFSET_X_MSB = 0x56,
    P0_Address_ACC_OFFSET_X_LSB = 0x55,
    // Address_Reserved = 0x43-0x54,
    P0_Address_AXIS_MAP_SIGN = 0x42,
    P0_Address_AXIS_MAP_CONFIG = 0x41,
    P0_Address_TEMP_SOURCE = 0x40,
    P0_Address_SYS_TRIGGER = 0x3F,
    P0_Address_PWR_MODE = 0x3E,
    P0_Address_OPR_MODE = 0x3D,
    // Address_Reserved = 3C,
    P0_Address_UNIT_SEL = 0x3B,
    P0_Address_SYS_ERR = 0x3A,
    P0_Address_SYS_STATUS = 0x39,
    P0_Address_SYS_CLK_STATUS = 0x38,
    P0_Address_INT_STA = 0x37,
    P0_Address_ST_RESULT = 0x36,
    P0_Address_CALIB_STAT = 0x35,
    P0_Address_TEMP = 0x34,
    P0_Address_GRV_DATA_Z_MSB = 0x33,
    P0_Address_GRV_DATA_Z_LSB = 0x32,
    P0_Address_GRV_DATA_Y_MSB = 0x31,
    P0_Address_GRV_DATA_Y_LSB = 0x30,
    P0_Address_GRV_DATA_X_MSB = 0x2F,
    P0_Address_GRV_DATA_X_LSB = 0x2E,
    P0_Address_LIA_DATA_Z_MSB = 0x2D,
    P0_Address_LIA_DATA_Z_LSB = 0x2C,
    P0_Address_LIA_DATA_Y_MSB = 0x2B,
    P0_Address_LIA_DATA_Y_LSB = 0x2A,
    P0_Address_LIA_DATA_X_MSB = 0x29,
    P0_Address_LIA_DATA_X_LSB = 0x28,
    P0_Address_QUA_DATA_Z_MSB = 0x27,
    P0_Address_QUA_DATA_Z_LSB = 0x26,
    P0_Address_QUA_DATA_Y_MSB = 0x25,
    P0_Address_QUA_DATA_Y_LSB = 0x24,
    P0_Address_QUA_DATA_X_MSB = 0x23,
    P0_Address_QUA_DATA_X_LSB = 0x22,
    P0_Address_QUA_DATA_W_MSB = 0x21,
    P0_Address_QUA_DATA_W_LSB = 0x20,
    P0_Address_EUL_PITCH_MSB = 0x1F,
    P0_Address_EUL_PITCH_LSB = 0x1E,
    P0_Address_EUL_ROLL_MSB = 0x1D,
    P0_Address_EUL_ROLL_LSB = 0x1C,
    P0_Address_EUL_HEADING_MSB = 0x1B,
    P0_Address_EUL_HEADING_LSB = 0x1A,
    P0_Address_GYR_DATA_Z_MSB = 0x19,
    P0_Address_GYR_DATA_Z_LSB = 0x18,
    P0_Address_GYR_DATA_Y_MSB = 0x17,
    P0_Address_GYR_DATA_Y_LSB = 0x16,
    P0_Address_GYR_DATA_X_MSB = 0x15,
    P0_Address_GYR_DATA_X_LSB = 0x14,
    P0_Address_MAG_DATA_Z_MSB = 0x13,
    P0_Address_MAG_DATA_Z_LSB = 0x12,
    P0_Address_MAG_DATA_Y_MSB = 0x11,
    P0_Address_MAG_DATA_Y_LSB = 0x10,
    P0_Address_MAG_DATA_X_MSB = 0xF,
    P0_Address_MAG_DATA_X_LSB = 0xE,
    P0_Address_ACC_DATA_Z_MSB = 0xD,
    P0_Address_ACC_DATA_Z_LSB = 0xC,
    P0_Address_ACC_DATA_Y_MSB = 0xB,
    P0_Address_ACC_DATA_Y_LSB = 0xA,
    P0_Address_ACC_DATA_X_MSB = 0x9,
    P0_Address_ACC_DATA_X_LSB = 0x8,
    P0_Address_PAGE_ID = 0x7,
    P0_Address_BL_REV_ID = 0x6,
    P0_Address_SW_REV_ID_MSB = 0x5,
    P0_Address_SW_REV_ID_LSB = 0x4,
    P0_Address_GYR_ID = 0x3,
    P0_Address_MAG_ID = 0x2,
    P0_Address_ACC_ID = 0x1,
    P0_Address_CHIP_ID = 0x0;

    //Page 1
    public static final int
    // Address_Reserved = 0x60-0x7F,
    P1_Address_UNIQUE_ID[] = {0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59, 0x5A, 0x5B, 0x5C, 0x5D, 0x5E, 0x5F},
    // Address_Reserved = 0x4F-0x20,
    P1_Address_GYR_AM_SET = 0x1F,
    P1_Address_GYR_AM_THRES = 0x1E,
    P1_Address_GYR_DUR_Z = 0x1D,
    P1_Address_GYR_HR_Z_SET = 0x1C,
    P1_Address_GYR_DUR_Y = 0x1B,
    P1_Address_GYR_HR_Y_SET = 0x1A,
    P1_Address_GYR_DUR = 0x19,
    P1_Address_GYR_HR_X_SET = 0x18,
    P1_Address_GYR_INT_SETTING = 0x17,
    P1_Address_ACC_NM_SET = 0x16,
    P1_Address_ACC_NM_THRE = 0x15,
    P1_Address_ACC_HG_Thres = 0x14,
    P1_Address_ACC_HG_Duration = 0x13,
    P1_Address_ACC_INT_SETTINGS = 0x12,
    P1_Address_ACC_AM_THR_ES = 0x11,
    P1_Address_INT_EN = 0x10,
    P1_Address_INT_MSK = 0xF,
    // Address_Reserved = 0xE,
    P1_Address_GYR_SLEEP_CONFIG = 0xD,
    P1_Address_ACC_SLEEP_CONFIG = 0xC,
    P1_Address_GYR_CONFIG_1 = 0xB,
    P1_Address_GYR_CONFIG_0 = 0xA,
    P1_Address_MAG_CONFIG = 0x9,
    P1_Address_ACC_CONFIG = 0x8,
    P1_Address_PAGE_ID = 0x7;
    // Address_Reserved = 0x0-0x6;

    /**Class Variables*/

    private static I2cDevice I2cIMU;

    private final static int I2cBuffer = 26;
    private static Lock I2cWriteCacheLock;
    private static Lock I2cReadCacheLock;
    private static byte[] I2cWriteCache;
    private static byte[] I2cReadCache;
    private static int opMode;
    public static int I2cBaseAdress;

    public static long Timeout = 3000000000L;


    /**Main Methods*/

    //Init
    public static void init(HardwareMap hardwareMapInstance, String deviceName, byte baseAddress, byte mode) throws Exceptions {


        byte[] outbound = new byte[I2cBuffer];

        opMode = mode & 0xFF;
        I2cBaseAdress = baseAddress & 0xFF;
        I2cIMU = hardwareMapInstance.i2cDevice.get(deviceName);
        I2cWriteCache = I2cIMU.getI2cWriteCache();
        I2cWriteCacheLock = I2cIMU.getI2cWriteCacheLock();
        I2cReadCache = I2cIMU.getI2cReadCache();
        I2cReadCacheLock = I2cIMU.getI2cReadCacheLock();

        outbound[0] = 0x00;

        writeToI2c(outbound, 1, P0_Address_PAGE_ID);

    }

    public static void writeToI2c(byte[] outbound, int byteNum, int regAdress){



    }


    /**Imported Methods*/

    public static String getDeviceName() {
        return null;
    }

    public static String getConnectionInfo() {
        return null;
    }

    public static int getVersion() {
        return 0;
    }

    public static void close() {

    }

}
