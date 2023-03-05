package net.vivani.robotics;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class BlinkingLed
{

    public BlinkingLed() {}

    public void start() {

        System.out.println("Starting Blinking Led");

        try {
            /** create gpio controller */
            final GpioController gpio = GpioFactory.getInstance();
            // Pi4J GPIO_29 is GPIO_21
            // Pi4J GPIO_16 is GPIO_27
            final GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);

            /** Blink every second during 15 seconds*/
            //ledPin.blink(1000, 15000);

            int milliseconds=3000;

            /** Blink every second*/
            ledPin.blink(milliseconds);

            System.out.println("LED is blinking every 3 seconds. (CTRL-C) to abort...");
            while (true) {
                //sleeping now for 500 milliseconds...
                Thread.sleep(500);
            }
            } catch (Exception e) {
              e.printStackTrace();
            }
        }

    public void stop() {
     
      System.out.println("Stopping Blinking Led");

    }

}
