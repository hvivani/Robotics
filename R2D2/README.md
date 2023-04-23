# Hernan Vivani's R2D2 Robot Controller Software

This project started as a Covid/Coronavirus project for the kids back in 2020. Hardware documentation is available here:
[raspberry-pi-java-r2d2-robot-part-1](https://vivani.net/2020/04/27/raspberry-pi-java-r2d2-robot-part-1/)


## Compiling
```
mvn clean && mvn package
```

## Running

Blinking Led Function:
```
sudo java -cp ./target/R2D2-1.0-SNAPSHOT.jar net.vivani.robotics.R2D2 BlinkingLed
```
Motor Controller Function:
```
sudo java -cp ./target/R2D2-1.0-SNAPSHOT.jar net.vivani.robotics.R2D2 MotorController
```

## Start Video Camera
```
sudo ./camera/start-vlc-stream.sh&
```
then on client computer open VLC --> Open Network Stream --> rtsp://YOUR-IP:8083/


## Legacy

lib folder is a legacy implementation. Currently all the project runs on Maven

```
sudo java -cp .:/opt/pi4j/lib/'*' MotorController
```
