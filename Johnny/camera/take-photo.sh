#!/bin/bash


##Takes Photo.
## https://projects.raspberrypi.org/en/projects/getting-started-with-picamera/3

dd=`date +%d`
mm=`date +%m`
YY=`date +%Y`
HH=`date +%H`
MM=`date +%M`

raspistill -o image-$YY$mm$dd$HH$MM.jpg
