#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -jar -Dserver.port=443 target/server-0.0.1-SNAPSHOT.jar > /home/ec2-user/logs/log.txt 2>&1 &