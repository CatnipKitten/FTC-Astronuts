package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.LightSensor;
//import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Zayle on 10/03/15.
 */
public class Test extends OpMode {

    final static float LEFT_MOTOR_MAX_POWER = (float) 0.2;
    final static float RIGHT_MOTOR_MAX_POWER = (float) 0.2;

    final static double ARM_MIN_RANGE = .4;
    final static double ARM_MAX_RANGE =.94;

    final static double CLAW_MIN_RANGE = 0.50;
    final static double Claw_MAX_RANGE = 1.00;

    double armPosition = ARM_MIN_RANGE;
    double clawPosition = CLAW_MIN_RANGE;


    DcMotor motorRight;
    DcMotor motorLeft;

    double armDelta = 0.01;
    double clawDelta = 0.01;

    Servo arm;
    Servo claw;

@Override
    public void  init() {

    motorRight = hardwareMap.dcMotor.get("motor_right");
    motorLeft = hardwareMap.dcMotor.get("motor_left");

    motorLeft.setDirection(DcMotor.Direction.REVERSE);

    arm = hardwareMap.servo.get("servo_arm");
    claw = hardwareMap.servo.get("servo");

    arm.setPosition(armPosition);
    claw.setPosition(clawPosition);

    }


    @Override
    public void loop() {

        float left = -gamepad1.left_stick_y;
        float right = -gamepad1.right_stick_y;

        left = left *LEFT_MOTOR_MAX_POWER;
        right = right *RIGHT_MOTOR_MAX_POWER;


        right = Range.clip(right, -RIGHT_MOTOR_MAX_POWER, RIGHT_MOTOR_MAX_POWER);
        left = Range.clip(left, -LEFT_MOTOR_MAX_POWER, LEFT_MOTOR_MAX_POWER);

        if (gamepad1.a) {
            armPosition += armDelta;
        }

        if (gamepad1.y) {
            armPosition -= armDelta;
        }

        if (gamepad1.x) {
            clawPosition += clawDelta;
        }

        if (gamepad1.b) {
            clawPosition -= clawDelta;
        }

        armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
        clawPosition = Range.clip(clawPosition, CLAW_MIN_RANGE, Claw_MAX_RANGE);

        arm.setPosition(armPosition);
        claw.setPosition(clawPosition);

        telemetry.addData("1-motor left power",left);
        telemetry.addData("2-motor right power",right);
        telemetry.addData("3-arm position", armPosition);
        telemetry.addData("4-claw position", claw);

    }
}
