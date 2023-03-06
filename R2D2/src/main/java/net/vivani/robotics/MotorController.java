package net.vivani.robotics;

import java.io.IOException;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class MotorController {

        //Right Wheel variables
        private static GpioPinDigitalOutput forwardRight;
        private static GpioPinDigitalOutput backwardRight;
        private static GpioPinPwmOutput speedPinLeft;
        private static int slowestRight = 380;
        private static int fastestRight = 700;

        //Left Wheel variables
        private static GpioPinDigitalOutput forwardLeft;
        private static GpioPinDigitalOutput backwardLeft;
        private static GpioPinPwmOutput speedPinRight;

        private static int slowestLeft = 420;
        private static int fastestLeft = 700;

        //Status LED
        StatusLed statusLed;


    public MotorController() {
        statusLed=new StatusLed();
        statusLed.standBy(); 
    }
    

    public void start() {
      
        try{

            System.out.println("Starting MotorController");

            System.out.println("Creating gpio controller");
            final GpioController gpio = GpioFactory.getInstance();

            System.out.println("Setting up movement variables.");
            System.out.println("ForwardLeft...");
            forwardRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04); //Pi4J GPIO_04 is GPIO_23
            System.out.println("BackwardLeft...");
            backwardRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05); //Pi4J GPIO_05 is GPIO_24
            System.out.println("SpeedPinLeft...");
            speedPinLeft = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "SPEED", 0); //Pi4J GPIO_26 is GPIO_12 //ENA
            System.out.println("ForwardRight...");
            forwardLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00); //Pi4J GPIO_00 is GPIO17_
            System.out.println("BackwardRight...");
            backwardLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02); //Pi4J GPIO_02 is GPIO_27
            System.out.println("SpeedPinRight...");
            speedPinRight = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "SPEED", 0); //Pi4J GPIO_23 is GPIO_13 //ENA

            System.out.println("Keeping the program running until user aborts (CTRL-C)");
            while (true) {
              keyPressed();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void keyPressed() {
    
        int x;
        try {
            x = System.in.read();
            switch(x) {
              case 102: //moving forward
                forward(); 
                break;
              case 98: //moving backwards
                backward();
                break;
              case 114: //moving right
                right();
                break;
              case 108: //moving left 
                left();
                break;
              case 115: //stopping 
                stop(); 
                break;
              default:
                if (x!=10)
                  System.out.println("Value not handled: " +x); 
            }
        } catch (Exception e) {
            System.out.println("You haven't entered a number!!!");
        }
    }

    private static void stop(){
        backwardRight.low();
        forwardRight.low();
        backwardLeft.low();
        forwardLeft.low();
        System.out.println("--> Stop.");
    }

    private static void forward(){
        forwardRight.high();
        backwardRight.low();
        forwardLeft.high();
        backwardLeft.low();
        System.out.println("--> Setting Speed to " + slowestRight);
        speedPinLeft.setPwm(slowestRight);
        speedPinRight.setPwm(slowestLeft);
        System.out.println("Moving Forward");
    } 

    private static void backward(){
        forwardRight.low();
        backwardRight.high();
        forwardLeft.low();
        backwardLeft.high();
        System.out.println("--> Setting Speed to " + slowestRight);
        speedPinLeft.setPwm(slowestLeft);
        speedPinRight.setPwm(slowestRight);
        System.out.println("--> Moving Backward");
    }

    private static void right(){
        forwardRight.high();
        backwardRight.low();
        System.out.println("--> Setting Speed to " + slowestRight);
        speedPinLeft.setPwm(slowestRight);
        System.out.println("Turning Right");
    }
  
    private static void left(){
        forwardLeft.high();
        backwardLeft.low();
        System.out.println("--> Setting Speed to " + slowestRight);
        speedPinRight.setPwm(slowestLeft);
        System.out.println("Turning Left");
    }

}
