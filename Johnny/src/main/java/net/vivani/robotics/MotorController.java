package net.vivani.robotics;

import java.io.IOException;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class MotorController {


        private static GpioPinDigitalOutput forward1;
        private static GpioPinDigitalOutput backward1;
        private static GpioPinPwmOutput speedPin1;
        private static GpioPinDigitalOutput forward2;
        private static GpioPinDigitalOutput backward2;
        private static GpioPinPwmOutput speedPin2;
        //private static GpioController gpio;

        private static int SLOWEST1 = 380;
        private static int FASTEST1 = 700;

        private static int SLOWEST2 = 420;
        private static int FASTEST2 = 700;


    public MotorController() {
    
    }
    

    public void start() {
      
        try{

            System.out.println("Starting MotorController");

            System.out.println("Creating gpio controller");
            final GpioController gpio = GpioFactory.getInstance();

            System.out.println("Setting up movement variables.");
            System.out.println("Forward1...");
            forward1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04); //Pi4J GPIO_04 is GPIO_23
            System.out.println("Backward1...");
            backward1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05); //Pi4J GPIO_05 is GPIO_24
            System.out.println("SpeedPin1...");
            speedPin1 = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "SPEED", 0); //Pi4J GPIO_26 is GPIO_12 //ENA
            System.out.println("Forward2...");
            forward2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00); //Pi4J GPIO_00 is GPIO17_
            System.out.println("Backward2...");
            backward2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02); //Pi4J GPIO_02 is GPIO_27
            System.out.println("SpeedPin2...");
            speedPin2 = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "SPEED", 0); //Pi4J GPIO_23 is GPIO_13 //ENA

            System.out.println("Keeping the program running until user aborts (CTRL-C)");
            //while (true) {
            //  keyPressed(forward1, backward1, speedPin1);
            //}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keyPressed(GpioPinDigitalOutput f, GpioPinDigitalOutput b, GpioPinPwmOutput p) {
    
        int x;
        try {
            x = System.in.read();
            switch(x) {
              case 102: //moving forward
                forward1.high();
                backward1.low();
                forward2.high();
                backward2.low();
                System.out.println("--> Setting Speed to " + SLOWEST1);
                speedPin1.setPwm(SLOWEST1);
                speedPin2.setPwm(SLOWEST2);
                System.out.println("Moving Forward"); 
                break;
              case 98: //moving backwards
                forward1.low();
                backward1.high();
                forward2.low();
                backward2.high();
                System.out.println("--> Setting Speed to " + SLOWEST1);
                speedPin1.setPwm(SLOWEST2);
                speedPin2.setPwm(SLOWEST1);
                System.out.println("--> Moving Backward"); 
                break;
              case 114: //moving right
                forward1.high();
                backward1.low();
              //  forward2.low();
              //  backward2.high();
                System.out.println("--> Setting Speed to " + SLOWEST1);
                speedPin1.setPwm(SLOWEST1);
              //  speedPin2.setPwm(SLOWEST2);
                System.out.println("Turning Right"); 
                break;
              case 108: //moving left 
              //  forward1.low();
              //  backward1.high();
                forward2.high();
                backward2.low();
                System.out.println("--> Setting Speed to " + SLOWEST1);
              //  speedPin1.setPwm(SLOWEST1);
                speedPin2.setPwm(SLOWEST2);
                System.out.println("Turning Left"); 
                break;
              case 115: //stopping 
                backward1.low();
                forward1.low();
                backward2.low();
                forward2.low();
                System.out.println("--> Stop."); 
                break;
              default:
                if (x!=10)
                  System.out.println("Value not handled: " +x); 
            }
        } catch (Exception e) {
            System.out.println("You haven't entered a number!!!");
        }
    }

}
