#!/bin/bash


##Opens Video Streaming on a preview window on a specific location.
## https://www.tomshardware.com/how-to/stream-live-video-raspberry-pi
## ihttps://blog.robertelder.org/commands-raspberry-pi-camera/

raspivid -o - -t 0 -w 800 -h 600 -fps 12  | cvlc -vvv stream:///dev/stdin --sout '#rtp{sdp=rtsp://:8080/}' :demux=h264
