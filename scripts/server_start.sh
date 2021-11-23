#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -jar -Dserver.port=443 target/server-0.0.1-SNAPSHOT.jar > /logs/log.txt 2>&1