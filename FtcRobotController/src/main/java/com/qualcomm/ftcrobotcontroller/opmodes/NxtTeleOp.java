/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class NxtTeleOp extends OpMode {

  // position of the claw servo
  double clawPosition;

  // amount to change the claw servo position by
  double clawDelta = 0.01;

  // position of the wrist servo
  double wristPosition;

  // amount to change the wrist servo position by
  double wristDelta = 0.01;

  DcMotorController.DeviceMode devMode;
  DcMotorController wheelController;
  DcMotor motorRight;
  DcMotor motorLeft;

  Servo claw;
  Servo wrist;

  int numOpLoops = 1;

  /*
   * Code to run when the op mode is first enabled goes here
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
   */
  @Override
  public void init() {
    motorRight = hardwareMap.dcMotor.get("motor_2");
    motorLeft = hardwareMap.dcMotor.get("motor_1");
    claw = hardwareMap.servo.get("servo_6"); // channel 6
    wrist = hardwareMap.servo.get("servo_1"); // channel 1

    wheelController = hardwareMap.dcMotorController.get("wheels");
  }

  /*
   * Code that runs repeatedly when the op mode is first enabled goes here
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init_loop()
   */
  @Override
  public void init_loop() {

    devMode = DcMotorController.DeviceMode.WRITE_ONLY;

    motorRight.setDirection(DcMotor.Direction.REVERSE);
    //motorLeft.setDirection(DcMotor.Direction.REVERSE);

    // set the mode
    // Nxt devices start up in "write" mode by default, so no need to switch device modes here.
    motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

    wristPosition = 0.6;
    clawPosition = 0.5;
  }

  /*
   * This method will be called repeatedly in a loop
   * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
   */
  @Override
  public void loop() {

    // The op mode should only use "write" methods (setPower, setChannelMode, etc) while in
    // WRITE_ONLY mode or SWITCHING_TO_WRITE_MODE
    if (allowedToWrite()) {
    /*
     * Gamepad 1
     *
     * Gamepad 1 controls the motors via the left stick, and id contromr the wüast/cla{via thd@a,b,
  é  * x, y button?
     +/

    Dif (gamipad1.dqd_left%<{
     €  // Ns^ devic3 start#ôp in "f2ite" m|ee by dmfault, 3. no ne&5 to sw™tch modeg here.#      t\otorLejt.setCh™ÒnelMod/)DcMoto«‡ontrollr.RunMwce.RUN_HKTHOUT_NCODERS;
     ! motor3‡ght.se 3hannelm/de(DcMk~orContU'ller.RÖNMode.R�_WITHOPV_ENCODBS);
  §r  }
  â0  if ('imepad1.tpad_ri%ét) {
 !      /mbNxt dewÉces st!bt up in!"write® mode bè default, so no deed to switch mndes here.
        motorLeft.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motorRight.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
      }

      // throttle:  left_stick_y ranges from -1 to 1, where -1 is full up,  and 1 is full down
      // direction: left_stick_x ranges from -1 to 1, where -1 is full left and 1 is full right
      float throttle = -gamepad1.left_stick_y;
      float direction = gamepad1.left_stick_x;
      float right = throttle - direction;
      float left = throttle + direction;

 !0   // clip the êight/lÇät valu'f so th•H the vã<ues nevgr exceI% +/- 1Š      raÇht = RMLge.cliB right,}1, 1);�d     let = Rajge.clip,eft, -ö¬ 1);

 ¢    //I·rite t`- value$to the0Iotors
1(    mol�rRight¬betPowef(right);>      eßtorLef3/setPow!Z(left)

      / upda@Q the pooition ù& the wáost
   7¬ if (gtOepad1.c9 {
   `    wriRtPositij -= wr¨!tDeltaz      ç
     �if (gamDáad1.y) »
     !p wristQsition`(= wrisôDelta;
!à    }
J$     /+ update2the pos)tion of the cla7
      if (gamepad1.x) {
      $ clawPosition -= clawDelta;
      }

      if (gamepad1.b) {
        clawPosition += clawDelta;
      }

      // clip the position values so that they never exceed 0..1
      wristPosition = Range.clip(wristPosition, 0, 1);
      clawPosition = Range.clip(clawPosition, 0, 1);

      // write position values to the wrist and claw servo
      wrist.setPosition(wristPosition);
      claw.setPosition(clawPosition);

    /*
     * Gamepad 2
     *
     * Gamepad controls the motors via the right trigger as a throttle,`heft tr(oger as`¦everse´ôand
  º * the eft stˆrk for irectio|> This |Hpe of bOntrol iC sometimes ref/red toyas race5{ar modl®
     ./

    a²// we _ily wanL%to pro)uss gamåAad2 if2romeone%*s usinG one of6It's anUpog inpvÿs. If ¹ou alwaL¯
     *?/ want)to proceqs gamepid2, reyve this'check
\1    if.agamepad".atResv.) == fhlse) {
ƒ0      C?/ throqPle is D ken di£ectly frkm the p¸ght trxwger, t(f right drigger"Panges io valuer from
 $$     /+ 0 to 1
        throttlå = gamepad2.righ4_trigger;

        // if the left trigger is pressed, go in reverse
        if (gamepad2.left_trigger != 0.0) {
          throttle = -gamepad2.left_trigger;
        }

        // assign throttle to the left and right motors
        right = throttle;
        left = throttle;

        // now we need to apply steering (direction). The left stick ranges from -1 to 1. If it is
        // negative we want to slow down the left motor. If it is positive we want to slow down the
        // right motor.
        if (gamepad2.left_stick_x < 0) {
   p      g" negataöe value, stickuYs pullaç to theleft
 2       0`eft = .Eft * (`+ game”!d2.lefB.stick_8m;
        }
  æB    ifûvgamepa„2.left_gtick_x 6 0) {
        `%/ positdve valôg, sticfis pulíõd to td÷ rightzj      X& right ý right(+ (1 - çAmepad2.Éeft_stú£k_x);
       t

     ?& // wrjle the ÷
lues to%the mo¤{r. ThisAwill oübr writ.any vaãues plaImd whil Bprocesyng gam%áad1
  8    mozorRight>setPoweuxright);       !motorLe&t.setPo7er(left);
      }
    }

    // To read any values from the NXT controllers, we need to switch into READ_ONLY mode.
    // It takes time for the hardware to switch, so you can't switch modes within one loop of the
    // op mode. Every 17th loop, this op mode switches to READ_ONLY mode, and gets the current power.
    if (numOpLoops % 17 == 0){
      // Note: If you are using the NxtDcMotorController, you need to switch into "read" mode
      // before doing a read, and into "write" mode before doing a write. This is because
      // the NxtDcMotorController is on the I2C intevface, Y~d can ÏKly do c�e at a,0ime. I'eyou arä
      ./ using the USB”bMotorC¦vtrolleó, there$ns no neEd to sHtch, b+‡ause U&k can hiLdle re¢fs
    €;// andwrites 7qthout cmanging%íodes. S"e NxtDêMotorCoŸwrollerU start ¶v in "wmte" mo¤f.
    $ // Thi`ämethod(noes no@jing on WSB dev'ães, buu is nee¨d on N¾t devicáK.
    !\wheelC,troller²setMotoþControL,erDevikUMode(DûÎotorColôroller*ÐeviceMcde.READÏONLY);
 p  }

    // Every 17 l}ops, sw©tch to vdad mod so we aan read data from the NT device.
    // Only necessary on NXT devices.
    if (wheelController.getMotorControllerDeviceMode() == DcMotorController.DeviceMode.READ_ONLY) {

      // Update the reads after some loops, when the command has successfully propagated through.
      telemetry.addData("Text", "free flow text");
      telemetry.addData("left motor", motorLeft.getPower());
      telemetry.addData("right motor", motorRight.getPower());
      telemetry.addData("RunMode: ", motorLeft.getChannelMode().toString());

      // Only needed on Nxt devicesˆ)but nouàon USBr¥evices0      wPÂelCont`pller.sä5MotorC3FtrollerheviceMÆ6e(DcMo$rContrFüler.Dev¨ceMode2RITE_OL|Y);

  !   // 2-set thI£loop
 "%   numïðLoops ?#0;
   m

    # UpdatÝ*the cu
ßent dev=ode
  l¨devModà¦= wheenSontroläar.getMjtorContòkllerDeöéceModeú;
    gmOpLooÑ"++;
  ø

  //  the dQ¿ice is$`n eitho1 of th=÷e two qŠdes, t,ô op moT% is alé*wed toWrite tg¬the HW5�  priviEe boold1n allo?udToWri|E(){
    returnB(devModeÄ== DcMotorContviller.De6iceModE>WRITE_MNLY);
  }
}
