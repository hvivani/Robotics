# Hernan Vivani's R2D2 Robot Controller Software

## Compiling
```
mvn clean && mvn package
```

## Running

Blinking Led Function:
```
java -cp ./target/R2D2-1.0-SNAPSHOT.jar net.vivani.robotics.R2D2 BlinkingLed
```
Motor Controller Function:
```
java -cp ./target/R2D2-1.0-SNAPSHOT.jar net.vivani.robotics.R2D2 MotorController
```

## Legacy

```
sudo java -cp .:/opt/pi4j/lib/'*' MotorController
```
