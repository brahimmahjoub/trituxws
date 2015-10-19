# trituxws

I- Tools used

Ubuntu 14.04
Eclipse STS 
maven 3.3.3
spring boot 1.2.7.RELEASE
mysql 5.5


II- Installation

Create a mysql database called tritux_ws, then execute the script "tritux_ws.sql" in the sql folder, this script will create tables with some data
#command
>$ mysql -u root
>$ create database tritux_ws
mysql>  exit
>$ cd sql
>$ mysql -u root tritux_ws < tritux_ws.sql

Open Terminal:

#command
>$ cd ~/Desktop
>$ mkdir TrituxWs
>$ cd TrituxWs
>$ git init
>$ git clone git@github.com:brahimmahjoub/trituxws.git
>$ cd trituxws
>$ mvn eclipse:eclispe
#run appllication
>$ mvn spring-boot:run


open browser and go to http://localhost:8080.