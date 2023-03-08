package net.vivani.robotics;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class StatusLed
{
    private static GpioController gpio;
    private static GpioPinDigitalOutput ledPin;

    public StatusLed() {
        try{
            /** create gpio controller */
            gpio = GpioFactory.getInstance();
            // Pi4J GPIO_29 is GPIO_21
            // Pi4J GPIO_16 is GPIO_27
            ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        } catch (Exception e) {
              e.printStackTrace();
        }
    }

    public void standBy() {

        System.out.println("Starting Status Led");

        try {
            int milliseconds=3000;

            /** Blink every second*/
            ledPin.blink(milliseconds);

            System.out.println("CTRL-C to stop");

            } catch (Exception e) {
              e.printStackTrace();
            }
        }

    public void stop() {
        System.out.println("Stopping Status Led");
        ledPin.low();
    }

    public void running() {
        try {
            int milliseconds=500;

            /** Blink every second*/
            ledPin.blink(milliseconds);

        } catch (Exception e) {
              e.printStackTrace();
        }

    }


}
