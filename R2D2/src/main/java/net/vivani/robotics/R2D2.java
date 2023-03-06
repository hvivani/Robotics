package net.vivani.robotics;

/**
 * 20230304. Hernan Vivani
 * R2D2 - Robotics Controller
 * https://vivani.net/2020/04/27/raspberry-pi-java-r2d2-robot-part-1/
 */
public class R2D2
{


    public static void main( String[] args )
    {
        System.out.println( "R2D2 is running." );


        int MAX_PARAM=1;
        String function="";
        
        System.out.println( "Hernan Vivani's Robot Controller" );

        if (args.length < MAX_PARAM){

          System.out.println ("Usage: ");
          System.out.println ("R2D2 <function> ");
          System.out.println ("Available functions: BlinkinLed/MotorController");

        }else{
          
           function=args[0]; 
           
           System.out.println("Entering function: " + function);

           if (function.compareTo("StatusLed") == 0){
               StatusLed s=new StatusLed();
               s.standBy();
           }
           if (function.compareTo("MotorController") == 0){
               MotorController m=new MotorController();
               m.start();
           }
               
        }

    }

}
