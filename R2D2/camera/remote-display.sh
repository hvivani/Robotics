#!/bin/bash

# https://blog.robertelder.org/commands-raspberry-pi-camera/

#How to Stream Video Remotely From Raspberry Pi
#A commonly-requested feature is to be able to stream video data from your Raspberry Pi over the local network and view it on another computer.  After having experimented with a number of different techniques for real-time video streaming from the Pi, I've found that the following method yields the lowest latency.  Run this command on your laptop/desktop computer:
#
# nc -l 2222 | mplayer -fps 25 -demuxer h264es -
#
#     and run this command on your Raspberry Pi:
#
#raspivid -t 0 -fps 25 -w 640 -h 480 -o - | nc REPLACE_WITH_YOUR_IP 2222


raspivid -t 0 -fps 25 -w 640 -h 480 -o - | nc 192.168.0.37 2222
