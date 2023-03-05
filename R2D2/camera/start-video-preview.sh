#!/bin/bash


##Opens Video Streaming on a preview window on a specific location.
## https://www.tomshardware.com/how-to/stream-live-video-raspberry-pi
## ihttps://blog.robertelder.org/commands-raspberry-pi-camera/

# -o is our output, in this case set to none.
# -t is the length of the video clip, using zero will set this to infinite.
# -w and -h are the width and height of the video, in this case 800 x 600.
# -fps are the frames per second for the video stream, a lower value should minimize dropouts.
# -p preview screen location

raspivid -o - -t 0 -w 640 -h 480 -fps 12 -p 10,0,640,460
