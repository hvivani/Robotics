#!/bin/bash


##Opens Video Streaming on a preview window on a specific location.
## https://www.tomshardware.com/how-to/stream-live-video-raspberry-pi
## ihttps://blog.robertelder.org/commands-raspberry-pi-camera/

raspivid -o - -t 0 -w 640 -h 480 -fps 24  | cvlc -vvv stream:///dev/stdin --sout '#rtp{sdp=rtsp://:8080/}' :demux=h264
