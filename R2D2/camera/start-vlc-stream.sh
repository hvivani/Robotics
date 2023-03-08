#!/bin/bash


##Opens Video Streaming on a preview window on a specific location.
## https://www.tomshardware.com/how-to/stream-live-video-raspberry-pi
## https://blog.robertelder.org/commands-raspberry-pi-camera/

## on client computer open VLC --> Open Network Stream --> rtsp://YOUR-IP:8083/

/bin/su -c "/usr/bin/raspivid -o - -t 0 -w 640 -h 480 -fps 24  | /usr/bin/cvlc -vvv stream:///dev/stdin --sout '#rtp{sdp=rtsp://:8083/}' :demux=h264" pi
